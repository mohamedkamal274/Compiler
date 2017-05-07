package app.Components;

import app.Navigator;
import app.Views.ResultsView;
import compiler.Lexer;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class ActionsBar {

    private static ActionsBar instance;
    private BorderPane actionBarLayout;
    private GridPane buttonsLayout;
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
        //Error Message
        errorMessage = new Label("1 error, at line 2");
        errorMessage.getStyleClass().add("error-message");

        //Buttons
        scanButton = new Button("Scan");
        scanButton.getStyleClass().add("btn");

        scanButton.setOnAction(this::scan);

        parseButton = new Button("Parse");
        parseButton.getStyleClass().add("btn");

        parseButton.setOnAction(e -> {
            //TODO
        });

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
        GridPane.setConstraints(scanButton, 0, 0);
        GridPane.setConstraints(parseButton, 1, 0);
        GridPane.setConstraints(compileButton, 2, 0);
        GridPane.setConstraints(browseButton, 3, 0);
        buttonsLayout.getChildren().addAll(scanButton, parseButton, compileButton, browseButton);

        //Action bar layout
        actionBarLayout = new BorderPane();
        actionBarLayout.getStyleClass().add("action-bar");
        actionBarLayout.setRight(buttonsLayout);
        actionBarLayout.setLeft(errorMessage);
    }

    private void scan(ActionEvent e) {
        if (!fileExist) {
            fileContent = Editor.getInstance().getEditor().getText();
        }
        lexer.setInput(fileContent);
        ResultsView.getInstance().setData(
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
        openFile .setTitle("Choose code file");
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
