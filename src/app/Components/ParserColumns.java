package app.Components;

import compiler.scanner.Lexeme;
import javafx.scene.control.TableColumn;

import java.util.ArrayList;
import javafx.scene.control.cell.PropertyValueFactory;
import compiler.parser.Output;

public class ParserColumns {

    private static ParserColumns instance;
    private ArrayList<TableColumn> parserColumns;

    private ParserColumns() {
        this.render();
    }

    private void render() {
        parserColumns = new ArrayList<>();

        TableColumn<Output, String> index = new TableColumn("No.");
        index.setMaxWidth(1f * Integer.MAX_VALUE * 10);
        index.setCellValueFactory(new PropertyValueFactory<>("index"));
        parserColumns.add(index);

        TableColumn<Output, String> rule = new TableColumn("Rule");
        rule.setMaxWidth(1f * Integer.MAX_VALUE * 45);
        rule.setCellValueFactory(new PropertyValueFactory<>("rule"));
        parserColumns.add(rule);
        
        TableColumn<Output, String> process = new TableColumn("Process");
        process.setMaxWidth(1f * Integer.MAX_VALUE * 45);
        process.setCellValueFactory(new PropertyValueFactory<>("process"));
        parserColumns.add(process);
    }

    public ArrayList<TableColumn> getParserColumns() {
        return parserColumns;
    }

    public static ParserColumns getInstance() {
        if (instance == null) {
            instance = new ParserColumns();
        }
        return instance;
    }
}
