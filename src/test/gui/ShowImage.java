package test.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowImage extends Application {

    public static void main ( String[] args ) {
        Application.launch( args );
    }

    @Override
    public void start ( Stage primaryStage ) throws Exception {
        // Image, ImageView
        Pane pane = new HBox( 10 ); // H 水平, V 垂直
        pane.setPadding( new Insets( 5, 5, 5, 5 ) ); // 边框大小, 上, 右, 底, 左

        Image image = new Image( "Image/ss.png" );
        pane.getChildren().add( new ImageView( image ) );

        ImageView imageView2 = new ImageView( image );
        imageView2.setFitWidth( 100 );
        imageView2.setFitHeight( 100 );
        pane.getChildren().add( imageView2 );


        ImageView imageView3 = new ImageView( image );
        imageView3.setFitWidth( 100 );
        imageView3.setFitHeight( 100 );
        imageView3.setRotate( 45 );
        pane.getChildren().add( imageView3 );

        primaryStage.setTitle( "ShowImage" );
        primaryStage.setScene( new Scene( pane, 100, 100 ) );
        primaryStage.show( );
    }
}
