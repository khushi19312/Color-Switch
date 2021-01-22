package application;

import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Star implements Serializable{

	private int stars_for_revival;
	private int pos_x;
	private int pos_y;
	private int count;
	private int difficulty;
	private long serialVersionUID;
	
	public Star(int pos)
	{
		Image i=new Image("AP\\star.png");
		   star = new ImageView(i);
		   star.setX(680);
		   star.setY(50);
		   star.setScaleX(0.25);
		   star.setScaleY(0.25);
		   setPos_y(pos);
	}
	public int getStars_for_revival() {
		return stars_for_revival;
	}
	public void setStars_for_revival(int stars_for_revival) {
		this.stars_for_revival = stars_for_revival;
	}
	public int getPos_x() {
		return pos_x;
	}
	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
		star.setLayoutX(pos_x);
	}
	public int getPos_y() {
		return pos_y;
	}
	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
		star.setLayoutY(pos_y);
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getDifficulty() {
		return difficulty;
	}
	protected transient ImageView star;
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	


}
