package hackerearth.hiringchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prayer {
    public static int greatestIndexNotExceeding(int[] data, int limit) {
        if (data.length < 1) {
            return -1;
        }
        return greatestIndexNotExceeding(data, limit, 0, data.length - 1);
    }

    private static int greatestIndexNotExceeding(int[] data, int limit, int lb, int ub) {
        final int mid = (lb + ub) / 2;

        // Need to go lower but can't
        if (mid == lb && data[mid] > limit) {
            return -1;
        }

        // Found a candidate, and can't go higher
        if (data[mid] <= limit && (mid == ub || data[mid + 1] > limit)) {
            return mid;
        }

        if (data[mid] <= limit) {
            // Consider upper half
            return greatestIndexNotExceeding(data, limit, mid + 1, ub);
        } else {
            // Consider lower half
            return greatestIndexNotExceeding(data, limit, lb, mid);
        }
    }
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			String[] arr = br.readLine().split(" ");
			int[] data = new int[n+1];
			
			for (int i=0; i<n; i++) {
				data[i] = Integer.parseInt(arr[i]);
			}
			
			for (int i=0; i<n; i++) {
				System.out.println(greatestIndexNotExceeding(data, 3));
			}
			
		}
		
	}
}
