package edu.poly.tchao;

//class for record the range, pixels number and x,y for extract character image.
public class CharRange{
  
  public int count;
  public int left,right,top,down;
  public static final int AREA_THRESHOLD = 200;
  public static final int AREA_WIDTH = 600;
  public static final int AREA_HEIGHT = 600;

  public CharRange(int left,int right,int top,int down,int count){
    this.left = left;
    this.right = right;
    this.top = top;
    this.down = down;
    this.count = count;
  }

  public CharRange(int x,int y){
    left = x;
    right = x;
    top = y;
    down = y;
    count = 1;
  }

  public void update(int x,int y){
    if(x < left){
      left = x;
    }

    if(x > right){
      right = x;
    }

    if(y < top){
      top = y;
    }

    if(y > down){
      down = y;
    }

    count += 1;
  }

  public int getWidth(){
    int width = (right+1) - left;
    if(width < 0){
      return 0;
    }
    return width;
  }

  public int getHeight(){
    int height = (down+1) - top;
    if(height < 0){
      return 0;
    }
    return height;
  }

  //check the range is big enought to count as a character
  public boolean isValid(){
    if(count < AREA_THRESHOLD || 
        getWidth() > AREA_WIDTH || 
        getHeight() > AREA_HEIGHT ){
      return false;
    }
    return true;
  }
}
