package testjava;

import java.util.Scanner;
public class C05 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("월을 입력하시오. ");
		int m = s.nextInt()-1;
		System.out.print("일을 입력하시오. ");
		int d = s.nextInt();

		int all_d = 0;
		
		if(m<0 || m>12 || d<0 || d>31){System.out.println("잘못 입력하셨습니다.");}
		else if(m<2){
			all_d = 31 + d;
			System.out.println("이 날짜는 1년 중 "+all_d+"날에 해당됩니다.");}
		else if(2<=m & m<=7){
			if(m%2==0){all_d = 31 + 28 + (m-2)*30 + (m-1-m/2) + d;}
			else{all_d = 31 + 28 + (m-2)*30 + (m-(m+1)/2) + d;}
			System.out.println("이 날짜는 1년 중 "+all_d+"날에 해당됩니다.");}
		else if(7<m){
			m=m-5;
			if(m%2==0){all_d = 212 + (m-2)*30 + (m-1-m/2) + d;}
			else{all_d = 212 + (m-2)*30 + (m-(m+1)/2) + d;}
			System.out.println("이 날짜는 1년 중 "+all_d+"날에 해당됩니다.");}
		
	}

}