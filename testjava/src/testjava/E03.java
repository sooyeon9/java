package testjava;

import java.util.Scanner;
public class E03 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("�̵ �ﰢ���� ���̸� �Է��Ͻÿ�.");
		int height = s.nextInt();
		int i,j;
		for (i=1;i<=height;i++)
		{
			for (j=1;j<=height-i;j++)
			{
				System.out.print(" ");
			}
			for (j=1;j<=2*i-1;j++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}

}
