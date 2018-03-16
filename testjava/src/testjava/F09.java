package testjava;

import java.util.Scanner;
public class F09 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("월을 입력하시오. ");
		int m = s.nextInt()-1;
		System.out.print("일을 입력하시오. ");
		int d = s.nextInt();

		int md[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		int all_d = 0;
		int i;
		
		if(m<0||m>11||d<0||d>31){System.out.println("잘못 입력하셨습니다.");}
		else if(m==1&d>28){System.out.println("잘못 입력하셨습니다.");}
		else if((m==3||m==5||m==8||m==10)&d>30){System.out.println("잘못 입력하셨습니다.");}
		else {
			for(i=0;i<m;i++){all_d += md[i];}
			System.out.println("이 날짜는 1년 중 "+(all_d+d)+"날에 해당됩니다.");}
		
	}
}