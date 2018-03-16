package testjava;

import java.util.Scanner;
public class F02 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		int score[] = new int[10];
		int max=0;
		int min=10;
		int total=0;
		int i;
		
		for(i=0;i<10;i++){
			System.out.print((i+1)+"번 째 심사점수를 입력하시오. : ");
			score[i] = s.nextInt();
		}
		
		for(i=0;i<10;i++){
			if(score[i]>=max){max=score[i];}
			if(score[i]<=min){min=score[i];}
			total += score[i];
		}
		
		int aver = (total-min-max)/8;
		System.out.println("가장 큰 점수와 가장 작은 점수를 제외한 8개의 점수에 대한 평균은 "+aver+"입니다.");
		
		
	}
}