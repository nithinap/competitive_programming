package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class MaximalEqualFreq {
    public static int maxEqualFreq(int[] nums) {
        int size = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        int res = -1, max = -1;
        for (int i=0; i< size; i++) {
//            if (freq.containsKey(nums[i])){
//                int key = freq.get(nums[i]);
//                cntMap.put(key, cntMap.get(key)-1);
//            }

            int c = freq.getOrDefault(nums[i], 0)+1;
            freq.put(nums[i], c);

            int count = cntMap.getOrDefault(c, 0);
            cntMap.put(c, count + 1);
            max = Math.max(max, cntMap.get(c));

            int tot = c * cntMap.get(c);
            if (freq.get(max) == 1 && cntMap.get(max-1) * (max -1) == i + 1) {
                System.out.println(i+"======= " + nums[i]);
                res = i + 1;
            }

        }


        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inp = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(inp[i]);
        }
        int res = maxEqualFreq(nums);
        System.out.println(res);
    }
}
