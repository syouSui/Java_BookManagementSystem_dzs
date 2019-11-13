package test.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ColorFontDemo extends Application {

    public static void main ( String[] args ) {
        Application.launch( args );
    }

    @Override
    public void start ( Stage primaryStage ) throws Exception {
        Pane pane = new StackPane();

        Circle circle = new Circle();
        circle.setRadius( 50 );
        circle.setStroke( Color.RED );
        circle.setFill( new Color( 0.5, 0.5, 0.5, 1 ) );
//        pane.getChildren().add( circle );

        Label label1 = new Label( "javaFX" );
        label1.setFont( Font.font( "Times new Roman",
                FontWeight.BOLD,
                FontPosture.ITALIC,
                20 ) );

        pane.getChildren().addAll( circle, label1 );

        primaryStage.setTitle( "" );
        primaryStage.setScene( new Scene( pane, 100, 100 ) );
        primaryStage.show();

    }
}
