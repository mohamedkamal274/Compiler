package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    public static BorderPane app;

    @Override
    public void start(Stage primaryStage) {
        //App container
        app = new BorderPane();
        app.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> app.requestFocus());

        //App Scene
        Scene scene = new Scene(app, 1200, 600);
        scene.getStylesheets().add("/styles/editor.css");

        primaryStage.setTitle("Compiler Editor");
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(600);

        primaryStage.setScene(scene);
        //primaryStage.getIcons().add(new Image("/assets/app-logo.png"));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
