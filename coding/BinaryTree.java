import java.util.Queue;
import java.util.LinkedList;

class Node{
	int data;
	Node left,right;

	public Node(int item){
		data = item;
		left = right = null;
	}
}
public class BinaryTree{
	Node root;

	public BinaryTree(){
		root = null;
	}
	public void inorder(){ inorder(root);};

	private void inorder(Node root){
		if(root==null)
			return;
		else{
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}

	public void insert(int key){
		Node temp = new Node(key);
		Queue<Node> queue = new LinkedList<Node>();
		if(root==null){
			root = temp;
		}
		else{
			Node top = queue.poll();
			if(top.left==null)
				top.left = temp;
			else if(top.right==null)
				top.right=temp;

			if(top.left!=null&&top.right!=null)
				queue.poll();
		}
		queue.add(temp);
	}
	public void levelOrder(){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			System.out.print(temp.data+" ");

			if(temp.left!=null)
				queue.add(temp.left);

			if(temp.right!=null)
				queue.add(temp.right);
		}
	}
	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
       		/*tree.root= new Node(1);
		tree.root.left= new Node(2);
                tree.root.right= new Node(3);
                tree.root.left.left= new Node(4);
                tree.root.left.right= new Node(5);*/
		//tree.inorder();
		int arr[]={1,2,3,4,5};
		for(int i=0;i<arr.length;i++)
			tree.insert(arr[i]);
		tree.levelOrder();
	}
}
