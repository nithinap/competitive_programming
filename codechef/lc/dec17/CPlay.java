package lc.dec17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPlay {
	private static String computeMinKick(String goals) {
		int tAScore = 0, tBScore = 0, tApossible = 5, tBpossible = 5;
		for (int i = 0; i < 10; i += 2) {
			if (goals.charAt(i) == '1')
				tAScore++;
			else
				tApossible--;

			if (tApossible < tBScore) {
				return "TEAM-B " + (i + 1);
			}
			if (tBpossible < tAScore) {
				return "TEAM-A " + (i + 1);
			}

			if (goals.charAt(i + 1) == '1')
				tBScore++;
			else
				tBpossible--;

			if (tBpossible < tAScore) {
				return "TEAM-A " + (i + 2);
			}

			if (tApossible < tBScore) {
				return "TEAM-B " + (i + 2);
			}

			// System.out.println("TA: " + tAScore + "; TB: " + tBScore);
		}

		if (tAScore != tBScore) {
			if (tAScore < tBScore)
				return "TEAM-B 10";
			else if (tBScore < tAScore)
				return "TEAM-A 10";
		}

		// when first 10 kicks couldn't decide the winner, decide by sudden death
		for (int i = 10; i < 20; i += 2) {
			if (goals.charAt(i) == '0' && goals.charAt(i + 1) == '1')
				return "TEAM-B " + (i + 2);
			else if (goals.charAt(i) == '1' && goals.charAt(i + 1) == '0')
				return "TEAM-A " + (i + 2);
		}

		return "TIE";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String goals;
		while ((goals = br.readLine()) != null) {
			// System.out.println(goals);
			System.out.println(computeMinKick(goals));
		}
	}

}
