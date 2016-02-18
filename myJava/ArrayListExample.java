import java.util.*;

class ArrayListExample {

	public static void main(String[] args) {
	
		ArrayList<String> ls = new ArrayList<String>();
		ls.add("sukanya");
		ls.add("kritika");
		ls.add("mridu");
		ls.add(0,"first");

		//Other ArrayList methods
		//remove(Object), remove(index), add(index, Object), set(index, Object)
		//indexOf(Object), get(index), size(), contains(Object), clear()
		//http://beginnersbook.com/2013/12/how-to-initialize-an-arraylist/ - See this to learn different ways to initialize an arrayList

		System.out.println(ls);
		
	}
}
