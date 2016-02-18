public class QuickSort{
	
	private static int partition(int[] arr, int l, int r){
		int i = l;
		int j = r;
		int pivot = arr[(l+r)/2];
		while(i<=j){
			while(arr[i]<pivot)
				i++;
			while(arr[j]>pivot)
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
	public static void quickSort(int[] arr, int left, int right){
		int index = partition(arr,left,right);
		if(left < index -1)
			quickSort(arr,left,index-1);
		if(index < right)
			quickSort(arr,index,right);
	}


	public static void main(String[] args){
		//int a[] = {78,3,51,8,10,1};
		int[] a = {12,7,9,41,64,3,23};
		quickSort(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}
