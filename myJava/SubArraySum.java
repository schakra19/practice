//import java.util.Scanner;
// Q. Given an array and an integer, find the subarray whose elements sum to that given integer

class SubArraySum{

	public int findSubArraySum(int[] arr, int sum){
		int curr_sum = arr[0];
		int start = 0, i;
		for(i=1; i <= arr.length; i++){
			while(curr_sum > sum && start < i-1){
				curr_sum = curr_sum - arr[start];
				start++;
			}

			if(curr_sum == sum){
				System.out.println("Indexes are :" + start + " and " + (i-1));
				return 1;
			}
			if(i < arr.length)
				curr_sum = curr_sum + arr[i];
		}

		return 0;
	}
	public static void main(String[] args){
		int myArr[] = {15, 2, 4, 8, 9, 5, 10, 23};
		//Scanner scan = new Scanner(System.in);
		//int sum = scan.nextInt();
		int sum = 22;
		SubArraySum sa = new SubArraySum();
		sa.findSubArraySum(myArr,sum);
	}
}
