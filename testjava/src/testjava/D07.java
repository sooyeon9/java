package testjava;

import java.util.Scanner;
public class D07
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("1차 함수 y=ax+b의 계수 a,b를 입력하시오.");
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println("x좌표의 시작 값과 끝 값을 입력하시오.");
		int x_begin = s.nextInt();
		int x_end = s.nextInt();
		int x,y,i;
		for (i=x_begin;i<=x_end;i++)
		{
			y = a*i+b;
			System.out.println("좌표 (" + i + "," + y + ")");
		
		}
		
	}
		
}