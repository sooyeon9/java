package testjava;

import java.util.Scanner;
public class C07 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("���� �뷮�� �ް�����Ʈ ������ �Է��Ͻÿ�. ");
		int mega = s.nextInt();
		System.out.print("���� ����� 1:Wi-Fi, 2:BlueTooth, 3:LTE, 4:USB ���� �����Ͽ� �Է��Ͻÿ�. ");
		byte kind = s.nextByte();
		long bytes = mega*1024*1024;
		double time = 0;
		
		if(kind==1){
			time = bytes/1500000;
			System.out.println("���� ���� �ð��� "+time+"�� �Դϴ�.");}
		else if(kind==2){
			time = bytes/300000;
			System.out.println("���� ���� �ð��� "+time+"�� �Դϴ�.");}
		else if(kind==3){
			time = bytes/1000000;
			System.out.println("���� ���� �ð��� "+time+"�� �Դϴ�.");}
		else {
			time = bytes/60000000;
			System.out.println("���� ���� �ð��� "+time+"�� �Դϴ�.");}
	}

}