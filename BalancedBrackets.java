
package com.greatlearning.lab3assignment1;

import java.util.Stack;

public class BalancedBrackets {
	
	public static void main(String[] args) {
		String inputString = "([[{}]])";

		if (checkBalance(inputString)) {
			System.out.println("The entered String has Balanced Brackets");
		} 
		else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}

	static boolean checkBalance(String expression) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {

			char x = expression.charAt(i);

			if (x == '(' || x == '[' || x == '{') {

				stack.push(x);
				continue;
			}

			if (stack.isEmpty()) {

				return false;
			}
			char check;
			switch (x) {
			case '}':
				check = stack.pop();
				if (check == '(' || check == '[') {
					return false;
				}
				break;

			case ')':
				check = stack.pop();
				if (check == '{' || check == '[') {
					return false;
				}
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{') {
					return false;
				}
				break;
			default:
				break;
			}
		}

		return stack.isEmpty();
	}
}
