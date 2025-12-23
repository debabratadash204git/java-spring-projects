package leetCode150;

import leetCode150.Node;
import java.util.*;

public class MergeSortedListWithoutExtralistt {

	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data);
			if (head.next != null)
				System.out.print(" -> ");
			head = head.next;
		}
		System.out.println();
	}

	static Node mergeList(Node head1, Node head2) {

		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		if (head1.data < head2.data)
			return mergeUtil(head1, head2);
		else
			return mergeUtil(head2, head1);

	}

	static Node mergeUtil(Node h1, Node h2) {

		Node curr1 = h1;
		Node next1 = h1.next;

		Node curr2 = h2;
		Node next2 = h2.next;

		while (next1 != null && curr2 != null) {

			if ((curr2.data) >= (curr1.data) && (curr2.data) <= (next1.data)) {

				next2 = curr2.next;
				curr1.next = curr2;
				curr2.next = next1;

				curr1 = curr2;
				curr2 = next2;

			} else {
				if (next1 != null) {
					next1 = next1.next;
					curr1 = curr1.next;
				} else {
					next1.next = curr2;
					return h1;
				}
			}

		}

		return h1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node list1 = new Node(1);
		list1.next = new Node(2);
		list1.next.next = new Node(4);

		Node list2 = new Node(1);
		list2.next = new Node(3);
		list2.next.next = new Node(4);

		Node finalList = mergeList(list1, list2);
		printList(finalList);

	}

}
