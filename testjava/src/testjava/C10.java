package testjava;

import java.util.Scanner;
public class C10 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("����1�� �Է��Ͻÿ�. ");
		int num1 = s.nextInt();
		System.out.print("����2�� �Է��Ͻÿ�. ");
		int num2 = s.nextInt();
		System.out.print("�����ȣ����('+','-','*','/'�� �Ѱ�)�� �Է��ϼ���.");
		String giho = s.next();
		int dab = 0;
		
		if(giho.equals("+")){dab=num1+num2;}
		else if(giho.equals("-")){dab=num1-num2;}
		else if(giho.equals("*")){dab=num1*num2;}
		else {dab=num1/num2;}
		
		System.out.println("������ ��� ���� "+dab+"�Դϴ�.");

	}

}