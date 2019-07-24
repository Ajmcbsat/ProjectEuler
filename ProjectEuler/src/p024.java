/**
 * This class solve Problem 24 in Project Euler.
 * 
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. 
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. 
 * The lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012   021   102   120   201   210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * 
 * @author Kamil Adem
 *
 */
public class p024 implements Euler {

	
	/**
	 * Array which contains the initial configuration of the permutation
	 */
	private int[] perm = new int[] {0,1,2,3,4,5,6,7,8,9};
			
	
	/**
	 * This method computes the next permutation of the array until the 1 millionth permutation is reached.
	 */
	@Override
	public String run() {
		int count = 1;
		while(count<1000000) {
			nextPerm(perm);
			count++;
		}
		return this.toString();
	}
	
	
	/**
	 * This method computes the next permutation of the given array.
	 * This algorithm first finds the largest index i such that arr[i] <arr[i+1]
	 * The algorithm then finds the larges index j such that arr[j]>arr[i+1] and j>i
	 * The values at arr[i] and arr[j] are swapped and the values in te array arr[i+1:] are reversed.
	 *  
	 * @param arr the given permutation array
	 */
	public void nextPerm(int[] arr) {
		int indexi = 0;
		int indexj = 0;
		for (int i=0; i<arr.length-1; i++) {
			if (arr[i] < arr[i+1]) {
				indexi = i;
			}
		}
		for (int j=0; j<arr.length; j++) {
			if (arr[j]>arr[indexi] && j>indexi) {
				indexj = j;
			}
		}
		swap(arr, indexi, indexj);
		reverse(arr, indexi+1);
	}
	
	
	/**
	 * This method swaps two array values given their index locations.
	 * 
	 * @param arr the given array
	 * @param i   the index of the first value
	 * @param j   the index of the second value
	 */
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	/**
	 * This method reverses a subsection of an array from the given starting index
	 * Iteratively swaps values from both sides of the array until it reaches the median of the subsection.
	 * 
	 * @param arr   the given array
	 * @param index the starting index
	 */
	public void reverse(int[] arr, int index) {
		int count = 1;
		for (int i=index; i<(index+arr.length)/2; i++) {
			swap(arr, i, arr.length-count);
			count++;
		}
	}
	
	
	/**
	 * This method translates the array values into a String literal
	 */
	@Override
	public String toString() {
		String s = "";
		for (int i=0; i<perm.length; i++) {
			s+=perm[i];
		}
		return s;
	}

}
