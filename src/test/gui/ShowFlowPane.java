package test.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ShowFlowPane extends Application {

    public static void main ( String[] args ) {
        Application.launch( args );
    }

    @Override
    public void start ( Stage primaryStage ) {
        FlowPane pane = new FlowPane( Orientation.VERTICAL);
        pane.setPadding( new Insets( 5, 5, 5, 5 ) );
        pane.setHgap( 5 );
        pane.setVgap( 5 );

        pane.getChildren().addAll(
                new Label( "first name" ),
                new TextField( ),
                new Label( "Mi:" ) );

        TextField tf_mi = new TextField( );
        tf_mi.setPrefColumnCount( 1 );

        pane.getChildren().addAll(
                tf_mi,
                new Label( "Last Name: " ),
                new TextField( ) );

        primaryStage.setTitle( "ShowFlowPane" );
        primaryStage.setScene( new Scene( pane, 200, 200 ) );
        primaryStage.show( );
    }
}
