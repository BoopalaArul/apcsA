
public class Tile extends Block {
	private boolean horizontal;
	
	public Tile(int x, int y, int w, int h, boolean b)
	{
		super(x,y,w,h);
		horizontal = b;
	}
	
	public boolean isHorizontal()
	{
		return horizontal;
	}
}
