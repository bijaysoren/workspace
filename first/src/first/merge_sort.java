package first;

import java.util.Arrays;

public class merge_sort {
	

	public static void  mergesort(int[] a,int l, int r){
		
		if (r > l){
		int mid = (l+r)/2;
		
		mergesort(a,l,mid);
		mergesort(a, mid+1, r);
		merge(a,l,mid,r);
		}
		
		
	}
	
	public static void merge(int[] b, int l, int mid, int r){
		
		int[] left = new int[mid-l+1];
		int[] right = new int[r-mid]; 
		
		for(int i=0; i< left.length ;i++){
			left[i]=b[l+i];
		}
		
		for(int i=0; i < right.length ;i++){
			right[i]=b[mid+1+i];
		}
		
		
		int i=0;
        int j =0 ;
        int k= l;
        
        while ( i < left.length && j < right.length){
        	if(left[i] <= right [j]){
        		b[k]=left[i];
        		i++;
        	}else{
        		b[k]=right[j];
        		j++;
        	}
        	k++;
        }
        
        while(i < left.length){
        	b[k]=left[i];
        	i++;
        	k++;
        }
        
        while( j < right.length){
        	b[k]=right[j];
        	j++;
        	k++;
        }
	}
	
	public static void main(String[] args){
		int[] a = {5,3,0,4,44,3,98,33,12,3};
		mergesort(a,0,9);
		System.out.println(Arrays.toString(a));
		
	}
}
