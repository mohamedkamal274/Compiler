package app.Components;

import app.Views.EditorView;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class SuggestionList {

    private static SuggestionList instance;
    private ContextMenu list;
    private ArrayList<MenuItem> menuItems;

    private SuggestionList() {
        this.render();
    }

    private void render() {
        //Creating list
        list = new ContextMenu();
        list.setAutoFix(true);
        menuItems = new ArrayList<>();
    }

    public void showList(BorderPane parent, double x, double y) {
        list.show(parent, x, y);
    }

    public void hideList() {
        list.hide();
    }

    public void addItemsToList(ArrayList<String> items) {
        this.clearList();

        for (String item : items) {
            MenuItem menuItem  = new MenuItem(item);
            menuItems.add(menuItem);
            menuItem.setOnAction(e -> Editor.getInstance().getEditor().replaceText(EditorView.getInstance().wordStartPosition,
                    EditorView.getInstance().wordEndPosition,
                    menuItem.getText()));

            if (menuItem.getText() == "No Suggestion")
                menuItem.setDisable(true);
        }
        list.getItems().addAll(menuItems);
    }

    private void clearList() {
        list.getItems().removeAll(menuItems);
        menuItems.clear();
    }

    public ContextMenu getList() {
        return list;
    }

    public static SuggestionList getInstance() {
        if (instance == null) {
            instance = new SuggestionList();
        }
        return instance;
    }
}
