package testjava;

import java.util.Scanner;
public class A03 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("���簢�� ���� ���̸� �Է��Ͻÿ�.");
		int width = s.nextInt();
		
		System.out.println("���簢�� ���� ���̸� �Է��Ͻÿ�.");
		int height = s.nextInt();
		int area = width * height;
		System.out.println("���簢���� ���̴� " + area + "�Դϴ�.");
	}

}
