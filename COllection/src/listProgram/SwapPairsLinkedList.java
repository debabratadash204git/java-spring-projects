package listProgram;

public class SwapPairsLinkedList {


	public static void printList(Node head) {

		while(head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
	}

	public static Node swapPairs(Node head)
	{
		Node curr = head;
		while(curr != null && curr.next != null) {
			int temp = curr.data;
			curr.data = curr.next.data;
			curr.next.data = temp;
			curr = curr.next.next;
		}
		return head;
	}
	
	public static Node swapPairswithNode(Node head) {
		
		Node curr = head;
		Node newhead = head.next;
		
		while(curr!= null && curr.next!= null) {
			
			Node temp = curr.next;
			curr.next = curr.next.next;
			temp.next = curr;
			curr = curr.next;
			
			if(curr.next != null && curr.next.next != null) {
				temp.next.next = curr.next;
			}
		}
		
		return newhead;
		
	}

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

		//Node oddevenList = swapPairs(head);
		Node oddevenList = swapPairswithNode(head);
		System.out.println("\n ");
		printList(oddevenList);

	}

}
