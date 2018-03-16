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
			System.out.println("아파트 분양 면적(제곱미터)을 입력하세요.");
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
			System.out.println("--> 평현은 " + pyung_area +" 입니다.");

		}
		
		System.out.println("소형 아파트 개수는 " + count1 +" 입니다.");
		System.out.println("중소형 아파트 개수는 " + count2 +" 입니다.");
		System.out.println("중형 아파트 개수는 " + count3 +" 입니다.");
		System.out.println("대형 아파트 개수는 " + count4 +" 입니다.");
		
		
	}

}
