package testjava;

import java.util.Scanner;
public class B03 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.println("���簢���� ���� ũ�⸦ �Է��Ͻÿ�.");
		int width = s.nextInt();
		System.out.println("���簢���� ���� ũ�⸦ �Է��Ͻÿ�.");
		int height = s.nextInt();
		int area = width * height;
		System.out.println("���̴� " + area +"�̰�,");
		if(height == width){
			System.out.println("���簢���Դϴ�.");
		} else {
			System.out.println("���簢���� �ƴմϴ�.");
		}
		
	}

}
