package CompCrypt_P3;

import java.util.Random;
import CompCrypt_P3.RSA;

/**
 * A Person Object contains a Person's public key, private key, public mod m and
 * encryption exponent e.
 * 
 * @author (Dylan Chow) 
 * @version (Dec 2019)
 */
public class Person
{
    Random rnd = new Random(); //generate random number object
    long m; //public mod 
    long e; //encryption exponent 
    private long d; //private key

    /**
     * Generate a public key for this person, consisting of exponent, e, and mod, m.
     * Generate a private key, consisting only of exponent, d.
     * Provide access to public key only.
     * @author Dylan Chow
     */
    public Person()
    {
        //Secret prime numbers
        long p = RSA.randPrime(111, 9999, rnd);
        long q = RSA.randPrime(111, 9999, rnd);
        while(p == q)
        {
            q = RSA.randPrime(111, 9999, rnd) + 2;
        }

        //Public Mod
        m = p * q;

        //N value
        long n = (p-1) * (q-1);

        //Encryption Exponent
        e = RSA.relPrime(n + 5, rnd);

        //Private Key
        d = RSA.inverse(e, n);        
    }

    /**
     * Access the public modulus, m.
     * @return the public modulus for this Person
     * @author Dylan Chow
     */
    public long getM()
    {
        return m;   
    }

    /**
     * Access the public encryption exponent
     * @return the pubic encrytpion exponent for this Person
     * @author Dylan Chow
     */
    public long getE()
    {
        return e;
    }

    /**
     * Encrypt a plain text msg to she.
     * @return an array of longs, which is the cipher text
     * @author Dylan Chow
     */
    public long[] encryptTo(String msg, Person she)
    {
        long [] result;
        int index = 1;

        if(msg.length() % 2 == 0)

            result = new long[msg.length()/2];           
        else
            result = new long[(msg.length()/2) + 1];

        long temp;
        int i = 0;

        while(index < msg.length()+1)
        {
            temp = RSA.toLong(msg, index);
            temp = RSA.modPower(temp, she.e, she.m);
            result[i] = temp;
            index+=2;
            i++;
        }

        return result;
    }

    /**
     * Decrypt the cipher text
     * @return a string of plain text
     * @author Dylan Chow
     */
    public String decrypt(long[] cipher)
    {
        long temp;
        String plain = "";

        for(int i = 0; i < cipher.length; i++)
        {
            temp = RSA.modPower(cipher[i], d, m);
            plain = plain + RSA.longTo2Chars(temp);
        }

        return plain;
    }
}
