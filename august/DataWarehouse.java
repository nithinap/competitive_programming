package lc.august;

import java.util.Scanner;

public class DataWarehouse {

	public static void main(String[] args) {
		int n, h;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		h = sc.nextInt();
		
		int[][] HDD = new int[h][4];
		
		for (int i = 0; i < h; i++) {
			HDD[i][0] = sc.nextInt(); // p - price
			HDD[i][1] = sc.nextInt(); // r - read speed 
			HDD[i][2] = sc.nextInt(); // w - write speed
			HDD[i][3] = sc.nextInt(); // c - capacity
			
			// System.out.println(HDD[i][0] + " "+ HDD[i][1]+ " "+ HDD[i][2]+" "+HDD[i][3]);
		}

		int penalty = sc.nextInt();
		
		
		
		sc.close();
	}

}
