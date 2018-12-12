package rsa;

import java.util.Random;

public class RemainderRSA {

	public static long randPrime(int m, int n, Random rand) {
		long num = rand.nextInt(((n - m) + 1) + m);
		boolean isPrime = false;
		while(isPrime == false) {
		    int counter = 0;
		    long i = 0;
		    for(i = num; i >= 1; i--){
		    	if(num%i == 0)
		    		counter = counter + 1;
		    }
		    if(counter == 2)
		    	isPrime = true;
		}
		return num;
	}
	
//	public static long relPrime(long n, Random rand) {	}
	
}
