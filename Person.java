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
    long d; //private key
    
    /**
     * Generate a public key for this person, consisting of exponent, e, and mod, m.
     * Generate a private key, consisting only of exponent, d.
     * Provide access to public key only.
     */
    public Person(long mod, long exp)
    {
        m = mod;
        e = exp;
        
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
    public long[] encryptTo(java.lang.String msg, Person she)
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
