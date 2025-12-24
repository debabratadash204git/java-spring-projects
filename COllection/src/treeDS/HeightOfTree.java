package treeDS;

public class HeightOfTree {

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
		
		System.out.println("height of a binary tree----" + height(root));

	}

	private static int height(Node root) {
		
		if(root == null)
				return 0;//for count node based 
			//  return -1 // for count edge based
		int height = 1 + Math.max(height(root.left), height(root.right));
		
		return height;
	}

}
