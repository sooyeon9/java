package testjava;

import java.util.Scanner;
public class C04 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("����Ʈ�� �о����(��������)�� �Է��Ͻÿ�. ");
		double area = s.nextDouble();
		double pyung = area / 3.305;
		
		System.out.println("����Ʈ�� ������ " + pyung + "�Դϴ�.");
		if(pyung < 15){System.out.println("���� ����Ʈ �Դϴ�.");}
		else if(15<=pyung & pyung<30){System.out.println("�߼��� ����Ʈ �Դϴ�.");}
		else if(30<=pyung & pyung<50){System.out.println("���� ����Ʈ �Դϴ�.");}
		else{System.out.println("���� ����Ʈ �Դϴ�.");}

	}

}
