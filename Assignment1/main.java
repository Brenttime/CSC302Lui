package Assignment1;
import java.math.BigInteger;
public class main {

	public static void main(String[] args) 
	{

		int factorial = 1;
		for(int i= 2; i <= 40; i++) 
			
		{
			factorial=factorial*i;
			
			System.out.println("Factorial of "+i+" = "+factorial);
		}
		
		System.out.println("");
		System.out.println("BigInteger Class \n");
		
	
		BigInteger Factorial =new BigInteger("1");
		
		
	
		for(int i= 2; i <= 50; i++) 
		
		{
			
		Factorial=Factorial.multiply(BigInteger.valueOf(i));
			
		System.out.println("BigInterger Factorial of "+i+" = "+Factorial);
		
		}
		
	}

}


