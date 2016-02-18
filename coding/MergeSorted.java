import java.util.*;
public class MergeSorted{
	public static void merge(int[] a, int[] b){
		int m = a.length;
		int n = b.length;
		for(int i=n-1; i>=0; i--){
			int j =0;
			while(a[j] < b[i] && j< m)
				j++;
			if(j<m){
				int temp = j;
				int last = a[m-1];
				for(int k=m-1;k>j;k--){
					a[k] = a[k-1];
				}
				a[temp]=b[i];
				b[i]=last;
			}
		}
	}

	public static void main(String[] args){
		int[] a = {1,5,9,10,15,20};
		int[] b = {2,3,8,13};
		merge(a,b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}
