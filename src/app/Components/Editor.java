package app.Components;

import javafx.scene.control.TextArea;

public class Editor {

    private static Editor instance;
    private TextArea editor;

    private Editor() {
        this.render();
    }

    private void render() {
        editor = new TextArea();
        editor.getStyleClass().add("editor");
    }

    public TextArea getEditor() {
        return editor;
    }

    public static Editor getInstance() {
        if (instance == null)
            instance = new Editor();
        return instance;
    }
}
