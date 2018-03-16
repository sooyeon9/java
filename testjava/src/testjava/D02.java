package testjava;

import java.util.Scanner;
public class D02 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int max_num=0;
		int min_num=100;

		while (true)
		{
			System.out.println("0부터 100사이의 숫자를 입력하세요.");
			int number = s.nextInt();
			if (number<0 || number>100)
			{
				break;
			}
			if (number>max_num)
			{
				max_num = number;
			}
			if (number<min_num)
			{
				min_num = number;
			}

		}
		
		System.out.println("입력된 숫자들 중 가장 큰 수는" + max_num +"이고, 가장 작은 수는 " + min_num + "입니다.");
		

		
	}
}
