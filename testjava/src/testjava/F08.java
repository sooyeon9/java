package testjava;

import java.util.Scanner;
public class F08 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		int num[] = new int[10];
		int count=0;
		int newnum=0;
		boolean dab;
		int i;
		
		System.out.println("1���� 100������ ���ڸ� �ߺ����� �Է��Ͻÿ�.");
		
		while(count<10){
			dab=false;
			System.out.print((count+1)+"��° ���ڸ� �Է��Ͻÿ�. : ");
			newnum = s.nextInt();
			for(i=0;i<10;i++){if(newnum==num[i]){dab=true;}}
			if(!(0<=newnum & newnum<=100)){System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");}
			else if(dab==true){System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");}
			else {
				num[count]=newnum;
				count+=1;}}
		
		for(i=0;i<10;i++){System.out.println((i+1)+"��° ���ڴ� "+num[i]+"�Դϴ�.");}


	}
}