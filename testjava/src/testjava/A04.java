package testjava;

import java.util.Arrays;
import java.util.Scanner;
public class A04 {
	public static void main(String[] args) 
	{
		/*Scanner s = new Scanner(System.in);

		System.out.println("아파트 분양 면적을 입력하시오.");
		double m2_area = s.nextDouble();

		double pyung_area = m2_area/3.305;
		System.out.println("아파트 평형은 " + pyung_area + "입니다.");*/
		
		/*
		int[] node = {4,1,3,2};
		int[] lineup = {0,0,0,0,0};
		int[] newnode = new int[3];
		System.arraycopy(node, 0, lineup, 0, 4);
		Arrays.sort(lineup);
		for(int i=0;i<5;i++)
			System.out.println(lineup[i]);
		
		System.arraycopy(lineup, 0, node, 0, 2);
		System.out.println("");
		
		for(int i=0;i<2;i++)
			System.out.println(node[i]);
		
		System.arraycopy(lineup, 2, newnode, 0, 3);
		System.out.println("");
		
		for(int i=0;i<3;i++)
			System.out.println(newnode[i]);
			
		*/
		
		Scanner s = new Scanner(System.in);

		System.out.println("아파트 분양 면적을 입력하시오.");
		int a = s.nextInt();
		
		switch(a){
		case 0 : 
			System.out.println("0이다");
			break;
		case 1 : 
			System.out.println("1이다");
			break;
		case 2 : 
			System.out.println("2이다");
			break;
		case 3 : 
			System.out.println("3이다");
			break;
		
		}


	}
}
