import java.util.Arrays;

public class Run2 {
	
	static void print(int data[]){ //Array�� �������
		for(int i=0; i<data.length; i++)
			System.out.print(data[i]+" ");
		System.out.println();
	}
	
	public static void mergeSort(int[] data){
		int n = data.length;
		
		if(n < 2) return; //�� �������� return
		
		int mid = n/2;
		int[] L = Arrays.copyOfRange(data, 0, mid); 
		int[] R = Arrays.copyOfRange(data, mid, n);
		//mid�� �����ϰ� ���� �����ؼ� �������ش�
		
		mergeSort(L);
		mergeSort(R); //������ �ٽ� ������,
		merge(L,R,data); //���� ���� ���� �����Ѵ�
	}
	
	public static void merge(int[] L, int[] R, int[] data){
		int i=0, j=0;
		while(i+j < data.length){ //i+j�� data�� ���Ұ����� �ɶ����� �ݺ�
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
