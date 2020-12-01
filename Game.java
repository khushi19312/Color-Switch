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
import javafx.event.ActionEvent;
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

	Game(Stage stage) throws FileNotFoundException
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
		
		start(stage);
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
	
	public void addObstacles()
	{
		
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

    public void addlineobstacle(List<Image> images) throws FileNotFoundException {
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

    }
    public void addringobstacle(List<Image> images2) throws FileNotFoundException {
        Image img1 = new Image("AP\\ring1.png");
        Image img2 = new Image("AP\\ring2.png");
        Image img3 = new Image("AP\\ring3.png");
        Image img4 = new Image("AP\\ring4.png");
        Image img5 = new Image("AP\\ring5.png");
        Image img6 = new Image("AP\\ring6.png");
        Image img7 = new Image("AP\\ring7.png");
        Image img8 = new Image("AP\\ring8.png");



        images2.add(img1);images2.add(img2);images2.add(img3);images2.add(img4);images2.add(img5);images2.add(img6);images2.add(img7);images2.add(img8);
    }
    void adddiamondobstacle(List<Image> images3) throws FileNotFoundException {
        Image im1 = new Image("AP\\diamond1.png");
        Image im2 = new Image("AP\\diamond2.png");
        Image im3 = new Image("AP\\diamond3.png");
        Image im4 = new Image("AP\\diamond4.png");
        Image im5 = new Image("AP\\diamond5.png");
        Image im6 = new Image("AP\\diamond6.png");
        Image im7 = new Image("AP\\diamond7.png");
        Image im8 = new Image("AP\\diamond8.png");



        images3.add(im1);images3.add(im2);images3.add(im3);images3.add(im4);images3.add(im5);images3.add(im6);images3.add(im7);images3.add(im8);

    }

    void animateline(ImageView imageView,List<Image> images) {
        Transition animation = new Transition() {
            {
                setCycleDuration(Duration.millis(2000)); // total time for animation
                setCycleCount(Animation.INDEFINITE);
            }

            @Override
            protected void interpolate(double fraction) {
                int index = (int) (fraction*(images.size()-1));
                imageView.setImage(images.get(index));
                imageView.setX(580);
                imageView.setY(610);
                imageView.setFitHeight(320);
                imageView.setFitWidth(320);
                imageView.setPreserveRatio(true);
            }
        };
        animation.play();
    }
    void animatering(ImageView imgView,List<Image> images2) {

        Transition animation2 = new Transition() {
            {
                setCycleDuration(Duration.millis(2000)); // total time for animation
                setCycleCount(Animation.INDEFINITE);
            }

            @Override
            protected void interpolate(double fraction) {
                int index = (int) (fraction*(images2.size()-1));
                imgView.setImage(images2.get(index));
                imgView.setX(655);
                imgView.setY(290);
                imgView.setFitHeight(180);
                imgView.setFitWidth(180);
                imgView.setPreserveRatio(true);
            }
        };
        animation2.play();
    }
    void animatediamond(List<Image> images3,ImageView imView) {

        Transition animation3 = new Transition() {
            {
                setCycleDuration(Duration.millis(2000)); // total time for animation
                setCycleCount(Animation.INDEFINITE);
            }

            @Override
            protected void interpolate(double fraction) {
                int index = (int) (fraction*(images3.size()-1));
                imView.setImage(images3.get(index));
                imView.setX(640);
                imView.setY(10);
                imView.setFitHeight(220);
                imView.setFitWidth(220);
                imView.setPreserveRatio(true);
               // System.out.println(index);
            }
        };
        animation3.play();

    }

    /*Button addbackbutton() throws FileNotFoundException {
        Image i = new Image(new FileInputStream("C:\\Users\\Khushi Agarwal\\Desktop\\AP\\buttons\\homebutton.png"));
        ImageView iw = new ImageView(i);
        iw.setFitHeight(150);
        iw.setFitWidth(150);
        Button b = new Button("", iw);
        b.setLayoutX(80);
        b.setLayoutY(40);
        b.setPadding(new Insets(-30));
        return b;
    }*/

    void setstarthand(ImageView starthand) {
        starthand.setX(720);
        starthand.setY(720);
        starthand.setFitHeight(60);
        starthand.setFitWidth(60);
        starthand.setPreserveRatio(true);
    }
    void setstar(ImageView star) {
        star.setX(720);
        star.setY(355);
        star.setFitHeight(50);
        star.setFitWidth(50);
        star.setPreserveRatio(true);

    }
    void setcolourwheel(ImageView colorwheel) {
        colorwheel.setX(720);
        colorwheel.setY(520);
        colorwheel.setFitHeight(40);
        colorwheel.setFitWidth(40);
        colorwheel.setPreserveRatio(true);
    }

    int getRandom()
    {
    	double f = Math.random()/Math.nextDown(1.0);
        double x = 1*(1.0 - f) + 4*f;
        return (int)x;

    }
    public void start(Stage stage) throws FileNotFoundException {

        ImageView imageV=addbackground();

        List<Image> images = new ArrayList<>();
        ImageView imageView=new ImageView();
        addlineobstacle(images);
        animateline(imageView,images);

        List<Image> images2 = new ArrayList<>();
        addringobstacle(images2);
        ImageView imgView=new ImageView();
        animatering(imgView,images2);

        //Button b= addbackbutton();

        List<Image> images3 = new ArrayList<>();
        ImageView imView=new ImageView();
        adddiamondobstacle(images3);
        animatediamond(images3,imView);


        ImageView starthand=new ImageView(new Image("AP\\starthand.png"));
        setstarthand(starthand);

        ImageView star=new ImageView(new Image("AP\\star.png"));
        setstar(star);

        ImageView colorwheel=new ImageView(new Image("AP\\colorwheel.png"));
        setcolourwheel(colorwheel);

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

        Circle ball = new Circle(9,colors.get(getRandom()));
		ball_obj.setMyball(ball);
        ball.setCenterY(600);
        ball_obj.setY_pos((int)ball.getCenterY());
        ball.setCenterX(738);
        ball_obj.setX_pos((int)ball.getCenterX());
        ball_obj.setY_jump(200);
        //ball.relocate(0,10);
        Group root = new Group(imageV,imageView,imgView,imView,starthand,star,colorwheel,b1,b2, ball);
        Scene scene = new Scene(root, 1500, 800);
        System.out.println("Entering handler");
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
        	System.out.println("Enter pressed 1");
            if(key.getCode()==KeyCode.SHIFT) {
            	 System.out.println(ball.getCenterY());
            	ball_obj.move();
                			 
            }
                
                
                //System.out.println(ball.getCenterY());
                
              });

		
	
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
        //sv.setX(490);
        //sv.setY(50);
        sv.setFitHeight(50);
        sv.setFitWidth(50);
        Button b2 = new Button("", sv);
        b2.setLayoutX(490);
        b2.setLayoutY(50);
        b2.setPadding(new Insets(-30));
        sv.setPreserveRatio(true);
        return b2;
    }
    public Button setpausebutton(ImageView p){
        //p.setX(955);
        //p.setY(50);
        p.setFitHeight(50);
        p.setFitWidth(50);
        Button b1 = new Button("", p);
        b1.setLayoutX(955);
        b1.setLayoutY(50);
        b1.setPadding(new Insets(-30));
        p.setPreserveRatio(true);
        return b1;
    }
	
}
