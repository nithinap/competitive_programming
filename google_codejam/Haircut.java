package google.codejam;

import java.util.Scanner;

public class Haircut {
	static int b;
	static int n;
	static int[] m;
	public static void main(String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int k=0; k<t; k++){
			b = sc.nextInt();
			n = sc.nextInt();
			m = new int[b];
			for (int i=0; i<b; i++) {
				m[i] = sc.nextInt();
			}
			
			//System.out.println(Arrays.toString(m));
			long tnow = bSearch(-1L, 100000000000000L);
			long tp = countInitiated(tnow-1);
			//System.out.println("tnow: "+ tnow + "; tp: "+tp);
			//n - tp completed
			long left = n - tp;
			//System.out.println("left: "+ left);
			int res = -1;
			for (int i=0; i<b; i++) {
				if (tnow%m[i] == 0) {
					if (left == 1) {
						res = i+1;
						break;
					} else 
						left--;
				}
			}
			
			System.out.println("Case #"+ (k+1) + ": "+ res);
		}
		
		sc.close();
	}
	
	static long bSearch(long lo, long hi) {
		while (lo+1 < hi) {
			long mid = lo + (hi - lo)/2;
			if (hasBegun(mid))
				hi = mid;
			else 
				lo = mid;
		}
		
		return hi;
	}

	static long countInitiated(long t) {
		if (t < 0)
			return 0;
		long running = 0;
		for (int i=0; i<b; i++) {
			/*if (t < m[i])
				running += 1;
			else
				running += (int)Math.ceil((double)t/m[i]);*/
			running += t/m[i] + 1;
		}	
		return running;
	}
	
	private static boolean hasBegun(long t) {
		long running = countInitiated(t);
		if (running >= n)
			return true;
		
		return false;
	}
}
 