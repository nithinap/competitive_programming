package challenges;

import java.util.Scanner;

public class Grid {
	static int valid = 0;
	static int n;

	private static int[] gridSolver(int[] arr, int gridSize) {
		// consider all 2*2 matrices
		// and reduce till we get a unit matrix
		int split = 0, position = 0;
		// int valid = 0;
		int[] red = new int[(gridSize - 1) * (gridSize - 1)];
		int newInd = 0;
		while (split < gridSize - 1) {
			// System.out.println("Split :" + split);
			position = 0;
			while (position < gridSize - 1) {
				int index = (split * gridSize) + position;
				// System.out.println(" For index " + index);
				if (n == gridSize && arr[index] == arr[index + 1] && arr[index + gridSize] == arr[index + gridSize + 1]
						&& arr[index] == arr[index + gridSize]) {
					valid++;
					red[newInd++] = 1;
				} else if(arr[index] == 1 && arr[index] == arr[index + 1] && arr[index + gridSize] == arr[index + gridSize + 1]
						&& arr[index] == arr[index + gridSize]){
					valid++;
					red[newInd++]=1;
				} else {
					red[newInd++] = 0;
				}
				position++;
			}
			split++;
		}return red;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int arr[] = null;

		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			arr = new int[n * n];
			valid = 0;

			// System.out.println(arr.length);
			// read the matrix in a 1-D array
			for (int index = 0; index < n * n; index++) {
				arr[index] = sc.nextInt();
			}

			// solve the problem
			int parts = n;
			while (parts > 1)
				arr = gridSolver(arr, parts--);

			System.out.println(valid + (n * n));
			arr = null;
		}
		sc.close();
	}
}
