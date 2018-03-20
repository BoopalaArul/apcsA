//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package lab18e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{
		//scanner doesn't take in keyboard input-- info fed to scanner through file object
		Scanner file = new Scanner(new File("src/lab18e.dat"));

		int size = file.nextInt();
		ArrayList<Word> w = new ArrayList<Word>();
		for(int i = 0; i <= size; i++)
		{
			w.add(new Word(file.nextLine()));
		}
		Collections.sort(w);
		System.out.println(w);
			
	}
}