package app.Components;

import compiler.scanner.Lexeme;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ScannerColumns {

    private static ScannerColumns instance;
    private ArrayList<TableColumn> scannerColumns;

    private ScannerColumns() {
        this.render();
    }

    private void render() {
        scannerColumns = new ArrayList<>();

        TableColumn<Lexeme, Integer> lineNumber = new TableColumn("Line Number");
        lineNumber.setMaxWidth(1f * Integer.MAX_VALUE * 15);
        lineNumber.setCellValueFactory(new PropertyValueFactory<>("line_no"));
        scannerColumns.add(lineNumber);

        TableColumn<Lexeme, String> lexeme = new TableColumn("Lexeme");
        lexeme.setMaxWidth(1f * Integer.MAX_VALUE * 23.66666);
        lexeme.setCellValueFactory(new PropertyValueFactory<>("lexeme"));
        scannerColumns.add(lexeme);

        TableColumn<Lexeme, String> returnToken = new TableColumn("Return Token");
        returnToken.setMaxWidth(1f * Integer.MAX_VALUE * 23.66666);
        returnToken.setCellValueFactory(new PropertyValueFactory<>("token"));
        scannerColumns.add(returnToken);

        TableColumn<Lexeme, Integer> lexemeNumber = new TableColumn("Lexeme Number");
        lexemeNumber.setMaxWidth(1f * Integer.MAX_VALUE * 15);
        lexemeNumber.setCellValueFactory(new PropertyValueFactory<>("lexeme_pos"));
        scannerColumns.add(lexemeNumber);

        TableColumn<Lexeme, Boolean> matchability = new TableColumn("Matchability");
        matchability.setMaxWidth(1f * Integer.MAX_VALUE * 23.66666);
        matchability.setCellValueFactory(new PropertyValueFactory<>("matched"));
        scannerColumns.add(matchability);
    }

    public ArrayList<TableColumn> getScannerColumns() {
        return scannerColumns;
    }

    public static ScannerColumns getInstance() {
        if (instance == null) {
            instance = new ScannerColumns();
        }
        return instance;
    }

}
