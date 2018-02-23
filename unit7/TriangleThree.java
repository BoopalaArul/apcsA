package lab11c;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private char letter;

	public TriangleThree()
	{
	}

	public TriangleThree(int count, char let)
	{
		size = count;
		letter = let;
	}

	public void setTriangle(int sz, char let)
	{
		size = sz;
		letter = let;
	}

	public String getLetter()
	{
		return ""+letter;
	}

	public String toString()
	{
		int cU = 0;
		int cD = size-1;
		String output="";
		for(int i = 0; i < size; i++)
		{
			for(int j = cU; j < size ; j++)
			{
				output = output + " ";
			
			}
			for(int k = cD; k < size; k++)
			{
				output = output + getLetter();
			}
			output = output+"\n";
			cU++;
			cD--;
		}
		return ""+output;
	}
}