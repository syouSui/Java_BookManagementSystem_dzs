package test.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HandleEvent_anorrymous extends Application {

    private TextField tf = new TextField( "This is a textFiled.");

    public static void main ( String[] args ) {
        launch( args );
    }

    @Override
    public void start ( Stage primaryStage ) {
        HBox pane = new HBox( 10 );

        Button btOk = new Button( "Ok" );
        btOk.setOnAction( new EventHandler<ActionEvent>(){
            @Override
            public void handle ( ActionEvent event ) {
                System.out.println( "btOk clicked ont time ..." );
                tf.setText( "Ok button clicked" );
            }
        } );

        Button btNo = new Button( "No" );
        btNo.setOnAction( new EventHandler<ActionEvent>(){
            @Override
            public void handle ( ActionEvent event ) {
                System.out.println( "btNo clicked ont time ..." );
                tf.setText( "No button clicked" );
            }
        });

        pane.getChildren().addAll( tf, btOk, btNo );


        primaryStage.setTitle( "HandleEvent" );
        primaryStage.setScene( new Scene( pane ) );
        primaryStage.show( );
    }

}

