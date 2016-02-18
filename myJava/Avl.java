import java.io.*;
import java.lang.Integer;

class Node {
	public int iData;
	public int height;
	public Node left;
	public Node right;

	public Node(int id){
		iData = id;
		height = 0;
		left = null;
		right = null;
	}
} //end class Node

class Avl {
	private Node root;
	public Avl(){
		root = null;
	}

	public Node getRoot(){
		return root;
	}

	public Node find(int key, Node rt){
		if(rt==null)
			return null;
		if(rt.iData == key)
			return rt;
		else if(rt.iData < key)
			return find(key,rt.right);
		else return find(key, rt.left);
	
		return null;
	} // end find

	public height(Node x){
		if(x==null) return -1;
		else return x.height;
	} 

	public Node rotatewithleft(Node c){
		Node p;
		p = c.left;
		c.left = p.right;
		p.right = c;

		c.height = Math.max(height(c.left), height(c.right))+1;
		p.height = Math.max(height(p.left), height(p.right))+1;

		return p;
	}

	public Node rotatewithright(Node c){
		Node p;
		p = c.right;
		c.right = p.left;
		p.left = c;
	
		c.height = Math.max(height(c.left), height(c.right))+1;
		p.height = Math.max(height(p.left), height(p.right))+1;

		return p;
	}

	public doublerotatewithright(Node c){
		Node tmp;
		c.right = rotatewithleft(c.right);
		tmp = rotatewithright(c);
	
    		return tmp;
   	}	

	public doublerotatewithleft(Node c){
		Node tmp;
		c.left = rotatewithright(c.left);
		tmp = rotatewithleft(c);
		
		return tmp;
	}

	

	
		
