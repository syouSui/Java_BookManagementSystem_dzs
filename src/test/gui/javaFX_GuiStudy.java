package test.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class javaFX_GuiStudy extends Application {
	
	public static void main ( String[] args ) {
		Application.launch(  args  );
	}

	@Override
	public void start ( Stage primaryStage ) throws Exception {
		primaryStage.setTitle( "myJavaFX" );
		primaryStage.setScene( new Scene( new Button( "OK" ), 200, 250 ) );
		primaryStage.show( );

		Stage stage = new Stage( );
		stage.setTitle( "Second Statge" );
		stage.setScene( new Scene( new Button( "Cancle" ), 100, 200 ) ) ;
		stage.show( );
	}
	
}
