package listProgram;

public class LinkedListPartition {

	public  static Node partitionLinkedList(Node head, int x) {

		Node tail = head;
		Node curr = head;

		while(curr != null) {

			Node next = curr.next;

			if(curr.data < x) {
				curr.next = head;
				head = curr;

			}
			else {
				tail.next = curr;
				tail = curr;

			}
			curr = next;
		}
		tail.next = null;
		return head;
	}

	public static void printList(Node head) {

		//Node curr = head;
		while(head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head = new Node(8);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);

		Node result = partitionLinkedList(head,5);
		printList(result);

	}

}
