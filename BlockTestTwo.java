//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

public class BlockTestTwo extends Canvas
{ // wait what does this class do lol
	//its supposed to print that thing you see
	//which it did before but i added paddles and bs and now itssad
	public BlockTestTwo()
	{
		setBackground(Color.WHITE);
	}//whoops that was the tester

	public void paint(Graphics window)
	{
		Block one = new Block();
		one.draw(window);

		Block two = new Block(50,50,30,30);
		two.draw(window);

		Block three = new Block(350,350,15,15,Color.RED);
		three.draw(window);

		//two.draw(window, Color.white);

		Block four = new Block(450,50,20,60, Color.GREEN);
		four.draw(window);
		
		Block five = new Block(20, 20, 20, 20, Color.WHITE);
		five.draw(window);
		
	}
}