public class NewLinkedList {

	//add functions to create and  test your linked list
	
}

class NwLinkedList {
	private static int counter;
	private Node head;

	public NwLinkedList(){
	}
	
	public void add(Object data){
		if(head == null){
			head = new Node(data);
		}

		Node temp = new Node(data);
		Node current = head;
		if(current != null){
			while(current.getNext() != null)
				current = current.getNext();
			current.setNext(temp);
		}	
		incrementCounter();
	}

	public void add(Object data, int index){
		Node temp = new Node(data);
		Node current = head;

		if(current != null){
			for(int i=1; i<index && current.getNext()!=null;i++)
				current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);

		incrementCounter();
		
	}

	public Object get(int index){
		if(index <= 0)
			return null;

		Node current = null;
		if(head != null){
			current = head.next();
			for(int i=0; i< index; i++){
				if(current.getNext() == null)
					return null;
				current = current.getNext();
			}
			return current.getData();
		}
		return current;
	}

	public boolean remove(int index){
			if(index < 1 || index > size())
				return false;

			Node current = head;
			if(current != null){
				for(int i=0; i<index;i++){
					if(current.getNext()==null)
						return false;
					current = current.getNext();
				}
				current.setNext(current.getNext().getNext());
				decrementCounter();
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
		String output="";
		

		

private class Node{
	Node next;
	Object data;

	//Node's constructor
	public Node(Object dataValue){
		next = null;
		data = dataValue;
	}

	public Node(Object dataValue, Node nextValue){
		next = nextValue;
		data = dataValue;
	}

	public void setNext(Node nextValue){
		next = nextValue;
	}
	public Node getNext(){
		return next;
	}
	public void setData(Object dataValue){
		data = dataValue;
	}
	public Object getData(){
		return data;
	}
   } 
}

