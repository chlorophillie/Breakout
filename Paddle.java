//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables

   private int speed;

   public Paddle()
   {
	  super(10,10, 10, 10, Color.BLACK);
      speed =5;
   }

   public Paddle(int i, int j) {
	   super(i, j, 10, 10, Color.BLACK);
	   speed =5;
   }

   public Paddle(int i, int j, int k) {
	   super(i, j, 10, 10, Color.BLACK);
	   speed =k;
   }

   public Paddle(int i, int j, int k, int l, int m) {
	   super(i, j, k, l, Color.BLACK);
	   speed=m;
   }

   public Paddle(int i, int j, int k, int l, Color c, int m) {
	   super(i, j, k, l, c);
	   speed=m;
   }

   public void moveUpAndDraw(Graphics window)
   {
	   window.setColor(Color.WHITE);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   setY(getY()-speed);
	   window.setColor(getColor());
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   
   }

   public void moveDownAndDraw(Graphics window)
   {
	   window.setColor(Color.WHITE);
   	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   setY(getY()+speed);
	   window.setColor(getColor());
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   public void moveLeftAndDraw(Graphics window) {
	   window.setColor(Color.WHITE);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   setX(getX()-speed);
	   window.setColor(getColor());
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
		
   }
   
   public void moveRightAndDraw(Graphics window) {
	   window.setColor(Color.WHITE);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   setX(getX()+speed);
	   window.setColor(getColor());
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
		
   }
   public int getSpeed(){
	   return speed;
   }
   public String toString(){
	   return getX()+" "+getY()+" "+getWidth()+" "+getHeight()+" "+getColor()+" "+getSpeed();
   }

}