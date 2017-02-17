//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{	xPos=100;
		yPos=150;
		width=10;
		height=10;
    	color=Color.black;
	}

    public Block(int i, int j, int k, int l) {
    	xPos=i;
    	yPos=j;
    	width=k;
    	height=l;
    	color=Color.black;
 	}

    public Block(int i, int j, int k, int l, Color m) {
    	xPos=i;
    	yPos=j;
    	width=k;
    	height=l;
    	color=m;
    }

    public Block(int i, int j) {
        xPos=i;
    	yPos=j;
    	width=10;
    	height=10;
    	color=Color.black;
	}

	public void setColor(Color col){
	   color=col;
    }
    
	public void setPos(int x, int y) {
		xPos=x;
		yPos=y;
	}

	public void setX(int x) {
		xPos=x;
	}

	public void setY(int y) {
		yPos=y;
	}
	public void setWidth(int w){
		width=w;
	}
	
	public void setHeight(int h){
		height=h;
	}

    public void draw(Graphics window)
    {
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col)
    {
        window.setColor(col);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }
   
	public boolean equals(Object obj)
	{
		if (getX()==((Block) obj).getX() && getY()==((Block) obj).getY() && getWidth()==((Block) obj).getWidth() && getHeight()==((Block) obj).getHeight() && getColor()==((Block) obj).getColor()){
			return true;
		}

		return false;
	}

	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}   
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	protected Color getColor(){
		return color;
	}

   //add the other get methods
    
	public String toString(){
		return getX() + " - " + getY() + " - " + getWidth() + " - " + getHeight() + " - " + getColor();
	}
   //add a toString() method  - x , y , width, height, color
}