import java.util.*;
public class Example{

	//Program to find union and intersection of two unsorted arrays 
	public static void main(String[] args){
		int arr[] = {19,23,11,5,3,81,61,8};
		int b[] = {23,8,19,15,7};

		ArrayList<Integer> al = new ArrayList<Integer>();

		Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
		//insert elements into a hash table now
		for(int i=0;i<arr.length;i++)
			ht.put(arr[i],1);

		for(int i=0;i<b.length;i++){
			if(ht.containsKey(b[i]))
				al.add(b[i]);
			else
				continue;
		}

		/*Enumeration keys;
		keys = ht.keys();
		while(keys.hasMoreElements())
			System.out.print(" "+keys.nextElement());*/
		System.out.println(al);
	}
}
