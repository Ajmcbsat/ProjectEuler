/**
 * @author Kamil Adem
 *
 */
public class p002 implements Euler{

	/**
	 * This method computes the sum of even Fibonacci numbers
	 * If the first sequence of the Fibonacci sequence is 
	 * greater than 4 million the method returns
	 * 
	 * @return the sum as a String
	 */
	@Override
	public String run() {
		int sum = 0;
		
		int fib1 = 1;
		int fib2 = 2;
		
		while (fib1 <4000000) {
			int temp = fib1;
			if (fib1%2 ==0) {
				sum+=fib1;
			}
			fib1 = fib2;
			fib2+=temp;
		}
		return Integer.toString(sum);
		
	}
}
