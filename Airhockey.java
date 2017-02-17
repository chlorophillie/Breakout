	//Name -
	//Date -
	//Class -
	//Lab  - 

	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Canvas;
	import java.awt.event.ActionEvent;
	import java.awt.event.KeyListener;
	import java.awt.event.KeyEvent;
	import static java.lang.Character.*;
	import java.awt.image.BufferedImage;
	import java.awt.event.ActionListener;

	public class Airhockey extends Canvas implements KeyListener, Runnable
	{
		private Ball ball;
		private Paddle leftPaddle;
		private Paddle rightPaddle;
		private boolean[] keys;
		private BufferedImage back;
		private int rightScore;
		private int leftScore;


		public Airhockey()
		{
			ball = new Ball();
			leftPaddle = new Paddle(10, 100, 10, 50, Color.yellow, 5);
			rightPaddle = new Paddle(780, 100, 10, 50, Color.yellow, 5);
			keys = new boolean[8];
	    	setBackground(Color.WHITE);
			setVisible(true);
			new Thread(this).start();
			addKeyListener(this);		
		}
		
	   public void update(Graphics window){
		   paint(window);
	   }
	   public void paint(Graphics window)
	   {
			Graphics2D twoDGraph = (Graphics2D)window;

			if(back==null)
			   back = (BufferedImage)(createImage(getWidth(),getHeight()));
			Graphics graphToBack = back.createGraphics();
			ball.moveAndDraw(graphToBack);
			leftPaddle.draw(graphToBack);
			rightPaddle.draw(graphToBack);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Right Player's Score = "+ rightScore, 300, 380);
			graphToBack.drawString("Left Player's Score = " + leftScore, 300, 400);
			graphToBack.setColor(Color.RED);
			graphToBack.fillRect(0, 0, 10, 250);
			graphToBack.fillRect(0, 320, 10, 250);
			graphToBack.setColor(Color.GREEN);
			graphToBack.fillRect(790, 0, 10, 250);
			graphToBack.fillRect(790, 320, 10, 250);
			
			//see if ball hits left wall or right wall

				
			if(!(ball.getX()>=10 && ball.getX()<=790)){
				
				if(ball.getX()<=10){
					graphToBack.setColor(Color.white);
					graphToBack.drawString("Right Player's Score = " + rightScore, 300, 380);
					if(ball.getY()>250 && ball.getY()<320){
						rightScore++;
					}
					graphToBack.setColor(Color.blue);
					graphToBack.drawString("Right Player's Score = "+ rightScore, 300, 380);}
				
				if(ball.getX()>=790){
					graphToBack.setColor(Color.white);
					graphToBack.drawString("Left Player's Score = " + leftScore, 300, 400);
					if(ball.getY()>250 && ball.getY()<320){
						leftScore++;
					}
					graphToBack.setColor(Color.blue);
					graphToBack.drawString("Left Player's Score = "+ leftScore, 300, 400);}
					
				ball.setXSpeed(ball.getXSpeed()*-1);
			}
			if(!(ball.getY()>=10) && ball.getY()<790){
				ball.setYSpeed(ball.getYSpeed()*-1);
			}
			if(!(ball.getX()>=0 && ball.getX()<=800))
			{
				ball.setXSpeed(-ball.getXSpeed());
			}

			if(!(ball.getY()>=0 && ball.getY()<=570))
			{
				ball.setYSpeed(-ball.getYSpeed());
			}
			/*if(ball.didCollideTop(rightPaddle)||ball.didCollideTop(leftPaddle)||ball.didCollideBottom(rightPaddle)||(ball.didCollideBottom(leftPaddle)))
				ball.setYSpeed(ball.getYSpeed()*-1);
			
			if(ball.didCollideLeft(rightPaddle)||ball.didCollideLeft(leftPaddle)||ball.didCollideRight(rightPaddle)||(ball.didCollideRight(leftPaddle)))
				ball.setXSpeed(ball.getXSpeed()*-1);*/
			
			if(ball.getX()<=(leftPaddle.getX()+leftPaddle.getWidth()+Math.abs(ball.getXSpeed())) && 
					(ball.getY()>=leftPaddle.getY() &&
					ball.getY()<=(leftPaddle.getY()+leftPaddle.getHeight()) || 
					(ball.getY()+ball.getHeight())>=leftPaddle.getY() &&
					(ball.getY()+ball.getHeight())<(leftPaddle.getY()+leftPaddle.getHeight()))){
				if (ball.getX()<=(leftPaddle.getX()+leftPaddle.getWidth()-Math.abs(ball.getXSpeed()))){
					ball.setYSpeed(-ball.getYSpeed());
				}
				else{
					ball.setXSpeed(-ball.getXSpeed());
				}
			}
			
			if(ball.getX()+ball.getWidth()>=(rightPaddle.getX()+Math.abs(ball.getXSpeed())) && 
					(ball.getY()>=rightPaddle.getY() &&
					ball.getY()<=(rightPaddle.getY()+rightPaddle.getHeight())||
					(ball.getY()+ball.getHeight())>=rightPaddle.getY()&&
					(ball.getY()+ball.getHeight())<(rightPaddle.getY()+rightPaddle.getHeight()))){
				if(ball.getX()+ball.getWidth()>=(rightPaddle.getX()-Math.abs(ball.getXSpeed())))
					ball.setXSpeed(-ball.getXSpeed());
				else
					ball.setYSpeed(-ball.getYSpeed());
			}
			if(keys[0]==true)
				leftPaddle.moveUpAndDraw(graphToBack);
			if(keys[1]==true)
				leftPaddle.moveDownAndDraw(graphToBack);
			if(keys[2]==true)
				leftPaddle.moveLeftAndDraw(graphToBack);
			if(keys[3]==true)
				leftPaddle.moveRightAndDraw(graphToBack);
			if(keys[4]==true)
				rightPaddle.moveUpAndDraw(graphToBack);
			if(keys[5]==true)
				rightPaddle.moveDownAndDraw(graphToBack);
			if(keys[6]==true)
				rightPaddle.moveLeftAndDraw(graphToBack);
			if(keys[7]==true)
				rightPaddle.moveRightAndDraw(graphToBack);

			//see if the paddles need to be moved
			
			twoDGraph.drawImage(back, null, 0, 0);
		}

		public void keyPressed(KeyEvent e)
		{
			switch(toUpperCase(e.getKeyChar()))
			{
				case 'W' : keys[0]=true; break;
				case 'S' : keys[1]=true; break;
				case 'A' : keys[2]=true; break;
				case 'D' : keys[3]=true; break;	
				case 'I' : keys[4]=true; break;
				case 'K' : keys[5]=true; break;
				case 'J' : keys[6]=true; break;
				case 'L' : keys[7]=true; break;
			}
		}

		public void keyReleased(KeyEvent e)
		{
			switch(toUpperCase(e.getKeyChar()))
			{
				case 'W' : keys[0]=false; break;
				case 'S' : keys[1]=false; break;
				case 'A' : keys[2]=false; break;
				case 'D' : keys[3]=false; break;
				case 'I' : keys[4]=false; break;
				case 'K' : keys[5]=false; break;
				case 'J' : keys[6]=false; break;
				case 'L' : keys[7]=false; break;
			}
		}

		public void keyTyped(KeyEvent e){}
		
	   public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread();
			Thread.sleep(8);
	            repaint();
	         }
	      }catch(Exception e)
	      {
	      }
	  	}	
	}

