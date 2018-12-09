package rsa;

import java.util.Random;

public class RemainderRSA {
	
	public static long randPrime(int m, int n, Random rand) {
		int i = 0;
		int num = 0;
		String primes = "";
		
		for(i = m; i <= n; i++){
			int counter = 0;
			for(num = i; num >= 1; num--) {
				if(i % num == 0){
					counter = counter + 1;
				}
			}
			if(counter == 2) {
				primes = primes + i + " ";
			}
		}
		long value = rand.nextLong();
		return value;
		
	}
	
	public static long relPrime(long n, Random rand) {
		if(rand == 0)
			return n;
		return relPrime(rand, n%rand);
	}
	
}
