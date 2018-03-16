package testjava;

import java.util.Scanner;
public class C02 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("물의 온도를 입력하시오. ");
		double degree = s.nextDouble();
		
		if(degree < 0){System.out.println("잘못 입력하셨습니다.");}
		else if(0<=degree & degree<25){System.out.println("냉수입니다.");}
		else if(25<=degree & degree<40){System.out.println("미온수입니다.");}
		else if(40<=degree & degree<80){System.out.println("온수입니다.");}
		else{System.out.println("끓는 물입니다.");}
		
		
	}

}
