package testjava;

import java.util.Scanner;
public class D06 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		double pyung_area;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int i;
		for (i=0;i<10;i++)
		{
			System.out.println("����Ʈ �о� ����(��������)�� �Է��ϼ���.");
			double m2_area = s.nextDouble();
			pyung_area = m2_area / 3.305;
			if (pyung_area<15)
			{
				count1++;
			} else if (15<=pyung_area & pyung_area<=30)
			{
				count2++;
			} else if (30<=pyung_area & pyung_area<=50)
			{
				count3++;
			} else {
				count4++;
			}
			System.out.println("--> ������ " + pyung_area +" �Դϴ�.");

		}
		
		System.out.println("���� ����Ʈ ������ " + count1 +" �Դϴ�.");
		System.out.println("�߼��� ����Ʈ ������ " + count2 +" �Դϴ�.");
		System.out.println("���� ����Ʈ ������ " + count3 +" �Դϴ�.");
		System.out.println("���� ����Ʈ ������ " + count4 +" �Դϴ�.");
		
		
	}

}
