package app;

import app.Views.EditorView;
import app.Views.ResultsView;
import javafx.scene.layout.BorderPane;
import static app.Partials.*;

public class Navigator {

    private static BorderPane app;

    private static BorderPane selectView(int viewCode) {
        if (viewCode == Partials.EDITOR_VIEW)
            return EditorView.getInstance().getEditorLayout();
        else
            return ResultsView.getInstance().getResultsView();
    }

    public static void viewPage() {
        app = App.getApp();
        Animations.fadeOutThenSlideUp(app, selectView(EDITOR_VIEW), selectView(RESULTS_VIEW));
    }

    public static void hidePage() {
        app = App.getApp();
        Animations.slideDownThenFadeIn(app, selectView(RESULTS_VIEW), selectView(EDITOR_VIEW));
    }
}
