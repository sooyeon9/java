package testjava;

import java.util.Scanner;
public class F01 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int num[] = new int[10];
		int i;
		
		for(i=0;i<10;i++){
			System.out.print((i+1)+"��° ���� �Է��Ͻÿ�. ");
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
		
		System.out.println("�ι�°�� ū ���� "+second_i+"��° �� "+second+"�Դϴ�.");
		
		
	}
}
