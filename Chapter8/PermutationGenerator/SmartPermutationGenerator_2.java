/*
-----------------------------------------------------------------------------------------------------
Produce random permutations of the number 1 to 10
-----------------------------------------------------------------------------------------------------
Copyright (C) 2014 by Zachary Rafael.
*/

//Chapter8 - Exercise P8.11

import java.util.ArrayList; 
import java.util.Random; 

public class SmartPermutationGenerator
{
    private int size; 
    private Random rand = new Random(); 

    public SmartPermutationGenerator()
    { 
    this.size = 10;
    } 

    public ArrayList nextPermutation() 
    { 
    int count = 0;
	
	
	ArrayList<Integer> unused = new ArrayList<Integer>();
	
	for (int i = 0; i < size; i++) // loop for element in array
        { 
        unused.add(i + 1);  
        } 

    ArrayList<Integer> perm = new ArrayList<Integer>(); 
        
	for (int k = 0; k < size; k++) //loop for random number between 1 to 10
        { 
        int pos = rand.nextInt(unused.size()); 
        perm.add(unused.get(pos)); 
        unused.remove(pos); 
		
		for (int j = 0; j < k; j++)
			{ 
			count++;
						
			System.out.print(perm.get(j) + " "); //loop for permutation 10 times
			if (count%10 == 0 && count !=0)
				{
				System.out.println();
				}
			}
		} 
    return perm; 
	}
} 