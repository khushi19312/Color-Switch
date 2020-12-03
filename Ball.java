package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ball extends Application{
	  private Circle myball;
	  private int x_pos;
	  private int y_pos;
	  private int y_jump;
	  private int color;
	  private boolean presence;
	  private static long serialVersionUID;
	  float dist;
      float gr;
      Timeline pre=null;
      
	  public int gety_pos(){
	    return getY_pos();
	  }
	  public void sety_pos(int x){
	    setY_pos(x);
	  }
	  public void increasey_jump(int y){
	    setY_pos(getY_pos() + y);
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
	  
	
	 
	  public void move()
	  {
		  int maxtotravel=(int) ((myball.getCenterY()-y_jump));
     	  if(pre!=null)
     	pre.stop();
     	 dist=5;
     	 gr=(float)0.2;
     	System.out.println("Enter pressed");
          Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>(){
         		 @Override
         		 public void handle(ActionEvent e)
         		 {
         		myball.setCenterY(myball.getCenterY()-dist);
         		setY_pos((int)myball.getCenterY());
         		dist-=gr;
         		//if(dist>0)System.out.println("************up***********");
         		//else
         			//System.out.println("down");
         		if(myball.getCenterY()<=maxtotravel)
         			{dist=-dist;
         			//gr=-1*(float)0.1;
         			}
	 
          }
          }));
          
          timeline2.setCycleCount(Animation.INDEFINITE);
          // ball.setCenterY(ball.getCenterY()-20);
         
           timeline2.play(); 
           pre=timeline2;
	  }
	  
	 
	
	public Circle getMyball() {
		return myball;
	}
	public void setMyball(Circle myball) {
		this.myball = myball;
	}
	public int getY_pos() {
		return y_pos;
	}
	public void setY_pos(int y_pos) {
		this.y_pos = y_pos;
	}
	public int getX_pos() {
		return x_pos;
	}
	public void setX_pos(int x_pos) {
		this.x_pos = x_pos;
	}
	public int getY_jump() {
		return y_jump;
	}
	public void setY_jump(int y_jump) {
		this.y_jump = y_jump;
	}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	}
