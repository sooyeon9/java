package testjava;

import java.util.Arrays;
import java.util.Scanner;
public class A04 {
	public static void main(String[] args) 
	{
		/*Scanner s = new Scanner(System.in);

		System.out.println("����Ʈ �о� ������ �Է��Ͻÿ�.");
		double m2_area = s.nextDouble();

		double pyung_area = m2_area/3.305;
		System.out.println("����Ʈ ������ " + pyung_area + "�Դϴ�.");*/
		
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

		System.out.println("����Ʈ �о� ������ �Է��Ͻÿ�.");
		int a = s.nextInt();
		
		switch(a){
		case 0 : 
			System.out.println("0�̴�");
			break;
		case 1 : 
			System.out.println("1�̴�");
			break;
		case 2 : 
			System.out.println("2�̴�");
			break;
		case 3 : 
			System.out.println("3�̴�");
			break;
		
		}


	}
}
