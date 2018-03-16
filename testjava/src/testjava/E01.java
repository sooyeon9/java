package testjava;

import java.util.Scanner;
public class E01 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("정사각형 크기를 입력하시오.");
		int length = s.nextInt();
		int i,j;
		for (i=1;i<=length;i++)
		{
			for (j=1;j<=length;j++)
			{
				System.out.print("#");
			}
			System.out.println("");
		}
		
	}
}
