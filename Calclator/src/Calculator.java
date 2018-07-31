public class Calculator {

	public String calculate(Expression expression) {
		String result = null;
		if(expression.getExpression() != null) {
			result = expression.calculateAndGet();
		}
		return result;
	}
	
	public String convertExpression(Numbers numbers) {
		String result = null;
		if(numbers != null) {
			result = numbers.getConvertedExpression();
		}
		return result;
	}
}
