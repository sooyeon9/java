package testjava;

import java.util.Scanner;
public class E02 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("직각 삼각형 높이와 안쪽 여백의 크기를 입력하시오.");
		int height = s.nextInt();
		int blank = s.nextInt();
		int i,j,k;
		for (i=1;i<=height;i++)
		{
			for (j=1;j<=blank+height-i;j++)
			{
				System.out.print(" ");
			}
			for (j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}

}
