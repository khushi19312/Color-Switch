package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
		static int highscore=0;
	    static Image score;
	    static ImageView s;
	    static Text t1 = new Text();
        static Scene homescene;
	    static Image bestscore;
	    static int gamescore=0;
	    static ImageView bs;
	    static Text t2 = new Text();
	    static Text t3 = new Text();
	    static Text t4 = new Text();
	    static ArrayList<Game> savedgames=new ArrayList<Game>();
	    
	    public static ImageView addstarcountend() throws FileNotFoundException {

	        Image i2 = new Image("AP\\stars.png");
	        ImageView iw2 = new ImageView(i2);
	        iw2.setX(1010);
	        iw2.setY(20);
	        iw2.setFitHeight(60);
	        iw2.setFitWidth(90);

	        return iw2;

	    }
	    public static Button addrestartbuttonend() throws FileNotFoundException {
	        Image i = new Image("AP\\loadbutton.png");
	        ImageView iw = new ImageView(i);
	        //iw.setX(710);
	        //iw.setY(445);
	        iw.setFitHeight(100);
	        iw.setFitWidth(100);
	        Button b = new Button("", iw);
	        b.setLayoutX(735);
	        b.setLayoutY(470);
	        b.setPadding(new Insets(-25));
	        return b;
	    }
	    public static Button addstarbuttonend() throws FileNotFoundException {
	        Image i = new Image("AP\\star.png");
	        ImageView iw = new ImageView(i);
	        //iw.setX(725);
	        //iw.setY(610);
	        iw.setFitHeight(70);
	        iw.setFitWidth(70);
	        Button b = new Button("", iw);
	        b.setLayoutX(750);
	        b.setLayoutY(635);
	        b.setPadding(new Insets(-25));

	        return b;
	    }
	    public static Button addhomebuttonend() throws FileNotFoundException {

	        Image i4 = new Image("AP\\homebutton.png");
	        ImageView iw4 = new ImageView(i4);
	        //iw4.setX(450);
	        //iw4.setY(20);
	        iw4.setFitHeight(60);
	        iw4.setFitWidth(60);
	        Button b4 = new Button("", iw4);
	        b4.setLayoutX(470);
	        b4.setLayoutY(60);
	        b4.setPadding(new Insets(-25));
	        return b4;


	    }

	    public static void addrotatingcirclesend(ImageView iw, ImageView iw2, ImageView iw3) throws FileNotFoundException {
	        iw.setX(690);
	        iw.setY(425);
	        iw.setFitHeight(140);
	        iw.setFitWidth(140);
	        iw.setPreserveRatio(true);

	        RotateTransition rt = new RotateTransition(Duration.millis(1500), iw);
	        rt.setByAngle(360);
	        rt.setCycleCount(Animation.INDEFINITE);
	        rt.play();

	        iw2.setX(670);
	        iw2.setY(405);
	        iw2.setFitHeight(180);
	        iw2.setFitWidth(180);
	        iw2.setPreserveRatio(true);

	        RotateTransition r = new RotateTransition(Duration.millis(1500), iw2);
	        r.setByAngle(-360);
	        r.setCycleCount(Animation.INDEFINITE);
	        r.play();

	        iw3.setX(705);
	        iw3.setY(595);
	        iw3.setFitHeight(110);
	        iw3.setFitWidth(110);
	        iw3.setPreserveRatio(true);

	        RotateTransition ro = new RotateTransition(Duration.millis(1500), iw3);
	        ro.setByAngle(-360);
	        ro.setCycleCount(Animation.INDEFINITE);
	        ro.play();

	    }
	    static void addscaletransitionendend(Button h){

	        ScaleTransition st = new ScaleTransition(Duration.millis(1000), h);
	        st.setToX(0.9);
	        st.setToY(0.9);
	        st.setByX(1);
	        st.setByY(1);
	        st.setCycleCount(Animation.INDEFINITE);
	        st.play();
	    }

	    static void addscaletransition1end(ImageView h){

	        ScaleTransition st = new ScaleTransition(Duration.millis(1000), h);
	        st.setToX(0.9);
	        st.setToY(0.9);
	        st.setByX(1);
	        st.setByY(1);
	        st.setCycleCount(Animation.INDEFINITE);
	        st.play();
	    }

	    public void addendpageend(List<Image> images) throws FileNotFoundException {

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
	    public static void animatehomepageend(List<Image> images,ImageView imageView) {
	        Transition animation = new Transition() {
	            {
	                setCycleDuration(Duration.millis(2000)); // total time for animation
	                setCycleCount(Animation.INDEFINITE);
	            }

	            @Override
	            protected void interpolate(double fraction) {
	                int index = (int) (fraction*(images.size()-1));
	                imageView.setImage(images.get(index));
	                imageView.setX(620);
	                imageView.setY(20);
	                imageView.setFitHeight(300);
	                imageView.setFitWidth(350);
	                imageView.setPreserveRatio(true);
	            }
	        };
	        animation.play();


	    }
	    static void scoredisplaysend() throws FileNotFoundException {
	        score = new Image("AP\\score.png");
	        s = new ImageView(score);
	        s.setX(610);
	        s.setY(220);
	        s.setFitHeight(50);
	        s.setFitWidth(300);
	        s.setPreserveRatio(true);

	        t1.setText(gamescore+"");
	        t1.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 25));
	        t1.setFill(Color.WHITESMOKE);
	        t1.setX(750);
	        t1.setY(280);

	        bestscore = new Image("AP\\bestscore.png");
	        bs = new ImageView(bestscore);
	        bs.setX(610);
	        bs.setY(320);
	        bs.setFitHeight(50);
	        bs.setFitWidth(300);
	        bs.setPreserveRatio(true);

	        t2.setText(highscore+"");
	        t2.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 25));
	        t2.setFill(Color.WHITESMOKE);
	        t2.setX(750);
	        t2.setY(380);
	    }

	    
			
		public static void main(String[] args1)
		{
			 args=args1;
			 MainMenu();
			 
		}
		
		public static void MainMenu() {
			launch(args);
		}
		
		public static  void NewGame(Stage stage) throws Exception
		{
			System.out.println("new game");
			new_game_obj=new Game(stage);
			
			System.out.println("OVER");
			
		
			
		}
		
		public static  void endgamepage(Stage st) throws Exception
		{
			Game.gameover=false;
			scoredisplaysend();
			new_game_obj=new Game(st);
			
		
			
			
			 List<Image> images=new ArrayList<Image>();
		        addhomepage(images);
		        ImageView imageView=new ImageView();
		        animatehomepageend(images,imageView);

		        Button b=addrestartbuttonend();
		        b.setOnAction(new EventHandler<ActionEvent>() {
		        	@Override
		        	public void handle(ActionEvent event) {
		        	try {
		        		
						NewGame(st);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	}
		        	});
		        addscaletransitionendend(b);

		        Button b2=addhomebuttonend();
		        b2.setOnAction(new EventHandler<ActionEvent>() {
		        	@Override
		        	public void handle(ActionEvent event) {
		        		System.out.println("MAIN");
		        		st.setScene(homescene);
		        	}
		        	});
		        addscaletransitionendend(b2);

		        ImageView b3=addstarcountend();
		        addscaletransition1end(b3);

		        Button b4=addstarbuttonend();
		        addscaletransitionendend(b4);

		        

		        Text t4 = new Text();


		        Image i = new Image("AP\\circle1.png");
		        ImageView iw = new ImageView(i);
		        Image i2 = new Image("AP\\circle2.png");
		        ImageView iw2 = new ImageView(i2);
		        Image i3 = new Image("AP\\circle1.png");
		        ImageView iw3 = new ImageView(i3);
		        addrotatingcirclesend(iw, iw2, iw3);

		        t3.setText("-3");
		        t3.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
		        t3.setFill(Color.BLACK);
		        t3.setX(750);
		        t3.setY(655);

		        t4.setText("20");
		        t4.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		        t4.setFill(Color.WHITESMOKE);
		        t4.setX(1042);
		        t4.setY(93);

		        Group root = new Group();
                root.getChildren().add(imageView);
                root.getChildren().add(bs);
                root.getChildren().add(s);
                root.getChildren().add(t1);
                root.getChildren().add(t2);
                root.getChildren().add(b);
                root.getChildren().add(b2);
                root.getChildren().add(b3);
                root.getChildren().add(b4);
                root.getChildren().add(t3);
                root.getChildren().add(t4);
                root.getChildren().add(iw);
                root.getChildren().add(iw2);
                root.getChildren().add(iw3);
                
		        Scene scene = new Scene(root, 1500, 780, Color.BLACK);

		        
		        st.setScene(scene);
		        st.show();
		}
		
		public static  void help()//
		{
			
		}
		public static Game ResumeGame()
		{
			FileInputStream f;
			try {
				f = new FileInputStream("colorswitch.ser");
				ObjectInputStream i=new ObjectInputStream(f);
				Game g = (Game) i.readObject();
				return g;
				
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
			return null;
	        
		}
		
		
		public static void save(Serializable game) {
			savedgames.add((Game) game);
			FileOutputStream f;
			try {
				f = new FileOutputStream("colorswitch.ser");
				ObjectOutputStream o=new ObjectOutputStream(f);
				o.writeObject(game);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		}
		
		public static void computeHighScore()
		{
			
		}
		
		public static void exit()
		{
			
		}
		
		
		 public static void addhomepage(List<Image> images) throws FileNotFoundException {

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
					} catch (Exception e) {
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
		        		Game g=ResumeGame();
		        		
		        		try {
							g.initialize(g, stage);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        		
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
		        homescene=scene;
		        stage.setTitle("Color Switch");
		        stage.setScene(scene);

		        stage.show();
		    }
		    
		    

}
