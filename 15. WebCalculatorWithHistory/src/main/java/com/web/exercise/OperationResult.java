package com.web.exercise;

public class OperationResult {

	private int number1;
	private int number2;
	private String operation;
	private int result;

	public OperationResult() {
	}

	public OperationResult(int number1, int number2, String operation) {
		this.number1 = number1;
		this.number2 = number2;
		this.operation = operation;
	}

	public void calculate() {
		if (operation.equals("+")) {
			result = number1 + number2;
		} else if (operation.equals("-")) {
			result = number1 - number2;
		}
	}

	@Override
	public String toString() {
		return "OperationResult [" + number1 + " " + operation + " " + number2
				+ " = " + result + "]";
	}

}
