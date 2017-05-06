package app.Views;

import app.Navigator;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ResultsView {

    private static ResultsView instance;
    private BorderPane resultsLayout;
    private GridPane pageHeaderLayout;
    private Button backButton;
    private Label headline;
    private TableView resultsTable;

    private ResultsView() {
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
        resultsTable = new TableView();
        resultsTable.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

        TableColumn lineNumber = new TableColumn("Line Number");
        lineNumber.setMaxWidth( 1f * Integer.MAX_VALUE * 15 );
        TableColumn lexeme = new TableColumn("Lexeme");
        lexeme.setMaxWidth( 1f * Integer.MAX_VALUE * 23.66666 );
        TableColumn returnToken = new TableColumn("Return Token");
        returnToken.setMaxWidth( 1f * Integer.MAX_VALUE * 23.66666 );
        TableColumn lexemeNumber = new TableColumn("Lexeme Number");
        lexemeNumber.setMaxWidth( 1f * Integer.MAX_VALUE * 15 );
        TableColumn matchability = new TableColumn("Matchability");
        matchability.setMaxWidth( 1f * Integer.MAX_VALUE * 23.66666 );
        resultsTable.getColumns().addAll(lineNumber, lexeme, returnToken, lexemeNumber, matchability);

        //Results layout
        resultsLayout = new BorderPane();
        resultsLayout.setStyle("-fx-background-color: white");
        resultsLayout.setPadding(new Insets(50, 75, 50, 75));
        resultsLayout.setTop(pageHeaderLayout);
        BorderPane.setMargin(pageHeaderLayout, new Insets(0 , 0, 25, 0));
        resultsLayout.setCenter(resultsTable);
    }

    public BorderPane getResultsView() {
        return resultsLayout;
    }

    public static ResultsView getInstance() {
        if (instance == null)
            instance = new ResultsView();
        return instance;
    }
}
