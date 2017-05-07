package app.Views;

import app.Components.ResultsTable;
import app.Navigator;
import compiler.Lexeme;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ScannerResultsView {

    private static ScannerResultsView instance;
    private BorderPane resultsLayout;
    private GridPane pageHeaderLayout;
    private Button backButton;
    private Label headline;
    private ResultsTable resultsTable;

    private ScannerResultsView() {
        this.render();
    }

    private void render() {
        //Page headline
        backButton = new Button();
        backButton.getStyleClass().add("back-btn");

        backButton.setOnAction(e -> Navigator.hidePage());

        headline = new Label("Results");
        headline.getStyleClass().add("headline");

        pageHeaderLayout = new GridPane();
        pageHeaderLayout.setHgap(10);
        GridPane.setConstraints(backButton, 0, 0);
        GridPane.setConstraints(headline, 1, 0);
        pageHeaderLayout.getChildren().addAll(backButton, headline);

        //Results table
        resultsTable = ResultsTable.getInstance();

        //Results layout
        resultsLayout = new BorderPane();
        resultsLayout.setStyle("-fx-background-color: white");
        resultsLayout.setPadding(new Insets(50, 75, 50, 75));
        resultsLayout.setTop(pageHeaderLayout);
        BorderPane.setMargin(pageHeaderLayout, new Insets(0, 0, 25, 0));
        resultsLayout.setCenter(resultsTable.getResultTable());
    }

    public BorderPane getResultsView() {
        return resultsLayout;
    }

    public void setData(List<Lexeme> Lexemes) {
        resultsTable.getResultTable().getItems().clear();
        resultsTable.getResultTable().getItems().addAll(Lexemes);
    }

    public static ScannerResultsView getInstance() {
        if (instance == null) {
            instance = new ScannerResultsView();
        }
        return instance;
    }
}
