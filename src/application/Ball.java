package application;

import java.io.Serializable;
import java.util.HashMap;

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

public class Ball extends Application implements Serializable{
	  private transient Circle myball;
	  private transient HashMap<Integer,Color> colors;
	  private int x_pos;
	  private int y_pos=700;
	  private int y_jump=100;
	  private int color;
	  private boolean presence;
	  private static long serialVersionUID;
	  private float dist;
     private float gr;
      private transient Timeline pre=null;
      
      public Ball(HashMap<Integer,Color> colors)
      {
    	  this.colors=colors;
      }
	  public int gety_pos(){
	    return y_pos;
	  }
	  
	
	  
	  public void setx_pos(int x){
		    myball.setCenterX(x);
		    x_pos=x;
		  }
	  public void increasey_jump(int y){
	    y_jump+=y;
	  }
	  public void change_colour(int c){
		  if(color==c)
		  {
			  if(color==1)
				  c=4;
			  else
				  c--;
		  }
	    color = c;
	   // if(colors==null)System.out.println("NULL");
	    myball.setFill(colors.get(c));
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
     	//System.out.println("Enter pressed");
          timeline2 = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>(){
         		 @Override
         		 public void handle(ActionEvent e)
         		 {
         		myball.setCenterY(myball.getCenterY()-dist);
         		sety_pos((int)myball.getCenterY());
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
	  
	 
	  protected transient Timeline timeline2=null;
	public Circle getMyball() {
		return myball;
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public void setMyball(Circle ball) {
		// TODO Auto-generated method stub
		myball=ball;
	}



	public void sety_pos(int i) {
		// TODO Auto-generated method stub
		myball.setCenterY(i);
	    y_pos=i;
	}


	}
