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
	
	

	Obstacle3(int pos) throws Exception
	{
		sety_pos(pos);
		setx_pos(650);
		 start();

	}
	
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
	

    public void start() throws Exception{

        

        ImageView imgView = new ImageView();
        List<Image> images2 = new ArrayList<>();
        
        create(images2);
        move(imgView, images2);
        setObstacle(imgView);

        
    }

    public void create(List<Image> images2) throws FileNotFoundException {
    	Image img1 = new Image("AP\\ring1.png");
        Image img2 = new Image("AP\\ring2.png");
        Image img3 = new Image("AP\\ring3.png");
        Image img4 = new Image("AP\\ring4.png");
        Image img5 = new Image("AP\\ring5.png");
        Image img6 = new Image("AP\\ring6.png");
        Image img7 = new Image("AP\\ring7.png");
        Image img8 = new Image("AP\\ring8.png");



       images2.add(img1);
       images2.add(img2);
        images2.add(img3);
       images2.add(img4);
        images2.add(img5);
        images2.add(img6);
       images2.add(img7);
        images2.add(img8);
        images2.add(img8);

    }

    public void move(ImageView imgView, List<Image> images2) {

    	Transition animation2 = new Transition() {
            {
                setCycleDuration(Duration.millis(4000)); // total time for animation
                setCycleCount(Animation.INDEFINITE);
            }

            @Override
            protected void interpolate(double fraction) {
                int index = (int) (fraction*(images2.size()-1));
                imgView.setImage(images2.get(index));
                setOrientation(index);
               // System.out.println("ring"+(index+1));
                imgView.setX(getx_pos());
                imgView.setY(gety_pos());
                imgView.setFitHeight(220);
                imgView.setFitWidth(220);
                imgView.setPreserveRatio(true);
            }
        };
        animation2.play();
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
