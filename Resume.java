package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.animation.*;

public class Resume extends Application {
	
	//ArrayList<Game> savedgames;
	
	Resume( Stage stage){
		try {
			start(stage);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public ImageView addbackground() throws FileNotFoundException {
        Image image1 = new Image("AP\\saved.jpg");
        ImageView imageView=new ImageView(image1);
        imageView.setFitHeight(1700);
        imageView.setFitWidth(1700);
        imageView.setPreserveRatio(true);
        return imageView;
    }

    public Button addbackbutton() throws FileNotFoundException {
        Image i = new Image("AP\\homebutton.png");
        ImageView iw = new ImageView(i);
        iw.setFitHeight(80);
        iw.setFitWidth(80);
        Button b = new Button("", iw);
        b.setLayoutX(100);
        b.setLayoutY(80);
        b.setPadding(new Insets(-25));
        return b;

    }

    public Button addsavegamebutton1() {
        Button b2 = new Button("Saved Game 1");
        Font font = Font.font("Verdana", FontWeight.NORMAL, 25);
        b2.setFont(font);
        b2.setBackground(null);
        b2.setTextFill(Color.WHITE);
        b2.setLayoutX(700);
        b2.setLayoutY(205);
        b2.setPadding(new Insets(-2));
        return b2;

    }

    public Button addsavegamebutton2() {

        Button b3 = new Button("Saved Game 2");
        Font font = Font.font("Verdana", FontWeight.NORMAL, 25);
        b3.setFont(font);
        b3.setBackground(null);
        b3.setTextFill(Color.WHITE);
        b3.setLayoutX(700);
        b3.setLayoutY(365);
        b3.setPadding(new Insets(-2));
        return b3;

    }

    public Button addsavegamebutton3() {
        Button b4 = new Button("Saved Game 3");
        Font font = Font.font("Verdana", FontWeight.NORMAL, 25);
        b4.setFont(font);
        b4.setBackground(null);
        b4.setTextFill(Color.WHITE);
        b4.setLayoutX(700);
        b4.setLayoutY(560);
        b4.setPadding(new Insets(-2));
        return b4;


    }
    
    public Game deserialise(int count) {
    	FileInputStream f;
    	ArrayList<Game> g = new ArrayList<>();
		try {
			f = new FileInputStream("colorswitch.ser");
			ObjectInputStream i=new ObjectInputStream(f);
			g = (ArrayList) i.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			return (Game)g.get(count-1);
    }
    
    void addscaletransition(Button h){

        ScaleTransition st = new ScaleTransition(Duration.millis(1000), h);
        st.setToX(0.9);
        st.setToY(0.9);
        st.setByX(1);
        st.setByY(1);
        st.setCycleCount(Animation.INDEFINITE);
        st.play();
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        ImageView imageView=addbackground();
        Button b=addbackbutton();
        b.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        	try {
				stage.setScene(Main.homescene);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	}
        });
        int count;
        addscaletransition(b);
        Button b2=addsavegamebutton1();
        b2.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        	try {
				Game g = deserialise(1);
				Game resume_game = new Game(g, stage);
				//resume_game = new Game(g, stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	}
        	});
        Button b3=addsavegamebutton2();
        b3.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        	try {
        		Game g = deserialise(2);
        		Game resume_game = new Game(g, stage);
        		//resume_game = new Game(g, stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	}
        	});
        Button b4=addsavegamebutton3();
        b4.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        	try {
        		Game g = deserialise(3);
        		Game resume_game = new Game(g, stage);
        		//resume_game = new Game(g, stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	}
        });
        //Game g= deserialise(count);
        Group root = new Group(imageView,b,b2,b3,b4);
        Scene scene = new Scene(root, 1500, 800, Color.BLACK );
        //stage.setTitle("Color Switch");
        stage.setScene(scene);

        stage.show();
        //return g;
    }
    
}
