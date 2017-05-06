package app.Components;

import javafx.scene.layout.GridPane;

public class ActionsBar {

    private static ActionsBar instance;
    private GridPane actionBarLayout;

    private ActionsBar() {
        this.render();
    }

    private void render() {

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
