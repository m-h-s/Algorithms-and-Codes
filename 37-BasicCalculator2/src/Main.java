
public class Main {

	public static void main(String[] args) {
		//SimpleCalculator cal = new SimpleCalculatorS1();
		SimpleCalculator cal = new SimpleCalculatorS2();
		// String input = "1 * 2 - 3 / 4 + 5 * 6 - 7 * 8 + 9 / 10";
		// String input = "0";
		String input = "282-1*2*13-30-2*2*2/2-95/5*2+55+804+3024";
		
		System.out.println ( cal.calculate(input));
		
	}

}
