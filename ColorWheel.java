package application;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class ColorWheel implements Serializable{

	private int x_pos;
	private int y_pos;
	
	private long serialVersionUID;
	transient ImageView star;
	
	ColorWheel(int pos)
	{
		Image i=new Image("AP\\colorwheel.png");
	   star = new ImageView(i);
	   star.setX(660);
	   star.setY(50);
	   star.setScaleX(0.25);
	   star.setScaleY(0.25);
	   sety_pos(pos);
	   
	}
	public int getx_pos()
	{return x_pos;
		
	}
	public int gety_pos()
	{return y_pos;
		
	}
	public void setx_pos(int x)
	{
		x_pos=x;
		star.setX(x);
	}
	public void sety_pos(int y)
	{
	y_pos=y;
	star.setY(y);
	}
	
	
		public int getColour()
	{
			double f = Math.random()/Math.nextDown(1.0);
		    double x = 1*(1.0 - f) + 4*f;
		    return (int)x;
	}
}
