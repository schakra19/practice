import java.util.*;

public class NGE{

	public static void nge(int[] arr){
		Stack<Integer> st = new Stack<Integer>();
		st.push(arr[0]);

		for(int i=1;i<arr.length;i++){
			while(!st.empty() && st.peek()<arr[i]){
				System.out.println("NGE of " + st.peek() + " is " + arr[i]);
				st.pop();
			}
			st.push(arr[i]);
		}
		while(!st.empty()){
			System.out.println("NGE of " + st.peek()+" is -1");
			st.pop();
		}
	}

	public static void main(String[] args){
		int arr[] = {11,12,5,8,13,14};
		nge(arr);
	}
}
