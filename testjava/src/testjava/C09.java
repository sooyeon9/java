package testjava;

import java.util.Scanner;
public class C09 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("연봉(원 단위)을 숫자로 입력하시오. ");
		int don = s.nextInt();
		int tax = 0;
		
		if(don<10000000){tax=don*95/1000;}
		else if(10000000<=don & don<40000000){tax=don*19/100;}
		else if(40000000<=don & don<80000000){tax=don*28/100;}
		else {tax=don*37/100;}
		
		System.out.println("연봉 금액에 대한 소득세는 "+tax+"원 입니다.");

	}

}