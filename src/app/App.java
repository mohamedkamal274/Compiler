package app;

import app.Views.EditorView;
import app.Views.ResultsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    private static BorderPane app;
    private EditorView editorView;
    private ResultsView resultsView;

    @Override
    public void start(Stage primaryStage) {
        //App container
        app = new BorderPane();
        app.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> app.requestFocus());

        editorView = EditorView.getInstance();
        resultsView = ResultsView.getInstance();
        app.setCenter(editorView.getEditorLayout());

        //App Scene
        Scene scene = new Scene(app, 1200, 600);
        scene.getStylesheets().add("/styles/buttons.css");
        scene.getStylesheets().add("/styles/colors.css");
        scene.getStylesheets().add("/styles/editor.css");
        scene.getStylesheets().add("/styles/results-view.css");
        scene.getStylesheets().add("/styles/action-bar.css");
        scene.getStylesheets().add("/styles/suggestion-list.css");

        primaryStage.setTitle("Compiler Editor");
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(600);

        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/assets/app-logo.png"));
        primaryStage.show();
    }

    public static BorderPane getApp() {
        return app;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
