import java.util.ArrayList;

/**
 * This class solves Problem 26 in Project Euler
 * 
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
 *  1/2	= 	0.5
 *  1/3	= 	0.(3)
 *  1/4	= 	0.25
 *  1/5	= 	0.2
 *  1/6	= 	0.1(6)
 *  1/7	= 	0.(142857)
 *  1/8	= 	0.125
 *  1/9	= 	0.(1)
 *  1/10=   0.1 
 *  
 *  Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 *  Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 *  
 * @author Kamil Adem
 *
 */
public class p026 implements Euler {

	
	/**
	 * Array of primes <=1000
	 */
	private int [] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
									   83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 
									   173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 
									   269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 
									   373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 
									   467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 
									   593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 
									   691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 
									   821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 
									   937, 941, 947, 953, 967, 971, 977, 983, 991, 997};
	
	/**
	 * This method computes the max cycle length of a fraction in the form 1/d, where d<1000
	 * Iterates through only prime numbers since prime numbers contain the largest recurring cycles
	 * 
	 * @return the denominator which produces the longest cycle
	 */
	@Override
	public String run() {
		int max = 0;
		int index = 0;
		for (int i=0; i<primes.length; i++) {
			int n = numCycles(primes[i]);
			if (n>max) {
				max = n;
				index = i;
			}
		}
		return Integer.toString(primes[index]);
	}

	
	/**
	 * This method returns the number of digits in a cycle given an prime integer
	 * Iteratively computes decimal point values until a repeating value is found
	 * 
	 * @param n the given prime integer
	 * @return the number of digits in the cycle
	 */
	public int numCycles(int n) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		int a = 1;
		int count = 0;
		while (!al.contains((a*10)%n)) {
			a = (a*10)%n;
			al.add(a);
			count++;
		}
		return count;
	}
}
