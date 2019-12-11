package test.InternetPrograming.oneUser;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application {	
	public static void main(String[] args) {
		Application.launch( );
	}

	//写入半径
	DataOutputStream toServer = null;
	//读取面积
	DataInputStream fromServer = null;

	@Override
	public void start(Stage primaryStage) throws Exception {

		TextField text_input = new TextField( );
		text_input.setAlignment( Pos.BOTTOM_RIGHT );

		BorderPane input_pane = new BorderPane( );
		input_pane.setPadding( new Insets( 5, 5, 5, 5) );
		input_pane.setStyle( "-fx-border-color:green" );
		input_pane.setLeft( new Label( "Enter a radius: ") );
		input_pane.setCenter( text_input );

		TextArea text_show = new TextArea();

		BorderPane mainPane = new BorderPane();
		mainPane.setCenter( new ScrollPane( text_show ) );
		mainPane.setTop( input_pane );

		primaryStage.setTitle( "Client" );
		primaryStage.setScene( new Scene( mainPane, 450, 200 ) );
		primaryStage.show( );

		//监听事件：文本框的输入
		text_input.setOnAction( (e)->{
			try {
				double radius = Double.parseDouble( text_input.getText().trim() );
				toServer.writeDouble( radius );
				toServer.flush( );
				double area = fromServer.readDouble();
				text_show.appendText( "Radius is : "+radius+'\n' );
				text_show.appendText( "Area received from the server is : "+area+'\n' );
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
//		text_input.setOnAction( new EventHandler<ActionEvent>(){
//			@Override
//			public void handle(ActionEvent arg0) {
//
//			}
//		} );
//
		try {
			Socket socket=new Socket("localhost",8000);
			fromServer=new DataInputStream(socket.getInputStream());
			toServer=new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
