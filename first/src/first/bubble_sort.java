package first;

import java.util.Arrays;

public class bubble_sort {
	
	public static void bubblesort(int[] a){
		int N=a.length;
		
		for (int i = 0; i < N;i++){
			for (int j= 0;j<N-1;j++){
				if(a[j]>a[j+1]){
					a[j]=a[j+1]+a[j];
					a[j+1]=a[j]-a[j+1];
					a[j]=a[j]-a[j+1];
				}
			}
			
		}
		
	}
	
	public static void main(String[] args){
		int[] a = {5,3,0,4,44,3,98,33,12,3};
		bubblesort(a);
		System.out.println(Arrays.toString(a));
		
	}

}
