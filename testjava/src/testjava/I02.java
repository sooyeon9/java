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
		System.out.print("직각 삼각형을 그리는데 사용할 문자를 입력하시오.");
		String ch = s.next();
		System.out.print("직각 삼각형 높이와 안쪽 여백의 크기를 입력하시오.");
		int size = s.nextInt();
		int blanks = s.nextInt();
		
		I02 obj = new I02();
		obj.PrintCharWithBlank(blanks,size,ch);
	}
	
}
