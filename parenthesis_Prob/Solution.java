package parenthesis_Prob;

import java.util.Stack;

public class Solution {
	public static int bracket_match(String bracket_String) {
		Stack<Character> st = new Stack<Character>();
		int count = 0;
		for (int i = 0; i < bracket_String.length(); i++) {
			if (bracket_String.charAt(i) == '(') {
				st.push(bracket_String.charAt(i));
				count++;
			} else if (bracket_String.charAt(i) == ')') {
				if (st.isEmpty())
					count++;
				else {
					st.pop();
					count--;
				}
			}

		}
		return count;
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(((";

		System.out.println(" " + bracket_match(s));
	}

}
