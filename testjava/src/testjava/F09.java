package testjava;

import java.util.Scanner;
public class F09 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("���� �Է��Ͻÿ�. ");
		int m = s.nextInt()-1;
		System.out.print("���� �Է��Ͻÿ�. ");
		int d = s.nextInt();

		int md[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		int all_d = 0;
		int i;
		
		if(m<0||m>11||d<0||d>31){System.out.println("�߸� �Է��ϼ̽��ϴ�.");}
		else if(m==1&d>28){System.out.println("�߸� �Է��ϼ̽��ϴ�.");}
		else if((m==3||m==5||m==8||m==10)&d>30){System.out.println("�߸� �Է��ϼ̽��ϴ�.");}
		else {
			for(i=0;i<m;i++){all_d += md[i];}
			System.out.println("�� ��¥�� 1�� �� "+(all_d+d)+"���� �ش�˴ϴ�.");}
		
	}
}