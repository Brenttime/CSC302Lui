/*
 * By Brent Turner
 * CSC 302 - Homework 1
 * 09/05/2017
 */
import java.math.BigInteger;

public class Factorial 
{
	public static void main(String[] args) 
	{
		int factorial = 1;
		for (int i = 2; i <= 40; i++)
		{
			factorial *= i;
			System.out.println(i + "!=" + factorial);
		}
		
		System.out.println("Now try it with BigIntegers");
		
		BigInteger bigFactorial = new BigInteger("1");
		
		for(int i = 2; i <= 50; i++)
		{
			bigFactorial = bigFactorial.multiply(BigInteger.valueOf(i)); //just did .valueOf to simplify using an int to multiply by
			System.out.println(i + "!=" + bigFactorial.toString());
		}
	}

}
