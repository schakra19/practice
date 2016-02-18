public class MyLinkedListTest{

	public static MyLinkedList myL;
	
	public static void main(String[] args){
		myL = new MyLinkedList();
		myL.add("1");
		myL.add("2");
		myL.add("3");
		myL.add("4");
		myL.add("5");
		myL.add("6");
		myL.add("7");
		System.out.println("Print : "+ myL.toString());
		System.out.println("Size  : "+ myL.size());
		/*System.out.println("Element at index 3 : "+ myL.get(3));
		System.out.println("Remove element at 2 : "+ myL.remove(2));
		System.out.println("Element at index 3 : "+ myL.get(3));
		System.out.println("Size again : "+ myL.size());*/
	//	System.out.println("Middle element is : "+ myL.middleElem());
	//	myL.rearrange();
	//	System.out.println("After rearranging "+myL);
		System.out.println("Removing element  "+myL.remove(2));
		System.out.println(myL.toString());
	}
}
class MyLinkedList {

	private static int counter;
	private Node head;

	//default contructor
	public MyLinkedList(){
	}

	// add a node at the end of list
	public void add(Object data){
		if(head == null){
			head = new Node(data);
		}
		else{
		Node temp = new Node(data);
		Node current = head;

		if(current != null){
			while(current.getNext() != null){
				current = current.getNext();
			}

			current.setNext(temp);
		   }
		}
		incrementCounter();
	}

	//add a node at the specified index
	public void add(Object data, int index){
		Node temp = new Node(data);
		Node current = head;

		if(current != null){
			for(int i = 1; i < index && current.getNext() != null;i++){
				current = current.getNext();
			}
		}

		temp.setNext(current.getNext());
		current.setNext(temp);
		
		incrementCounter();
	}

	// get object at specified index
	public Object get(int index){
		if(index <= 0){
			return null;
		}

		Node current = null;
		if(head != null){
			current = head.getNext();
			for(int i = 0; i < index; i++){
				if(current.getNext() == null){
					return null;
				}
				current = current.getNext();
			}

			return current.getData();
		}
		return current;
	}

	// remove object at specified index
	public boolean remove(int index){
		if(index < 1 && index > size())
			return false;

		Node current = head;
		if(head != null){
			for(int i = 0; i < index; i++){
				if(current.getNext() == null)
					return false;
				current = current.getNext();
			}

			current.setNext(current.getNext().getNext());
			decrementCounter();
			return true;
		}

		return false;
	}

	// remove object which matches the key
	public boolean removeKey(Object key){
		Node current = head;
		Node prev = head;
		while(current!=null){
			if(current.getData()==key)
				break;
			if(current.getNext()==null){
				System.out.println("element not found in list");
				return false;
			}
			prev = current;
			current=current.getNext();
		}
		if(current.getNext()==null){
			//deleting last node
			prev.setNext(null);
			decrementCounter();
			return true;
		}
		else if(prev == current){
			// if head is the matching node
			head = head.getNext(); 
			decrementCounter(); 
			return true;
		}
		else{
			//delete some other node which is not last node
			prev.setNext(current.getNext());
			decrementCounter();
			return true;
		}
	}

	//public void swapNodes(Object a, Object b) - waf to swap nodes in a linked list
	//http://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/

	// return middle node of linked list
	public Object middleElem(){
		Node slow = head;
		Node fast = head;
		if(head!=null){
			while(fast!=null && fast.getNext()!=null){
				fast = fast.getNext().getNext();
				slow = slow.getNext();
			}
		}
		return slow.getData();
	}

	// reverse linked list
	private Node reverse(Node nd){
		Node curr = nd;
		Node prev = null;
		Node next = null;
		while(curr!=null){
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		nd = prev;
		return nd;
	}

	// Rearrange Linked list such that L0 -> Ln -> L1 -> Ln-1 ... 
	public void rearrange(){
		Node slow=head;
		Node fast=head;
		if(head!=null){
			while(fast!=null && fast.getNext()!=null){
				fast = fast.getNext().getNext();
				slow = slow.getNext();
			}
			Node node1 = head;
			Node node2 = slow.getNext();
			slow.setNext(null);
			node2 = reverse(node2);
			Node newHead = new Node(0);
			Node curr = newHead;
			while(node1!=null || node2!=null){
				if(node1!=null){
					curr.setNext(node1);
					curr = curr.getNext();
					node1 = node1.getNext();
				}
				if(node2!=null){
					curr.setNext(node2);
					curr = curr.getNext();
					node2 = node2.getNext();
				}
			}
			head = newHead.getNext();
		}
	}
	private static int getCounter(){
		return counter;
	}

	private static void incrementCounter(){
		counter++;
	}

	private void decrementCounter(){
		counter--;
	}

	public int size(){
		return getCounter();
	}

	public String toString(){
		String output = "";
		if(head != null){
			Node current = head;
			while(current != null){
				output += "["+current.getData().toString()+"]";
				current = current.getNext();
			}
		}
		return output;
	}
	

private class Node {
	Node next;
	Object data;

	//Node's contructor
	public Node(Object dataValue){
		next = null;
		data = dataValue;
	}

	//if we want to point to a specific node
	public Node(Object dataValue, Node nextValue){
		data = dataValue;
		next = nextValue;
	}

	public Object getData(){
		return data;
	}

	public void setData(Object dataValue){
		data = dataValue;
	}

	public Node getNext(){
		return next;
	}

	public void setNext(Node nextValue){
		next = nextValue;
	}

   }

}
