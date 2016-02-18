public class Google1 {

	//Question - http://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/
	public static int method(int arr[]){
		int ans = 0;
		int n = arr.length;
		int i,j=0;
		for(i=0; i<32; i++){
			int count = 0;
			for(j=0;j<n;j++){
				if((arr[j] & (1 << i))>0)
					count++;
			}
			ans += count * (n-count)*2;
		}
		return ans;
	}

	public static void main(String[] args){
		int a[] = {1,3,5};
		System.out.println("Bit difference sum is "+method(a));
	}
}

