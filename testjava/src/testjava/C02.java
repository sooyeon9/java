package testjava;

import java.util.Scanner;
public class C02 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("���� �µ��� �Է��Ͻÿ�. ");
		double degree = s.nextDouble();
		
		if(degree < 0){System.out.println("�߸� �Է��ϼ̽��ϴ�.");}
		else if(0<=degree & degree<25){System.out.println("�ü��Դϴ�.");}
		else if(25<=degree & degree<40){System.out.println("�̿¼��Դϴ�.");}
		else if(40<=degree & degree<80){System.out.println("�¼��Դϴ�.");}
		else{System.out.println("���� ���Դϴ�.");}
		
		
	}

}
