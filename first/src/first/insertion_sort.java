package first;

import java.util.Arrays;

public class insertion_sort {
	
	
	public static  void  insertionsort(int[] a){
		int N= a.length;
		int i, j, temp;
		
		for(i = 0 ; i < N; i++){
			j=i;
			temp=a[i];
			while(j>0 &&  temp  < a[j-1]){
				a[j]=a[j-1];
				j=j-1;
				
			}
			a[j]=temp;
		}
	}
	
	public static void main(String[] args){
		int[] a = {5,3,0,4,44,3,98,33,12,3};
		insertionsort(a);
		System.out.println(Arrays.toString(a));
		
	}

}
