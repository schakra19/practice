import java.util.*;

public class StackDemo {
	public static void main(String[] args){
		Stack<Object> st = new Stack<Object>();
		st.push(new Integer(42));
		st.push(new Integer(33));
		st.push(new Integer(12));
		System.out.println(st);
		Object a = st.pop();
		st.push(new Integer(19));
		System.out.println(st.isEmpty());
		System.out.println(st);
	}

}
