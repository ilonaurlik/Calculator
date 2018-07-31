public enum Operation {
    PLUS, MINUS, MULTIPLY, DIVIDE, POWER;

    long calculate (long x, long y){
        switch(this) {
            case PLUS: 
            	return x + y;
            case MINUS:
            	return x - y;
            case MULTIPLY:
            	return x * y;
            case DIVIDE:
                return x / y;
            case POWER: return getPower(x,y);
        }
        throw new AssertionError("Unknown op: " + this);
    }

	private long getCornerCases(long baseOfThePower, long exponent) {
		long result = 1;
		if (exponent == 0 && baseOfThePower != 0) {
			result = 1;
		} else if (baseOfThePower == 0) {
			result = 0;
		}
		return result;
	}

	private long getPower(long baseOfThePower, long exponent) {
		long result = 1;
        if (exponent > 0) {
        	for (long i = 1; i <= exponent; i++) {
        		result *= baseOfThePower;
        	}
        } else if (exponent < 0) {
        	for (double i = exponent; i < 0; i++) {
        		result *= 1/baseOfThePower;
        	}
        } else {
        	getCornerCases(baseOfThePower, exponent);
        }
        return result;
    }
}