package listProgram;

public class OddEvenlinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);

		printList(head);

		Node oddevenList = generateOddEven(head);
		System.out.println("\n ");
		printList(oddevenList);

	}

	public static Node generateOddEven(Node head) {

		Node oddp = head;
		Node evenp = head.next;
		Node even = head.next;

		while(evenp != null && evenp.next != null) {

			oddp.next = oddp.next.next;
			oddp = oddp.next;
			evenp.next = evenp.next.next;
			evenp = evenp.next;
		}
		oddp.next = even;

		return head;

	}

	public static void printList(Node head) {

		while(head != null) {
			System.out.print(head.data+ "->");
			head = head.next;
		}
	}

}
