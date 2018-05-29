package hackerearth.hiringchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Bugs {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n, t, val;
		int size = 0;
		
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		n = sc.nextInt();
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
//			t = sc.nextInt();
			String[] line = br.readLine().split(" ");
			t = Integer.parseInt(line[0]);
			switch (t) {
			case 1: 
//				val = sc.nextInt();
				val = Integer.parseInt(line[1]);
				size = insertSorted(arr, size, val, n);
//				System.out.println(Arrays.toString(arr));
//				System.out.println("size: "+size);
				break;
			case 2:
				if (size < 3) {
					System.out.println("Not enough enemies");
				} else {
					System.out.println(arr[(size/3)-1]);
				}
				break;
			}
		}
		
//		sc.close();
	}
	private static int insertSorted(int[] arr, int size, int val, int n) {
		if (size >= n) {
			return size;
		}
		
		int i;
		for (i=size-1; (i >=0 && arr[i] < val); i--) {
			arr[i+1] = arr[i];
		}
		arr[i+1] = val;
		return (size+1);
	}
}
