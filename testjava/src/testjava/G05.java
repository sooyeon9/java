package testjava;

import java.util.Scanner;
public class G05 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		int total=0;
		
		while(true){
			System.out.print("����� �ð��� �ð��� ������ �Է��ϼ���. : ");
			int h = s.nextInt();
			int m = s.nextInt();
			
			if(h==0 & m==0){break;}
			
			int time = h*60 + m;
			int don = 0;
			if(time%30==0){don=(time/30)*1000;}
			else {don=(time/30+1)*1000;}
			
			if(120<=time & time<180){don=don*95/100;}
			else if(180<=time & time<300){don=don*90/100;}
			else if(300<=time){don=don*80/100;}
			
			System.out.println("������ �̿��� "+don+"�� �Դϴ�.");
			total += don;}
		
		System.out.println();
		System.out.print("���ݱ����� �̿�� �ѱݾ��� "+total+"�� �Դϴ�.");
		
	}
}