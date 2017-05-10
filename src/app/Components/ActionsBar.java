package app.Components;

import app.Navigator;
import app.Views.ResultsView;
import compiler.parser.Output;
import compiler.parser.ParseTable;
import compiler.scanner.Lexeme;
import compiler.scanner.Lexer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class ActionsBar {

    private ScannerColumns scannerColumns;
    private ParserColumns parserColumns;
    private ArrayList<Lexeme> lexemes = new ArrayList<>();
    private int errorCount = 0;

    private static ActionsBar instance;
    private BorderPane actionBarLayout;
    private GridPane buttonsLayout;
    private ScrollPane errorMessageScroll;
    private Label errorMessage;
    private Button scanButton;
    private Button parseButton;
    private Button compileButton;
    private Button browseButton;

    private String fileContent = "";
    private boolean fileExist = false;
    private final Lexer lexer = new Lexer("");

    private ActionsBar() {
        this.render();
    }

    private void render() {
        //scanner
        scannerColumns = ScannerColumns.getInstance();

        //parser
        parserColumns = ParserColumns.getInstance();

        //Error Message
        errorMessage = new Label();
        errorMessage.getStyleClass().add("error-message");

        //Error code
        Editor.getInstance().getEditor().textProperty().addListener(this::findError);

        errorMessageScroll = new ScrollPane(errorMessage);
        errorMessageScroll.setMinWidth(800);
        errorMessageScroll.setMaxWidth(800);
        errorMessageScroll.setMaxHeight(125);
        errorMessageScroll.getStyleClass().add("scrollbar");
        errorMessageScroll.toBack();

        //Buttons
        scanButton = new Button("Scan");
        scanButton.getStyleClass().add("btn");

        scanButton.setOnAction(this::scan);

        parseButton = new Button("Parse");
        parseButton.getStyleClass().add("btn");

        parseButton.setOnAction(this::parse);

        compileButton = new Button("Compile");
        compileButton.getStyleClass().add("btn");

        compileButton.setOnAction(this::compile);

        browseButton = new Button("Browse");
        browseButton.getStyleClass().add("btn");
        browseButton.setOnAction(this::browse);

        //Buttons layout
        buttonsLayout = new GridPane();
        buttonsLayout.setAlignment(Pos.CENTER_RIGHT);
        buttonsLayout.setMaxWidth(400);
        GridPane.setConstraints(scanButton, 0, 0);
        GridPane.setConstraints(parseButton, 1, 0);
        GridPane.setConstraints(compileButton, 2, 0);
        GridPane.setConstraints(browseButton, 3, 0);
        buttonsLayout.getChildren().addAll(scanButton, parseButton, compileButton, browseButton);

        //Action bar layout
        actionBarLayout = new BorderPane();
        actionBarLayout.getStyleClass().add("action-bar");
        actionBarLayout.setRight(buttonsLayout);
        actionBarLayout.setLeft(errorMessageScroll);
    }

    private void parse(ActionEvent e) {
        if (!fileExist) {
            fileContent = Editor.getInstance().getEditor().getText();
        }
        ParseTable parseObject = new ParseTable();
        ArrayList<Output> outputData = null;
        try {
            outputData = parseObject.topDownAlgorithm(fileContent);
        } catch (IOException ex) {
            Logger.getLogger(ActionsBar.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultsView.getInstance().setData(parserColumns.getParserColumns(), new ArrayList<Object>(outputData));
        ResultsView.getInstance().setNumberOfErrors((int) countParseError(outputData));
        SuggestionList.getInstance().hideList();
        Navigator.viewPage();
    }

    private void scan(ActionEvent e) {
        if (!fileExist) {
            fileContent = Editor.getInstance().getEditor().getText();
        } else {
            lexer.setInput(fileContent);
            lexemes = lexer.lexicalAnalyzer();
            errorCount = (int) lexemes.stream().filter(lexeme -> !lexeme.getMatched()).count();
        }

        ResultsView.getInstance().setData(scannerColumns.getScannerColumns(),new ArrayList(lexemes));

        ResultsView.getInstance().setNumberOfErrors(errorCount);
        SuggestionList.getInstance().hideList();
        Navigator.viewPage();
    }

    private void compile(ActionEvent e) {
        if (!fileExist) {
            fileContent = Editor.getInstance().getEditor().getText();
        } else {
            lexer.setInput(fileContent);
            lexemes = lexer.lexicalAnalyzer();
            errorCount = (int) lexemes.stream().filter(lexeme -> !lexeme.getMatched()).count();
        }
        ArrayList<Lexeme> AllLexme = new ArrayList(lexemes
                .parallelStream()
                .filter(lexeme -> !lexeme.getToken().contains("comment"))
                .collect(Collectors.toList()));
        String program = "";
        for (int i = 0; i < AllLexme.size(); i++) {
            if(AllLexme.get(i).getToken().equals("String")){
                String lex=AllLexme.get(i).getLexeme();
                String removeQuate="";
                for(int j=1;j<lex.length()-1;j++){
                    removeQuate+=lex.charAt(j);
                }
                program += removeQuate + " ";
                
            }else if(AllLexme.get(i).getToken().equals("charConstant")){
                program += "charConstant"+ " ";
            }else {           
            program += AllLexme.get(i).getLexeme() + " ";
            
            }
        }
        ParseTable parseObject = new ParseTable();
        //System.out.println(program);
        ArrayList<Output> outputData = null;
        try {
            outputData = parseObject.topDownAlgorithm(program);
        } catch (IOException ex) {
            Logger.getLogger(ActionsBar.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultsView.getInstance().setData(parserColumns.getParserColumns(), new ArrayList<Object>(outputData));
        ResultsView.getInstance().setNumberOfErrors((int) countParseError(outputData));
        SuggestionList.getInstance().hideList();
        Navigator.viewPage();
    }

    private void findError(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        lexer.setInput(newValue);
        errorMessage.setText("");
        lexemes = lexer.lexicalAnalyzer();
        errorCount = 0;
        String errors = "";
        for (Lexeme lexeme : lexemes) {
            if (!lexeme.getMatched()) {
                errorCount++;
                errors += (errors.isEmpty() ? "" : "\n") + "Error at " + lexeme.getLine_no() + ":" + lexeme.getLexeme_pos() + " Not defined - (" + lexeme.getLexeme() + ")";
            }
        }
        errorMessage.setText(errors);
        //parseButton.setDisable(!errorMessage.getText().isEmpty());
    }

    private void browse(ActionEvent e) {
        //Clearing if there is an existing file
        if (fileExist) {
            fileContent = "";
            browseButton.setText("Browse");
            fileExist = false;
            lexemes.clear();
            return;
        }
        FileChooser openFile = new FileChooser();
        openFile.setTitle("Choose code file");
        File file = openFile.showOpenDialog(null);
        if (file != null) {
            browseButton.setText("Clear");
            try {

                fileContent = java.nio.file.Files.lines(file.toPath()).reduce("", (t, u) -> t + u + "\n");
            } catch (IOException ex) {
                Logger.getGlobal().log(Level.SEVERE, ex.getMessage(), ex);
            }
            fileExist = true;
        } else {
            fileExist = false;
        }
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage.setText(errorMessage);
    }

    private long countParseError(ArrayList<Output> out) {
        return out.stream().filter(p -> p.getRule().contains("Syntax Error")).count();
    }

    public BorderPane getActionBar() {
        return actionBarLayout;
    }

    public static ActionsBar getInstance() {
        if (instance == null) {
            instance = new ActionsBar();
        }
        return instance;
    }
}
