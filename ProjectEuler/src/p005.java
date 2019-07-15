
/**
 * This class solves problem five in Project Euler.
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * This solution uses the concept of dynamic programming
 * 
 * @author Kamil Adem
 *
 */

public class p005 implements Euler {

	
	/**
	 * THe array which holds the max counts of each prime factor in the range 1-20
	 */
	private int [] val = new int[20];

	/**
	 * This method computes the smallest multiple that can be divided by all numbers 1-20
	 * This method computes the prime factors of every number in the range 2-20, stores those 
	 * values in an array and update the final array based on the max count of each prime number.
	 * The final product is then computed by multiplying the values in the final array.
	 * 
	 *@return the final product as a String
	 */
	@Override
	public String run() {
		for (int i=2; i<21; i++) {
			int[] temp = new int[20];
			primeFactor(temp, i);
			update(val, temp);
		}
		int num = smallestMultiple(val);
		return Integer.toString(num);
	}

	/**
	 * This method computes the prime factors of a number.
	 * Recursively computes prime factors of the number and
	 * updates the given array's values
	 * 
	 * @param arr the array that will hold the prime factors
	 * @param num the integer 
	 */
	public void primeFactor(int [] arr,int num) {
		for (int i=2; i<=num; i++) {
			if (num%i == 0) {
				primeFactor(arr, num/i);
				arr[i]++;
				return;
			}
		}
		return;
	}

	/**
	 * This method updates the first array based on the second array's values
	 * The update is based on the max value at each index.
	 * 
	 * @param arr1 the first array
	 * @param arr2 the second array
	 */
	public void update(int[] arr1, int[] arr2) {
		for (int i=0; i<20; i++) {
			arr1[i] = Integer.max(arr1[i], arr2[i]);
		}
	}
	
	
	/**
	 * Based on the final array, this method computes the final product
	 * Using the values obtained by computing the prime factors, the values
	 * present in the array are multiplied by their respective counts
	 * 
	 * @param arr the final array containing the counts of each prime number
	 * @return    the final product
	 */
	public int smallestMultiple(int[] arr) {
		int num = 1;
		for (int i=0; i<20; i++) {
			if (arr[i] != 0) {
				num*=Math.pow(i, arr[i]);
			}
		}
		return num;
	}
}
