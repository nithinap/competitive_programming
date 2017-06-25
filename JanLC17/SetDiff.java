package JanLC17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetDiff {
	public static void main(String[] args) {

		   Set<Integer>  set1 = new HashSet<Integer>();
		   Set<Integer>  set2 = new HashSet<Integer>();
		   set1.addAll(Arrays.asList(1,2,3,4));
		   set2.addAll(Arrays.asList(1,3,7,8,9));
		   
		   set1.retainAll(set2);
		   System.out.println(set1);
	}
}
