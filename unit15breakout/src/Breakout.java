import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import static java.lang.Character.*;

import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Breakout extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	//private Paddle leftPaddle;
	//private Paddle rightPaddle;
	private Paddle paddle;
	private Tiles tiles;
	private boolean[] keys;
	private BufferedImage back;
	
	//private int leftScore;
	//private int rightScore;
	
	private boolean gameOver = false;

	public Breakout()
	{
		//set up all variables related to the game
		ball = new Ball();
		paddle = new Paddle(750/2, 300/2);
		//ball = new BlinkyBall();
		ball.setColor(Color.BLUE);
		tiles = new Tiles();
		//leftPaddle = new Paddle(5, 10, 5, 10, 100);
		//rightPaddle = new Paddle(720, 10, 5, 10, 100);
		//leftPaddle.setColor(new Color(0x803380));
		//rightPaddle.setColor(new Color(0xff83ff));
		
		//leftScore = 0;
		//rightScore = 0;
		
		//ball.setXSpeed(3);
		//ball.setYSpeed(3);
		//back = new BufferedImage();

		keys = new boolean[4];
	
    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		JOptionPane.showMessageDialog(null, "WASD to move. R to restart.");
		
		new Thread(this).start();
		addKeyListener(this);		
	}
	
   public void update(Graphics window){
	   paint(window);
   }
   
   
   private static boolean PtInRect(Paddle p, int x, int y )
   {
	   //check if between bottom and top sides AND between left and right sides
       return x >= p.getX() && x < p.getX() + p.getWidth()
           && y >= p.getY() && y < p.getY() + p.getHeight();
   }
   private static boolean PtInTile(Tile p, int x, int y )
   {
	   return x >= p.getX() && x < p.getX() + p.getWidth()
       && y >= p.getY() && y < p.getY() + p.getHeight();
   }

   public void paint(Graphics window)
   {
	   setBackground(Color.WHITE);
	   Graphics2D twoDGraph = (Graphics2D)window;
//game over	   
	   if (gameOver) {
		   
		   for (int i = 0; i < 9; ++i) {
			   for (int j = 0; j < 26; ++j) {
				   twoDGraph.drawString("YOU WIN", 10 + 80 * i, 20 * j);
			   }
			   
		   }
		   tiles = new Tiles();
		  
		   return;
	   }
	 
	   back = (BufferedImage)(createImage(getWidth(),getHeight()));	
		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

//creation of game objects
		ball.moveAndDraw(graphToBack);
		paddle.draw(graphToBack);
		for(int i = 0; i < tiles.getList().size() ; i++)
		{
			Tile t = (Tile) tiles.getList().get(i);
			t.draw(graphToBack);
		}
		
//key responses
		if(keys[0] == true)
		{
			//move paddle up and draw it on the window
			paddle.moveDownAndDraw(window);
			//leftPaddle.moveDownAndDraw(window);
		}
		if(keys[1] == true)
		{
			//move paddle down and draw it on the window
			paddle.moveRightAndDraw(window);
			//leftPaddle.moveUpAndDraw(window);
		}
		if(keys[2] == true)
		{
			
			//rightPaddle.moveDownAndDraw(window);
			paddle.moveUpAndDraw(window);
		}
		if(keys[3] == true)
		{
			paddle.moveLeftAndDraw(window);
			//rightPaddle.moveUpAndDraw(window);
		}

		//see if ball hits left wall or right wall
		/*if(!(ball.getX()>=10 && ball.getX()<=730))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
		}

		
		//see if the ball hits the top or bottom wall 

		if(!(ball.getY()>=10 && ball.getY()<=550))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		
		*/
		
		//window.setColor(Color.BLACK);
//check if game is over		
		if (ball.didCollideLeft(null) || ball.didCollideRight(null)|| ball.didCollideTop(null)|| ball.didCollideBottom(null)) {
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			
			gameOver = true;
		}
		
		/*
		 * if (ball.didCollideTop(null) || ball.didCollideBottom(null)) {
			ball.setYSpeed(-ball.getYSpeed());

			}
		 */
	
//ball hits paddle
		if (PtInRect(paddle, ball.getX(), ball.getY())) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			
			//ball.setXSpeed(-ball.getXSpeed());
			//rightScore ++;	
		}

//ball collides off tile
		for(int i = 0; i < tiles.getList().size() ; i++)
		{
			int j = 0;
			Tile t = (Tile) tiles.getList().get(i);
			
			if (PtInTile(t, ball.getX(), ball.getY())) 
			{
				if(t.isHorizontal())
				{
					ball.setYSpeed(-ball.getYSpeed());
					tiles.getList().remove(i);
				}
				else
				{
					ball.setXSpeed(-ball.getXSpeed());
					tiles.getList().remove(i);
				}
			}
			
			
		}
		/*
		 * 	if (PtInRect(leftPaddle, ball.getX(), ball.getY())) {
			ball.setXSpeed(-ball.getXSpeed());
			leftScore ++;
			
			}
		 */
	
		if (paddle.getY() < 0)
			paddle.setY(0);
		
		if (paddle.getX() < 0)
			paddle.setX(0);
		
		if (paddle.getY() > 560)
			paddle.setY(500);
		
		if (paddle.getX() > 710)
			paddle.setX(710);
		/*
		 * 
		if (leftPaddle.getY() < 0)
			leftPaddle.setY(0);
		
		if (rightPaddle.getY() < 0)
			rightPaddle.setY(0);
		
		if (leftPaddle.getY() > 500)
			leftPaddle.setY(500);
		
		if (rightPaddle.getY() > 500)
			rightPaddle.setY(500);
		 */
		
		

//see if the paddles need to be moved

		twoDGraph.drawImage(back, null, 0, 0);
	   
		twoDGraph.setColor(new Color(0x800080));
		twoDGraph.drawRect(2, 2, 730, 557);
		//twoDGraph.drawString("Leftscore: " + Integer.toString(leftScore), 20, 520);
		//twoDGraph.drawString("Rightscore: " + Integer.toString(rightScore), 20, 550);
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
   
	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'A' : keys[1]=true; break;
			case 'S' : keys[2]=true; break;
			case 'D' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'A' : keys[1]=false; break;
			case 'S' : keys[2]=false; break;
			case 'D' : keys[3]=false; break;
			
			case 'R':
				
				ball = new Ball();
				//ball.setXSpeed(3);
				//ball.setYSpeed(3);
				gameOver = false;
				break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   			
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}