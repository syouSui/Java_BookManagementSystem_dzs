package test.InternetPrograming.multiplyThreadSever;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class MultiplyThreadSever extends Application {
	public static void main(String[] args) {
		launch( );
	}
	
	private int clintNo = 0;
	private TextArea text_show = new TextArea( );
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle( "MultiplyThreadSever" );
//		primaryStage.setScene( new Scene( text_show ), 450, 200 );
		primaryStage.show( );
		
		new Thread( ()->{ // Server�˿�, ����ĳ���˿��Ƿ�����������
			try {
				// 1) server��Lisetn(����) ĳ���˿��Ƿ�����������
				ServerSocket serverScoket = new ServerSocket( 8000 );
				while ( true ) {
					//��������, �����һֱ�ڵȴ�, ֱ��һ���ͻ������꽫����������
					Socket socket = serverScoket.accept();
					clintNo++;
					Platform.runLater( ()->{
						text_show.appendText( "Starting thread for client "+clintNo+" at "+new java.util.Date()+'\n' );
					});
					new Thread( new HandlerAClient( socket) ).start();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
	} ).start();

	}

	class HandlerAClient implements Runnable {
		private Socket socket;
		public HandlerAClient( Socket socket ) {
			this.socket = socket;
		}
		@Override
		public void run() {
			try {
				// �뾶 --> д��ͻ��˵�������  --> �������δ��������ȡ
				// ��� --> ������д�������      --> �ͻ��˶�ȡ
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
		}
		
	}

}
