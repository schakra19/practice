public class Seg012 {
	static void seg012(int[] arr){
		int lo = 0;
		int mid = 0;
		int hi = arr.length -1, temp;

		while(mid <= hi){
			switch(arr[mid]){
				case 0:
					temp = arr[mid];
					arr[mid] = arr[lo];
					arr[lo] = temp;
					lo++; 
					mid++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					temp = arr[hi];
					arr[hi] = arr[mid];
					arr[mid] = temp;
					hi--;
					break;
			}
		}
	}


	public static void main(String[] args){
		int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

		seg012(arr);
		for(int i =0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}
}
