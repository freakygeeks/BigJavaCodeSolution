import java.io.Console; 
import java.util.Scanner; 

public class TestNewton { 

public static void main(String[] args) { 

Scanner reader = new Scanner(System.in); 
System.out.println("Enter a number you would like to find the square root of"); 

int a = reader.nextInt(); 

NewtonRaphson nr = new NewtonRaphson(5.0, a); 

nr.findSqRtA(); 

} 
} 