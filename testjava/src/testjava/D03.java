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
			System.out.println("0���� 100������ ���ڸ� �Է��ϼ���.");
			int number = s.nextInt();
			if (number<0 || number>100)
			{
				break;
			}
			totalsum += number;
			count++;
		}
		
		average = (double)(totalsum / count);
		System.out.println("�Է��� " + count +"���� ���ڵ��� �� �հ�� " + totalsum + "�̰�, ��� ���� " + average + "�Դϴ�.");
		
		
	}

}
