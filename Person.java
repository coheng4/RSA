/*
 * Generate a public key for this person, consisting of exponent,e, and modulus, m.
 * Generate a private key, consisting of an exponent, d.
 * Provide access to the public key only.
 */
public class Person {

	/*
	 * Access the public modulus
	 * @return The public modulus for this Person
	 */
	public long getM() {
		return 0;
	}
	
	/*
	 * Access the public encryption exponent
	 * @return The public encryption exponent for this Person
	 */
	public long getE() {
		return 0;
	}
	
	/*
	 * Encrypt a plain text message to she.
	 * An array of longs, which is the cipher text
	 */
	public long[] encryptTo(java.lang.String msg,
            Person she) {
		return null;
	}
	
	/*
	 * Decrypt the cipher text
	 * @return a string of plain text
	 */
	public java.lang.String decrypt(long[] cipher) {
		return "";
	}
}