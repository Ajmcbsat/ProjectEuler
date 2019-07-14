/**
 * 
 */

/**
 * @author Kamil Adem
 *
 */
public class p005 implements Euler {

	private int [] val = new int[20];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new p005().run());
	}
	
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
	 * This method computes the smallest prime factor of a number.
	 * If there are no prime factors left in the range, then the
	 * remaining number is prime
	 * 
	 * @param num the integer 
	 * @return    the smallest prime factor of the number
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

	public void update(int[] arr1, int[] arr2) {
		for (int i=0; i<20; i++) {
			arr1[i] = Integer.max(arr1[i], arr2[i]);
		}
	}
	
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
