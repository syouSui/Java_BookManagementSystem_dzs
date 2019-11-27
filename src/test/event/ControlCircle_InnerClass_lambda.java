package test.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle_InnerClass_lambda extends Application {

	public static void main(String[] args) {
		Application.launch( args );
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		HBox hbox = new HBox( );
		hbox.setSpacing( 10 );
		hbox.setAlignment( Pos.CENTER );

		HBox circleBox = new HBox( );
		circleBox.setSpacing( 10 );
		circleBox.setAlignment( Pos.CENTER );
		Circle circle = new Circle( 50 );

		circle.setStroke( Color.RED );
		circle.setFill( Color.YELLOW );
		circleBox.getChildren().add( circle );

		Button btEnlarge = new Button( "放大" );
		btEnlarge.setOnAction( arg0 -> circle.setRadius(circle.getRadius()+10 ) );

		Button btShrink = new Button( "缩小" );
		btShrink.setOnAction( arg0 -> circle.setRadius( circle.getRadius()>10 ? circle.getRadius()-10 : 10 ) );
		hbox.getChildren().addAll( btEnlarge, btShrink );

		BorderPane borderPane = new BorderPane( );
		borderPane.setCenter( circleBox );
		borderPane.setBottom( hbox );
		borderPane.setAlignment( hbox, Pos.CENTER );
		
		primaryStage.setTitle( "ControlCircle" );
		primaryStage.setScene( new Scene( borderPane, 500, 400 ) );
		primaryStage.show( );
		
	}
}