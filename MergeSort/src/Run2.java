import java.util.Arrays;

public class Run2 {
	
	static void print(int data[]){ //Array를 출력해줌
		for(int i=0; i<data.length; i++)
			System.out.print(data[i]+" ");
		System.out.println();
	}
	
	public static void mergeSort(int[] data){
		int n = data.length;
		
		if(n < 2) return; //다 나눴으면 return
		
		int mid = n/2;
		int[] L = Arrays.copyOfRange(data, 0, mid); 
		int[] R = Arrays.copyOfRange(data, mid, n);
		//mid를 지정하고 각각 복사해서 생성해준다
		
		mergeSort(L);
		mergeSort(R); //각각을 다시 나누고,
		merge(L,R,data); //나눈 것을 각각 정렬한다
	}
	
	public static void merge(int[] L, int[] R, int[] data){
		int i=0, j=0;
		while(i+j < data.length){ //i+j가 data의 원소개수가 될때까지 반복
			if(j==R.length || (i<L.length && Integer.compare(L[i], R[j])<0))
				data[i+j] = L[i++];
			else
				data[i+j] = R[j++];
		}
	}
	
	public static void main(String[] args)  {

		int data[] = {45, 39, 98, 15, 52, 44, 33, 28, 40, 38, 77, 68, 11, 43};
		print(data);
		mergeSort(data);
		print(data);

	}
	
}
