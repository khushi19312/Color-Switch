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
	
	Obstacle3(int pos) throws Exception
	{
		 
         sety_pos(pos);
         start();
	}
	
    public void start() throws Exception{

        ImageView t = new ImageView();
        List<Image> tr = new ArrayList<>();
        
        create(tr);
        move(t, tr);

        setObstacle(t);
    }

    public void create(List<Image> tr) throws FileNotFoundException {
    	Image tri1 = new Image("AP\\triangle1.png");
        Image tri2 = new Image("AP\\triangle2.png");
        Image tri3 = new Image("AP\\triangle3.png");
        Image tri4 = new Image("AP\\triangle4.png");

        tr.add(tri1);
        tr.add(tri2);
        tr.add(tri3);
        tr.add(tri4);
        tr.add(tri4);

    }

    void move(ImageView t, List<Image> tr) {

    	Transition trianglerotate = new Transition() {
            {
                setCycleDuration(Duration.millis(2000));
                setCycleCount(Animation.INDEFINITE);
            }

            @Override
            protected void interpolate(double fraction) {
                int index = (int) (fraction*(tr.size()-1));
                t.setImage(tr.get(index));
                setOrientation(index);
                t.setX(getx_pos()+60);
                t.setY(gety_pos());
                t.setFitHeight(220);
                t.setFitWidth(220);
                t.setPreserveRatio(true);
            }

        };
        trianglerotate.play();
    }

	
	
	public void get_ypos() {
		
	}
	
}
