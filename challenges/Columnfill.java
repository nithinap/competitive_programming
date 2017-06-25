package challenges;

public class Columnfill {
	public static void main(String[] args) {
		String str ="abcdefgh";
		int n = str.length();
		int r = 3;
		for (int i=0; i<r; i++) {
			int j = i;
			while(j < n) {
				System.out.print(str.charAt(j));
				j += r;
			}
		}
	}
}
