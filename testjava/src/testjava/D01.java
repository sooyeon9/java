package testjava;

import java.util.Scanner;
public class D01 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);

		System.out.println("���ڸ� �Է��ϼ���.");
		int number = s.nextInt();
		int i=0;
		int totalsum=0;
		for (i=0;i<=number;i++)
		{
			totalsum += i;
		}
		System.out.println("1���� �Է��� ���ڱ����� ��� ������ ���� ����" + totalsum +"�Դϴ�.");
		
		
	}
}
