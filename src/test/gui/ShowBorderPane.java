package test.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowBorderPane extends Application {

    public static void main ( String[] args ) {
        launch( args );
    }

    @Override
    public void start ( Stage primaryStage ) {
        BorderPane pane = new BorderPane( );
        HBox pane1 = new HBox( 10 );
        pane1.setPadding( new Insets( 5, 5, 5, 5 ) );
        Pane pane2 = new Pane( );
        pane.setBottom( pane1 );
        pane.setCenter( pane2 );

        Button bt_beginPage = new Button( "首页" );
        Button bt_lastPage = new Button( "上一页" );
        Button bt_nextPage = new Button( "下一页" );
        Button bt_endPage = new Button( "尾页");

        pane1.getChildren().addAll( bt_beginPage, bt_lastPage, bt_nextPage, bt_endPage );

        Label lab = new Label( "This is a Label." );
        pane2.getChildren().addAll( lab );

        primaryStage.setTitle( "ShowBorderPane" );
        primaryStage.setScene( new Scene( pane, 200, 200 ) );
        primaryStage.show( );
    }
}