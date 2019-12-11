package test.InternetPrograming.oneUser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.*;

public class Server extends Application {

	public static void main ( String[] args) {
		Application.launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		TextArea text_show = new TextArea( );
		primaryStage.setTitle( "Server" );
		primaryStage.setScene( new Scene( new ScrollPane(text_show), 450, 200) );
		primaryStage.show( );

		new Thread( ()->{ //Server端Listen（监听）某个端口是否有连接请求。
			try {
				//1)Server端Listen（监听）某个端口是否有连接请求。
				//创建一个服务器套接字，并附加到一个端口上
				ServerSocket serverScoket = new ServerSocket( 8000 );
				Platform.runLater( new Runnable( ) {
					@Override
					public void run() {
						text_show.appendText( "Sever started at "+new java.util.Date()+'\n' );
					}

				});
//				Platform.runLater( ()->{
//					text_show.appendText( "Sever started at "+new java.util.Date()+'\n' );
//				});

				//监听连接，该语句一直等待，直到一个客户端连接到服务器套接字
				Socket socket = serverScoket.accept();

				//2)创建输入流、输出流
				//半径---》客户端写入（客户端的）输出流----》服务器端从输入流中读取
				//面积---》服务器端写入输出流-----》客户端从输入流中读取
				DataInputStream inputFromClient = new DataInputStream( socket.getInputStream() );
				DataOutputStream outputToClient = new DataOutputStream( socket.getOutputStream() );
				while ( true ) {
					double radius = inputFromClient.readDouble( );
					double area = radius*radius*Math.PI;
					outputToClient.writeDouble( area );
					Platform.runLater( ()->{
						text_show.appendText( "Radius received from client:  "+new java.util.Date()+'\n' );
						text_show.appendText( "Area is: "+area+'\n' );
					});
				}


			} catch (Exception e) {
				e.printStackTrace();
			}
		} ).start();
	}



}