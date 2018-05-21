import java.util.ArrayList;
import java.util.Arrays;

public class Tiles {

	private ArrayList list;
	
	
	public Tiles()
	{
		//Tiles w/ width 50, height 25
		
		//750 divided by 14 = around 53 = 50 + 3
			//600 divided by 11 = around 54 = 50 + 4
		//550 divided by 10 = around 55 = 50 + 5
		//outer layer = 14 + 14 + 10 + 10 = 48
		
		//700 divided by 13 = around 53
		//
		list = new ArrayList<Tile>();
		for (int i = 0; i < 750; i += 53)
		{
			Tile t = new Tile(i, 0, 50, 25, true);
			list.add(t);
			Tile t2 = new Tile(i, 500, 50, 25, true);
			list.add(t2);
		}
		for (int i = 30; i < 500; i += 55)
		{
			Tile t = new Tile(0, i, 25, 50, false);
			list.add(t);
			Tile t2 = new Tile(700, i, 25, 50, false);
			list.add(t2);
		}
		for (int i = 30; i < 700; i += 53)
		{
			Tile t = new Tile(i, 30, 50, 25, true);
			list.add(t);
			Tile t2 = new Tile(i, 470, 50, 25, true);
			list.add(t2);
		}
		for (int i = 0; i < 470; i += 53)
		{
			Tile t = new Tile(30, i, 25, 50, false);
			list.add(t);
			Tile t2 = new Tile(670, i, 25, 50, false);
			list.add(t2);
		}
	}
	
	public ArrayList getList()
	{
		return list;
	}
		
}
