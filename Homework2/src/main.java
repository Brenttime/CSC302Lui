/*
 * Brent Turner
 * 9/21/2017
 * Homework2.java
 * 
 * This program is a Caesar cipher program made for CSC302
 */
public class main {

	/*
	 * Encrypt message
	 * 
	 * @param plainText - plain text message
	 * @param shiftKey - key we are using to shift the plain text message
	 * @return cipherText - the cipherText
	 */
	public static String encrypt(String plainText, int shiftKey) 
	{
		char[] temp = plainText.toCharArray();
		String cipherText;
		
		for(int i = 0; i < temp.length; i++)
		{
			temp[i] = plainText.toCharArray()[(i + shiftKey) % plainText.length()];
		}
		return cipherText = new String(temp);
	}
	
	/*
	 * Decrypt message
	 * 
	 * @param plainText - plain text message
	 * @param shiftKey - key we are using to shift the plain text message
	 * @return cipherText - the cipherTex
	 */
	public static String decrypt(String plainText, int shiftKey) 
	{
		char[] temp = plainText.toCharArray();
		String cipherText;
		
		for(int i = 0; i < temp.length; i++)
		{
			if(i < shiftKey)
			{
				temp[i] = plainText.toCharArray()[((i - shiftKey) + plainText.length()) % plainText.length()];
			}
			else
			{
				temp[i] = plainText.toCharArray()[(i - shiftKey) % plainText.length()];
			}
		}
		return cipherText = new String(temp);
	}
	
	/*
	 * Main Method
	 */
	public static void main(String[] args) 
	{
		String message1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println(encrypt(message1, 3));
		System.out.println(decrypt(encrypt(message1, 3), 3));
		System.out.println(encrypt(message1.toLowerCase(), 5));
		System.out.println(decrypt(encrypt(message1.toLowerCase(), 5), 5));
	}

}
