public class TwoOdd{

	public static void twoOdd(int[] arr){
		int x = 0;
		int y = 0;
		int xor2 = arr[0];
		//Do xor of all all elements in arr
		for(int i =1; i<arr.length;i++)
			xor2 ^= arr[i];
		//Find the rightmost set bit in xor2
		int set_bit = xor2 & ~(xor2 - 1);

		for(int i=0;i<arr.length;i++){
			//Separate out numbers who have the set_bit set in arr
			if((arr[i] & set_bit)!=0)
				x ^= arr[i];

			else
				y ^= arr[i];
		}
		System.out.println("Odd occurrences are " + x + " and " + y);
	}

	public static void main(String[] args){
		int arr[] = {2,2,1,4,5,4};
		twoOdd(arr);
	}
}
	
		
