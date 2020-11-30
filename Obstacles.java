package application;

import java.util.List;

public class Obstacles {
	private int x_pos;
	private int y_pos;
	private String type;
	private int orientation;
	protected List <Integer> colors;
	private int speed;
	private static long serialVersionUID;
	
	public void move() {
		
	}
	public void create() {
		
	}
	public int getColour_ypos() {
		return 1;
	}
	public int getx_pos() {
		return x_pos;
	}
	public int gety_pos(){
		return x_pos;
	}
	public void setx_pos(int x) {
		x_pos = x;
	}
	public void sety_pos(int x) {
		y_pos = x;
	}
	public List<Integer> getColours(){
		return colors;
	}
	public void setColours(List<Integer> l) {
		
	}
	public void setSpeed(int x) {
		speed = x;
	}
	public int getSpeed() {
		return speed;
	}
	public int getOrientation() {
		return orientation;
	}
	public void setOrientation(int x) {
		orientation = x;
	}
	public void setType(String s) {
		type = s;
	}
	public String getType() {
		return type;
	}
	private void checkDifficulty(Stars s) {
		
	}

}

