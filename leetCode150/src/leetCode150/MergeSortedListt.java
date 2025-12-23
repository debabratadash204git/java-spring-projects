package leetCode150;

import java.util.*;
//list1 = [1,2,4]
//list2 = [1,3,4]

//1,1,2,3,4,4

import leetCode150.Node;

public class MergeSortedListt {
	
	

	public static void main(String[] args) {
	
		Node list1 = new Node(1);
		
		list1.next = new Node(2);
		list1.next.next = new Node(4);
		
		
		Node list2 = new Node(1);
		list2.next = new Node(3);
		list2.next.next =  new Node(4);
		
		List<Node> list = new ArrayList<>();
		list.add(list1);
		list.add(list2);
		
//		list.add(new Node(1));
//		list.get(0).next = new Node(3);
//		list.get(0).next.next = new Node(4);
//		list.get(0).next.next.next = new Node(6);
//		
//		list.add(new Node(2));
//		list.get(1).next = new Node(7);
//		list.get(1).next.next = new Node(8);
//		list.get(1).next.next.next = new Node(9);
		
		list.add(new Node(3));
		list.get(2).next = new Node(5);
		list.get(2).next.next = new Node(6);
		list.get(2).next.next.next = new Node(7);
		
//		Node result = mergeListUsingMinHeap(list);
//		printList(result);
//	
//		Node finalList = mergeList(list1,list2);
//		printList(finalList);
		
		Node resultNodeUsingRecursion = mergeUsingRecursion(list1,list2);
		printList(resultNodeUsingRecursion);
	}
	
	public static Node mergeUsingRecursion(Node head1, Node head2) {
		
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		
		if(head1.data <= head2.data) {
			head1.next = mergeUsingRecursion(head1.next, head2);
			return head1;
		}
		else {
			head2.next = mergeUsingRecursion(head2.next, head1);
			return head2;
		}
		
		
	}
	
	
	
	
	public static Node mergeListUsingMinHeap(List<Node> arr) {
		
		PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b)-> a.data-b.data);
		
		for(Node head:arr) {
			if(head!= null)
				minHeap.add(head);			
		}
		
		Node dummy  = new Node(-1);
		Node temp = dummy;
		
		while(!minHeap.isEmpty()) {
			
			Node top = minHeap.poll();
			temp.next = top;
			temp = top;
			
			if(temp.next != null) {
				minHeap.add(temp.next);
			}
		}
		
		
		return dummy.next;
	}

	public static Node mergeList(Node head1, Node head2) {
		Node dummy  = new Node(-1);
		Node temp = dummy;
		
		while(head1 != null && head2 != null) {
			if(head1.data <= head2.data) {
				
				temp.next = head1;
				head1 = head1.next;
				
			}
			else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}
		if(head1 != null) {
			temp.next = head1;
			//head1 = head1.next;
		}
		else {
			temp.next = head2;
			//head2 = head2.next;
		}
		
		
		return dummy.next;
		}
	static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
	

}
