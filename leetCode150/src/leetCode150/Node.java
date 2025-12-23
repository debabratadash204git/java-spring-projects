package leetCode150;

public class Node {
		int data;
		Node next;
		Node(int data){
			this.data = data;
			Node next = null;
		}
		Node(){
			
		}
		 @Override
		    public String toString() {
		        return "Node [data=" + data + "]"; // Customize this based on your Node's properties
		    }
}

