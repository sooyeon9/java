package testjava;

import java.util.Scanner;
public class C01 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("태어난 년도를 입력하시오. ");
		int year = s.nextInt();
		int age = 2015 - year + 1;
		if(age < 7){System.out.println("유아입니다.");} 
		else if(7<=age & age<13){System.out.println("어린이입니다.");}
		else if(13<=age & age<20){System.out.println("청소년입니다.");}
		else if(20<=age & age<30){System.out.println("청년입니다.");}
		else if(30<=age & age<60){System.out.println("중년입니다.");}
		else{System.out.println("노년입니다.");}
		
		
	}

}
