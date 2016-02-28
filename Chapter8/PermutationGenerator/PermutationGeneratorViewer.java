//Chapter8 - Exercise P8.11

//http://csc.csudh.edu/jhan/Spring2005/csc121/lab/lab14/lab14.htm
//https://answersresource.wordpress.com/2014/10/25/printing-random-permutation-array-and-arraylist-using-brute-force-and-smart-method-into-jframe/
//http://stackoverflow.com/questions/6946789/generating-random-permutation-uniformly-in-java

public class PermutationGeneratorViewer
{
    public static void main(String[] args) 
	{
	BrutePermutationGenerator brute = new BrutePermutationGenerator();
	SmartPermutationGenerator smart = new SmartPermutationGenerator();
	
	System.out.println("\n" + "Random arrays using Brute Force: ");
	brute.nextPermutation();
	
   	System.out.println("\n" + "Random arrays using Smart Force: ");
	smart.nextPermutation();
    }
} 