package app;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.util.Duration;

public class Animations {
    static void fadeOutThenSlideUp(BorderPane parent, Region tab, Region page) {
        Timeline fadeOutThenSlideUpAnimation = new Timeline();

        //Creating all key values for the animation
        KeyValue tabOpacityStart = new KeyValue(tab.opacityProperty(), 1);
        KeyValue tabChildOpacityEnd = new KeyValue(tab.opacityProperty(), 0);

        KeyValue pageOpacityStart = new KeyValue(page.opacityProperty(), 0);
        KeyValue pageOpacityEnd = new KeyValue(page.opacityProperty(), 1);

        KeyValue pageTranslateStart = new KeyValue(page.translateYProperty(), 20);
        KeyValue pageTranslateEnd = new KeyValue(page.translateYProperty(), 0, Interpolator.EASE_BOTH);

        //Hiding and moving fromChild
        KeyFrame startFadeOut = new KeyFrame(Duration.ZERO, tabOpacityStart);
        KeyFrame finishFadeOut = new KeyFrame(Duration.millis(125), tabChildOpacityEnd);

        //Clearing the setCenter
        KeyFrame clear = new KeyFrame(Duration.millis(151), e -> {
            parent.setCenter(null);
            parent.setCenter(page);
        });

        //Showing and moving toChild
        KeyFrame startFadeIn = new KeyFrame(Duration.millis(151), pageOpacityStart);
        KeyFrame startMoveIn = new KeyFrame(Duration.millis(151), pageTranslateStart);
        KeyFrame finishFadeIn = new KeyFrame(Duration.millis(276), pageOpacityEnd);
        KeyFrame finishMoveIn = new KeyFrame(Duration.millis(301), pageTranslateEnd);

        fadeOutThenSlideUpAnimation.getKeyFrames().addAll(startFadeOut, finishFadeOut, clear, startFadeIn, startMoveIn, finishFadeIn, finishMoveIn);
        fadeOutThenSlideUpAnimation.play();
    }

    static void slideDownThenFadeIn(BorderPane parent, Region page, Region tab) {
        Timeline slideDownThenFadeInAnimation = new Timeline();

        //Creating all key values for the animation
        KeyValue pageOpacityStart = new KeyValue(page.opacityProperty(), 1);
        KeyValue pageOpacityEnd = new KeyValue(page.opacityProperty(), 0);

        KeyValue pageTranslateStart = new KeyValue(page.translateYProperty(), 0);
        KeyValue pageTranslateEnd = new KeyValue(page.translateYProperty(), 20, Interpolator.EASE_BOTH);

        KeyValue tabOpacityStart = new KeyValue(tab.opacityProperty(), 0);
        KeyValue tabChildOpacityEnd = new KeyValue(tab.opacityProperty(), 1);

        //Creating the timeline keyframes
        KeyFrame startFadeIn = new KeyFrame(Duration.ZERO, pageOpacityStart);
        KeyFrame startMoveIn = new KeyFrame(Duration.ZERO, pageTranslateStart);
        KeyFrame finishFadeIn = new KeyFrame(Duration.millis(125), pageOpacityEnd);
        KeyFrame finishMoveIn = new KeyFrame(Duration.millis(150), pageTranslateEnd);

        //Clearing the setCenter
        KeyFrame clear = new KeyFrame(Duration.millis(151), e -> {
            parent.setCenter(null);
            parent.setCenter(tab);
        });

        //Showing and moving toChild
        KeyFrame startFadeOut = new KeyFrame(Duration.millis(151), tabOpacityStart);
        KeyFrame finishFadeOut = new KeyFrame(Duration.millis(276), tabChildOpacityEnd);

        slideDownThenFadeInAnimation.getKeyFrames().addAll(startFadeOut, finishFadeOut, clear, startFadeIn, startMoveIn, finishFadeIn, finishMoveIn);
        slideDownThenFadeInAnimation.play();
    }
}
