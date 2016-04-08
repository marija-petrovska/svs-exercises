public class Numbers {

	int convert(String[] args) {

		int digit = 0;
		int digitValue = 1;
		int result = 0;

		int numberOfArg = args.length;

		//find the digit value of the first number (argument)
		while (numberOfArg > 1) {
			digitValue = digitValue * 10;
			numberOfArg--;
		}

		for (String word : args) {

			switch (word) {
			case "zero":
				digit = 0;
				break;
			case "one":
				digit = 1;
				break;
			case "two":
				digit = 2;
				break;
			case "three":
				digit = 3;
				break;
			case "four":
				digit = 4;
				break;
			case "five":
				digit = 5;
				break;
			case "six":
				digit = 6;
				break;
			case "seven":
				digit = 7;
				break;
			case "eight":
				digit = 8;
				break;
			case "nine":
				digit = 9;
				break;

			default:
				digit = 0;
			}
			result = result + digit * digitValue;
			digitValue = digitValue / 10;
		}
		return result;
	}

	public static void main(String[] args) {

		Numbers numbers = new Numbers();

		int convertedNum = numbers.convert(args);

		System.out.println("Converted number is: " + convertedNum);

	}

}
