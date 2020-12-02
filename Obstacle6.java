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

public class Obstacle6 extends Obstacles{
	
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
	
	

	Obstacle6(int pos) throws Exception
	{
		sety_pos(pos);
		 start();

	}
	


    public void start() throws Exception{

       
        ImageView imgView = new ImageView();
        List<Image> images2 = new ArrayList<>();
        
        create(images2);
        move(imgView, images2);

      setObstacle(imgView);
      
    }

    public void create(List<Image> images3) throws FileNotFoundException {
    	Image im1 = new Image("AP\\diamond1.png");
        Image im2 = new Image("AP\\diamond2.png");
        Image im3 = new Image("AP\\diamond3.png");
        Image im4 = new Image("AP\\diamond4.png");
        Image im5 = new Image("AP\\diamond5.png");
        Image im6 = new Image("AP\\diamond6.png");
        Image im7 = new Image("AP\\diamond7.png");
        Image im8 = new Image("AP\\diamond8.png");



        images3.add(im1);
        images3.add(im2);
        images3.add(im3);
        images3.add(im4);
        images3.add(im5);
        images3.add(im6);
        images3.add(im7);
        images3.add(im8);
        images3.add(im8);

    }

    void move(ImageView imView, List<Image> images3) {

    	Transition animation3 = new Transition() {
            {
                setCycleDuration(Duration.millis(2000)); // total time for animation
                setCycleCount(Animation.INDEFINITE);
            }

            @Override
            protected void interpolate(double fraction) {
                int index = (int) (fraction*(images3.size()-1));
                imView.setImage(images3.get(index));
                setOrientation(index);
                imView.setX(getx_pos());
                imView.setY(gety_pos());
                imView.setFitHeight(220);
                imView.setFitWidth(220);
                imView.setPreserveRatio(true);
                //System.out.println(index);
            }
        };
        animation3.play();
    }

	
	
	public void get_ypos() {
		
	}
	
}
