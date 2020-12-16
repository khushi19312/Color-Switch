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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application
{
	private Ball ball_obj;
	private List<Obstacles> Obstacle_list;
	private Star star_obj1;
	private Star star_obj2;
	private int value;
	private ColorWheel colorwheel_obj1,colorwheel_obj2;
	private HashMap<Integer,Color> colors;
	private int currentScore;
	private long serialVersionUID;
	private static String[] args;
	boolean checking=false;
    int count=0;
    Group root;
    Label score;
	Game(Stage stage) throws Exception
	{
	
		value=0;
		colors=new HashMap<Integer, Color>();
		Color purple=Color.rgb(117, 37, 212);
		Color pink=Color.rgb(255, 0, 128);
		Color blue=Color.rgb(53, 226, 242);
		Color white=Color.rgb(255,255, 255);
		Color yellow=Color.rgb(245, 223, 15);
		colors.put(1,purple);//purple
		colors.put(2,pink);//pink
		colors.put(3,blue);//blue
		colors.put(4,yellow);//yellow
		score = new Label("Score: ");
		score.setTextFill(white);
		score.setLayoutX(850);
		score.setLayoutY(40);
		score.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		Obstacle_list = new ArrayList<Obstacles>();
		
		Obstacle_list.add(new Obstacle1(500));
		count++;
		Obstacle_list.add(new Obstacle1(100));
		count++;
		//System.out.print("\n"+ Obstacle_list.get(0).gety_pos() + " " + Obstacle_list.get(0).gety_gpos());
		//addObstacles();
		
		
		
		start(stage);
    }

	 int getRandom()
	    {
	    	double f = Math.random()/Math.nextDown(1.0);
	        double x = 1*(1.0 - f) + 4*f;
	        return (int)x;

	    }
	 
	 boolean getRandomboolean()
	    {
	    	double f = Math.random();
	    	if(f>0.5)return true;
	    	else
	    		return false;
	      

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
		score.setText("Score: "+value*5);
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
	{	System.out.print("\n Adding obstacles");
	     int l=Obstacle_list.size();
	     int prev_y=500;
	     int sub=400;
	     if(count>2)
	    	 sub=500;
	     if(l>0)
		prev_y = Obstacle_list.get(l-1).gety_pos()-sub;
		System.out.print(" "+prev_y);
		int no=getRandom();
		//System.out.println(no);
		if(no==1){
			Obstacle_list.add(new Obstacle1(prev_y));
			//System.out.print("added 1");
		}
		else if(no==2){
			Obstacle_list.add(new Obstacle2(prev_y));
			//System.out.print("added 2");
		}
		else {
			Obstacle_list.add(new Obstacle3(prev_y));
			//System.out.print("added 3");
		}
		
		if(getRandomboolean())
		{
			if(colorwheel_obj1==null && count>1)
			{
				colorwheel_obj1=new ColorWheel(prev_y-400);
				root.getChildren().add(colorwheel_obj1.star);
				
			      
					
				
			}
			else if(colorwheel_obj2==null&& count>1)
			{
				colorwheel_obj2=new ColorWheel(prev_y-400);
				root.getChildren().add(colorwheel_obj2.star);
				
				
			}
		}
		
		int reduce=0;
		if(no==2 && count>3)
			reduce=230;
		else 
			reduce=150;
		
		if(true)
		{
			if(star_obj1==null && count>1&& no!=1)
			{
				star_obj1=new Star(prev_y-reduce);
				root.getChildren().add(star_obj1.star);
				
			     if(no==3)
			    	 star_obj1.setPos_x(star_obj1.getPos_x()+10);
					
				
			}
			else if(star_obj2==null&& count>1 && no!=1)
			{
				star_obj2=new Star(prev_y-reduce);
				root.getChildren().add(star_obj2.star);
				
				   if(no==3)
				    	 star_obj1.setPos_x(star_obj1.getPos_x()+10);
				
			}
		}
		//System.out.println("+++++++"+Obstacle_list.size());
		
		
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
        
        int ballcolor=getRandom();
        Circle ball = new Circle(12,colors.get(ballcolor));
        ball_obj=new Ball(colors);
		ball_obj.setMyball(ball);
        ball_obj.sety_pos(700);
        ball_obj.setx_pos(750);
        ball_obj.change_colour(ballcolor);
        ball.setTranslateZ(1);
        //ball.relocate(0,10);
        
        
    	
        root = new Group(imageV, b1, b2, starthand,ball,score);
        root.getChildren().add(Obstacle_list.get(0).getObstacle());
        root.getChildren().add(Obstacle_list.get(1).getObstacle());
        Scene scene = new Scene(root, 1500, 800);

       // System.out.println("Entering handler");
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
        	//System.out.println("Enter pressed 1");
            if(key.getCode()==KeyCode.SHIFT) {
            	//System.out.println(ball.getCenterY());
            	ball_obj.move();
 
            	if(ball_obj.gety_pos()<600) {
                	
            		starthand.setY(starthand.getY()+30);
            		
            		
            		checking=true;
            		if(Obstacle_list.size()>=1)
            			{
            			for(int i=0;i<Obstacle_list.size();i++)
            			   Obstacle_list.get(i).sety_pos(Obstacle_list.get(i).gety_pos()+30);
            			}
            		
                   if(colorwheel_obj1!=null)
                	   colorwheel_obj1.sety_pos(colorwheel_obj1.gety_pos()+30);
                   if(colorwheel_obj2!=null)
                	   colorwheel_obj2.sety_pos(colorwheel_obj2.gety_pos()+30);
                   
                   if(star_obj1!=null)
                	   star_obj1.setPos_y(star_obj1.getPos_y()+30);
                   if(star_obj2!=null)
                	   star_obj2.setPos_y(star_obj2.getPos_y()+30);
                   
            		ball_obj.sety_pos(ball_obj.gety_pos()+30);
            		checking=false;
            			}
            		
        		}
            	
            
            
               //System.out.println(ball.getCenterY());

        });
        //scene.setEventDispatcher(new EventDispatcher(Event e));
         
			   Timeline checkExitCondition = new Timeline(new KeyFrame(Duration.millis(1),new EventHandler<ActionEvent>() {
			
			   @Override
			   public void handle(ActionEvent event) {
				   
				   if(colorwheel_obj1!=null)
				   {
					   if(ball_obj.gety_pos()-100<=colorwheel_obj1.gety_pos())
					   {
						   root.getChildren().remove(colorwheel_obj1.star);
						   colorwheel_obj1=null;
						   ball_obj.change_colour(getRandom());
					   }
				   }
				   
				   if(colorwheel_obj2!=null)
				   {
					   if(ball_obj.gety_pos()-100<=colorwheel_obj2.gety_pos())
					   {
						   root.getChildren().remove(colorwheel_obj2.star);
						   colorwheel_obj2=null;
						   ball_obj.change_colour(getRandom());
					   }
				   }
				   
				   if(star_obj1!=null)
				   {
					   if(ball_obj.gety_pos()-100<=star_obj1.getPos_y())
					   {
						   root.getChildren().remove(star_obj1.star);
						   star_obj1=null;
						   value++;
						   updateCurrentScore();
					   }
				   }
				   
				   if(star_obj2!=null)
				   {
					   if(ball_obj.gety_pos()-100<=star_obj2.getPos_y())
					   {
						   root.getChildren().remove(star_obj2.star);
						   star_obj2=null;
						  value++;
						  updateCurrentScore();
						  
					   }
				   }
				   
				  System.out.println("Obstacles in list******"+Obstacle_list.size()+"*************");
				  for(int i=0;i<Obstacle_list.size();i++)
					     System.out.println(Obstacle_list.get(i).gety_pos()+Obstacle_list.get(i).getType());
				  
				  if(Obstacle_list.get(0).gety_pos()>=850 && checking==false && count>2) {
	        			System.out.println("***********HERE********************");
	        			
	        			System.out.print("\nRemoved 1");
	        			try {
							addObstacles();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						root.getChildren().add(Obstacle_list.get(Obstacle_list.size()-1).getObstacle());
						System.out.print("\nAdded 0");
						count++;
						root.getChildren().remove(Obstacle_list.get(0).getObstacle());
	        			Obstacle_list.remove(0);
					}	
				  else if(Obstacle_list.get(0).gety_pos()>=740 && checking==false && count<=2) {
	        			System.out.println("***********HERE********************");
	        			
	        			System.out.print("\nRemoved 1");
	        			try {
							addObstacles();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						root.getChildren().add(Obstacle_list.get(Obstacle_list.size()-1).getObstacle());
						System.out.print("\nAdded 0");
						count++;
						root.getChildren().remove(Obstacle_list.get(0).getObstacle());
	        			Obstacle_list.remove(0);
					}	
					
					
					
			   }
			}));
			checkExitCondition.setCycleCount(Timeline.INDEFINITE);
			checkExitCondition.play();
        
        
        
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
