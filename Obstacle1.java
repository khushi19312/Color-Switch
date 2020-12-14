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

public class Obstacle1 extends Obstacles{
	
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
	List<Rectangle> c;
	
	Obstacle1(int pos) throws Exception
	{
		 c = new ArrayList<Rectangle>();
         sety_pos(pos);
         start();
	}

    public void start() throws Exception{
        
    	
        
        create(c);
        Group group = new Group(c.get(0), c.get(1), c.get(2), c.get(3));       
        move(group, c);         
        setObstacle(group);

    }

    public void create(List<Rectangle> c) throws FileNotFoundException {
    	Rectangle rect1= new Rectangle();
        rect1.setX(680); 
		rect1.setY(gety_pos()-90); 
		rect1.setWidth(20); 
		rect1.setHeight(100); 
		rect1.setArcWidth(30.0); 
		rect1.setArcHeight(20.0);  
		rect1.setFill(Color.web("#FF0181"));
        
		Rectangle rect2= new Rectangle();
		rect2.setX(590); 
		rect2.setY(gety_pos()); 
		rect2.setWidth(100); 
		rect2.setHeight(20); 
		rect2.setArcWidth(30.0); 
		rect2.setArcHeight(20.0);  
		rect2.setFill(Color.web("#900DFF"));
		
        Rectangle rect3= new Rectangle();
        rect3.setX(690); 
		rect3.setY(gety_pos()); 
		rect3.setWidth(100); 
		rect3.setHeight(20); 
		rect3.setArcWidth(30.0); 
		rect3.setArcHeight(20.0);  
		rect3.setFill(Color.web("FAE100"));
        
        Rectangle rect4= new Rectangle();
        rect4.setX(680); 
		rect4.setY(gety_pos()); 
		rect4.setWidth(20); 
		rect4.setHeight(110); 
		rect4.setArcWidth(30.0); 
		rect4.setArcHeight(20.0);  
		rect4.setFill(Color.web("#32DBF0"));
        
		c.add(rect1);
        c.add(rect2);
        c.add(rect3);
        c.add(rect4);
    }

    public void move(Group g, List<Rectangle> sq) {

    	RotateTransition rotate = new RotateTransition(); 
        
        rotate.setDuration(Duration.millis(4000));
        rotate.setCycleCount(Animation.INDEFINITE);
    	rotate.setByAngle(-360);
    	rotate.setAutoReverse(false);
    	rotate.setInterpolator(Interpolator.LINEAR);
    	//rotate.pivotXProperty().bind(195);
    	//rotate.pivotYProperty().bind(400);
    	rotate.setNode(g);
    	rotate.play();
    }

	
	
	public void get_ypos() {
		
	}

	@Override
	public int[] collision_pos(int ballpos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColours(int ballpos) {
		// TODO Auto-generated method stub
		return 0;
	}
}
