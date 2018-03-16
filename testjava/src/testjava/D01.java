package testjava;

import java.util.Scanner;
public class D01 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);

		System.out.println("숫자를 입력하세요.");
		int number = s.nextInt();
		int i=0;
		int totalsum=0;
		for (i=0;i<=number;i++)
		{
			totalsum += i;
		}
		System.out.println("1부터 입력한 숫자까지의 모든 정수를 더한 값은" + totalsum +"입니다.");
		
		
	}
}
