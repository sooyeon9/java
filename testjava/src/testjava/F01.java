package testjava;

import java.util.Scanner;
public class F01 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int num[] = new int[10];
		int i;
		
		for(i=0;i<10;i++){
			System.out.print((i+1)+"번째 수를 입력하시오. ");
			num[i] = s.nextInt();
		}
		int first = num[0];
		int second = num[0];
		int second_i = 0;
		
		for(i=1;i<10;i++){
			if(first<=num[i]){
				first = num[i];}
			if(first>num[i]&num[i]>=second){
				second = num[i];
				second_i = i+1;}
		}
		
		System.out.println("두번째로 큰 수는 "+second_i+"번째 수 "+second+"입니다.");
		
		
	}
}
