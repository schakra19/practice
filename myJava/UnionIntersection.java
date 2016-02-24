/* Given two arrays, find the union and intersection 
of elements of both arrays */
public class UnionIntersection{

	static void unionSorted(int a[], int b[]){

		int i=0;
		int j=0;
		while(i<a.length && j<b.length){
			if(a[i] < b[j]){
				System.out.print(a[i]+" ");
				i++;
			}
			else if(a[i] > b[j]){
				System.out.print(b[j]+" ");
				j++;
			}
			else{
				System.out.print(a[i]+" ");
				i++; j++;
			}
		}

		while(i<a.length){
			System.out.print(a[i]+" ");
			i++;
		}
		while(j<b.length){
			System.out.print(b[j]+" ");
			j++;
		}
	}

	static void intersectionSorted(int a[], int b[]){
		int i=0;
		int j=0;
		while(i<a.length && j<b.length){
			if(a[i] < b[j])
				i++;
			else if(a[i] > b[j])
				j++;
			else{
				System.out.print(a[i]+" ");
				i++; j++;
			}
		}
	}

	public static void main(String[] args){
		int a[] = {1, 2, 4, 5, 6};
		int b[] = {2, 3, 5, 7};

		unionSorted(a,b);
		System.out.println("");
		intersectionSorted(a,b);		

	
	}
}
