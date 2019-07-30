/**
 * This class solves problem 27 in Project Euler
 * 
 * Euler discovered the remarkable quadratic formula:
 * n2+n+41
 * 
 * It turns out that the formula will produce 40 primes for the consecutive integer values 0<=n<=39. 
 * However, when n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41
 * is clearly divisible by 41.
 * 
 * The incredible formula n2-79n+1601 was discovered, which produces 80 primes for the consecutive values 0<=n<=79. 
 * The product of the coefficients, -79 and 1601, is -126479.
 * 
 * Considering quadratics of the form:
 * n2+an+b, where |a|<1000 and |b|<=1000
 * where |n| is the modulus/absolute value of n e.g. |11|=11 and |-4|=4
 * 
 * Find the product of the coefficients, a
 * and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.
 * 
 * @author Kamil Adem
 *
 */
public class p027 implements Euler {

	/**
	 * This method returns the product of the coefficients that produce the 
	 * greatest number of consecutive primes. 
	 * Brute force searches all integer values from -1000 to 1000
	 * 
	 * @return the product of the coefficients that produce the greatest number of consecutive primes
	 */
	@Override
	public String run() {
		int max = 0;
		int maxA = 0;
		int maxB = 0;
		for (int a=-1000; a<=1000; a++) {
			for (int b =-1000; b<=1000; b++) {
				int temp = numConsecutivePrimes(a,b);
				if (temp>max) {
					max = temp;
					maxA = a;
					maxB = b;
				}
			}
		}
		return Integer.toString(maxB*maxA);
	}

	/**
	 * This method return the number of consecutive primes
	 * Starting from n=0, this method iterates until a non-prime number is reached
	 * using the equation n^2+an+b.
	 * 
	 * @param a the a coefficient
	 * @param b the b coefficient
	 * @return the number of consecutive primes
	 */
	public int numConsecutivePrimes(int a, int b) {
		int count = 0;
		int i = 0;
		while(true) {
			int val = (int) i*i + a*i + b;
			if (!isPrime(val)) {
				return count;
			}
			count++;
			i++;
		}
	}
	
	/**
	 * This method determines if the given number is prime.
	 * If the input is negative or a multiple 2 or 3, false.
	 * After first two test cases, all numbers less than 9 are prime numbers.
	 * All prime numbers greater than 3 can be written in the form 6k+-1 where k is 1:sqrt(num).
	 * All primes numbers grater than 3 are tested by every prime number until the square of itself.
	 * 
	 * @param num the number being tested
	 * @return	  whether the number is prime
	 */
	public boolean isPrime(int num) {
		if (num<0) {
			return false;
		}
		if (num%2 == 0) {
			return false;
		}
		if (num%3 == 0) {
			return false;
		}
		if (num<9) {
			return true;
		}

		int p = 5;
		while (p<=Math.sqrt(num)) {
			if (num%p == 0) {
				return false;
			}
			if (num%(p+2) == 0) {
				return false;
			}
			p+=6;
		}
		return true;
		
	}

}
