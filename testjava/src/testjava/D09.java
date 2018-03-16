package testjava;

import java.util.Scanner;
public class D09 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int i = 0;

		while (true)
		{
			System.out.println("출력하고 싶은 구구단의 단 수를 입력하시오(2~9).");
			int dan = s.nextInt();
			if (dan<2 || dan>9)
			{
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			for (i=1;i<=9;i++)
			{
				System.out.println(dan + "X" + i + "=" + dan*i);
			}
			if (2<=dan & dan<=9)
			{
				break;
			}
			
		}
	}
}
