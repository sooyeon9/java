package testjava;

import java.util.Scanner;
public class D05 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;

		while (true)
		{
			System.out.println("���� ũ��� ���� ũ�⸦ �Է��ϼ���.");
			int width = s.nextInt();
			int height = s.nextInt();
			if (width<0 || height<0)
			{
				break;
			}
			if (width == height)
			{
				count1++;
			} else if (width> height*2)
			{
				count2++;
			} else if (width*2 < height)
			{
				count3++;
			} else if (width>height)
			{		
				count4++;
			} else if (width<height)
			{
				count5++;
			}
		}
		System.out.println("���簢���� ������ " + count1 +" �Դϴ�.");
		System.out.println("�¿�� ������ ���簢���� ������ " + count2 +" �Դϴ�.");
		System.out.println("���Ʒ��� ������ ���簢���� ������ " + count3 +" �Դϴ�.");
		System.out.println("�Ϲ����� ������ ���簢���� ������ " + count4 +" �Դϴ�.");
		System.out.println("�Ϲ����� ������ ���簢���� ������ " + count5 +" �Դϴ�.");
		
	}
}
