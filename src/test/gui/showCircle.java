package test.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class showCircle extends javafx.application.Application {

    public static void main ( String[] args ) {
        Application.launch( args );
    }

    @Override
    public void start ( Stage primaryStage ) throws Exception {
        // 通用属性和方法
        Circle circle = new Circle( );
        circle.setCenterX( 100 );
        circle.setCenterY( 100 );
        circle.setRadius( 50 );
//        circle.setStroke( Color.GREEN );
//        circle.setFill( Color.YELLOW );
        circle.setStyle( "-fx-stroke:black; -fx-fill:yellow" );

        Pane pane = new Pane( );
        pane.getChildren().add( circle );

        primaryStage.setTitle( "Show Circle" );
        primaryStage.setScene( new Scene( pane, 200, 200 ) );
        primaryStage.show( );
    }
}
