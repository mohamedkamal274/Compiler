package app.Components;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ResultsTable {

    private static ResultsTable instance;
    private TableView resultsTable;

    private ResultsTable() {
        this.render();
    }

    private void render() {
        //Results table
        resultsTable = new TableView();
        resultsTable.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

        TableColumn lineNumber = new TableColumn("Line Number");
        lineNumber.setMaxWidth( 1f * Integer.MAX_VALUE * 15 );
        TableColumn lexeme = new TableColumn("Lexeme");
        lexeme.setMaxWidth( 1f * Integer.MAX_VALUE * 23.66666 );
        TableColumn returnToken = new TableColumn("Return Token");
        returnToken.setMaxWidth( 1f * Integer.MAX_VALUE * 23.66666 );
        TableColumn lexemeNumber = new TableColumn("Lexeme Number");
        lexemeNumber.setMaxWidth( 1f * Integer.MAX_VALUE * 15 );
        TableColumn matchability = new TableColumn("Matchability");
        matchability.setMaxWidth( 1f * Integer.MAX_VALUE * 23.66666 );
        resultsTable.getColumns().addAll(lineNumber, lexeme, returnToken, lexemeNumber, matchability);
    }

    public TableView getResultTable() {
        return resultsTable;
    }

    public static ResultsTable getInstance() {
        if (instance == null)
            instance = new ResultsTable();
        return instance;
    }
}
