package application;

import java.util.List;
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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList; 
import java.util.List;
import javafx.application.Application;

public abstract class Obstacles extends Application {
	private int x_pos=570;
	private int y_pos;
	private String type;
	private int orientation;
	protected List <Integer> colors;
	private int speed;
	private static long serialVersionUID;
	private ImageView obstacle;
	
	public abstract void move(ImageView imageView, List<Image> images) ;
	public abstract void create(List<Image> images) throws FileNotFoundException;
	public int getColour_ypos() {
		return 1;
	}
	
	public abstract int[] collision_pos(int ballpos);
	public int getx_pos() {
		return x_pos;
	}
	public int gety_pos(){
		return y_pos;
	}
	public void setx_pos(int x) {
		x_pos = x;
	}
	public void sety_pos(int x) {
		y_pos = x;
	}
	public abstract int getColours(int ballpos);
	
	public void setColours(List<Integer> l) {
		
	}
	public void setSpeed(int x) {
		speed = x;
	}
	public int getSpeed() {
		return speed;
	}
	public int getOrientation() {
		return orientation;
	}
	public void setOrientation(int x) {
		orientation = x;
	}
	public void setType(String s) {
		type = s;
	}
	public String getType() {
		return type;
	}
	//private void checkDifficulty(Stars s) {
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public ImageView getObstacle() {
		return obstacle;
	}
	public void setObstacle(ImageView obstacle) {
		this.obstacle = obstacle;
	}
		
	//}

}
