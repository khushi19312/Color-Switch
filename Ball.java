package ColorSwitch;

public class Ball {
  private int x_pos;
  private int y_pos;
  private int y_jump;
  private int color;
  private boolean presence;
  private static long serialVersionUID;
  
  public int gety_pos(){
    return x_pos;
  }
  public void sety_pos(int x){
    y_pos = x;
  }
  public void increasey_jump(int y){
    y_pos += y;
  }
  public void change_colour(int c){
    color = c;
  }
  public int get_colour(){
    return color;
  }
  public boolean get_presence(){
    return presence;
  }
  public void change_presence(){
    presence = !presence;
  }
}
