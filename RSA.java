import java.util.Random;

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

		String msg = new String("Bob, let's have lunch."); // message to be sent to Bob
		long[] cipher;
		cipher = Alice.encryptTo(msg, Bob); // encrypted, with Bob's public key

		System.out.println("Message is: " + msg);
		System.out.println("Alice sends:");
		show(cipher);

		System.out.println("Bob decodes and reads: " + Bob.decrypt(cipher)); // decrypted,
		// with Bob's private key.
		System.out.println();

		msg = new String("No thanks, I'm busy");
		cipher = Bob.encryptTo(msg, Alice);

		System.out.println("Message is: " + msg);
		System.out.println("Bob sends:");
		show(cipher);

		System.out.println("Alice decodes and reads: " + Alice.decrypt(cipher));
	}
	
	/*
	 * Find the multiplicative inverse of a long int
	 * @author Geoff Cohen
	 * @return The inverse of e, mod m. Uses the extended Eulidean Algorithm
	 */
	public static long inverse(long e, long m)
    {
		long makePositive = m; 
		long u = 1, v = 0; 
  
        if (m == 1) 
            return 0; 

        //EEA
        while (e > 1 && m != 0) 
        { 
            long q = e / m; // divide repeatedly
            long temp = m; // for holding original m
  
            m = e % m; // r
            e = temp; // move m down
            temp = v; // for holding v
  
            v = u - q * v; // calculate new v
            u = temp; // calculate new u
        } 
  
        if (u < 0) //in case negative result
            u += makePositive; 
        
        return u; 
    }
	
	/*
     	* Display an array of longs on stdout
     	* @author Dylan Chow
     	*/
   	public static void show(long[] cipher) 
   {
        
	for(int i = 0; i < cipher.length; i++)
        {
            System.out.print(cipher[i]);
        }
        System.out.println();
   }
	
	/*
	 * Raise a number, b, to a power, p, modulo m
	 * @author Geoff Cohen
	 * @return bp mod m
	 */
	public static long modPower(long b, long p, long m)
    {
        b = b % m; // mod number
        long result = 1;
        
        while (p > 0) { // Reduce power through shift operations; 0/1 is base case
            if((p & 1)==1) // When power is reduced to 1, stop and calculate result
            	result = (result * b) % m;
            
            b = (b * b) % m; // Increment b by one power
            p = p >> 1; // Decrement p by one power
        } 
        return result; 
    }
	
	    /*
     * Find a random prime number
     * @author Dave Smits, Dylan Chow
     * @return A random prime in the range m..n, using rand to generate the number
     */
    public static long randPrime(int m, int n, Random rand) {
        
        long num = (rand.nextInt(n) % ((n - m) + 1)) + n;

        return num;
    }

    /*
     * Find a random number relatively prime to a given long int
     * @author Dave Smits, Dylan Chow
     * @return a random number relatively prime to n
     */
    public static long relPrime(long n, Random rand) {
        long t = rand.nextInt((int) n); //get Random t Long

        for(int i = 2; i < t; i++)
        {
            if(t % i == 0)
                return relPrime(n, rand); // t was not prime
        }

        return t;
    }
	
	/*
	 * Convert two numeric chars to long int
	 * 
	 * @author Dave Smits, Geoff Cohen
	 * 
	 * @return the two digit number beginning at position p of msg as a long int.
	 */
	public static long toLong(java.lang.String msg, int p) {
		long lr = 0;
		byte l = (byte) msg.substring(p, p + 2).charAt(0);
		byte r = (byte) msg.substring(p, p + 2).charAt(1);

		lr = l;
		lr = lr << 8;
		lr += r;

		return lr;
	}

	/*
	 * Convert a long to 2 chars
	 * 
	 * @author Dave Smits, Geoff Cohen
	 * 
	 * @return The string made up two numeric digits representing x
	 */
	public static String longTo2Chars(long x) {
		byte r = (byte) x;
		long t = x >> 8;
		byte l = (byte) t;

		return (char) l + (char) r + "";
	}
}