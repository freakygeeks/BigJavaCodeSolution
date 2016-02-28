/*
-----------------------------------------------------------------------------------------------------------------------------------
This program is use to play a game of "He loves me, he loves me not or She loves me, she loves me not". Originally name as 'effeuiller la marguerite' in French which is a game of French origin. In this game one person seeks to determine whether the object of their affection returns that affection or not.
-----------------------------------------------------------------------------------------------------------------------------------
Copyright (C) 2014 by NieSe.

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.util.Scanner;

public class effeuiller_la_marguerite
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner (System.in);
	
	boolean done1 = false;//boolean instruction is set to false
	while (!done1) //if it false, keep iterating
	{
		System.out.println ("..il m'aime un peu - beaucoup - passionément - à la folie - pas du tout..");
		System.out.print ("Entrer A, B, C, D, or E. Pour quitter entrer Q : ");
		String input = in.nextLine();
		if (input.equalsIgnoreCase("Q"))
		{
			done1 = true;//if it true, terminate
			System.out.println ("Vraiment?.." +"\n");
		}
		else
		{
			if (input.equalsIgnoreCase("A"))
				System.out.println ("il m'aime un peu" + "\n");
			else if (input.equalsIgnoreCase("B"))
				System.out.println ("beaucoup" + "\n");
			else if (input.equalsIgnoreCase("C"))
				System.out.println ("passionément" + "\n");
			else if (input.equalsIgnoreCase("D"))
				System.out.println ("à la folie" + "\n");
			else if (input.equalsIgnoreCase("E"))
				System.out.println ("pas du tout"+ "\n");
			else
				System.out.println ("Oppsss..mal alphabet!" + "\n");
		}
	}

	boolean done2 = true;//boolean instruction is set to true
	while (done2) //if it true, keep iterating
	{
		System.out.println ("~ENGLISH TRANSLATION~");
		System.out.println ("..he loves me a little - very much - passionately - madly - not at all..");
		System.out.print ("Enter A, B, C, D, or E. To quit enter Q : ");
		String input = in.nextLine();
		if (input.equalsIgnoreCase("Q"))
		{
			done2 = false;//if it false, terminate
			System.out.println ("Really?..");
		}
		else
		{
			if (input.equalsIgnoreCase("A"))
				System.out.println ("he loves me a little" + "\n");
			else if (input.equalsIgnoreCase("B"))
				System.out.println ("very much" + "\n");
			else if (input.equalsIgnoreCase("C"))
				System.out.println ("passionately" + "\n");
			else if (input.equalsIgnoreCase("D"))
				System.out.println ("madly" + "\n");
			else if (input.equalsIgnoreCase("E"))
				System.out.println ("not at all"+ "\n");
			else
				System.out.println ("Oppsss..wrong alphabet!" + "\n");
		}
	}
	}
}