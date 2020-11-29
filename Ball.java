package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ball extends Application{
	  private int x_pos;
	  private int y_pos;
	  private int y_jump;
	  private int color;
	  private boolean presence;
	  private static long serialVersionUID;
	  
	  public int gety_pos(){
	    return x_pos;
	  }
	  public void sety_pos(int x){
	    y_pos = x;
	  }
	  public void increasey_jump(int y){
	    y_pos += y;
	  }
	  public void change_colour(int c){
	    color = c;
	  }
	  public int get_colour(){
	    return color;
	  }
	  public boolean get_presence(){
	    return presence;
	  }
	  public void change_presence(){
	    presence = !presence;
	  }
	  
	  public static void main(String[] args)
	  {
		  launch(args);
	  }
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Circle ball = new Circle(10, Color.RED);
        ball.setCenterY(600);
        ball.setCenterX(738);
        //ball.relocate(0,10);
        

        Group root = new Group(ball);
        Scene scene = new Scene(root, 1500, 800);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.ENTER) {
            	
            	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(ball.layoutYProperty(), -40)));
            	 
                timeline.setCycleCount(1);
               
                timeline.play();
                
            }
      });
        stage.setTitle("Color Switch");
        stage.setScene(scene);

        stage.show();
		
	}
	}
