package testjava;

import java.util.Scanner;
public class B04 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("����Ʈ�� �о� ���� (��������)�� �Է��Ͻÿ�.");
		double m2_area = s.nextDouble();
		double pyung_area = m2_area / 3.305;
		System.out.println("����Ʈ�� ������ " + pyung_area + "�̰�,");
		if (pyung_area >= 30){
			System.out.println("30�� �̻��̹Ƿ� ū ����Ʈ�Դϴ�.");
		} else {
			System.out.println("30�� �̸��̹Ƿ� ���� ����Ʈ�Դϴ�.");
		}
		
	}

}
