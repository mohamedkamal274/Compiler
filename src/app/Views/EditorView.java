package app.Views;

import app.Components.ActionsBar;
import app.Components.Editor;
import javafx.scene.layout.BorderPane;

public class EditorView {

    private static EditorView instance;
    private BorderPane editorLayout;
    private Editor editor;
    private ActionsBar actionsBar;

    private EditorView() {
        this.render();
    }

    private void render() {
        //Editor
        editor = Editor.getInstance();

        //Action bar
        actionsBar = ActionsBar.getInstance();

        //Editor layout
        editorLayout = new BorderPane();
        editorLayout.setCenter(editor.getEditor());
        editorLayout.setBottom(actionsBar.getActionBar());
    }

    public BorderPane getEditorLayout() {
        return editorLayout;
    }

    public static EditorView getInstance() {
        if (instance == null)
            instance = new EditorView();
        return instance;
    }
}
