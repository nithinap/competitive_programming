package hackerearth.hiringchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Winner {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t;
		//Scanner sc = new Scanner(System.in);
		//t = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
		    /*int s_p, s_q, s_r, s_s;
		    int d_p, d_q, d_r, d_s;
		    int f_p, f_q, f_r, f_s;
		    int c_p, c_q, c_r, c_s;*/
		    
		    String s_line = br.readLine();
			String d_line = br.readLine();
			String f_line = br.readLine();
			String c_line = br.readLine();
		    
			int[] s = new int[4];
			int[] d = new int[4];
			int[] f = new int[4];
			int[] c = new int[4];

            int ind = 0;
			for (String str : s_line.split(" ")) {
				s[ind++] = Integer.parseInt(str);
			}
			
			ind = 0;
			for (String str : d_line.split(" ")) {
				d[ind++] = Integer.parseInt(str);
			}
			
			ind = 0;
			for (String str : f_line.split(" ")) {
				f[ind++] = Integer.parseInt(str);
			}
			
			ind = 0;
			for (String str : c_line.split(" ")) {
				c[ind++] = Integer.parseInt(str);
			}
			
            
			System.out.println(Arrays.toString(s));
			System.out.println(Arrays.toString(d));
			System.out.println(Arrays.toString(f));
			System.out.println(Arrays.toString(c));

			long tot_f = 0, tot_c = 0;
			for (int i = 0; i < 4; i++) {
				long tmp = (d[i] * f[i]);
				if (tmp > s[i]/2)
					tot_f += (int)(s[i]/2);
				else
					tot_f += (s[i] - tmp);
			}

			for (int i = 0; i < 4; i++) {
				long tmp = (d[i] * c[i]);
				if (tmp > s[i]/2)
					tot_c += (int)(s[i]/2);
				else
					tot_c += (s[i] - tmp);
			}
			
			System.out.println(tot_f);
			System.out.println(tot_c);
			
			if (tot_f == tot_c) {
				int time_f = f[0];
                for (int i = 1; i < 4; i++) {
                	if (f[i] > time_f)
                		time_f = f[i];
		        }
				
				
				int time_c = c[0];
                for (int i = 1; i < 4; i++) {
                	if (c[i] > time_c)
                		time_c = c[i];
		        }
		        
				if (time_f == time_c) {
					System.out.println("Tie");
				} else if (time_f > time_c) {
					System.out.println("Flash");
				} else {
					System.out.println("Cisco");
				}
				
				
			} else if (tot_f > tot_c){
				System.out.println("Flash");
			} else {
				System.out.println("Cisco");
			}
			
		}

	}

	private static void readArr(Scanner sc, int[] arr, int len) {
		for (int i = 0; i < len; i++) {
			arr[i] = sc.nextInt();
		}
	}

	private static int getTime(int[] arr, int len) {
		int max = arr[0];
		for (int i = 1; i < len; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}
}
