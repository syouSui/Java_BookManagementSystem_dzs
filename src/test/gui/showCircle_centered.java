package test.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class showCircle_centered extends javafx.application.Application {

    public static void main ( String[] args ) {
        Application.launch( args );
    }

    @Override
    public void start ( Stage primaryStage ) throws Exception {
        Circle circle = new Circle( );
        Pane pane = new Pane( );
        circle.centerXProperty().bind( pane.widthProperty().divide( 2 ) );
        circle.centerYProperty().bind( pane.heightProperty().divide( 2 ) );
//        circle.setCenterX( 100 );
//        circle.setCenterY( 100 );
        circle.setRadius( 50 );
        circle.setStroke( Color.GREEN );
        circle.setFill( Color.YELLOW );

        pane.getChildren().add( circle );

        primaryStage.setTitle( "Show Circle" );
        primaryStage.setScene( new Scene( pane, 200, 200 ) );
        primaryStage.show( );
    }
}
