package testjava;

import java.util.Scanner;
public class C10 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("숫자1을 입력하시오. ");
		int num1 = s.nextInt();
		System.out.print("숫자2를 입력하시오. ");
		int num2 = s.nextInt();
		System.out.print("연산기호문자('+','-','*','/'중 한개)를 입력하세요.");
		String giho = s.next();
		int dab = 0;
		
		if(giho.equals("+")){dab=num1+num2;}
		else if(giho.equals("-")){dab=num1-num2;}
		else if(giho.equals("*")){dab=num1*num2;}
		else {dab=num1/num2;}
		
		System.out.println("계산식의 결과 값은 "+dab+"입니다.");

	}

}