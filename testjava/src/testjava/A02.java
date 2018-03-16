package testjava;

import java.util.Scanner;
public class A02 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("섭씨 온도를 입력하시오.");
		double c_degree = s.nextDouble();
		double f_degree = c_degree * 1.8 + 32;
		System.out.println("화씨온도는 " + f_degree + "입니다.");
	}

}
