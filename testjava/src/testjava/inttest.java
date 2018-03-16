package testjava;

import java.util.Scanner;

public class inttest {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		System.out.println("정수를 입력하시오.");
		int a = s.nextInt();
		System.out.println("입력하신 수는 " +a+" 입니다.");
	}  
}
