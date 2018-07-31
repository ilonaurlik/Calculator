public class Numbers {
	private String expression = "";

	private static final int[] ARABIC_NUMBERS = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	private static String[] ROMAN_NUMBERS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public Numbers(String expression) {
		this.expression = expression;
	}

	public String convertArabicToRoman(String expression) {
		String arabicToRoman = null;

		if (isNumeric(expression)) {
			int arabicValid = isArabicValid(Integer.parseInt(expression));
			arabicToRoman = arabicToRoman(arabicValid);
		} else {
			arabicToRoman = expression;
		}
		return arabicToRoman;
	}

	public String convertRomanToArabic(String expression) {
		String romanToArabic = null;
		if (!isNumeric(expression)) {
			String trimmedRoman = trimWhitespaces(expression);
			String romanValid = isRomanValid(trimmedRoman);
			romanToArabic = Integer.toString(romantoArabic(romanValid));
		} else {
			romanToArabic = expression;
		}
		
		return romanToArabic;
	}

	private boolean isNumeric(String expression) {
		return !expression.matches("[a-zA-Z]+") && expression.length() > 0;
	}

	private String trimWhitespaces(String roman) {
		if (roman == null) {
			throw new IllegalArgumentException("Operation is not supported!");
		} else
			return roman.replaceAll("\\s+", "");
	}

	private String isRomanValid(String romanExpression) {
		romanExpression = romanExpression.toUpperCase();

		if (romanExpression == null || romanExpression.isEmpty()
				|| !romanExpression.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
			throw new IllegalArgumentException("Error");
		}
		return romanExpression;
	}

	private int isArabicValid(int arabic) {
		if (arabic < 1) {
			throw new NumberFormatException("Error");
		}
		if (arabic > 3999) {
			throw new NumberFormatException("Error");
		} else
			return arabic;

	}

	private int romantoArabic(String roman) {
		int i = 0;
		int arabic = 0;

		while (i < roman.length()) {

			char letter = roman.charAt(i);
			int number = letterToNumber(letter);

			i++;

			if (i == roman.length()) {

				arabic += number;
			} else {
				int nextNumber = letterToNumber(roman.charAt(i));
				if (nextNumber > number) {
					arabic += (nextNumber - number);
					i++;
				} else {
					arabic += number;
				}
			}
		}
		return arabic;
	}

	private int letterToNumber(char letter) {
		switch (letter) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			throw new NumberFormatException("Error");
		}
	}

	private String arabicToRoman(int arabicValid) {
		String roman = "";
		int N = arabicValid;
		for (int i = 0; i < ARABIC_NUMBERS.length; i++) {
			while (N >= ARABIC_NUMBERS[i]) {
				roman += ROMAN_NUMBERS[i];
				N -= ARABIC_NUMBERS[i];
			}
		}
		return roman;
	}

	public String getConvertedExpression() {
		String convertedExpression;
		if (isNumeric(expression)) {
			convertedExpression = convertArabicToRoman(expression);
			System.out.println(convertedExpression);
		} else {
			convertedExpression = convertRomanToArabic(expression);
			System.out.println(convertedExpression);
		}
		return convertedExpression;
	}

}