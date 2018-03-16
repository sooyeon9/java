public class Run  {
	
	static void print(int data[]){ //Array�� �������
		for(int i=0; i<data.length; i++)
			System.out.print(data[i]+" ");
		System.out.println();
	}/*
	s ���۰�
	m �߰���
	e ����
	*/
	public static void mergeSort(int[] data, int s, int e){
		int m = 0;
		
		if(s < e){ //���Ұ� �ϳ� ���������� ������
			m = (int)((s+e)/2);
			mergeSort(data,s,m); //�պκ� �� ������,
			mergeSort(data,m+1,e); //�޺κ� �� ������,
			merge(data,s,m,e); //�������ִ� �Լ�
		}
	}
	
	public static void merge(int [] data, int s, int m, int e){
		int n1 = m-s+1; //L�κ� ���Ұ���
		int n2 = e-m; //R�κ� ���Ұ���
		
		//���� �κ��� ���� �������ش� (�Ѱ��� �����ϰ� ���� �����ϱ����� ū���� ���ҷ� �־���)
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		L[n1] = Integer.MAX_VALUE;
	    R[n2] = Integer.MAX_VALUE;
		
		for(int i=0; i<L.length-1; i++)
			L[i] = data[s+i]; //����������
		for(int j=0; j<R.length-1; j++)
			R[j] = data[m+1+j]; //�߰�������
		//data�� ���Ҹ� ���� �־���
	    
	    for(int k=s,i=0,j=0; k<=e; k++){ //���� �����ؼ� ������
	    	if(L[i] <= R[j]){
	    		data[k] = L[i];
	    		i++;
	    	} else {
	    		data[k] = R[j];
	    		j++;
	    	}
	    }
	    
	}
	
  
	public static void main(String[] args)  {

		int data[] = {45, 39, 98, 15, 52, 44, 33, 28, 40, 38, 77, 68, 11, 43};
		print(data);
		mergeSort(data, 0, data.length-1);
		print(data);

	}

}
