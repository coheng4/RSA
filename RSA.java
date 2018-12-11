import java.util.Random;

/*
 * Public-key encryption implementation
 */
public class RSA {
	
	/*
	 * Driver to test RSA encryption
	 */
	public static void main(java.lang.String[] args) {
	
	Random r = new Random();
	System.out.println(randPrime(2, 2000, r));	
		
	/*
	Person Alice = new Person(0, 0);
	Person Bob = new Person(0, 0);

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

	System.out.println ("Alice decodes and reads: " + Alice.decrypt (cipher));*/
	}
	
	/*
	 * Find the multiplicative inverse of a long int
	 * @return The inverse of e, mod m. Uses the extended Eulidean Algorithm
	 */
	public static long inverse(long e, long m)
    {
        long[] u = new long[3];
		long[] v = new long[3];
		long q;
		long[] c = new long[3];
		
		u[0] = 1;
		u[1] = 0;
		u[2] = m;
		
		v[0] = 0;
		v[1] = 1;
		v[2] = e;

		//EEA
		while(v[2] != 0) { 
			q = u[2] / v[2];
			c[0] = u[0] - (q * v[0]);
			c[1] = u[1] - (q * v[1]);
			c[2] = u[2] - (q * v[2]);
			u = v;
			v = c;
		}

		if(u[1] < 0) {
			return (u[1] + m);
		}
		else
			return u[1];
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
	public static long randPrime(int m, int n, Random rand) {
		long num = 0;
		boolean isPrime = false;
		while(isPrime == false) {
		    num = rand.nextInt(((n - m) + 1) + m);}
			//check if num is prime here
		return num;
	}
	
	/*
	 * Find a random number relatively prime to a given long int
	 * @return a random number relatively prime to n
	 */
	public static long relPrime(long n, Random rand) {
		long x = rand.nextLong();
		if(x == 0)
			return n;
		return relPrime(n%x, rand);
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
