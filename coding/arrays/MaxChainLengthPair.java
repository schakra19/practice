class Pair{
	int a;
	int b;

	public Pair(int x,int y){
		a = x;
		b = y;
	}
}
public class MaxChainLengthPair{

	public static int maxChainLength(Pair[] pArr){
		int i,j,max = 0;
		int[] mcl = new int[pArr.length];
		for(i=0; i<pArr.length;i++)
			mcl[i]=1;

		for(i=1; i<pArr.length; i++){
			for(j=0; j<i;j++){
				if(pArr[i].a > pArr[j].b && mcl[i] < mcl[j]+1)
				mcl[i] = mcl[j] + 1;
			}
		}
		for(i=0;i<mcl.length;i++)
			if(mcl[i]>max)
				max = mcl[i];

		return max;
	}
	public static void main(String[] args){
		Pair[] p = new Pair[5];
		p[0] = new Pair(5,10);
		p[1] = new Pair(1,3);
		p[2] = new Pair(27,68);
		p[3] = new Pair(16,30);
		p[4] = new Pair(32,45);
		System.out.println("Max Length of chain of pairs is " + maxChainLength(p));
	}
}
