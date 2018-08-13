package lc.aug18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GCDMod {
	private static Long MOD = 1000000007L;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			long a, b, n;
			String[] abn = br.readLine().split(" ");
			a = Long.parseLong(abn[0]);
			b = Long.parseLong(abn[1]);
			n = Long.parseLong(abn[2]);
			long diff = Math.abs(a - b);

			long bn = modpow(b, n);
			bn = (bn << 1) % MOD;

			if (diff == 0)
				System.out.println(bn);
			else {
				Map<Long, Integer> bprime = getPrime(2*b);
				Map<Long, Integer> diffprime = getPrime(diff);
				Long gcd = 1L;

				if (2 * b > diff) {
					for (Entry<Long, Integer> entry : diffprime.entrySet()) {
						Long p = entry.getKey();
						if (bprime.containsKey(p)) {
							if (p != 2)
								gcd = gcd * modpow(p, Math.min(bprime.get(p) * n, entry.getValue()));
							else
								gcd = gcd * modpow(p, Math.min(((bprime.get(p)-1)*n) +1, entry.getValue()));
						}
					}
				} else {
					for (Entry<Long, Integer> entry : bprime.entrySet()) {
						Long p = entry.getKey();
						if (diffprime.containsKey(p)) {
							if (p != 2)
								gcd = gcd * modpow(p, Math.min(diffprime.get(p), entry.getValue()*n));
							else
								gcd = gcd * modpow(p, Math.min(diffprime.get(p), (entry.getValue()-1)*n + 1 ));
						}
					}
				}
				System.out.println(gcd%MOD);
			}
		}
	}

	private static Map<Long, Integer> getPrime(long b) {
		int sqb = (int) Math.sqrt(b);
		long num = b;
		Map<Long, Integer> primes = new HashMap<>();
		int pow = 0;
		while (num % 2 == 0) {
			++pow;
			num /= 2;
		}
		if (num != b)
			primes.put(2L, pow);

		for (int i = 3; i <= sqb; i += 2) {
			if (num % i == 0) {
				pow = 0;

				while (num % i == 0) {
					++pow;
					num /= i;
				}
				primes.put((long) i, pow);
			}
		}
		if (num > 2)
			primes.put(num, 1);
		return primes;
	}

	private static long modpow(long a, long n) {
		long res = 1L;
		a = a % MOD;
		while (n > 0) {
			if ((n & 1) == 1) {
				res = (res * a) % MOD;
			}
			n = n >> 1;
			a = (a * a) % MOD;
		}
		return res % MOD;
	}
}
