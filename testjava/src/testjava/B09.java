package testjava;

import java.util.Scanner;
public class B09 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("����(cm����)�� �Է��Ͻÿ�.");
		int height = s.nextInt();
		System.out.print("ü��(kg����)�� �Է��Ͻÿ�.");
		int weight = s.nextInt();
		
		int bmi = (weight*100*100) / (height*height);
		
		if(bmi<25){
			System.out.print("����� ���� �ƴմϴ�.");	
		} else {
			System.out.print("����� ���Դϴ�.");
		}
		
	}

}
