//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -
package lab11c;
import static java.lang.System.*;

import java.util.Scanner;

public class Lab11c
{
   public static void main( String args[] )
   {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Enter a letter.");
	   char c = sc.next().charAt(0);
	   System.out.println("Enter a triangle size.");
	   int i = sc.nextInt();
	   TriangleThree tt = new TriangleThree(i, c);
	   System.out.println(tt);





	}
}