package codeforces.r608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Blocks {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int b = 0, w =0;
        for (int i =0; i<n; i++) {
            if (s.charAt(i) == 'B') b++;
            else w++;
        }

        if (w % 2 != 0 && b %2 != 0) {
            System.out.println("-1");
        } else {
            int f = 0;
            char[] str =  s.toCharArray();
            StringBuilder steps = new StringBuilder();

            if (b % 2 == 0 && w%2 != 0) {
                for (int i = 0; i < n; i++) {
                    // flip bw
                    if (str[i] == 'B' && str[i+1] == 'W') {
                        str[i] = 'W';
                        str[i+1] = 'B';
                        steps.append((i+1)+" ");
                        f++;
                    } else if (str[i] == 'B' && str[i+1] == 'B') {
                        str[i] = 'W';
                        str[i+1] = 'W';
                        steps.append((i+1)+" ");
                        f++;
                    }
                }
            } else if (w % 2 == 0 && b%2 != 0) {
                for (int i = 0; i < n; i++) {
                    // flip wb
                    if (str[i] == 'W' && str[i+1] == 'B') {
                        str[i] = 'B';
                        str[i+1] = 'W';
                        steps.append((i+1)+" ");
                        f++;
                    } else if (str[i] == 'W' && str[i+1] == 'W') {
                        str[i] = 'B';
                        str[i+1] = 'B';
                        steps.append((i+1)+" ");
                        f++;
                    }
                }
            } else {
                if (w > b) {
                    // prop w
                    for (int i=0; i<n; i++) {
                        // flip wb
                        if (str[i] == 'W' && str[i+1] == 'B') {
                            str[i] = 'B';
                            str[i+1] = 'W';
                            steps.append((i+1)+" ");
                            f++;
                        } else if (str[i] == 'W' && str[i+1] == 'W') {
                            str[i] = 'B';
                            str[i+1] = 'B';
                            steps.append((i+1)+" ");
                            f++;
                        }
                    }
                } else {
                    for (int i=0; i<n; i++) {
                        // flip bw
                        if (str[i] == 'B' && str[i + 1] == 'W') {
                            str[i] = 'W';
                            str[i + 1] = 'B';
                            steps.append((i+1)+" ");
                            f++;
                        } else if (str[i] == 'B' && str[i + 1] == 'B') {
                            str[i] = 'W';
                            str[i + 1] = 'W';
                            steps.append((i+1)+" ");
                            f++;
                        }
                    }
                }
            }

            System.out.println(f);
            System.out.println(steps);
        }


    }
}
