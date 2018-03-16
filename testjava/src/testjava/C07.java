package testjava;

import java.util.Scanner;
public class C07 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("파일 용량을 메가바이트 단위로 입력하시오. ");
		int mega = s.nextInt();
		System.out.print("전송 방식을 1:Wi-Fi, 2:BlueTooth, 3:LTE, 4:USB 에서 선택하여 입력하시오. ");
		byte kind = s.nextByte();
		long bytes = mega*1024*1024;
		double time = 0;
		
		if(kind==1){
			time = bytes/1500000;
			System.out.println("파일 전송 시간은 "+time+"초 입니다.");}
		else if(kind==2){
			time = bytes/300000;
			System.out.println("파일 전송 시간은 "+time+"초 입니다.");}
		else if(kind==3){
			time = bytes/1000000;
			System.out.println("파일 전송 시간은 "+time+"초 입니다.");}
		else {
			time = bytes/60000000;
			System.out.println("파일 전송 시간은 "+time+"초 입니다.");}
	}

}