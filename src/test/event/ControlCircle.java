package test.event;






import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {
	private CirclePane circlePane = new CirclePane();

	@Override
	public void start(Stage primaryStage) throws Exception {
//		StackPane pane = new StackPane( ); 
//		Circle circle = new Circle( 50 );
//		circle.setStroke( Color.RED );
//		circle.setFill( Color.YELLOW );
		
		HBox hbox = new HBox( );
		hbox.setSpacing( 10 );
		hbox.setAlignment(Pos.CENTER );
		
		Button btEnlarge = new Button( "放大" );
		btEnlarge.setOnAction( new EnlargeHandler() );
		Button btShrink = new Button( "缩小" );
		btShrink.setOnAction( new ShrinkHandler() );
		hbox.getChildren().addAll( btEnlarge, btShrink );
		
		BorderPane borderPane = new BorderPane( );
		borderPane.setCenter( circlePane );
		borderPane.setBottom( hbox );
		borderPane.setAlignment( hbox, Pos.CENTER );
		
		primaryStage.setTitle( "ControlCircle" );
		primaryStage.setScene( new Scene( borderPane, 500, 400 ) );
		primaryStage.show( );
		
	}

	public static void main(String[] args) {
		Application.launch( args );
	}
	
	class EnlargeHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			circlePane.enlarge( );
		}
	}
	class ShrinkHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			circlePane.shrink( );
		} 
	}
}
class CirclePane extends StackPane { // 事件处理器类
	private Circle circle = new Circle( 50 ); 
	public CirclePane () {
		this.getChildren().add( circle );
		circle.setStroke( Color.RED );
		circle.setFill( Color.YELLOW );
		
	}
	public void enlarge ( ) {
		circle.setRadius(circle.getRadius()+10 );
	}
	public void shrink ( ) {
		circle.setRadius( circle.getRadius()>10 ? circle.getRadius()-10 : 10 );
	}
}