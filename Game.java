package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventDispatcher;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application
{
	private Ball ball_obj;
	private List<Obstacles> Obstacle_list;
	//private Stars star_obj;
	//private Stars next_nearest_star_obj;
	private ColorWheel colorwheel_obj;
	private HashMap<Integer,Color> colors;
	private int currentScore;
	private long serialVersionUID;
	private static String[] args;
	

	Game(Stage stage) throws Exception
	{
		ball_obj=new Ball();

		colors=new HashMap();
		Color purple=Color.rgb(117, 37, 212);
		Color pink=Color.rgb(255, 0, 128);
		Color blue=Color.rgb(53, 226, 242);
		Color yellow=Color.rgb(245, 223, 15);
		colors.put(1,purple);//purple
		colors.put(2,pink);//pink
		colors.put(3,blue);//blue
		colors.put(4,yellow);//yellow
		
		
		Obstacle_list = new ArrayList<Obstacles>();
		Obstacle_list.add(new Obstacle4(600));
		addObstacles();
		
		
		start(stage);
    }

	 int getRandomColor()
	    {
	    	double f = Math.random()/Math.nextDown(1.0);
	        double x = 1*(1.0 - f) + 4*f;
	        return (int)x;

	    }
	 
	 int getRandom()
	    {
	    	double f = Math.random()/Math.nextDown(1.0);
	        double x = 1*(1.0 - f) + 6*f;
	        return (int)x;

	    }
	public static int play()
	{
	
	return 1;	
	}
	
	public void menu_on_hit()
	{
		

	}
	
	public void getinput()
	{
		
	}
	
	public void check_star()
	{
		
	}
	public void pause()
	{
		
	}
	public void save()
	{
		
	}
	public void updateCurrentScore()
	{
		
	}
	public void check_obstacle()
	{
		
	}
	public void set_ball_pos()
	{
		
	}
	
	public List<Integer> getcolour()
	{
		return null;
	}
	
	public void addObstacles() throws Exception
	{
		int prev_y = Obstacle_list.get(0).gety_pos()-300;
		int no=getRandom();
		System.out.println(no);
		if(no==1){
			Obstacle_list.add(new Obstacle1(prev_y));
			System.out.print("added 1");
		}
		else if(no==2){
			Obstacle_list.add(new Obstacle2(prev_y));
			System.out.print("added 2");
		}
		else if(no==3){
			Obstacle_list.add(new Obstacle3(prev_y));
			System.out.print("added 3");
		}
		else if(no==4){
			Obstacle_list.add(new Obstacle4(prev_y));
			System.out.print("added 4");
		}
		else if(no==5){
			Obstacle_list.add(new Obstacle5(prev_y));
			System.out.print("added 5");
		}
		else{
			Obstacle_list.add(new Obstacle6(prev_y));
			System.out.print("added 6");
		};
		
		System.out.println("+++++++"+Obstacle_list.size());
		
		
	}
	
	public void posStars()
	{
		
	}
	
	public void difficulty()
	{
		
	}
	
	public int ReturnScore()
	{
		return 1;
	}
	
	public ImageView addbackground() throws FileNotFoundException {

        Image image = new Image("AP\\background.png");
        ImageView imageV=new ImageView(image);
        imageV.setFitHeight(1700);
        imageV.setFitWidth(1700);
        imageV.setPreserveRatio(true);
        return imageV;

    }

    
    public void start(Stage stage) throws Exception {

        ImageView imageV=addbackground();

        ImageView starthand=new ImageView(new Image("AP\\starthand.png"));
        setstarthand(starthand);

        /*ImageView star=new ImageView(new Image("AP\\star.png"));
        setstar(star);*/

        /*ImageView colorwheel=new ImageView(new Image("AP\\colorwheel.png"));
        setcolourwheel(colorwheel);*/

        Image pause = new Image("AP\\pausebutton.png");
        ImageView p = new ImageView(pause);
        Button b1 =  new Button();
        b1 = setpausebutton(p);
        addscaletransition(b1);


        Image save = new Image("AP\\savebutton.png");
        ImageView sv = new ImageView(save);
        Button b2 = new Button();
        b2 = setsavebutton(sv);
        addscaletransition(b2);
        
        
        Circle ball = new Circle(9,colors.get(getRandomColor()));
		ball_obj.setMyball(ball);
        ball.setCenterY(700);
        ball_obj.setY_pos((int)ball.getCenterY());
        ball.setCenterX(738);
        ball_obj.setX_pos((int)ball.getCenterX());
        ball_obj.setY_jump(200);
        //ball.relocate(0,10);
        
        
    	
        Group root = new Group(imageV, b1, b2, starthand, Obstacle_list.get(1).getObstacle(), ball, Obstacle_list.get(0).getObstacle());
        Scene scene = new Scene(root, 1500, 800);

        System.out.println("Entering handler");
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
        	System.out.println("Enter pressed 1");
            if(key.getCode()==KeyCode.SHIFT) {
            	System.out.println(ball.getCenterY());
            	ball_obj.move();
            	if(ball_obj.gety_pos()<700) {
                	System.out.print("\nin for updation");
            		starthand.setY(starthand.getY()+10);
            		Obstacle_list.get(0).sety_pos(Obstacle_list.get(0).gety_pos()+10);
            		Obstacle_list.get(1).sety_pos(Obstacle_list.get(1).gety_pos()+10);
        		}
            	if(Obstacle_list.get(0).gety_pos()>=700) {
        			
        			root.getChildren().remove(Obstacle_list.get(0).getObstacle());
        			Obstacle_list.remove(0);
        			try {
        				addObstacles();
        				root.getChildren().add(Obstacle_list.get(1).getObstacle());
        			} catch (Exception e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        		}
            }
            
               //System.out.println(ball.getCenterY());

        });
        //scene.setEventDispatcher(new EventDispatcher(Event e));
          
        
        
        
        stage.setTitle("Color Switch");
        stage.setScene(scene);
        stage.show();       
        
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
    public Button setsavebutton(ImageView sv){
        //sv.setX(480);
        //sv.setY(50);
        sv.setFitHeight(60);
        sv.setFitWidth(60);
        Button b2 = new Button("", sv);
        b2.setLayoutX(475);
        b2.setLayoutY(60);
        b2.setPadding(new Insets(-30));
        sv.setPreserveRatio(true);
        return b2;
    }
    public Button setpausebutton(ImageView p){
        /*p.setX(955);
        p.setY(50);*/
        p.setFitHeight(60);
        p.setFitWidth(60);
        Button b1 = new Button("", p);
        b1.setLayoutX(1040);
        b1.setLayoutY(60);
        b1.setPadding(new Insets(-30));
        p.setPreserveRatio(true);
        return b1;
    }
    void setstarthand(ImageView starthand) {
        starthand.setX(720);
        starthand.setY(720);
        starthand.setFitHeight(60);
        starthand.setFitWidth(60);
        starthand.setPreserveRatio(true);
    }

}
