package test.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonInPane extends javafx.application.Application {

    public static void main ( String[] args ) {
        Application.launch( args );
    }

    @Override
    public void start ( Stage primaryStage ) throws Exception {
        StackPane pane = new StackPane( );
        pane.getChildren().add( new Button( "OK" ) );
        primaryStage.setTitle( "Button in a pane" );
        primaryStage.setScene( new Scene( pane, 200, 50 ) );
        primaryStage.show( );

    }
}
