package general;

public class RemoveAdjacentDuplicates {

	public static String removeAdjacentDuplicate(String str) {

		StringBuilder sb = new StringBuilder();

		for(char ch : str.toCharArray()) {

			if(sb.length() > 0 && sb.charAt(sb.length() -1 ) == ch) {

				sb.deleteCharAt(sb.length() -1);

			}
			else {
				sb.append(ch);
			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String output = removeAdjacentDuplicate("abbaca");
		System.out.println("RemoveAdjacentDuplicates--------->" + "\t"+ output);


	}

}




