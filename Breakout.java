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

	public class Breakout extends Canvas implements KeyListener, Runnable
	{
		private Ball ball;
		private Paddle APaddle;
		private boolean[] keys;
		private BufferedImage back;
		private TopBlock1 block1;
		private TopBlock1 block2;
		private TopBlock1 block3;
		private TopBlock1 block4;
		private TopBlock1 block5;
		private TopBlock1 block6;
		private TopBlock1 block7;
		private TopBlock1 block8;
		private TopBlock1 block9;
		private TopBlock1 block10;

		

		public Breakout()
		{
			ball = new Ball(300, 300);
			APaddle = new Paddle(300, 570, 200, 10, Color.yellow, 5);
			keys = new boolean[8];
	    	setBackground(Color.WHITE);
			setVisible(true);
			new Thread(this).start();
			addKeyListener(this);
			block1= new TopBlock1(0, 300, 80, 10);
			block2= new TopBlock1(80, 300, 80, 10);
			block3= new TopBlock1(160, 300, 80, 10);
			block4= new TopBlock1(240, 300, 80, 10);
			block5= new TopBlock1(320, 300, 80, 10);
			block6= new TopBlock1(400, 300, 80, 10);
			block7= new TopBlock1(480, 300, 80, 10);
			block8= new TopBlock1(560, 300, 80, 10);
			block9= new TopBlock1(640, 300, 80, 10);
			block10= new TopBlock1(720, 300, 80, 10);

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
			if(block1.equals(block2) && block3.equals(block4) && block5.equals(block6) && block7.equals(block8) && block9.equals(block10)){
				graphToBack.drawString("YOU WIN!", 375, 300);
				ball.setXSpeed(0);
				ball.setYSpeed(0);
			}
			APaddle.draw(graphToBack);
			block1.draw(graphToBack);
			block2.draw(graphToBack);
			block3.draw(graphToBack);
			block4.draw(graphToBack);
			block5.draw(graphToBack);
			block6.draw(graphToBack);
			block7.draw(graphToBack);
			block8.draw(graphToBack);
			block9.draw(graphToBack);
			block10.draw(graphToBack);


			
			//see if ball hits left wall or right wall

				
			if(!(ball.getX()>=10 && ball.getX()<=790)){
					
				ball.setXSpeed(ball.getXSpeed()*-1);
			}
			if(!(ball.getY()>=10)){
				ball.setYSpeed(ball.getYSpeed()*-1);
			}
			if((ball.getY()>580)){
				graphToBack.setColor(Color.RED);
				graphToBack.drawString("GAME OVER", 375, 300);
			}
			
			//topballbottombrick
			if(((ball.getY())==block1.getY()) && 
					(ball.getX()>=block1.getX())&&((ball.getX()+ball.getWidth())<=block1.getX()+block1.getWidth())){
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				graphToBack.clearRect(0, 300, 80, 10);
				block1=new TopBlock1(3000, 3000, 0, 0);
			}
			if(((ball.getY())==block2.getY()) && 
					(ball.getX()>=block2.getX())&&((ball.getX()+ball.getWidth())<=block2.getX()+block2.getWidth())){
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				graphToBack.clearRect(80, 300, 80, 10);
				block2=new TopBlock1(3000, 3000, 0, 0);;
			}
			if(((ball.getY())==block3.getY()) && 
					(ball.getX()>=block3.getX())&&((ball.getX()+ball.getWidth())<=block3.getX()+block3.getWidth())){
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				graphToBack.clearRect(160, 300, 80, 10);
				block3=new TopBlock1(3000, 3000, 0, 0);
			}
			if(((ball.getY())==block4.getY()) && 
					(ball.getX()>=block4.getX())&&((ball.getX()+ball.getWidth())<=block4.getX()+block4.getWidth())){
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed()); 
				graphToBack.clearRect(240, 300, 80, 10);
				block4=new TopBlock1(3000, 3000, 0, 0);
			}
			if(((ball.getY())==block5.getY()) && 
					(ball.getX()>=block5.getX())&&((ball.getX()+ball.getWidth())<=block5.getX()+block5.getWidth())){
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				graphToBack.clearRect(320, 300, 80, 10);
				block5=new TopBlock1(3000, 3000, 0, 0);
			}
			if(((ball.getY())==block6.getY()) && 
					(ball.getX()>=block6.getX())&&((ball.getX()+ball.getWidth())<=block6.getX()+block6.getWidth())){
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				graphToBack.clearRect(400, 300, 80, 10);
				block6=new TopBlock1(3000, 3000, 0, 0);
			}
			if(((ball.getY())==block7.getY()) && 
					(ball.getX()>=block7.getX())&&((ball.getX()+ball.getWidth())<=block7.getX()+block7.getWidth())){
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				graphToBack.clearRect(480, 300, 80, 10);
				block7=new TopBlock1(3000, 3000, 0, 0);
			}
			if(((ball.getY())==block8.getY()) && 
					(ball.getX()>=block8.getX())&&((ball.getX()+ball.getWidth())<=block8.getX()+block8.getWidth())){
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				graphToBack.clearRect(560, 300, 80, 10);
				block8=new TopBlock1(3000, 3000, 0, 0);
			}
			if(((ball.getY())==block9.getY()) && 
					(ball.getX()>=block9.getX())&&((ball.getX()+ball.getWidth())<=block9.getX()+block9.getWidth())){
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				graphToBack.clearRect(640, 300, 80, 10);
				block9=new TopBlock1(3000, 3000, 0, 0);
			}
			if(((ball.getY())==block10.getY()) && 
					(ball.getX()>=block10.getX())&&((ball.getX()+ball.getWidth())<=block10.getX()+block10.getWidth())){
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				graphToBack.clearRect(720, 300, 80, 10);
				block10=new TopBlock1(3000, 3000, 0, 0);
			}
			if(((ball.getY())==APaddle.getY())&&
				(ball.getX()>=APaddle.getX()-10)&&((ball.getX()+ball.getWidth())<=APaddle.getX()+APaddle.getWidth()+10)){
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				
			}
			
			/*if(ball.getX()<=(APaddle.getX()+APaddle.getWidth()+Math.abs(ball.getXSpeed())) && 
					(ball.getY()>=APaddle.getY() &&
					ball.getY()<=(APaddle.getY()+APaddle.getHeight()) || 
					(ball.getY()+ball.getHeight())>=APaddle.getY() &&
					(ball.getY()+ball.getHeight())<(APaddle.getY()+APaddle.getHeight()))){
				if (ball.getX()<=(APaddle.getX()+APaddle.getWidth()-Math.abs(ball.getXSpeed()))){
					ball.setYSpeed(-ball.getYSpeed());
					ball.setXSpeed(ball.getXSpeed());
				}
				else{
					ball.setXSpeed(-ball.getXSpeed());
				}
			}*/
	

			if(keys[0]==true)
				APaddle.moveLeftAndDraw(graphToBack);
			if(keys[1]==true)
				APaddle.moveRightAndDraw(graphToBack);


			//see if the paddles need to be moved
			
			twoDGraph.drawImage(back, null, 0, 0);
		}

		public void keyPressed(KeyEvent e)
		{
			switch(toUpperCase(e.getKeyChar()))
			{
				case 'A' : keys[0]=true; break;
				case 'S' : keys[1]=true; break;
			}
		}

		public void keyReleased(KeyEvent e)
		{
			switch(toUpperCase(e.getKeyChar()))
			{
				case 'A' : keys[0]=false; break;
				case 'S' : keys[1]=false; break;

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
