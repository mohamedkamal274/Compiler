package app.Components;

import app.Navigator;
import app.Views.ResultsView;
import compiler.Lexeme;
import compiler.Lexer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class ActionsBar {

    private ArrayList<TableColumn> scanner;
    private ArrayList<TableColumn> parser;

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
        scanner = new ArrayList<>();
        TableColumn<Lexeme, Integer> lineNumber = new TableColumn("Line Number");
        lineNumber.setMaxWidth(1f * Integer.MAX_VALUE * 15);
        lineNumber.setCellValueFactory(new PropertyValueFactory<>("line_no"));
        scanner.add(lineNumber);
        TableColumn<Lexeme, String> lexeme = new TableColumn("Lexeme");
        lexeme.setMaxWidth(1f * Integer.MAX_VALUE * 23.66666);
        lexeme.setCellValueFactory(new PropertyValueFactory<>("lexeme"));
        scanner.add(lexeme);
        TableColumn<Lexeme, String> returnToken = new TableColumn("Return Token");
        returnToken.setMaxWidth(1f * Integer.MAX_VALUE * 23.66666);
        returnToken.setCellValueFactory(new PropertyValueFactory<>("token"));
        scanner.add(returnToken);
        TableColumn<Lexeme, Integer> lexemeNumber = new TableColumn("Lexeme Number");
        lexemeNumber.setMaxWidth(1f * Integer.MAX_VALUE * 15);
        lexemeNumber.setCellValueFactory(new PropertyValueFactory<>("lexeme_pos"));
        scanner.add(lexemeNumber);
        TableColumn<Lexeme, Boolean> matchability = new TableColumn("Matchability");
        matchability.setMaxWidth(1f * Integer.MAX_VALUE * 23.66666);
        matchability.setCellValueFactory(new PropertyValueFactory<>("matched"));
        scanner.add(matchability);

        //parser
        /* TODO
        parser = new ArrayList<>();
        TableColumn<DummyClass, Integer> parserlineNumber = new TableColumn("Line Number");
        parserlineNumber.setMaxWidth(1f * Integer.MAX_VALUE * 15);
        parserlineNumber.setCellValueFactory(new PropertyValueFactory<>("lineNo"));
        parser.add(parserlineNumber);
        TableColumn<DummyClass, Boolean> parserMatchability = new TableColumn("Matchability");
        parserMatchability.setMaxWidth(1f * Integer.MAX_VALUE * 23.66666);
        parserMatchability.setCellValueFactory(new PropertyValueFactory<>("matchability"));
        parser.add(parserMatchability);
        TableColumn<DummyClass, String> role = new TableColumn("Rule Used");
        role.setMaxWidth(1f * Integer.MAX_VALUE * 23.66666);
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        parser.add(role);*/

        //Error Message
        errorMessage = new Label();
        errorMessage.getStyleClass().add("error-message");

        errorMessageScroll = new ScrollPane(errorMessage);
        errorMessageScroll.setMaxWidth(650);
        errorMessageScroll.setMaxHeight(75);
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

        compileButton.setOnAction(e -> {
            //TODO
        });

        browseButton = new Button("Browse");
        browseButton.getStyleClass().add("btn");
        browseButton.setOnAction(this::browse);

        //Buttons layout
        buttonsLayout = new GridPane();
        buttonsLayout.setAlignment(Pos.CENTER_RIGHT);
        buttonsLayout.setMaxWidth(370);
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
        //ResultsView.getInstance().setData(parser, DummyClass.getDummyData());
        Navigator.viewPage();
    }

    private void scan(ActionEvent e) {
        if (!fileExist) {
            fileContent = Editor.getInstance().getEditor().getText();
        }
        lexer.setInput(fileContent);
        ResultsView.getInstance().setData(scanner,
                lexer.lexicalAnalyzer()
                        .parallelStream()
                        .filter(lexeme -> !lexeme.getToken().equals("White Space"))
                        .map(lexeme -> {
                            if (lexeme.getToken().equals("comment")) {
                                lexeme.setLexeme(lexeme.getLexeme().substring(0, 2));
                            }
                            return lexeme;
                        })
                        .collect(Collectors.toList())
        );
        Navigator.viewPage();
    }

    private void browse(ActionEvent e) {
        //Clearing if there is an existing file
        fileExist = false;
        FileChooser openFile = new FileChooser();
        openFile.setTitle("Choose code file");
        File file = openFile.showOpenDialog(null);
        if (file != null) {
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
