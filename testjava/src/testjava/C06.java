package testjava;

import java.util.Scanner;
public class C06 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("���� ������ �Է��Ͻÿ�. ");
		int kor = s.nextInt();
		System.out.print("���� ������ �Է��Ͻÿ�. ");
		int eng = s.nextInt();
		System.out.print("���� ������ �Է��Ͻÿ�. ");
		int math  = s.nextInt();
		
		int sum = kor+eng+math;
		double aver = sum/3.0;
		System.out.println("�Է��Ͻ� ������ ������ "+sum+"�̰�,");
		System.out.println("����� " +aver+"�Դϴ�.");
		
		if(90<=aver){System.out.println("�� �Դϴ�.");}
		else if(80<=aver & aver<90){System.out.println("�� �Դϴ�.");}
		else if(70<=aver & aver<80){System.out.println("�� �Դϴ�.");}
		else if(60<=aver & aver<70){System.out.println("�� �Դϴ�.");}
		else {System.out.println("�� �Դϴ�.");}

	}

}
