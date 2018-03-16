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
			System.out.println("가로 크기와 세로 크기를 입력하세요.");
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
		System.out.println("정사각형의 개수는 " + count1 +" 입니다.");
		System.out.println("좌우로 길쭉한 직사각형의 개수는 " + count2 +" 입니다.");
		System.out.println("위아래로 길쭉한 직사각형의 개수는 " + count3 +" 입니다.");
		System.out.println("일반적인 가로형 직사각형의 개수는 " + count4 +" 입니다.");
		System.out.println("일반적인 세로형 직사각형의 개수는 " + count5 +" 입니다.");
		
	}
}
