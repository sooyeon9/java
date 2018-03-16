package testjava;

import java.util.Scanner;
public class D10 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("2개의 숫자를 입력하시오.");
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		int i;
		for (i = 0; i <= 100; i++){
	         if (i%num1 == 0 || i%num2 == 0){
	            if (!(i%num1 == 0 & i%num2 == 0))
	               System.out.print(i+", ");}
		}
		
	}
}
