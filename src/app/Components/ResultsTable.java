package app.Components;

import javafx.scene.control.TableView;

public class ResultsTable {

    private static ResultsTable instance;
    private TableView resultsTable;

    private ResultsTable() {
        this.render();
    }


    private void render() {
        resultsTable = new TableView();
        resultsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public TableView getResultTable() {
        return resultsTable;
    }

    public static ResultsTable getInstance() {
        if (instance == null) {
            instance = new ResultsTable();
        }
        return instance;
    }
}
