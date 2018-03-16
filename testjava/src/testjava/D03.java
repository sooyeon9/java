package testjava;

import java.util.Scanner;
public class D03 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int count=0;
		int totalsum=0;
		double average;

		while (true)
		{
			System.out.println("0부터 100사이의 숫자를 입력하세요.");
			int number = s.nextInt();
			if (number<0 || number>100)
			{
				break;
			}
			totalsum += number;
			count++;
		}
		
		average = (double)(totalsum / count);
		System.out.println("입력한 " + count +"개의 숫자들의 총 합계는 " + totalsum + "이고, 평균 값은 " + average + "입니다.");
		
		
	}

}
