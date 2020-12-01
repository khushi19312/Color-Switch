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

        ImageView s = new ImageView();
        List<Image> sq = new ArrayList<>();
        
        create(sq);
        move(s, sq);


        Group root = new Group(imageV, s);
        primaryStage.setScene(new Scene(root, 1500, 800, Color.BLACK));
        primaryStage.show();
    }

    public void create(List<Image> sq) throws FileNotFoundException {
    	Image square1 = new Image("AP\\square1.png");
        Image square2 = new Image("AP\\square2.png");
        Image square3 = new Image("AP\\square3.png");
        Image square4 = new Image("AP\\square4.png");
        Image square5 = new Image("AP\\square5.png");
        Image square6 = new Image("AP\\square6.png");
        Image square7 = new Image("AP\\square7.png");
        Image square8 = new Image("AP\\square8.png");

        sq.add(square1);
        sq.add(square2);
        sq.add(square3);
        sq.add(square4);
        sq.add(square5);
        sq.add(square6);
        sq.add(square7);
        sq.add(square8);
        sq.add(square8);

    }

    void move(ImageView s, List<Image> sq) {

    	Transition squarerotate = new Transition() {
            {
                setCycleDuration(Duration.millis(2000));
                setCycleCount(Animation.INDEFINITE);
            }

            @Override
            protected void interpolate(double fraction) {
                int index = (int) (fraction*(sq.size()-1));
                s.setImage(sq.get(index));
                setOrientation(index);
                s.setX(630);
                s.setY(280);
                s.setFitHeight(230);
                s.setFitWidth(230);
                s.setPreserveRatio(true);
            }

        };
        squarerotate.play();
    }

	
	
	public void get_ypos() {
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

