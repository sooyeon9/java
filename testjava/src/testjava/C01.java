package testjava;

import java.util.Scanner;
public class C01 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("�¾ �⵵�� �Է��Ͻÿ�. ");
		int year = s.nextInt();
		int age = 2015 - year + 1;
		if(age < 7){System.out.println("�����Դϴ�.");} 
		else if(7<=age & age<13){System.out.println("����Դϴ�.");}
		else if(13<=age & age<20){System.out.println("û�ҳ��Դϴ�.");}
		else if(20<=age & age<30){System.out.println("û���Դϴ�.");}
		else if(30<=age & age<60){System.out.println("�߳��Դϴ�.");}
		else{System.out.println("����Դϴ�.");}
		
		
	}

}
