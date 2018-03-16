package testjava;

import java.util.Scanner;
public class A03 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("직사각형 가로 길이를 입력하시오.");
		int width = s.nextInt();
		
		System.out.println("직사각형 세로 길이를 입력하시오.");
		int height = s.nextInt();
		int area = width * height;
		System.out.println("직사각형의 넓이는 " + area + "입니다.");
	}

}
