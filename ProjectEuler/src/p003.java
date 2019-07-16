/**
 * This class solves problem three in Project Euler.
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * This solution uses a brute force algorithm 
 * 
 * @author Kamil Adem
 *
 */
public class p003 implements Euler {

	/**
	 * Long integer containing the value 600851475143
	 */
	private long num = 600851475143L;
	
	/**
	 * This method computes the biggest prime factor of a number
	 * This method iteratively calls method smallestPrimeFactor to
	 * obtain the smallest prime factor and factors that value out
	 * from the original number. Once all prime factors have been
	 * found it returns the last prime factor found.
	 * 
	 * @return the largest prime factor as a String
	 */
	@Override
	public String run() {
		long p = 0;
		while(num!=1) {
			p = smallestPrimeFactor(num);
			num /=p;
		}
		// TODO Auto-generated method stub
		return Long.toString(p);
	}
	
	/**
	 * This method computes the smallest prime factor of a number.
	 * This method has an upper limit of √n for prime factors.
	 * If there are no prime factors left in the range, then the
	 * remaining number is prime
	 * 
	 * @param num the integer 
	 * @return    the smallest prime factor of the number
	 */
	public long smallestPrimeFactor(long num) {
		for (int i=2; i<Math.sqrt(num); i++) {
			if (num%i == 0) {
				return i;
			}
		}
		return num;
	}

}
