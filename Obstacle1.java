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
        
        ImageView br = new ImageView();
        List<Image> bubble = new ArrayList<>();
        
        create(bubble);
        move(br, bubble);


        Group root = new Group(imageV, br);
        primaryStage.setScene(new Scene(root, 1500, 800));
        primaryStage.show();
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

    void move(ImageView br, List<Image> bubble) {

        Transition bubblerotate = new Transition() {
            {
                setCycleDuration(Duration.millis(2000));
                setCycleCount(Animation.INDEFINITE);
            }

            @Override
            protected void interpolate(double fraction) {
                int index = (int) (fraction*(bubble.size()-1));
                
                br.setImage(bubble.get(index));
                //setDelay(2000);
                setOrientation(index);
                //System.out.println(getOrientation());
                br.setX(655);
                br.setY(320);
                br.setFitHeight(170);
                br.setFitWidth(170);
                br.setPreserveRatio(true);
            }
        };
        bubblerotate.play();
    }

	
	
	public void get_ypos() {
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

