public class Run  {
	
	static void print(int data[]){ //Array를 출력해줌
		for(int i=0; i<data.length; i++)
			System.out.print(data[i]+" ");
		System.out.println();
	}/*
	s 시작값
	m 중간값
	e 끝값
	*/
	public static void mergeSort(int[] data, int s, int e){
		int m = 0;
		
		if(s < e){ //원소가 하나 남을때까지 나눈다
			m = (int)((s+e)/2);
			mergeSort(data,s,m); //앞부분 또 나누고,
			mergeSort(data,m+1,e); //뒷부분 또 나누고,
			merge(data,s,m,e); //정렬해주는 함수
		}
	}
	
	public static void merge(int [] data, int s, int m, int e){
		int n1 = m-s+1; //L부분 원소개수
		int n2 = e-m; //R부분 원소개수
		
		//나눈 부분을 각각 생성해준다 (한개씩 많게하고 끝에 정렬하기위한 큰수를 원소로 넣어줌)
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		L[n1] = Integer.MAX_VALUE;
	    R[n2] = Integer.MAX_VALUE;
		
		for(int i=0; i<L.length-1; i++)
			L[i] = data[s+i]; //시작점부터
		for(int j=0; j<R.length-1; j++)
			R[j] = data[m+1+j]; //중간점부터
		//data의 원소를 각각 넣어줌
	    
	    for(int k=s,i=0,j=0; k<=e; k++){ //각각 정렬해서 합쳐줌
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
