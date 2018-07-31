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