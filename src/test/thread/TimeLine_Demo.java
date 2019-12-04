package test.thread;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TimeLine_Demo extends Application {

    public static void main ( String[] args ) {
        launch( args );
    }

    @Override
    public void start ( Stage primaryStage ) {
        StackPane pane = new StackPane( );
        Text text = new Text( 20, 50, "Programming is fun." );
        text.setFill( Color.BLUE );
        pane.getChildren().add( text );

        new Thread( new Runnable( ) {
            @Override
            public void run ( ) {
                while( true ) {
                    Platform.runLater( new Runnable() {
                        @Override
                        public void run ( ) {
                            text.setText( text.getText().length()!=0 ? "" : "Programming is fun." );
                        }
                    } );
                    try {
                        Thread.sleep( 100 );
                    } catch ( InterruptedException e ) {
                        e.printStackTrace( );
                    }
                }
            }
        } ).start();

        primaryStage.setTitle( "TimeLine_Demo" );
        primaryStage.setScene( new Scene( pane ) );
        primaryStage.show( );

    }
}
