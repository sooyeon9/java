package testjava;

import java.util.Scanner;
public class B02 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.println("�µ��� �Է��Ͻÿ�.");
		double input_degree = s.nextDouble();
		System.out.println("�Է��Ͻ� �µ��� �����µ��̸� C�� ȭ���µ��̸� F�� �Է��Ͻÿ�.");
		String kind = s.next();
		if(kind.equals("C")){
			double output_degree = input_degree * 1.8 + 32;
			System.out.println("��ȯ�� �µ��� " + output_degree + "�Դϴ�.");
		} else {
			double output_degree = (input_degree - 32) / 1.8;
			System.out.println("��ȯ�� �µ��� " + output_degree + "�Դϴ�.");
		}
	}

}
