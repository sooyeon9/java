package testjava;

import java.util.Scanner;
public class D04 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("가족이 몇 명인지 입력하세요.");
		int count_all = s.nextInt();
		int count_young = 0;
		int i;
		for (i=0;i<count_all;i++)
		{
			System.out.println("태어난 년도를 입력하세요.");
			int birth_year = s.nextInt();
			if (birth_year<=1997)
			{
				count_young =+ 1;
			}
		}
		
		System.out.println("가족들 중에 미성년자는 모두 " + count_young + "명 입니다.");
		
		
	}
}
