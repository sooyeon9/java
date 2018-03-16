package testjava;

import java.util.Scanner;
public class E06 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		System.out.print("출력하려는 행의 크기와 열의 크기를 입력하시오.");
		int hang = s.nextInt();
		int yaul = s.nextInt();
		int i,j;
		for (i=1;i<=hang;i++)
		{
			for (j=1;j<=yaul;j++)
			{
				System.out.print(i*j);
			}
			System.out.println("");
		}
		
	}

}
