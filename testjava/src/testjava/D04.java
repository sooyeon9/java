package testjava;

import java.util.Scanner;
public class D04 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("������ �� ������ �Է��ϼ���.");
		int count_all = s.nextInt();
		int count_young = 0;
		int i;
		for (i=0;i<count_all;i++)
		{
			System.out.println("�¾ �⵵�� �Է��ϼ���.");
			int birth_year = s.nextInt();
			if (birth_year<=1997)
			{
				count_young =+ 1;
			}
		}
		
		System.out.println("������ �߿� �̼����ڴ� ��� " + count_young + "�� �Դϴ�.");
		
		
	}
}
