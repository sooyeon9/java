import java.util.Arrays;

public class exercise {
	
	public static void mergeSort(int[] data){
		int n = data.length;
		if(n<2) return;
		
		int mid = n/2;
		int[] l = Arrays.copyOfRange(data, 0, mid);
		int[] r = Arrays.copyOfRange(data, mid, n);
		
		mergeSort(l);
		mergeSort(r);
		merge(l,r,data);
	}
	
	public static void merge(int[] l, int[] r, int[] data){
		int i=0,j=0;
		
		while(i+j<data.length){
			if(j==r.length || (i<l.length && Integer.compare(l[i], r[j])<0))
				data[i+j] = l[i++];
			else
				data[i+j] = r[j++];
		}
	}
	
	public static void print(int[] data){
		for(int i=0; i<data.length; i++)
			System.out.print(data[i]+" ");
		System.out.println();
	}
	
	public static void main(String arg[]){
		int[] data = {44, 34,2,6,78,26,1,84,23,823,3,9,4};
		print(data);
		mergeSort(data);
		print(data);
		}
}
