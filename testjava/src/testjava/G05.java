package testjava;

import java.util.Scanner;
public class G05 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		int total=0;
		
		while(true){
			System.out.print("사용한 시간을 시간과 분으로 입력하세요. : ");
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
			
			System.out.println("고객님의 이용료는 "+don+"원 입니다.");
			total += don;}
		
		System.out.println();
		System.out.print("지금까지의 이용료 총금액은 "+total+"원 입니다.");
		
	}
}