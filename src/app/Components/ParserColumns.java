package app.Components;

import javafx.scene.control.TableColumn;

import java.util.ArrayList;

public class ParserColumns {

    private static ParserColumns instance;
    private ArrayList<TableColumn> parserColumns;

    private ParserColumns() {
        this.render();
    }

    private void render() {

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
