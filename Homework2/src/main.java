
public class main {

	/*
	 * Encrypt message
	 */
	public static String encrypt(String plainText, int shiftKey) 
	{
		char[] temp = plainText.toCharArray();

		for(int i = 0; i < temp.length; i++)
		{
			if(i  < temp.length - shiftKey)
			{
				temp[i] = temp[i + shiftKey];
			}
			else
			{
				temp[i] = plainText.toCharArray()[(i - temp.length) + shiftKey];
			}
		}
		return plainText = new String(temp);
	}
	
	/*
	 * Decrypt message
	 */
	public static String decrypt(String plainText, int shiftKey) 
	{
		char[] temp = plainText.toCharArray();

		for(int i = 0; i < temp.length; i++)
		{
			if(i < shiftKey)
			{
				temp[i] = plainText.toCharArray()[(temp.length) - shiftKey + i];
			}
			else
			{
				temp[i] = plainText.toCharArray()[i - shiftKey];
			}
		}
		return plainText = new String(temp);
	}
	
	
	
	public static void main(String[] args) 
	{
		String message1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println(encrypt(message1, 3));
		System.out.println(decrypt(encrypt(message1, 3), 3));
		System.out.println(encrypt(message1.toLowerCase(), 5));
		System.out.println(decrypt(encrypt(message1.toLowerCase(), 5), 5));
	}

}
