package listProgram;

import java.util.Stack;

public class PlaindromList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		
		boolean valid = validPalindromList(head);
		System.out.println("Palindrom List "+ valid);
	}

	private static boolean validPalindromList(Node head) {
		
		Node current = head;
		Stack<Integer> st = new Stack<>();
		while(current != null) {
			st.push(current.data);
			current = current.next;
		}
		while(head != null) {
			
			int data = st.pop();
			if(head.data != data)
				return false;
			head = head.next;
		}
		
		return true;
	}

}
