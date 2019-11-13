package test.event;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HandleEvent extends Application {

    public static void main ( String[] args ) {
        launch( args );
    }

    @Override
    public void start ( Stage primaryStage ) {
        HBox pane = new HBox( 10 );
        Button btOk = new Button( "Ok" );
        OkHanddleClass hd_btOk = new OkHanddleClass();
        btOk.setOnAction( hd_btOk );

        Button btNo = new Button( "No" );
        NoHanddleClass hd_btNo = new NoHanddleClass();
        btOk.setOnAction( hd_btNo );

        pane.getChildren().addAll( btOk, btNo );


        primaryStage.setTitle( "HandleEvent" );
        primaryStage.setScene( new Scene( pane ) );
        primaryStage.show( );
    }
}

class OkHanddleClass implements EventHandler {

    @Override
    public void handle ( Event event ) {
        System.out.println( "btOk clicked ont time ..." );
    }
}
class NoHanddleClass implements EventHandler {

    @Override
    public void handle ( Event event ) {
        System.out.println( "btNo clicked ont time ..." );
    }
}