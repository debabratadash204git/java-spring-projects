package treeDS;

public class LowestCommonAncestor {
	
	private static Node lca(Node root, int n1, int n2) {
		
		if(root == null)
			return null;
		if(root.data== n1 || root.data == n2)
			return root;
		Node leftlca = lca(root.left,n1,n2);
		Node rightlca = lca(root.right,n1,n2);
		
		if(leftlca != null && rightlca != null)
			return root;
		
		return (leftlca!= null)?leftlca:rightlca;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(3);
		root.left = new Node(4);
		root.right =  new Node(6);
		root.left.left = new Node(7);
		root.left.right = new Node(8);
		root.right.left = new Node(9);
		root.right.right = new Node(10);
		root.right.left.left = new Node(11);
		
		Node ans = lca(root,9,10);
		System.out.println("Lowest common ancestor is -> " + ans.data);
		

	}

	

}
