package app.Components;

import compiler.Lexeme;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class ResultsTable {

    private static ResultsTable instance;
    private TableView<Lexeme> resultsTable;

    private ResultsTable() {
        this.render();
    }

    private void render() {
        //Results table
        resultsTable = new TableView();
        resultsTable.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

        TableColumn<Lexeme, Integer> lineNumber = new TableColumn("Line Number");
        lineNumber.setMaxWidth( 1f * Integer.MAX_VALUE * 15 );
        lineNumber.setCellValueFactory(new PropertyValueFactory<>("line_no"));
        TableColumn<Lexeme, String> lexeme = new TableColumn("Lexeme");
        lexeme.setMaxWidth( 1f * Integer.MAX_VALUE * 23.66666 );
        lexeme.setCellValueFactory(new PropertyValueFactory<>("lexeme"));
        TableColumn<Lexeme, String> returnToken = new TableColumn("Return Token");
        returnToken.setMaxWidth( 1f * Integer.MAX_VALUE * 23.66666 );
        returnToken.setCellValueFactory(new PropertyValueFactory<>("token"));
        TableColumn<Lexeme, Integer> lexemeNumber = new TableColumn("Lexeme Number");
        lexemeNumber.setMaxWidth( 1f * Integer.MAX_VALUE * 15 );
        lexemeNumber.setCellValueFactory(new PropertyValueFactory<>("lexeme_pos"));
        TableColumn<Lexeme, Boolean> matchability = new TableColumn("Matchability");
        matchability.setMaxWidth( 1f * Integer.MAX_VALUE * 23.66666 );
        matchability.setCellValueFactory(new PropertyValueFactory<>("matched"));
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
