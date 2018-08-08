/**
 * Using the calculator, you can convert an Arabic number to Roman, or vice versa.
 * The program can do the following calculations:
 * - addition
 * - subtraction
 * - multiplication
 * - division
 * - exponentiation.
 * Activities can be performed on Roman, Arabic or mixed numbers.
 */

public class Main {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();

		Expression expression = new Expression("2^V");
		Expression expression1 = new Expression("^", "5", "3");
		Numbers expression2 = new Numbers("MCM");
		Numbers expression3 = new Numbers("159");

		calculator.calculate(expression);
		calculator.calculate(expression1);
		calculator.convertExpression(expression2);
		calculator.convertExpression(expression3);

	}
}