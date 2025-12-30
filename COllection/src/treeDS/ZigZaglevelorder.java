package treeDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZaglevelorder {
	
	private static List<List<Integer>> printZigzagLevelOrder(Node root){
		
		if(root == null)
			return new ArrayList();
		
		List<List<Integer>> output = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		boolean lefttoright = true;
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			List<Integer> levelitem = new ArrayList<>();
			
			for(int i = 0; i< size;i++) {
				
				Node node = queue.poll();
				
				if(lefttoright)
					levelitem.addLast(node.data);
				else
					levelitem.addFirst(node.data);
				
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
				
			}
			lefttoright = !lefttoright;
			output.add(new ArrayList<>(levelitem));
			
		}
		return output;
		
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
		List<List<Integer>> output = printZigzagLevelOrder(root);
		System.out.println("height of a binary tree----" + output);

	}

}
