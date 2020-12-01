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

public class Obstacle5 extends Obstacles{
	
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
	
	public ImageView addbackground() throws FileNotFoundException {

        Image image = new Image("AP\\background.png");
        ImageView imageV=new ImageView(image);
        imageV.setFitHeight(1700);
        imageV.setFitWidth(1700);
        imageV.setPreserveRatio(true);
        return imageV;

    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        ImageView imageV=addbackground();

        ImageView imgView = new ImageView();
        List<Image> images2 = new ArrayList<>();
        
        create(images2);
        move(imgView, images2);


        Group root = new Group(imageV, imgView);
        primaryStage.setScene(new Scene(root, 1500, 800, Color.BLACK));
        primaryStage.show();
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

    void move(ImageView imgView, List<Image> images2) {

    	Transition animation2 = new Transition() {
            {
                setCycleDuration(Duration.millis(2000)); // total time for animation
                setCycleCount(Animation.INDEFINITE);
            }

            @Override
            protected void interpolate(double fraction) {
                int index = (int) (fraction*(images2.size()-1));
                imgView.setImage(images2.get(index));
                setOrientation(index);
                imgView.setX(660);
                imgView.setY(290);
                imgView.setFitHeight(180);
                imgView.setFitWidth(180);
                imgView.setPreserveRatio(true);
            }
        };
        animation2.play();
    }

	
	
	public void get_ypos() {
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

