package lc.aug18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SheokNum {
	private static double LOG2 = Math.log(2);

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int num = Integer.parseInt(br.readLine());
			// System.out.println(minOps(num));
			calcOps(num);
		}
	}

	private static void calcOps(int num) {
		int[] pow2 = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536,
				131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728,
				268435456, 536870912, 1073741824 };
		
		int steps = getClosestSum(pow2, num, pow2.length);
		System.out.println(steps);
	}

	private static int getClosestSum(int[] pow2, int num, int len) {
		int l = 0, r = len -1;
		int min = Integer.MAX_VALUE;
		while (l < r) {
			int dist = Math.abs(pow2[l] + pow2[r] - num);
			if (dist < min) {
				min = dist;
			}
			if ((pow2[l] + pow2[r]) > num)
				r--;
			else 
				l++;
		}
		return min;
	}

	private static int minOps(int num) {
		if (num == 1)
			return 2;
		if ((num & (num - 1)) == 0) {
			// already power of 2
			return 1;
		} else {
			int x = findClosestPowOf2(num); // x is less than num & of the form 2^k
			int gt2p = 1;
			while (gt2p < num)
				gt2p <<= 1;

			int y = findClosestPowOf2(num - x);
			System.out.println("x: " + x + "; y: " + y + "closest 2^x+2^y: " + (x + y));
			System.out.println("gt2p: " + gt2p);
			int val = x + y;
			if (val == num)
				return 0;
			else {
				int next = (val - num + y);
				if (next < 0)
					next = Integer.MAX_VALUE;
				int steps = Math.min(Math.min((num - val), next), (gt2p - num + 1));
				// int steps = Math.min((num- val), (gt2p-num+1));
				return steps;
			}
		}
	}

	private static int findClosestPowOf2(int num) {
		// closest less than num
		int pow = (int) (Math.log(num) / LOG2);
		int less2p = 1 << pow;
		return less2p;
	}
}
