package testjava;

import java.util.Scanner;
public class D07
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("1�� �Լ� y=ax+b�� ��� a,b�� �Է��Ͻÿ�.");
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println("x��ǥ�� ���� ���� �� ���� �Է��Ͻÿ�.");
		int x_begin = s.nextInt();
		int x_end = s.nextInt();
		int x,y,i;
		for (i=x_begin;i<=x_end;i++)
		{
			y = a*i+b;
			System.out.println("��ǥ (" + i + "," + y + ")");
		
		}
		
	}
		
}