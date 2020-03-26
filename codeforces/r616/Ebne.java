package r616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ebne {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            int sum = 0;
            for (int i=0; i<n; i++) {
                int num = s.charAt(i) - '0';
                sum += num;
            }

            //System.out.println(" ===== " + sum);
            if ((s.charAt(n-1) - '0' ) % 2 != 0 && (sum % 2 == 0)) {
                System.out.println(s);
            } else {

                int i = -1, num = -1;
                for (i=0; i<n; i++) {
                    num = s.charAt(i) - '0';
                    //sum += num;
                    if (num % 2 == 1) break;
                }

                if (num == -1) {
                    // no ans
                    System.out.println("-1");
                } else {
                    if (sum % 2 == 1) {
                        if (i == n-1)
                            System.out.println("-1");
                        else {
                            int tmp = 0;
                            //System.out.println(s +  " =======");
                            for (i = n-1; i>=0; i--) {
                                int d = (s.charAt(i) - '0');
                                if (d % 2 == 1) {
                                    if ((sum - tmp) % 2 == 0)
                                        break;
                                    else tmp += d;
                                } else {
                                    tmp += d;
                                }
                                //System.out.println("sum: " + sum + " tmp: " +  tmp);
                            }

                            //System.out.println("=== " + i + " === " + tmp);
                            if (i == -1 || (sum - tmp) % 2 == 1 || tmp == sum) {
                                System.out.println("-1");
                            } else {
                                StringBuilder sb = new StringBuilder(s);
                                //System.out.println(" === HERE " + i +" " + s.length());
                                sb.delete(i+1, n);
                                System.out.println(sb);
                            }
                        }
                    } else {
                        // sum even
                        int tmp = 0;
                        for (i = n-1; i>=0; i--) {
                            int d = (s.charAt(i) - '0');
                            if (d % 2 != 0) {
                                if ((sum - tmp) % 2 == 0)
                                break;
                                else tmp += d;
                            } else {
                                tmp += d;
                            }
                        }
                        if (i == -1 || (sum - tmp) % 2 == 1 || tmp == sum) {
                            System.out.println("-1");
                        } else {
                            StringBuilder sb = new StringBuilder(s);
                            //System.out.println(" === HERE " + i +" " + s.length());
                            sb.delete(i+1, n);
                            System.out.println(sb);
                        }
                    }
                }
            }
        }
    }

}
