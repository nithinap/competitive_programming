package lc.sept17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SeaCo {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t, n, m;
		int[][] arr;
		int[] count;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[m + 1][3];
			count = new int[m + 1];
			Arrays.fill(count, 1);
			for (int i = 1; i <= m; i++) {
				// read 'm' commands
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
			}

			for (int i = m; i > 0; i--) {
				if (arr[i][0] == 2) {
					for (int j = arr[i][1]; j <= arr[i][2]; j++) {
						count[j]+= count[i];
					}
				}
			}

			int[] res = new int[n+1];
			for (int i = 1; i <= m; i++) {
				if (arr[i][0] == 1) {
					for (int j = arr[i][1]; j <= arr[i][2]; j++) {
						res[j] += count[i];
					}
				}
				//System.out.println("count["+i+"] = "+count[i]);
			}
			
			for(int i=1; i<=n; i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();

		}

	}
}
