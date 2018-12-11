/*
 * Public-key encryption implementation
 */
public class RSA {
	
	/*
	 * Driver to test RSA encryption
	 */
	public static void main(java.lang.String[] args) {
	Person Alice = new Person();
	Person Bob = new Person();

	String msg = new String ("Bob, let's have lunch."); 	// message to be sent to Bob
	long []  cipher;
	cipher =  Alice.encryptTo(msg, Bob);			// encrypted, with Bob's public key

	System.out.println ("Message is: " + msg);
	System.out.println ("Alice sends:");
	show (cipher);

	System.out.println ("Bob decodes and reads: " + Bob.decrypt (cipher));	// decrypted,
								// with Bob's private key.
	System.out.println ();

	msg = new String ("No thanks, I'm busy");
	cipher = Bob.encryptTo (msg, Alice);
	
	System.out.println ("Message is: " + msg);
	System.out.println ("Bob sends:");
	show (cipher);

	System.out.println ("Alice decodes and reads: " + Alice.decrypt (cipher));
	}
	
	/*
	 * Find the multiplicative inverse of a long int
	 * @return The inverse of e, mod m. Uses the extended Eulidean Algorithm
	 */
	public static long inverse(long e,
            long m) {
		return 0;
	}
	
	/*
	 * Display an array of longs on stdout
	 */
	public static void show(long[] cipher) {
		
	}
	
	/*
	 * Raise a number, b, to a power, p, modulo m
	 * @return bp mod m
	 */
	public static long modPower(long b,
            long p,
            long m) {
		return 0;
	}
	
	/*
	 * Find a random prime number
	 * @return A random prime in the range m..n, using rand to generate the number
	 */
	public static long randPrime(int m,
            int n,
            java.util.Random rand) {
		return 0;
	}
	
	/*
	 * Find a random number relatively prime to a given long int
	 * @return a random number relatively prime to n
	 */
	public static long relPrime(long n,
            java.util.Random rand) {
		return 0;
	}
	
	/*
	 * Convert two numeric chars to long int
	 * @return the two digit number beginning at position p of msg as a long int.
	 */
	public static long toLong(java.lang.String msg,
            int p) {
		return 0;
	}
	
	/*
	 * Convert a long to 2 chars
	 * @return The string made up two numeric digits representing x
	 */
	public static java.lang.String longTo2Chars(long x){
		return "";
	}
}
