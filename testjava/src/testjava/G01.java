package testjava;

import java.util.Scanner;
public class G01 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		int age[] = new int[100];
		int count=0;
		int i;
		int p1=0,p2=0,p3=0,p4=0,p5=0,p6=0;

		for(i=0;i<100;i++){
			System.out.print((i+1)+"��° ����� �¾ �⵵�� �Է��Ͻÿ�. : ");
			int year = s.nextInt();
			if(year>2015){break;}
			age[i] = 2015 - year + 1;
			count += 1;}
		
		for(i=0;i<count;i++){
			System.out.println((i+1)+"��° ����� ���̴� "+age[i]+"�Դϴ�.");
			if(age[i]<7){p1+=1;} 
			else if(7<=age[i] & age[i]<13){p2+=1;}
			else if(13<=age[i] & age[i]<20){p3+=1;}
			else if(20<=age[i] & age[i]<30){p4+=1;}
			else if(30<=age[i] & age[i]<60){p5+=1;}
			else{p6+=1;}}
		
		System.out.println("���ƴ� "+p1+"�� �Դϴ�.");
		System.out.println("��̴� "+p2+"�� �Դϴ�.");
		System.out.println("û�ҳ��� "+p3+"�� �Դϴ�.");
		System.out.println("û���� "+p4+"�� �Դϴ�.");
		System.out.println("�߳��� "+p5+"�� �Դϴ�.");
		System.out.println("����� "+p6+"�� �Դϴ�.");
		
	}
}
