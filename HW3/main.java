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

		String message = "m1";
		String secondMessage = "m2";

		RSA(message, secondMessage);
	}

	public static BigInteger RSA(String message, String secondMessage) {

		// Decently long BitLength keeps m < n
		int bitLength = 25;

		// Select just one random number
		Random r = new Random();

		p = BigInteger.probablePrime(bitLength, r);
		q = BigInteger.probablePrime(bitLength, r);
		n = p.multiply(q);
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		// e = BigInteger.probablePrime(bitLength / 2, r);
		e = new BigInteger("13");

		// Ensure that the gcd is equal to one
		while (!phi.gcd(e).equals(BigInteger.ONE)) {
			e.add(BigInteger.ONE);
		}

		d = e.modInverse(phi);

		// TESTING
		System.out.println(new BigInteger(message.getBytes()) + " " + new BigInteger(secondMessage.getBytes()) + " "
				+ new BigInteger(message.getBytes()).multiply(new BigInteger(secondMessage.getBytes())));

		// encrypt
		byte[] encrypted = encrypt(message.getBytes());
		byte[] secondEncrypted = encrypt(secondMessage.getBytes());
		byte[] multiplyMessages = encrypt(
				new BigInteger(message.getBytes()).multiply(new BigInteger(secondMessage.getBytes())).toByteArray());

		// decrypt
		byte[] decrypted = decrypt(encrypted);
		byte[] secondDecrypted = decrypt(secondEncrypted);

		// create signatures
		byte[] signature = signature(message.getBytes());
		byte[] secondSignature = signature(secondMessage.getBytes());

		// verify signature
		byte[] verify = verification(signature);
		byte[] secondVerify = verification(secondSignature);

		// Output for the First Message
		System.out.println("e: " + e);
		System.out.println("n: " + n);
		System.out.println("d: " + d);
		System.out.println("First Message");
		System.out.println("Original Message: " + message);
		System.out.println("Encrypted Message: " + new BigInteger(encrypted));
		System.out.println("Decrypted String: " + new String(decrypted));
		System.out.println("Signature: " + new BigInteger(signature));
		System.out.println("Verification: " + new String(verify));

		// Output for the Second Message
		System.out.println();
		System.out.println("Second Message");
		System.out.println("Original Message: " + secondMessage);
		System.out.println("Encrypted Message: " + new BigInteger(secondEncrypted));
		System.out.println("Decrypted String: " + new String(secondDecrypted));
		System.out.println("Signature: " + new BigInteger(secondSignature));
		System.out.println("Verification: " + new String(secondVerify));

		// Prove the homomorphic property of RSA
		System.out.println();
		System.out.println("Prove the homomorphic property of RSA");
		System.out.println("E(m1) * E(m2): " + new BigInteger(encrypted).multiply(new BigInteger(secondEncrypted))
				+ " = E(m1*m2): " + new BigInteger(multiplyMessages));
		// System.out.println(new String(decrypt(multiplyMessages)));

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

	// signature
	public static byte[] signature(byte[] message) {
		return (new BigInteger(message)).modPow(d, n).toByteArray();
	}

	// verification
	public static byte[] verification(byte[] message) {
		return (new BigInteger(message)).modPow(e, n).toByteArray();
	}
}