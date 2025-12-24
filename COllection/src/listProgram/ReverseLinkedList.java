package listProgram;




public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);

		Node node = head;
		while(node != null) {
            System.out.print(node.data+" ");
            node=node.next;
        }

       Node reverse = reverseLinkList(head);
        System.out.println(" ");

        node = reverse;
       while(node != null) {
           System.out.print(node.data+" ");
           node=node.next;
       }

	}

	public static Node reverseLinkList(Node head)
	{
		Node next= null;
		Node previus = null;
		Node current = head;

		while(current != null) {

			next = current.next;
			current.next = previus;
			previus = current;
			current = next;
		}
		return previus;

	}

}
