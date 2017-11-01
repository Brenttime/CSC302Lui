package hw3csc302;

/*
 * CSC302 - Homework 3
 * By: Brent Turner 
 */

import java.math.BigInteger;
import java.util.Random;

public class main {

	private static BigInteger p;
	private static BigInteger q;
	private static BigInteger n;
	private static BigInteger phi;
	private static BigInteger e;
	private static BigInteger d;

	public static void main(String[] args) {

		String message = "message1";
		String secondMessage = "message2";

		RSA(message, secondMessage);
	}

	public static BigInteger RSA(String message, String secondMessage) {

		int bitLength = 50;

		Random r = new Random();

		p = BigInteger.probablePrime(bitLength, r);
		q = BigInteger.probablePrime(bitLength, r);
		n = p.multiply(q);
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e = BigInteger.probablePrime(bitLength / 2, r);

		while (!phi.gcd(e).equals(BigInteger.ONE)) {
			e.add(BigInteger.ONE);
		}

		d = e.modInverse(phi);

		// encrypt
		byte[] encrypted = encrypt(message.getBytes());

		// decrypt
		byte[] decrypted = decrypt(encrypted);

		System.out.println("");
		System.out.println("e: " + e);
		System.out.println("n: " + n);
		System.out.println("d: " + d);
		System.out.println("Original Message: " + message);
		System.out.println("Encrypted Message: " + new BigInteger(encrypted));
		System.out.println("Decrypted String: " + new String(decrypted));

		// Prove the homomorphic property of RSA
		System.out.println("E(m1) * E(m2): " + new BigInteger(message).multiply(new BigInteger(secondMessage)));

		return new BigInteger(encrypted);
	}

	// Encrypt message
	public static byte[] encrypt(byte[] message) {
		return (new BigInteger(message)).modPow(e, n).toByteArray();
	}

	// Decrypt message
	public static byte[] decrypt(byte[] message) {
		return (new BigInteger(message)).modPow(d, n).toByteArray();
	}
}