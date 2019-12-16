package lc.dec17;

import java.util.Scanner;

public class TotalDiamonds {
	static int[] evenStore = new int[2000002];
	static int[] oddStore = new int[2000002];

	static void procOEDiff() {
		for (int i = 1; i < 2000001; i++) {
			if (i == 0) {
				oddStore[i] = 0;
				evenStore[i] = 0;
			}
			if (i == 1) {
				oddStore[i] = 1;
				evenStore[i] = 0;
			} else if (i % 10 == 0) {
				oddStore[i] = oddStore[i / 10];
				evenStore[i] = evenStore[i / 10];
			} else if (i % 10 == 1) {
				oddStore[i] = oddStore[i / 10] + 1;
				evenStore[i] = evenStore[i / 10];
			} else if (i % 2 == 0) {
				oddStore[i] = oddStore[i - 2];
				evenStore[i] = evenStore[i - 2] + 2;
			} else {
				oddStore[i] = oddStore[i - 2] + 2;
				evenStore[i] = evenStore[i - 2];
			}
		}
	}
	
	private static long getOEdiff(int i) {
		return Math.abs(oddStore[i] - evenStore[i]);
	}

	public static void main(String[] args) {
		int t, n;
		procOEDiff();
		
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		
		long[] sumStore = new long[1000002];
		long[] bottomEdge = new long[1000002]; //bottom edge sum, excluding the leftmost cell
 		for (int i=1; i<1000001; i++) {
			if (i==1) 
				sumStore[i] = 2;
			else if (i==2) {
				sumStore[i] = 12;
				bottomEdge[i] = 4;
			} else if (i==2) {
				sumStore[i] = 36;
				bottomEdge[i] = 11;
			} else {
				sumStore[i] = sumStore[i-1];
				int corner = 2 * i;
				long newCell = getOEdiff(corner - 1);
				long cornerCell = getOEdiff(corner);
				bottomEdge[i] = bottomEdge[i-1] + newCell + cornerCell - getOEdiff(i+1);
				sumStore[i] += newCell * 2 + cornerCell + bottomEdge[i-1] *2;			
			} 
			
			
		}
		
		while (t-- > 0) {
			n = sc.nextInt();
			System.out.println(sumStore[n]);
		}

		sc.close();
	}


}