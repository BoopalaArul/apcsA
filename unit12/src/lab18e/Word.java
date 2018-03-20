//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package lab18e;
import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s)
	{
		word = s;
	}

	public int compareTo( Word rhs )
	{
		if(this.vowelCount()<rhs.vowelCount())
			return -1;
		else if(this.vowelCount()==rhs.vowelCount())
			return 0;
		else
			return 1;
	}
	//y is not counted as vowel
	private int vowelCount()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for(int i=0;i<word.length();i++)
		{
			if(vowels.contains(word.substring(i,i+1)))
				vowelCount++;
		}
		return vowelCount;
	}
	

	public String toString()
	{
		return word;
	}
}