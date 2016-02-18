public class SelectionSort {

	public static void selectionSort(int arr[]){
		
		int n = arr.length;
		int i,j,index = 0;
		for(i=0; i< n-1;i++){
			index = i;
			for(j=i+1;j<n;j++){
				if(arr[j] < arr[index])
					index = j;
			}
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args){

		int arr[] = {3,1,18,12,9,91,2};
		selectionSort(arr);
		for(int i =0; i< arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}
