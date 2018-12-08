/*
* Find the multiplicative inverse of a long int, mod m
* @author Geoff Cohen
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