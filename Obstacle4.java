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

public class Obstacle4 extends Obstacles{
	
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
	
	Obstacle4(int pos) throws Exception
	{
		 
         sety_pos(pos);
         start();
	}
	

	
	
    public void start() throws Exception{

        
        ImageView imageView = new ImageView();
        List<Image> image = new ArrayList<>();
        
        create(image);
        move(imageView, image);

        setObstacle(imageView);
        
    }

    public void create(List<Image> images) throws FileNotFoundException {
    	Image image1 = new Image("AP\\line1.png");
        Image image2 = new Image("AP\\line2.png");
        Image image3 = new Image("AP\\line3.png");
        Image image4 = new Image("AP\\line4.png");
        Image image5 = new Image("AP\\line5.png");
        Image image6 = new Image("AP\\line6.png");
        Image image7 = new Image("AP\\line7.png");
        Image image8 = new Image("AP\\line8.png");

        images.add(image1);
        images.add(image2);
       images.add(image3);
       images.add(image4);
        images.add(image5);
     images.add(image6);
        images.add(image7);
        images.add(image8);
       images.add(image8);

    }

    public void move(ImageView imageView, List<Image> images) {

    	Transition animation = new Transition() {
            {
                setCycleDuration(Duration.millis(4000)); // total time for animation
                setCycleCount(Animation.INDEFINITE);
            }

            @Override
            protected void interpolate(double fraction) {
                int index = (int) (fraction*(images.size()-1));
                imageView.setImage(images.get(index));
                
                setOrientation(index);
               // System.out.println(" line"+(index+1));
                imageView.setX(getx_pos());
                imageView.setY(gety_pos());
                imageView.setFitHeight(360);
                imageView.setFitWidth(360);
                imageView.setPreserveRatio(true);
                
            }
        };
        animation.play();
    }




	@Override
	public int getColours(int ballpos) {
		// TODO Auto-generated method stub
		if(getOrientation()==1 || getOrientation()==2)
		    return 4;
		else if(getOrientation()==3 || getOrientation()==4)
		    return 2;
		else if(getOrientation()==5 || getOrientation()==6)
		    return 1;
		else 
		    return 4;
	}




	@Override
	public int[] collision_pos(int ballpos) {
		// TODO Auto-generated method stub
		int[] limits=new int[2];
		limits[0]=gety_pos()+17;
		limits[1]=gety_pos()-17;
		return limits;
	}


	
}
