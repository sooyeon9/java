package testjava;

import java.util.Scanner;
public class A01 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("태어난 년도를 입력하시오.");
		int brith_year = s.nextInt();
		int age = 2015 - brith_year + 1;
		System.out.println("당신의 나이는 " + age + "입니다." );
		
		
	}
	
	

}
