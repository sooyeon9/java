package DataStructurePractice;

import java.util.ArrayList;
import java.util.Scanner;

public class ex01 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		ArrayList<Integer> p = new ArrayList<Integer>();
	
		System.out.print("N = ");
		int N = s.nextInt();

		if(N>=2){p.add(2);} //N�� 2������ ��� primes�� 2�߰�
		
		for(int i=2; i<=N; i++){ //primes�� �Ҽ��� ã�Ƽ� ����
			for(int j=0; p.size()>j; j++){
				if(i%p.get(j)==0){break;}
				if(j+1==p.size()){p.add(i);}
			}
		}
	
		int[] primes = new int[p.size()];
		
		for(int i=0; i<p.size(); i++){
			primes[i] = p.get(i);
			System.out.println(primes[i]);
			}
		

		//System.out.println(p);

	
	}

	
}