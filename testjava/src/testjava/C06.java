package testjava;

import java.util.Scanner;
public class C06 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("국어 점수를 입력하시오. ");
		int kor = s.nextInt();
		System.out.print("영어 점수를 입력하시오. ");
		int eng = s.nextInt();
		System.out.print("수학 점수를 입력하시오. ");
		int math  = s.nextInt();
		
		int sum = kor+eng+math;
		double aver = sum/3.0;
		System.out.println("입력하신 점수의 총점은 "+sum+"이고,");
		System.out.println("평균은 " +aver+"입니다.");
		
		if(90<=aver){System.out.println("수 입니다.");}
		else if(80<=aver & aver<90){System.out.println("우 입니다.");}
		else if(70<=aver & aver<80){System.out.println("미 입니다.");}
		else if(60<=aver & aver<70){System.out.println("양 입니다.");}
		else {System.out.println("가 입니다.");}

	}

}
