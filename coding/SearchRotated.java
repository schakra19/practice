public class SearchRotated{

	public static int searchRotated(int[] arr,int key){
		int pivot = findPivot(arr,0,arr.length-1);
		
		if(pivot==-1) //array is not rotated
			return binarySearch(arr,0,arr.length-1,key);

		if(key==arr[pivot]) //pivot element is key
			return pivot;

		if(arr[0]<=key) //element is left side of pivot
			return binarySearch(arr,0,pivot-1,key);
		else // element is in right side of pivot
			return binarySearch(arr,pivot+1,arr.length-1,key);
	}

	public static int findPivot(int[] arr, int low, int high){
		if(high < low)
			return -1;
		if(high==low)
			return low;

		int mid = low + (high-low)/2;
		if(mid < high && arr[mid] > arr[mid+1])
			return mid;
		if(mid > low && arr[mid-1] > arr[mid])
			return mid-1;
		else if(arr[low] >= arr[mid])
			return findPivot(arr,low,mid-1);
		else
			return findPivot(arr,mid+1,high);
	}

	public static int binarySearch(int[] arr, int low, int high, int key){
		if(high < low)
			return -1;
		int mid = low + (high-low)/2;
		if(arr[mid]==key)
			return mid;
		if(arr[mid] > key)
			return binarySearch(arr,low,mid-1,key);
		else
			return binarySearch(arr,mid+1,high,key);
	}

	public static void main(String[] args){
		int[] arr = {3,4,5,6,1,2};
		System.out.println("element found " +searchRotated(arr,4));
	}
}
