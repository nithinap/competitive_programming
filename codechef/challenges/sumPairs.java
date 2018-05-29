package challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class sumPairs {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 7, -1, 5 };
		int n = arr.length;
		int sum = 6;

		getPairCount(arr, n, sum);

	}

	private static void getPairCount(int[] arr, int n, int sum) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int tcount = 0;
		
		for (int i = 0; i < n; i++) {
			if(map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i])+1);
			else
				map.put(arr[i], 1);
		}
		
		for(Entry<Integer, Integer> e: map.entrySet()) {
			System.out.println(e.getKey()+ "===>"+e.getValue());
			Integer value = map.get(sum - e.getKey());
			tcount +=  (value == null) ? 0:value*e.getValue();
			System.out.println(tcount);
		}
		System.out.println(tcount/2);
	}
}
