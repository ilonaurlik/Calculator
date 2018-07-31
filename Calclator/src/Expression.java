import java.util.regex.Pattern;

public class Expression {
	private String expression;
	private String operation;
	private String x;
	private String y;

	public Expression(String expression) {
		this.expression = expression;
	}

	public Expression(String operation, String x, String y) {
		this.operation = operation;
		this.x = x;
		this.y = y;
	}

	private String determineOperation(String expression) {
		String operation = null;

		if (expression.contains("+")) {
			operation = "+";
		} else if (expression.contains("-")) {
			operation = "-";
		} else if (expression.contains("*")) {
			operation = "*";
		} else if (expression.contains("/")) {
			operation = "/";
		} else if (expression.contains("^")) {
			operation = "^";
		} else {
			throw new IllegalArgumentException("Operation is not supported!");
		}
		return operation;
	}

	private String trimWhitespaces(String expression) {
		return expression.replaceAll("\\s+", "");
	}

	private long calculate(String x, String y, String operation) {
		long result = Long.valueOf(0);
		long xToNumber = Long.valueOf(x);
		long yToNumber = Long.valueOf(y);

		if ("+".equals(operation)) {
			result = Operation.PLUS.calculate(xToNumber, yToNumber);
		} else if ("-".equals(operation)) {
			result = Operation.MINUS.calculate(xToNumber, yToNumber);
		} else if ("*".equals(operation)) {
			result = Operation.MULTIPLY.calculate(xToNumber, yToNumber);
		} else if ("/".equals(operation)) {
			result = Operation.DIVIDE.calculate(xToNumber, yToNumber);
		} else if ("^".equals(operation)) {
			result = Operation.POWER.calculate(xToNumber, yToNumber);
		} else {
			throw new IllegalArgumentException("Operation " + operation + " is not supported!!");
		}
		return result;
	}

	public String calculateAndGet() {
		Long result;
		String convertedResult = null;
		Numbers number = new Numbers(expression);
		if (expression != null) {
			String newTrimmedExpression = trimWhitespaces(expression); 
			String newOperation = determineOperation(newTrimmedExpression); 
			String[] aAndB = newTrimmedExpression.split(Pattern.quote(newOperation));
			String a = aAndB[0];
			String decimalA = number.convertRomanToArabic(a);
			String b = aAndB[1];
			String decimalB = number.convertRomanToArabic(b);

			result = calculate(decimalA, decimalB, newOperation);
			System.out.println(expression + "=" + result);
		} else {
			String decimalX = number.convertRomanToArabic(x);
			String decimalY = number.convertRomanToArabic(y);
			calculate(decimalX, decimalY, operation);
			System.out.println(x + operation + y + "=" + calculate(decimalX, decimalY, operation));
		}

		return convertedResult;
	}

	public String getExpression() {
		return expression;
	}

	public String getOperation() {
		return operation;
	}

	public String getX() {
		return x;
	}

	public String getY() {
		return y;
	}
}