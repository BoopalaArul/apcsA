
import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	@Override
	public String toString() {
		return "Block [xPos=" + xPos + ", yPos=" + yPos + ", width=" + width
				+ ", height=" + height + ", color=" + color + "]";
	}

	private int xPos;
	private int yPos;
	protected int width;
	protected int height;

	protected Color color;
	
	public Block() {
		xPos = 0;
		yPos = 0;
		width = 0;
		height = 0;
		color = Color.GREEN;
	}

	public Block(int xPos, int yPos, int width, int height) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		color = Color.GREEN;
	}
	
	public Block(int xPos, int yPos, int width, int height, Color c) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		color = c;
	}



	//add other Block constructors - x , y , width, height, color
	
	
	
	public Block(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		width = 10;
		height = 10;
		color = Color.MAGENTA;
	}
	
	
	
	
	
	
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
   //add the other set methods
   

   public void setColor(Color col)
   {
	   color = col;

   }
   
   public Color getColor() {
	   return color;
   }
   
   public void draw(Graphics window)
   {
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	  draw(window);
   }
   
	public boolean equals(Object obj)
	{




		return this == obj;
	}

	@Override
	public void setPos(int x, int y) {
		// TODO Auto-generated method stub
		setX(x);
		setY(y);
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		xPos = x;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		yPos = y;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return xPos;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return yPos;
	}   

   //add the other get methods
    

   //add a toString() method  - x , y , width, height, color
}