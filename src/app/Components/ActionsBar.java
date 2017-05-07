package app.Components;

import app.Navigator;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ActionsBar {

    private static ActionsBar instance;
    private BorderPane actionBarLayout;
    private GridPane buttonsLayout;
    private Label errorMessage;
    private Button scanButton;
    private Button parseButton;
    private Button compileButton;
    private Button browseButton;

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

        scanButton.setOnAction(e -> Navigator.viewPage());

        parseButton = new Button("Parse");
        parseButton.getStyleClass().add("btn");
        
        parseButton.setOnAction(e -> { //TODO });

        compileButton = new Button("Compile");
        compileButton.getStyleClass().add("btn");
            
        compileButton.setOnAction(e -> { //TODO });
        
        browseButton = new Button("Browse");
        browseButton.getStyleClass().add("btn");
            
        browseButton.setOnAction(e -> { //TODO });

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

    public void setErrorMessage(String errorMessage) {
        this.errorMessage.setText(errorMessage);
    }

    public BorderPane getActionBar() {
        return actionBarLayout;
    }

    public static ActionsBar getInstance() {
        if (instance == null)
            instance = new ActionsBar();
        return instance;
    }
}
