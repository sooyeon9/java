package testjava;

import java.util.Scanner;
public class C03 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("직사각형의 가로를 입력하시오. ");
		int garo = s.nextInt();
		System.out.print("직사각형의 세로를 입력하시오. ");
		int sero = s.nextInt();
		
		if(garo==sero){System.out.println("정사각형");}
		else if(garo>=sero*2){System.out.println("좌우로 길쭉한 직사각형");}
		else if(sero>=garo*2){System.out.println("위아래로 길쭉한 직사각형");}
		else if(garo>sero){System.out.println("일반적인 가로형 직사각형");}
		else if(garo<sero){System.out.println("일반적인 세로형 직사각형");}
		
	}

}