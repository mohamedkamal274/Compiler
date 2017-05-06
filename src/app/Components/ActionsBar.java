package app.Components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ActionsBar {

    private static ActionsBar instance;
    private GridPane actionBarLayout;
    private Button scanButton;
    private Button parseButton;
    private Button compileButton;

    private ActionsBar() {
        this.render();
    }

    private void render() {
        //Buttons
        scanButton = new Button("Scan");
        scanButton.getStyleClass().add("btn");

        parseButton = new Button("Parse");
        parseButton.getStyleClass().add("btn");

        compileButton = new Button("Compile");
        compileButton.getStyleClass().add("btn");

        //Action bar container
        actionBarLayout = new GridPane();
        actionBarLayout.setAlignment(Pos.CENTER_RIGHT);
        actionBarLayout.getStyleClass().add("action-bar");
        GridPane.setConstraints(scanButton, 0, 0);
        GridPane.setConstraints(parseButton, 1, 0);
        GridPane.setConstraints(compileButton, 2, 0);
        actionBarLayout.getChildren().addAll(scanButton, parseButton, compileButton);
    }

    public GridPane getActionBar() {
        return actionBarLayout;
    }

    public static ActionsBar getInstance() {
        if (instance == null)
            instance = new ActionsBar();
        return instance;
    }
}
