public class CharLinkedList{

	public static MyLinkedList myL;
	
	public static void main(String[] args){
		myL = new MyLinkedList();
		myL.add("1");
		myL.add("2");
		myL.add("3");
		myL.add("4");
		myL.add("5");

		System.out.println("Print : "+ myL.toString());
		System.out.println("Size  : "+ myL.size());
		System.out.println("Get : " + myL.remove(2));;
		System.out.println("Print : "+ myL.toString());
		System.out.println("Size  : "+ myL.size());
	//	myL.reverse();
	//	System.out.println("Print : "+myL.toString());
	}
}
class MyLinkedList {

	private static int counter;
	private Node head;
	//default contructor
	public MyLinkedList(){
	}

	public void add(Object data){
		if(head == null){
			head = new Node(data);
			head.setNext(head);
		}
		else{
		Node temp = new Node(data);
		temp.setNext(head);
		Node current = head;

		if(current != null){
			while(current.getNext() != head){
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
			for(int i = 1; i < index && current.getNext() != head;i++){
				current = current.getNext();
			}
		}

		temp.setNext(current.getNext());
		current.setNext(temp);
		
		incrementCounter();
	}

	public Object get(int index){
		if(index < 0){
			return null;
		}
                
		Node current = null;
		if(head != null){
			current = head;
			if(index==0){
				return current.getData();
			}
			//current = head.getNext();
			for(int i = 0; i < index; i++){
				if(current.getNext() == head){
					return null;
				}
				current = current.getNext();
			}

			return current.getData();
		}
		return current;
	}

	public boolean remove(int index){
		if(index < 1 && index > size())
			return false;

		Node current = head;
		if(head != null){
			for(int i = 0; i < index; i++){
				if(current.getNext() == head)
					return false;
				current = current.getNext();
			}

			current.setNext(current.getNext().getNext());
			decrementCounter();
			return true;
		}

		return false;
	}

	public void reverse(){
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current !=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public boolean compare(MyLinkedList n){
		Node a = head;
		Node b = n.head;
		while(a !=null && b!=null){
			if(a.data == b.data){
				a = a.getNext();
				b = b.getNext();
			}
			else return false;
		if(a == null && b==null)
			return true;	
		}
		return false;
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
			output="["+current.getData().toString()+"]";
			current = current.getNext();
			while(current != head){
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
