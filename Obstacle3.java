package application;

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList; 
import java.util.List;

public class Obstacle3 extends Obstacles{
	
	

	
	
	/*private int x_pos;
	private int y_pos;
	private String type;
	private int orientation;
	protected List <Integer> colors;
	private int speed;
	private static long serialVersionUID;*/
	//private static String[] args1;
	
	/*Obstacle1(Stage stage) throws Exception{
		start(stage);
	}*/
	
	List<Rectangle> t;
	
	Obstacle3(int pos) throws Exception
	{
		t= new ArrayList<Rectangle>();
		sety_pos(pos);
		//setx_pos(650);
		start();

	}
	
    public void start() throws Exception{

        

    	create(t);
        Group group = new Group(t.get(0), t.get(1), t.get(2));       
        move(group, t);         
        setObstacle(group);

        
    }

    public void create(List<Rectangle> t) throws FileNotFoundException {
    	Rectangle rect1= new Rectangle();
        rect1.setX(690); 
		rect1.setY(gety_pos()-100); 
		rect1.setWidth(20); 
		rect1.setHeight(250); 
		rect1.setArcWidth(30.0); 
		rect1.setArcHeight(20.0);  
		rect1.setRotate(32);
		rect1.setFill(Color.web("#FF0181"));
        
		Rectangle rect2= new Rectangle();
		rect2.setX(812); 
		rect2.setY(gety_pos()-100); 
		rect2.setWidth(20); 
		rect2.setHeight(250); 
		rect2.setArcWidth(30.0); 
		rect2.setArcHeight(20.0);  
		rect2.setRotate(-32);
		rect2.setFill(Color.web("#900DFF"));
		
        Rectangle rect3= new Rectangle();
        rect3.setX(628); 
		rect3.setY(gety_pos()+116.205); 
		rect3.setWidth(265); 
		rect3.setHeight(20); 
		rect3.setArcWidth(30.0); 
		rect3.setArcHeight(20.0);  
		rect3.setFill(Color.web("FAE100"));
        
        
        
		t.add(rect1);
        t.add(rect2);
        t.add(rect3);

    }

    public void move(Group g, List<Rectangle> sq) {

    	RotateTransition rotate = new RotateTransition(); 
        
        rotate.setDuration(Duration.millis(4000));
        rotate.setCycleCount(Animation.INDEFINITE);
    	rotate.setByAngle(360);
    	rotate.setAutoReverse(false);
    	rotate.setInterpolator(Interpolator.LINEAR);
    	//rotate.pivotXProperty().bind(195);
    	//rotate.pivotYProperty().bind(400);
    	rotate.setNode(g);
    	rotate.play();
    }

	@Override
	public int getColours(int ballpos) {
		if(ballpos>=gety_pos())
			{
				if(getOrientation()==1 || getOrientation()==2)
				    return 1;
				else if(getOrientation()==3 || getOrientation()==4)
				    return 4;
				else if(getOrientation()==5 || getOrientation()==6)
				    return 2;
				else 
				    return 3;
			}
		else
			{
			
			if(getOrientation()==1 || getOrientation()==2)
			    return 2;
			else if(getOrientation()==3 || getOrientation()==4)
			    return 3;
			else if(getOrientation()==5 || getOrientation()==6)
			    return 1;
			else 
			    return 4;
				
			}
	}

	@Override
	public int[] collision_pos(int ballpos) {
		// TODO Auto-generated method stub
		int[] limits=new int[4];
		limits[0]=gety_pos()+130+18;
		limits[1]=gety_pos()+130;
		limits[2]=gety_pos()-130;
		limits[3]=gety_pos()-130-18;
		return limits;
		
	}


}
