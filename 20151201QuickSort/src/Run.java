public class Run {
	
	static void print(int data[]){ //Array를 출력해줌
		for(int i=0; i<data.length; i++)
			System.out.print(data[i]+" ");
		System.out.println();
	}
	
	static void quickSort(int data[],int a,int b){
		if(a >= b) return;
		int l=a, r=b-1, pivot = data[b], temp;
		while(l <= r){
			while(l<=r && data[l]<pivot) l++;
			while(l<=r && data[r]>pivot) r--;
			if(l <= r){
				temp = data[l];
				data[l] = data[r];
				data[r] = temp;
				l++;
				r--;
			}
		}
		temp = data[l];
		data[l] = data[b];
		data[b] = temp;
		quickSort(data,a,l-1);
		quickSort(data,l+1,b);
	}
	

	public static void main(String[] args){

		int data[] = {45, 39, 98, 15, 52, 44, 33, 28, 40, 38, 77, 68, 11, 43};
		print(data);
		quickSort(data,0,data.length-1);
		print(data);
		
		int data2[] = {101, 39, 98, 15, 52, 44,11, 28, 40, 5, 77, 68, 11, 43};
		print(data2);
		quickSort(data2,0,data2.length-1);
		print(data2);
		}


}
