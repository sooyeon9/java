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
			System.out.println("0���� 100������ ���ڸ� �Է��ϼ���.");
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
		
		System.out.println("�Էµ� ���ڵ� �� ���� ū ����" + max_num +"�̰�, ���� ���� ���� " + min_num + "�Դϴ�.");
		

		
	}
}
