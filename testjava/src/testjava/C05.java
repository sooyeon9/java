package testjava;

import java.util.Scanner;
public class C05 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("���� �Է��Ͻÿ�. ");
		int m = s.nextInt()-1;
		System.out.print("���� �Է��Ͻÿ�. ");
		int d = s.nextInt();

		int all_d = 0;
		
		if(m<0 || m>12 || d<0 || d>31){System.out.println("�߸� �Է��ϼ̽��ϴ�.");}
		else if(m<2){
			all_d = 31 + d;
			System.out.println("�� ��¥�� 1�� �� "+all_d+"���� �ش�˴ϴ�.");}
		else if(2<=m & m<=7){
			if(m%2==0){all_d = 31 + 28 + (m-2)*30 + (m-1-m/2) + d;}
			else{all_d = 31 + 28 + (m-2)*30 + (m-(m+1)/2) + d;}
			System.out.println("�� ��¥�� 1�� �� "+all_d+"���� �ش�˴ϴ�.");}
		else if(7<m){
			m=m-5;
			if(m%2==0){all_d = 212 + (m-2)*30 + (m-1-m/2) + d;}
			else{all_d = 212 + (m-2)*30 + (m-(m+1)/2) + d;}
			System.out.println("�� ��¥�� 1�� �� "+all_d+"���� �ش�˴ϴ�.");}
		
	}

}