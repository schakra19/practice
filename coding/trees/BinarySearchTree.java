class Index{
	int index;
}
public class BinarySearchTree {
	Node root;
	Index index;

	public BinarySearchTree(){
		root = null;
	}

	public void insert(int key){
		root = insert(root,key);
	}
	private Node insert(Node nd, int key){
		if(nd==null){
			return new Node(key);
		}
		
		if(key > nd.data)
			nd.right =  insert(nd.right,key);
		else if(key < nd.data)
			nd.left =  insert(nd.left, key);
		else return nd;
		
		return nd;
	}

	public void inorder(){
		inorder(root);
	}
	private void inorder(Node nd){
		if(nd!=null){
			inorder(nd.left);
			System.out.print(nd.data+" ");
			inorder(nd.right);
		}
	}
	public void preorder(){
		preorder(root);
	}
	private void preorder(Node nd){
		if(nd!=null){
			System.out.print(nd.data+" ");
			preorder(nd.left);
			preorder(nd.right);
		}
	}

	// Min max method to check if tree is BST
	public boolean isValidBST(){
		return isValidBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean isValidBST(Node nd, int min, int max){
		if(nd==null)
			return true;
		if(nd.data < min || nd.data > max)
			return false;
		return (isValidBST(nd.left,min,nd.data) && isValidBST(nd.right,nd.data,max));
	}

	// Inorder (prev) method to check if tree is BST
	public boolean checkBST(){
		return checkBST(root);
	}
	private boolean checkBST(Node nd){
		Node prev = null;
		if(nd!=null){
			if (!checkBST(nd.left))
				return false;
			else if(prev !=null && nd.data <= prev.data)
				return false;	
			prev = nd;
			return checkBST(nd.right);
		}
		return true;
	}
	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(20);
		bst.insert(5);
		bst.insert(12);
		bst.insert(7);
		bst.insert(3);
		//bst.preorder();
		
		System.out.println(bst.checkBST());
		bst.inorder();
	}
}
