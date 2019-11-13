package test.gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ShowGridPane extends Application {

    public static void main ( String[] args ) {
        Application.launch( args );
    }

    @Override
    public void start ( Stage primaryStage ) {
        GridPane pane = new GridPane(  );
        pane.setAlignment( Pos.CENTER );
        pane.setPadding( new Insets( 5, 5, 5, 5 ) );
        pane.setHgap( 5 );
        pane.setVgap( 5 );

        pane.add( new Label( "firset name: " ), 0, 0 );
        pane.add( new TextField( ), 1, 0 );
        pane.add( new Label( "Mi: ") , 1, 0 );
        pane.add( new TextField( ), 1, 1 );
        pane.add( new Label( "last name: " ), 2, 0 );
        pane.add( new TextField( ), 2, 1 );

        Button btAdd = new Button( "添加" );
        pane.add( btAdd, 1, 3 );
        GridPane.setHalignment( btAdd, HPos.RIGHT );

        primaryStage.setTitle( "ShowGridPane" );
        primaryStage.setScene( new Scene( pane ) );
        primaryStage.show( );
    }
}
