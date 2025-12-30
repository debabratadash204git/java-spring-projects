package treeDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Input: [1, 3, 4, null, 2, 7, null, 8]
//output : [1, 7, 9, 8]

//Using BFS and Queue DS

public class level_order_sum {
	
	private static List<Integer> lavelOrderSum(Node root) {
		
		if(root == null)
			return new ArrayList();
		Queue<Node> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		
		queue.offer(root);
		
		
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			int sum = 0;
			
			for(int i =0; i < size;i++) {
				
				Node node = queue.poll();
				sum = sum+node.data;
				
				if(node.left != null)
					queue.offer(node.left);
				
				if(node.right != null)
					queue.offer(node.right);
				
			}
			list.add(sum);
		}
		
		return list;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(4);
		root.left = new Node(2);
		root.right =  new Node(7);
		root.left.left = new Node(1);
		//root.left.right = null;
		root.right.left = new Node(6);
		root.right.right = new Node(9);
		//root.right.left.left = null;
		root.left.left.right = new Node(11);
		List output = lavelOrderSum(root);
		System.out.println("height of a binary tree----" + output);

	}

}
