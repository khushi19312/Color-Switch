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
	
	Obstacle1(int pos) throws Exception
	{
		 
         sety_pos(pos);
         start();
	}

    public void start() throws Exception{
        
        ImageView br = new ImageView();
        List<Image> bubble = new ArrayList<>();
        
        create(bubble);
        move(br, bubble);
        setObstacle(br);

    }

    public void create(List<Image> bubble) throws FileNotFoundException {
        Image bubblering1 = new Image("AP\\bubblering1.png");//orientation 1
        Image bubblering2 = new Image("AP\\bubblering2.png");//orientation 2
        Image bubblering3 = new Image("AP\\bubblering3.png");//3
        Image bubblering4 = new Image("AP\\bubblering4.png");//4
        Image bubblering5 = new Image("AP\\bubblering5.png");//5
        Image bubblering6 = new Image("AP\\bubblering6.png");//6

        bubble.add(bubblering1);
        bubble.add(bubblering2);
        bubble.add(bubblering3);
        bubble.add(bubblering4);
        bubble.add(bubblering5);
        bubble.add(bubblering6);
        bubble.add(bubblering6);

    }

    public void move(ImageView br, List<Image> bubble) {

        Transition bubblerotate = new Transition() {
            {
                setCycleDuration(Duration.millis(2000));
                setCycleCount(Animation.INDEFINITE);
            }

            @Override
            protected void interpolate(double fraction) {
                int index = (int) (fraction*(bubble.size()-1));
                setOrientation(index);
                br.setImage(bubble.get(index));
                //setDelay(2000);
                setOrientation(index);
                //System.out.println(getOrientation());
                br.setX(getx_pos()+100);
                br.setY(gety_pos());
                br.setFitHeight(220);
                br.setFitWidth(220);
                br.setPreserveRatio(true);
            }
        };
        bubblerotate.play();
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
