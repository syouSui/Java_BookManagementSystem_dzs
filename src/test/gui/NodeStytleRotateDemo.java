package test.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class NodeStytleRotateDemo extends javafx.application.Application {

    public static void main ( String[] args ) {
        Application.launch( args );
    }


    @Override
    public void start ( Stage primaryStage ) throws Exception {
        StackPane pane = new StackPane();
        Button btOk = new Button( "Yes" );
        btOk.setStyle( "-fx-border-color:blue;" );
        pane.getChildren().add( btOk );
        pane.setRotate( 45 );
        pane.setStyle( "-fx-border-color:red;" +
                "-fx-background-color:lightfray;" );

        primaryStage.setTitle( "" );
        primaryStage.setScene( new Scene( pane, 200, 200 ) );
        primaryStage.show( );
    }
}
