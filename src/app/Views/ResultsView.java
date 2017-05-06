package app.Views;

import javafx.scene.layout.BorderPane;

public class ResultsView {

    private static ResultsView instance;
    private BorderPane resultsLayout;

    private ResultsView() {
        this.render();
    }

    private void render() {
        resultsLayout = new BorderPane();
    }

    public BorderPane getResultsView() {
        return resultsLayout;
    }

    public static ResultsView getInstance() {
        if (instance == null)
            instance = new ResultsView();
        return instance;
    }
}
