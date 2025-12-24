package stackProgram;

import java.util.Stack;

public class Checkparenthesis {

	public boolean validParenthsis(String str) {

		Stack<Character> st = new Stack();
		for(int i = 0; i < str.length(); i++) {

			if(str.charAt(i) == '(') {
				st.push(str.charAt(i));
			}
			else
			{
				if(!st.isEmpty() && (st.peek() == '(' && str.charAt(i) == ')')) {
					st.pop();

				}
				else {
					return false;
				}
			}
		}


		return st.empty();

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String parenthsis = "()()";
		Checkparenthesis cp = new Checkparenthesis();
		System.out.println(cp.validParenthsis(parenthsis));

	}

}
