public class MergeSort{

	private int[] numbers;
	private int[] helper;
	private int number;

	public void sort(int[] values){
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		mergesort(0,number-1);
	}

	private void mergesort(int low, int high){
		if(low < high){
			int mid = low + (high - low) / 2;
			mergesort(low,mid);
			mergesort(mid+1,high);
			merge(low,mid,high);
		}
	}

	private void merge(int low, int middle, int high){
		for(int i=low; i<=high; i++)
			helper[i] = numbers[i];

		int i = low;
		int j = middle + 1;
		int k = low;

		while(i<=middle && j<=high){
			if(helper[i] <= helper[j]){
				numbers[k] = helper[i];
				i++;
			}
			else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		while(i<=middle){
			numbers[k] = helper[i];
			i++;
			k++;
		}
		while(j<=high){
			numbers[k] = helper[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args){
		int arr[] = {12, 11, 13, 5, 6, 7};
		MergeSort ms = new MergeSort();
		ms.sort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		}
}
