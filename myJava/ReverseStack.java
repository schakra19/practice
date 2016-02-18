import java.util.*;
public class ReverseStack{

	public static void insertAtBottom(Stack<Integer> st, int item){
		if(st.empty() || item>st.peek())
			st.push(item);
		else{
			int temp = st.pop();
			insertAtBottom(st,item);
			st.push(temp);
		}
	}
	public static void reverseStack(Stack<Integer> st){
		if(!st.empty()){
			int z = st.pop();
			reverseStack(st);
			insertAtBottom(st,z);
		}
	}
	public static void main(String[] args){
		Stack<Integer> st = new Stack<Integer>();
		st.push(4);
		st.push(1);
		st.push(3);
		st.push(2);
		System.out.println(st);
		System.out.println("After sorting stack");
		reverseStack(st);
		System.out.println(st);
	}
}
