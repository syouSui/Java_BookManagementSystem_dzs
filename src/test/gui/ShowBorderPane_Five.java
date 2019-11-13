package test.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ShowBorderPane_Five extends Application {

    public static void main ( String[] args ) {
        launch( args );
    }


    @Override
    public void start ( Stage primaryStage ) {
        BorderPane pane = new BorderPane( );

//        Button bt_beginPage = new Button( "首页" );
//        Button bt_lastPage = new Button( "上一页" );
//        Button bt_nextPage = new Button( "下一页" );
//        Button bt_endPage = new Button( "尾页");
//        Button bt_currentPage = new Button( "当前页" );

//        pane.setTop( new Pane( bt_beginPage ) );
//        pane.setRight( new Pane( bt_lastPage ) );
//        pane.setBottom( new Pane( bt_nextPage ) );
//        pane.setLeft( new Pane( bt_endPage ) );
//        pane.setCenter( new Pane( bt_currentPage ) );
        pane.setTop( new myPane( "首页" ) );
        pane.setRight( new myPane( "上一页" ) );
        pane.setBottom( new myPane( "下一页" ) );
        pane.setLeft( new myPane( "尾页" ) );
        pane.setCenter( new myPane( "当前页" ) );

        primaryStage.setTitle( "ShowBorderPane_Five" );
        primaryStage.setScene( new Scene( pane, 200, 200 ) );
        primaryStage.show( );
    }
}
class myPane extends StackPane {
    public myPane ( String title ) {
        this.getChildren().add( new Button( title ) );
        this.setStyle( "-fx-border-color:red" );
        this.setPadding( new Insets( 10, 10, 10, 10 ) );

    }
}