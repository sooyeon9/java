package testjava;

import java.util.Scanner;
public class C03 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("���簢���� ���θ� �Է��Ͻÿ�. ");
		int garo = s.nextInt();
		System.out.print("���簢���� ���θ� �Է��Ͻÿ�. ");
		int sero = s.nextInt();
		
		if(garo==sero){System.out.println("���簢��");}
		else if(garo>=sero*2){System.out.println("�¿�� ������ ���簢��");}
		else if(sero>=garo*2){System.out.println("���Ʒ��� ������ ���簢��");}
		else if(garo>sero){System.out.println("�Ϲ����� ������ ���簢��");}
		else if(garo<sero){System.out.println("�Ϲ����� ������ ���簢��");}
		
	}

}