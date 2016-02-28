//Import standard Java class Random
import java.util.Random;
 
public class Load {
    public static void main(String[] args)
    {
        //Delcare new Random object
        Random rand = new Random();
 
        //Intialize variables
        int number, nRCount = 0;
        int[] array = new int[10];
        boolean fill;
 
		do{
            fill = true;
            //Get new random number
            number = rand.nextInt(10) + 1;
 
            //If the number exists in the array already, don't add it again
            for(int i = 0; i < array.length; i++)
            {
                if(array[i] == number)
                {
                    fill = false;
                }
            }
            //If the number didn't already exist, put it in the array and move
            //To the next position.
			
			if(fill == true)
            {
				array[nRCount] = number;
                nRCount++;
			}
			
        }while(nRCount < 10);
            for(int i = 0; i < array.length; i++)
        System.out.print(array[i]+" ");
	}
 
}