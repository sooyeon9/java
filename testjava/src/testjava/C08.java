package testjava;

import java.util.Scanner;
public class C08 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력하시오. ");
		int num1 = s.nextInt();
		System.out.print("두번째 숫자를 입력하시오. ");
		int num2 = s.nextInt();
		System.out.print("세번째 숫자를 입력하시오. ");
		int num3 = s.nextInt();
		
		int max=0;
		int min=0;
		
		if(num1>=num2 & num1>=num3){
			max = num1;
			if (num3>=num2){min=num2;}
			else {min=num3;}}
		else if(num2>=num1 & num2>=num3){
			max = num2;
			if (num3>=num1){min=num1;}
			else {min=num3;}}
		else if(num3>=num1 & num3>=num2){
			max = num3;
			if (num1>=num2){min=num2;}
			else {min=num1;}}
		
		System.out.println("가장 큰 수는  "+max+"이고, 가장 작은 수는 "+min+"입니다.");
	}

}