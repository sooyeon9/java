package testjava;

import java.util.Scanner;
public class I02 {
	public void PrintCharWithBlank(int blanks, int size, String ch){
		int i,j;
		for (i=1;i<=size;i++)
		{
			for (j=1;j<=blanks+size-i;j++)
			{
				System.out.print(" ");
			}
			for (j=1;j<=i;j++)
			{
				System.out.print(ch);
			}
			System.out.println("");
		}
	}
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.print("���� �ﰢ���� �׸��µ� ����� ���ڸ� �Է��Ͻÿ�.");
		String ch = s.next();
		System.out.print("���� �ﰢ�� ���̿� ���� ������ ũ�⸦ �Է��Ͻÿ�.");
		int size = s.nextInt();
		int blanks = s.nextInt();
		
		I02 obj = new I02();
		obj.PrintCharWithBlank(blanks,size,ch);
	}
	
}
