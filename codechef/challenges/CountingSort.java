package challenges;

import java.util.Arrays;

public class CountingSort {

	private static char[] countsort(char[] arr) {
		int[] count = new int[26];
		char[] result = new char[arr.length];
		Arrays.fill(count, 0);

		for (int i = 0; i < arr.length; i++) {
			count[(int) arr[i] - 97]++;
		}

		for (int i = 1; i < count.length; i++)
			count[i] += count[i - 1];

		for (int i = 0; i < arr.length; i++) {
			result[count[arr[i] - 97] - 1] = arr[i];
			--count[arr[i] - 97];
		}
		return result;
	}

	public static void main(String[] args) {
		char[] arr = { 'f', 'g', 'a', 'd', 'b', 'a' };

		char[] output = countsort(arr);
		for ( char o : output)
			System.out.println(o);
	}
}
