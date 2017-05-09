package app.Views;

import app.Components.ActionsBar;
import app.Components.Editor;
import app.Components.SuggestionList;
import compiler.scanner.ReservedKeywords;
import javafx.geometry.Point2D;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EditorView {

    private static EditorView instance;
    private BorderPane editorLayout;
    private Editor editor;
    private ActionsBar actionsBar;
    private SuggestionList suggestionList;

    private TextInputControl control;
    private Point2D position;

    public int wordStartPosition = 0;
    public int wordEndPosition = 0;
    public String selectedWord = "";

    private EditorView() {
        this.render();
    }

    private void render() {
        //Editor
        editor = Editor.getInstance();

        //Showing suggestion list
        editor.getEditor().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.CONTROL) {
                control = (TextInputControl) e.getSource();
                position = control.getInputMethodRequests().getTextLocation(0);
                suggestionList.showList(editorLayout, position.getX(), position.getY());
                suggestionList.addItemsToList(new ArrayList(ReservedKeywords.reservedWords.keySet().stream().filter(p -> p.toLowerCase().startsWith(selectedWord.toLowerCase()) && p.length()>2).sorted().collect(Collectors.toList())));
            } else {
                suggestionList.hideList();
            }
        });

        //Getting current word and indexes
        editor.getEditor().caretPositionProperty().addListener((obs, oldPosition, newPosition) -> {
            String text = editor.getEditor().getText().substring(0, newPosition.intValue());
            int index ;
            for (index = text.length() - 1; index >= 0 && !Character.isWhitespace(text.charAt(index)); index--);

            wordStartPosition = index + 1;
            wordEndPosition = (int) newPosition;
            selectedWord = text.substring(index + 1, text.length());
        });

        //Action bar
        actionsBar = ActionsBar.getInstance();

        //Suggestion list
        suggestionList = SuggestionList.getInstance();

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
