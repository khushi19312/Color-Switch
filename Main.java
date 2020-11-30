package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application 
{
	
		private boolean new_game;
		private static Game new_game_obj;
		private boolean resume_game;
		private Resume resume_game_obj;
		private Save save_obj;
		private boolean exit;
		private HashMap<Integer,Game> prev_games;
		private int highScore;
		private static String[] args;
			
		public static void main(String[] args1)
		{
			 args=args1;
			 MainMenu();
			 
		}
		
		public static void MainMenu() {
			launch(args);
		}
		
		public static  void NewGame(Stage stage) throws FileNotFoundException
		{
			System.out.println("new game");
			new_game_obj=new Game(stage);
			
		}
		
		
		public static  void help()//
		{
			
		}
		public static void ResumeGame()
		{
			
		}
		
		public static void computeHighScore()
		{
			
		}
		
		public static void exit()
		{
			
		}
		
		
		 public void addhomepage(List<Image> images) throws FileNotFoundException {

		        Image image1 = new Image("AP\\homepage1.png");
		        Image image2 = new Image("AP\\homepage2.png");
		        Image image3 = new Image("AP\\homepage3.png");
		        Image image4 = new Image("AP\\homepage4.png");
		        Image image5 = new Image("AP\\homepage5.png");
		        Image image6 = new Image("AP\\homepage6.png");
		        Image image7 = new Image("AP\\homepage7.png");
		        Image image8 = new Image("AP\\homepage8.png");


		        images.add(image1);images.add(image2);images.add(image3);images.add(image4);
		        images.add(image5);images.add(image6);images.add(image7);images.add(image8);

		    }
		    public void animatehomepage(List<Image> images,ImageView imageView) {
		        Transition animation = new Transition() {
		            {
		                setCycleDuration(Duration.millis(2000)); // total time for animation
		                setCycleCount(Animation.INDEFINITE);
		            }

		            @Override
		            protected void interpolate(double fraction) {
		                int index = (int) (fraction*(images.size()-1));
		                imageView.setImage(images.get(index));
		                imageView.setX(520);
		                imageView.setY(20);
		                imageView.setFitHeight(300);
		                imageView.setFitWidth(600);
		                imageView.setPreserveRatio(true);
		            }
		        };
		        animation.play();


		    }

		    public Button addplaybutton() throws FileNotFoundException {
		        Image i = new Image("AP\\playbutton.png");
		        ImageView iw = new ImageView(i);
		        /*iw.setX(700);
		        iw.setY(390);*/
		        iw.setFitHeight(100);
		        iw.setFitWidth(100);
		        Button b = new Button("", iw);
		        b.setLayoutX(725);
		        b.setLayoutY(415);
		        b.setPadding(new Insets(-25));
		        return b;
		    }
		    public Button addexitbutton() throws FileNotFoundException {

		        Image i2 = new Image("AP\\exitbutton.png");
		        ImageView iw2 = new ImageView(i2);
		        //iw2.setX(1015);
		        //iw2.setY(20);
		        iw2.setFitHeight(60);
		        iw2.setFitWidth(60);
		        Button b2 = new Button("", iw2);
		        b2.setLayoutX(1040);
		        b2.setLayoutY(60);
		        b2.setPadding(new Insets(-25));
		        return b2;

		    }
		    public Button addloadbutton() throws FileNotFoundException {

		        Image i3 = new Image("AP\\loadbutton.png");
		        ImageView iw3 = new ImageView(i3);
		        //iw3.setX(710);
		        //iw3.setY(600);
		        iw3.setFitHeight(80);
		        iw3.setFitWidth(80);
		        Button b3 = new Button("", iw3);
		        b3.setLayoutX(735);
		        b3.setLayoutY(625);
		        b3.setPadding(new Insets(-25));
		        return b3;
		    }
		    public Button addhelpbutton() throws FileNotFoundException {

		        Image i4 = new Image("AP\\helpbutton.png");
		        ImageView iw4 = new ImageView(i4);
		        //iw4.setX(450);
		        //iw4.setY(20);
		        iw4.setFitHeight(60);
		        iw4.setFitWidth(60);
		        Button b4 = new Button("", iw4);
		        b4.setLayoutX(475);
		        b4.setLayoutY(60);
		        b4.setPadding(new Insets(-25));
		        return b4;


		    }

		    public void addrotatingcircles(ImageView iw, ImageView iw2, ImageView iw3) throws FileNotFoundException {
		        iw.setX(675);
		        iw.setY(365);
		        iw.setFitHeight(150);
		        iw.setFitWidth(150);
		        iw.setPreserveRatio(true);

		        RotateTransition rt = new RotateTransition(Duration.millis(1500), iw);
		        rt.setByAngle(360);
		        rt.setCycleCount(Animation.INDEFINITE);
		        rt.play();

		        iw2.setX(650);
		        iw2.setY(340);
		        iw2.setFitHeight(200);
		        iw2.setFitWidth(200);
		        iw2.setPreserveRatio(true);

		        RotateTransition r = new RotateTransition(Duration.millis(1500), iw2);
		        r.setByAngle(-360);
		        r.setCycleCount(Animation.INDEFINITE);
		        r.play();

		        iw3.setX(695);
		        iw3.setY(585);
		        iw3.setFitHeight(110);
		        iw3.setFitWidth(110);
		        iw3.setPreserveRatio(true);

		        RotateTransition ro = new RotateTransition(Duration.millis(1500), iw3);
		        ro.setByAngle(-360);
		        ro.setCycleCount(Animation.INDEFINITE);
		        ro.play();

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

		        List<Image> images=new ArrayList<Image>();
		        addhomepage(images);
		        ImageView imageView=new ImageView();
		        animatehomepage(images,imageView);

		        Button b=addplaybutton();
		        addscaletransition(b);
		        b.setOnAction(new EventHandler<ActionEvent>() {
		        	@Override
		        	public void handle(ActionEvent event) {
		        	try {
						NewGame(stage);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	}
		        	});

		        Button b2=addexitbutton();
		        addscaletransition(b2);
		        
		        b2.setOnAction(new EventHandler<ActionEvent>() {
		        	@Override
		        	public void handle(ActionEvent event) {
		        	exit();
		        	}
		        	});

		        Button b3=addloadbutton();
		        addscaletransition(b3);
		        
		        b3.setOnAction(new EventHandler<ActionEvent>() {
		        	@Override
		        	public void handle(ActionEvent event) {
		            ResumeGame();
		        	}
		        	});

		        Button b4=addhelpbutton();
		        addscaletransition(b4);
		        
		        b4.setOnAction(new EventHandler<ActionEvent>() {
		        	@Override
		        	public void handle(ActionEvent event) {
		        	help();
		        	}
		        	});

		        Image i = new Image("AP\\circle1.png");
		        ImageView iw = new ImageView(i);
		        Image i2 = new Image("AP\\circle2.png");
		        ImageView iw2 = new ImageView(i2);
		        Image i3 = new Image("AP\\circle1.png");
		        ImageView iw3 = new ImageView(i3);
		        addrotatingcircles(iw, iw2, iw3);

		        Group root = new Group(imageView,b,b2,b3,b4, iw, iw2, iw3);
		        Scene scene = new Scene(root, 1500, 800, Color.BLACK);
		        stage.setTitle("Color Switch");
		        stage.setScene(scene);

		        stage.show();
		    }

}
