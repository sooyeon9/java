package testjava;

import java.util.Scanner;
public class D08 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("2�� �Լ� y=ax^2+bx+c�� ��� a,b,c�� �Է��Ͻÿ�.");
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		System.out.println("x��ǥ�� ���� ���� �� ���� �Է��Ͻÿ�.");
		int x_begin = s.nextInt();
		int x_end = s.nextInt();
		int x,y,i;
		for (i=x_begin;i<=x_end;i++)
		{
			y = a*i*i+b*i+c;
			System.out.println("��ǥ (" + i + "," + y + ")");
		
		}
		
	}

}
