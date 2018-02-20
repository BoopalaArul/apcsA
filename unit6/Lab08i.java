//© A+ Computer Science  -  www.apluscompsci.com 
//Name -
//Date -
//Class -
//Lab  -
package lab08i;

import static java.lang.System.*; 
import java.lang.Math;
import java.util.Scanner;

public class Lab08i
{
	public static void main ( String[] args )
	{
		//add test cases
		System.out.println("Enter a new number.");
		Scanner sc = new Scanner(System.in);
		Prime p = new Prime(sc.nextInt());
		System.out.println(p);
	}	
}