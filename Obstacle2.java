package application;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList; 
import java.util.List;

public class Obstacle2 extends Obstacles{
	
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
	private transient List<Rectangle> sq=new ArrayList();;
	private Ball ball;
	public Obstacle2(int pos, Ball b) throws Exception
	{
		
		ball = (Ball)b; 
		sq= new ArrayList<Rectangle>();
        setType("square");
         sety_pos(pos);
         start();
	}
	
    public void start() throws Exception{


        //ImageView s = new ImageView();
    	//List<Rectangle> sq = new ArrayList<>(); 
        create(sq);        
        Group group = new Group(sq.get(0), sq.get(1), sq.get(2), sq.get(3));       
        move(group, sq);         
        setObstacle(group);
        /*Group root = new Group(group);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/
        ball.getMyball().boundsInParentProperty().addListener((ChangeListener<? super Bounds>) new ChangeListener<Bounds>() {
	        @Override
	        public void changed(ObservableValue<? extends Bounds> observable,
	                Bounds oldValue, Bounds newValue) {
	            for (Rectangle o : sq ) {
	                if (((Path)Shape.intersect(ball.getMyball(), o)).getElements().size() > 0) {
	                    if(!o.getFill().equals(ball.getMyball().getFill())){
	                    	Game.gameover=true;
	                    }
	                    if(o.getFill().equals(ball.getMyball().getFill())){
	                    	System.out.println("Pass!");
	                    }
	                }
	            }
	        }
	    });

    }

    public void create(List<Rectangle> sq) throws FileNotFoundException {
    	/*Image square1 = new Image("AP\\square1.png");
        Image square2 = new Image("AP\\square2.png");
        Image square3 = new Image("AP\\square3.png");
        Image square4 = new Image("AP\\square4.png");
        Image square5 = new Image("AP\\square5.png");
        Image square6 = new Image("AP\\square6.png");
        Image square7 = new Image("AP\\square7.png");
        Image square8 = new Image("AP\\square8.png");*/
        
    	
    	Rectangle rect1= new Rectangle();
        rect1.setX(650); 
		rect1.setY(gety_pos()-80); 
		rect1.setWidth(200); 
		rect1.setHeight(20); 
		rect1.setArcWidth(30.0); 
		rect1.setArcHeight(20.0);  
		rect1.setFill(Color.web("#FF0181"));
        
		Rectangle rect2= new Rectangle();
		rect2.setX(650); 
		rect2.setY(gety_pos()-80); 
		rect2.setWidth(20); 
		rect2.setHeight(200); 
		rect2.setArcWidth(30.0); 
		rect2.setArcHeight(20.0);  
		rect2.setFill(Color.web("#900DFF"));
		
        Rectangle rect3= new Rectangle();
        rect3.setX(650); 
		rect3.setY(gety_pos()+100); 
		rect3.setWidth(200); 
		rect3.setHeight(20); 
		rect3.setArcWidth(30.0); 
		rect3.setArcHeight(20.0);  
		rect3.setFill(Color.web("FAE100"));
        
        Rectangle rect4= new Rectangle();
        rect4.setX(830); 
		rect4.setY(gety_pos()-80); 
		rect4.setWidth(20); 
		rect4.setHeight(200); 
		rect4.setArcWidth(30.0); 
		rect4.setArcHeight(20.0);  
		rect4.setFill(Color.web("#32DBF0"));
        
		sq.add(rect1);
        sq.add(rect2);
        sq.add(rect3);
        sq.add(rect4);

        /*sq.add(square1);
        sq.add(square2);
        sq.add(square3);
        sq.add(square4);
        sq.add(square5);
        sq.add(square6);
        sq.add(square7);
        sq.add(square8);
        sq.add(square8);*/

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
    public ArrayList<Rectangle> getShape() {
    	return (ArrayList<Rectangle>) sq;
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
