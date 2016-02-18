import java.util.*;

class Node{
        int data;
        Node left;
        Node right;

        public Node(int key){
                data = key;
                left = right = null;
        }
}

public class Tree{
	
	static Node root;
	public Tree(){
		root  = null;
	}

	//1. Level iorder traversal - Using queue
	public void levelOrderTraversal(){
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

	//2. Print tree level by level in each line
	// (OR) Recursive method to calculate height of tree
	public void lineByLine(){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		//int height = 0;
		while(true){
			int size = queue.size();
			if(size==0)
				break;
				//return height;
			//height++;
			while(size > 0){
				
				Node temp = queue.poll();
				System.out.print(temp.data+" ");
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
				size--;
			}	
			System.out.println();
		}
	}
	//3. Iterative inorder traversal using stack - IMPORTANT - See iterator for inorder traversal below!!
	public void iterativeInorder(){
		if(root==null)
			return;
		Stack<Node> st = new Stack<Node>();
		Node curr = root;
		while(curr!=null){
			st.push(curr);
			curr = curr.left;
		}
		while(st.size()>0){
			curr = st.pop();
			System.out.print(curr.data+" ");
			if(curr.right!=null){
				curr = curr.right;
				while(curr!=null){
					st.push(curr);
					curr = curr.left;
				}
			}	
		}
	}
	//4. Calculate size of tree
	public int size(){
		return size(root);
	}
	public int size(Node node){
		if(node==null)
			return 0;
		else{
			return(size(node.left)+size(node.right)+1);
		}
	}
	//5. Check if two trees are identical - write a Java equals method for this class! 
	//6a. Height of the tree - (recursive) - trivial 
	//6b. Height of a tree - (iterative) - See #2 above

	//7. Delete a tree - (Trick - do a postorder traversal) 
	public void deleteTree(){
		deleteTree(root);
	}	
	public void deleteTree(Node node){
		if(node==null)
			return;
		else{
			deleteTree(node.left);
			deleteTree(node.right);
			node = null;
		}
	}

	//8. Level Order Traversal in Spiral form
	//9. Count leaf nodes in a tree - Trivial
	//
	/* Iterative traversal using iterator (see end of this file for iterator impl)
	public void iteratorInorder(){
		InOrderIterClass it = new InOrderIterClass(root);
		while(it.hasNext())
			System.out.print(it.next()+" ");
	}*/

	//10. Check if a tree is a sum tree (variation - 10a. convert a tree to a sum tree)
	private int isLeaf(Node nd){
		if(nd==null)
			return 1;
		if(nd.left==null && nd.right==null)
			return 1;
		return 0;
	}	
	public int isSumTree(){
		return isSumTree(root);
	}
	private int isSumTree(Node nd){
		if(nd==null || (isLeaf(nd)==1))
			return 1;
		int ls;
		int rs;
		if(isSumTree(nd.left)!=0 && isSumTree(nd.right)!=0){
			if(nd.left==null)
				ls=0;
			else if(isLeaf(nd.left)==1)
				ls = nd.left.data;
			else
				ls = 2*(nd.left.data);

			if(nd.right==null)
				rs=0;
			else if(isLeaf(nd.right)==1)
				rs = nd.right.data;
			else rs = 2*(nd.right.data);
			
			if(nd.data== rs+ls)
				return 1;
			else
				return 0;
		}
		return 0;
	}

	//11. Check if the tree satisfies the children sum prooperty (variation 11a. convert tree to one that holds children sum prop
	public boolean childrenSum(){
		return (childrenSum(root)==1);
	}
	private int childrenSum(Node nd){
		if(nd==null || (nd.left==null && nd.right==null))
			return 1;
		int lData=0;
		int rData=0;
		if(nd.left!=null)
			lData = nd.left.data;
		if(nd.right!=null)
			rData = nd.right.data;

		if(nd.data==lData+rData && (childrenSum(nd.left)==1) && (childrenSum(nd.right)==1))
			return 1;
		else return 0;
	}

	// 12. Calculate vertical sums in a tree
	public void verticalSum(){
		 verticalSum(root);
	}
	private void verticalSum(Node nd){
		if(nd==null)
			return;
		HashMap<Integer,Integer> hM = new HashMap<Integer,Integer>();
		verticalSumUtil(nd, 0, hM);
		if(hM!=null)
			System.out.println(hM.entrySet());
	}
	private void verticalSumUtil(Node nd, int hd, HashMap<Integer,Integer> hm){
		if(nd==null)
			return;

		verticalSumUtil(nd.left,hd-1,hm);
		int prev = (hm.get(hd)==null ? 0 : hm.get(hd));
		hm.put(hd,prev+nd.data);
		verticalSumUtil(nd.right,hd+1,hm);
	}
	//This main program constructs a tree as below
	//         1
	//       /  \
	//      2    3
	//     / \ 
	//    4   5
	public static void main(String[] args){
		Tree myTree = new Tree();
		myTree.root = new Node(13);
		myTree.root.left = new Node(10);
		myTree.root.right = new Node(3);
		myTree.root.left.left = new Node(4);
		myTree.root.left.right = new Node(6);
		myTree.root.right.right = new Node(3);
	//	myTree.levelOrderTraversal();
//		myTree.lineByLine();
//		System.out.println("Size of the tree is "+myTree.size());
	//	System.out.println("Height of the tree is "+myTree.lineByLine());
	//	System.out.println(myTree.childrenSum());	
		myTree.verticalSum();
	}
}

/*interface InorderIterator implements Iterator<Integer>{
	public int next();
	public boolean hasNext();
}

public class InOrderIterClass implements InorderIterator{
	Stack<Node> st;

	public InOrderIterClass(Node root){
		st = new Stack<Node>();
		while(root!=null){
			st.push(root);
			root = root.left;
		}
	}
	
	public boolean hasNext(){
		return !st.empty();
	}
	
	public int next(){
		if(!hasNext())
			throws NoSuchElementException("all elements have been visited");
		Node result = st.pop();
		int res = result.data;
		if(result.right!=null){
			result = result.right;
			while(result!=null){
				st.push(result);
				result = result.left;
			}
		}
		return res;
	}
}*/
