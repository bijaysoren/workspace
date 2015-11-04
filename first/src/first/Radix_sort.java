package first;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Radix_sort {
	
	
	
	public static void main (String[] args){
		int[] kop= {112,58,6,46,466,64652,4655};
		sort(kop);
		System.out.println(Arrays.toString(kop));
		int maxVal=5;
	      int [] data= {5,3,0,4,4,1,0,5,2,3,1,4}; 
	 
	      System.out.println("Before: " + Arrays.toString(data));
	      sort(data,maxVal);
	      System.out.println("After:  " + Arrays.toString(data));
	
	
	}


	public static void sort(int[] input){
		int radix =10;
		List<Integer>[] bucket = new ArrayList[radix];
		ArrayList[] nop= new ArrayList[10];
		String[] nopp= new String[0];
		for (int i = 0; i< radix ; i++){
			bucket[i]= new ArrayList<Integer>();
		}
		
		

		boolean maxLength = false;
		int tmp = -1, placement = 1;
		while (!maxLength) {
			maxLength = true;
			// split input between lists
			for (Integer i : input) {
				tmp = i / placement;
				bucket[tmp % radix].add(i);
				if (maxLength && tmp > 0) {
					maxLength = false;
				}
			}
			// empty lists into input array
			int a = 0;
			
			
			
			for (int b = 0; b < radix; b++) {
				for (Integer i : bucket[b]) {
					input[a++] = i;
				}
				bucket[b].clear();
			}
			// move to next digit
			placement *= radix;
		}

	}
	
	public static void sort(int[] a, int maxVal) {
	      int [] bucket=new int[maxVal+1];
	 
	      for (int i=0; i<bucket.length; i++) {
	         bucket[i]=0;
	      }
	 
	      for (int i=0; i<a.length; i++) {
	         bucket[a[i]]++;
	      }
	      System.out.println(Arrays.toString(bucket));
	      
	      int outPos=0;
	      for (int i=0; i<bucket.length; i++) {
	         for (int j=0; j<bucket[i]; j++) {
	            a[outPos++]=i;
	         }
	      }
	   }

}
