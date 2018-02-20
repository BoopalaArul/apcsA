//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package lab08i;
import static java.lang.System.*;
import java.lang.Math;

public class Prime
{
	private int number;

	public Prime()
	{


	}

	public Prime(int num)
	{
		number = num;
	}

	public void setPrime(int num)
	{
		number = num;
	}

	public boolean isPrime()
	{
		for(int i = 2; i < number; i++)
		{
			if(number % i == 0 && number != 2)
			{
				return false;
			}
		}
		return true;
	}

	public String toString()
	{
		if(isPrime())
		{
			return number + " is a prime number.";
		}
		else
		{
			return number + " is not a prime number.";
		}
	}
}