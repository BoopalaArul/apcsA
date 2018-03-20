//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	// sort words w/ length
	public Word( String s )
	{
		word = s;
	}

	/*
	 * you can have a compareTo function because of the implements Comparable
	 * public interface Comparable<T>
	 * This interface imposes a total ordering on the objects of each class that implements it. 
	 * This ordering is referred to as the class's natural ordering
	 * the class's compareTo method is referred to as its natural comparison method.
	 */
	public int compareTo( Word rhs )
	{
		if(this.getLength()<rhs.getLength())
			return -1;
		else if(this.getLength()==rhs.getLength())
			return 0;
		else
			return 1;
	}
	
	public int getLength()
	{
		return word.length();
	}
	
	public String toString()
	{
		return word;
	}
}