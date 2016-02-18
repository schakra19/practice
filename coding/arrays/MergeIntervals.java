import java.util.*;

class Interval{
	int x;
	int y;

	public Interval(int a,int b){
		x = a;
		y = b;
	}
}

class IntervalComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval i, Interval j){
		return (i.x - j.x); 
	}
}
public class MergeIntervals{

	public static void mergeInterval(Interval[] iv){
		Stack<Interval> st = new Stack<Interval>();
		st.push(iv[0]);
		for(int k=1; k< iv.length; k++){
			Interval top = st.peek();
			if(top.y < iv[k].x)
				st.push(iv[k]);
			else if(top.y < iv[k].y){
				top.y = iv[k].y;
				st.pop();
				st.push(top);
			}
		}

		while(!st.empty()){
			Interval t = st.peek();
			System.out.print("("+t.x+","+t.y+") ");
			st.pop();
		}
	}
	public static void printIntervalArray(Interval[] iv){
		for(int j=0; j<iv.length;j++){
			System.out.print("("+iv[j].x+","+iv[j].y+") ");
		}
	}
	public static void main(String[] args){
		Interval[] ivs = new Interval[4];
		ivs[0] = new Interval(1,3);
		ivs[1] = new Interval(2,4);
		ivs[2] = new Interval(6,8);
		ivs[3] = new Interval(5,7);

		printIntervalArray(ivs);
		Arrays.sort(ivs, new IntervalComparator());
		System.out.println();
		mergeInterval(ivs);
//		printIntervalArray(ivs);
	}
}


