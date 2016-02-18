import java.util.*;

public class MergeBufArr{

	private static void pushBack(int[] A){
		int j=A.length-1;
		for(int i=A.length-1;i>=0;i--){
			if(A[i]!=Integer.MIN_VALUE){
				A[j]=A[i];
				j--;
			}
		}
	}

	public static void mergeArr(int[] A, int[] B){
		pushBack(A);
		int i=B.length;
		int j=0;
		int k=0;
		while(k<A.length){
			if(i<A.length && A[i] <= B[j] || (j==B.length))
			{
				A[k] = A[i];
				i++; k++;
			}
			else{
				A[k] = B[j];
				j++; k++;
			}
		}
	}	
	public static void main(String[] args){
		int NA = Integer.MIN_VALUE;
		int[] A = {2,NA,7,NA,NA,10,NA};
		int[] B = {5,8,12,14};
		mergeArr(A,B);
		System.out.println(java.util.Arrays.toString(A));
	}
}
