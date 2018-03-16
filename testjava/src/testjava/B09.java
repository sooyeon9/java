package testjava;

import java.util.Scanner;
public class B09 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("신장(cm단위)을 입력하시오.");
		int height = s.nextInt();
		System.out.print("체중(kg단위)을 입력하시오.");
		int weight = s.nextInt();
		
		int bmi = (weight*100*100) / (height*height);
		
		if(bmi<25){
			System.out.print("당신은 비만이 아닙니다.");	
		} else {
			System.out.print("당신은 비만입니다.");
		}
		
	}

}
