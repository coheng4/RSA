package CompCrypt_P3;

import java.util.Random;


/**
 * A Person Object contains a Person's public key, private key, public mod m and
 * encryption exponent e.
 * 
 * @author (Dylan Chow) 
 * @version (Dec 2019)
 */
public class Person extends RSA
{
    Random rnd = new Random(); //generate random number object
    long m; //public mod 
    long e; //encryption exponent 
    private long d; //private key
    public long pubKey; //public key
    
    /**
     * Generate a public key for this person, consisting of exponent, e, and mod, m.
     * Generate a private key, consisting only of exponent, d.
     * Provide access to public key only.
     */
    public Person()
    {
        m = rsa.relPrime(rnd.nextLong(), rnd);
        e = rnd.relPrime(rnd.nextLong(), rnd);        
    }
    
    /**
     * Access the public modulus, m.
     * @return the public modulus for this Person
     */
    public long getM()
    {
        return m;   
    }
    
    /**
     * Access the public encryption exponent
     * @return the pubic encrytpion exponent for this Person
     */
    public long getE()
    {
        return e;
    }
    
    /**
     * Encrypt a plain text msg to she.
     * @return an array of longs, which is the cipher text
     */
    public long[] encryptTo(String msg, Person she)
    {
        
        return null;
    }
    
    /**
     * Decrypt the cipher text
     * @return a string of plain text
     */
    public String decrypt(long[] cipher)
    {
        return null;
    }
}
