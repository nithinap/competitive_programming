package soroco;

import java.math.BigDecimal;

public class Numsu {
	public static void main(String[] args) {
		BigDecimal num = new BigDecimal(1);
		BigDecimal two = new BigDecimal(2);
		int pow = 1;
		for (pow = 0; pow < 1000; pow++) {
			num = num.multiply(two);
		}
		System.out.println(num);
		BigDecimal sum = new BigDecimal(0);
		while(num.compareTo(new BigDecimal(0)) == 1) {		
			sum = sum.add(num.remainder(new BigDecimal(10)));
			num = num.divideToIntegralValue(new BigDecimal(10));
		}
		System.out.println("Sum : "+sum);
	}
}
