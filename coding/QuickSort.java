public class QuickSort{
	public static int partition(int[] arr, int l, int r){
		int i = l;
		int j = r;
		int pivot = arr[(l +r)/2];

		while(i<=j){
			while(arr[i] < pivot)
				i++;
			while(arr[j] > pivot)
				j--;
			if(i<=j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++; j--;
			}
		}
		return i;
	}

	public static void quicksort(int[] arr, int left, int right){		
		int p = partition(arr,left,right);
		if(left < p-1)
			quicksort(arr,left,p-1);
		if(p < right)
			quicksort(arr,p,right);
	}

	public static void main(String[] args){
		int[] arr = {12,7,9,41,64,3,23};
		quicksort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}
