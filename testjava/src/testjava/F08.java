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
		
		System.out.println("1부터 100사이의 숫자를 중복없이 입력하시오.");
		
		while(count<10){
			dab=false;
			System.out.print((count+1)+"번째 숫자를 입력하시오. : ");
			newnum = s.nextInt();
			for(i=0;i<10;i++){if(newnum==num[i]){dab=true;}}
			if(!(0<=newnum & newnum<=100)){System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");}
			else if(dab==true){System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");}
			else {
				num[count]=newnum;
				count+=1;}}
		
		for(i=0;i<10;i++){System.out.println((i+1)+"번째 숫자는 "+num[i]+"입니다.");}


	}
}