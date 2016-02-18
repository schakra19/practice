public class OddOccurringElem{
	public static int oddElem(int[] arr){
		int xor = arr[0];
		for(int i=1;i<arr.length;i++)
			xor ^= arr[i];
		return xor;
	}
	public static void main(String[] args){
		int[] arr = {1,1,5,1,2,4,4,1,5,2,2};
		System.out.println(oddElem(arr));
	}
}
