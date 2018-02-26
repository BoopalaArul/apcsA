//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package lab14i;

import static java.lang.System.*;

public class RomanNumeral
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
		setRoman(str);
	}

	public RomanNumeral(int orig)
	{
		setNumber(orig);
	}

	public void setNumber(int num)
	{
		number = num;
	}

	public void setRoman(String rom)
	{
		roman = rom;
	}
	public Integer getNumber() //convert to number
	{
		String r = roman;
		number = 0;
		for(int i = 0; i < (r.length()-1); i++)
		{
			for(int j = 0; j < NUMBERS.length; j++)
			{
				if(r.substring(i,i+2) == LETTERS[j])
				{
					number = number + NUMBERS[j];
				}
				else if(r.substring(i,i+1) == LETTERS[j])
				{
					number = number + NUMBERS[j];
				}
				
			}
		}
		return number;
	}		
	
	public String toString() //convert to roman
	{
		int n = number;
		roman = "";
		for(int i = 0; i < NUMBERS.length; i++)
		{
			while(NUMBERS[i] <= n)
			{
				roman = roman + LETTERS[i];
				n = n - NUMBERS[i];
			}
		}
		return roman;
	}
}