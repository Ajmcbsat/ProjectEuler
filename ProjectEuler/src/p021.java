/**
 * This class solves Project Euler Problem 21
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * @author Kamil Adem
 *
 */
public class p021 implements Euler {

	
	/**
	 * The method iterates through all numbers less than 1000 and checks if they for an amicable pair
	 * Adds the values that forms an amicable pair
	 * 
	 * @return sum of all amicable pairs as String
	 */
	@Override
	public String run() {
		int sum = 0;
		for (int i=1; i<10000; i++) {
			if (isAmicable(i)) {
				sum+=i;
			}
		}
		return Integer.toString(sum);
	}

	
	/**
	 * This method checks if d(a)=b and d(b)=a and a!b where d(n) is the number of divisors of n
	 * 
	 * @param b the initial pair value
	 * @return  if b can form an amicable pair
	 */
	public boolean isAmicable(int b) {
		int a = sumDivisors(b);
		return a!=b && sumDivisors(a)==b; 
	}
	
	
	/**
	 * This method computes the sum of the divisors of the given number.
	 * Iterates through all n values and checks if the current index value is a divisor.
	 * 
	 * @param n the given number
	 * @return  the sum of the divisors
	 */
	public int sumDivisors(int n) {
		int num = 0;
		for (int i=1; i<n; i++) {
			if (n%i == 0) {
				num+=i;
			}
		}
		return num;
	}
}
