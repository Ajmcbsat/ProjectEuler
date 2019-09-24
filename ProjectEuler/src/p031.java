/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 *     1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * 
 * 
 * It is possible to make £2 in the following way:
 *     1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * 
 * How many different ways can £2 be made using any number of coins?
 * 
 * @author Kamil Adem
 *
 */
public class p031 implements Euler {

	/**
	 * Array containing pence values
	 */
	private int[] pounds = new int[] {1,2,5,10,20,50,100,200};
	
	
	/**
	 * This method computes the solution using dynamic programming.
	 * Iteratively solves subset sums and stores the values into the matrix array.
	 * Solution is built upon previous results and value is stored at the end of matrix array
	 */
	@Override
	public String run() {
		int[] matrix = new int[201];
		matrix[0] = 1;
		for (int i=0; i<pounds.length; i++) {
			for (int j=pounds[i]; j<=200; j++){
				matrix[j] += matrix[j-pounds[i]];
			}
		}
		return Integer.toString(matrix[200]);
	}

	public static void main(String[] args) {
		System.out.println(new p031().run());
	}
}
