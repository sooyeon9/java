package testjava;

import java.util.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class customer {
	int num;
	int steak, spaghetti, pasta;
	String card;
	int money=0;
	long time = System.currentTimeMillis(); 
	SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	String str = dayTime.format(new Date(time));
	
	void order(){
		Scanner s = new Scanner(System.in);
		System.out.print("손님 수를 입력하시오.");
		num = s.nextInt();
		
		System.out.print("스테이크, 스파게티, 파스타의 개수를 입력하시오.");
		steak = s.nextInt();
		spaghetti = s.nextInt();
		pasta = s.nextInt();
		
		System.out.print("멤버쉽 카드가 있습니까?(Y/N)");
		card = s.next();
		
		if(card.equals("Y")){money = (steak*25000 + spaghetti*15000 + pasta*17000)*90/100;}
		else {money = steak*25000 + spaghetti*15000 + pasta*17000;}
		if(money>=100000){money = money + money*10/100;}
		else {money = money + money*7/100;}
		money = money + money*10/100;
		
		System.out.println("들어오신 시간은 "+str+"입니다.");
		System.out.println("총 금액은 "+money+"원 입니다.");}

	void paylist(){
		System.out.println(num+"\t"+steak+"\t"+spaghetti+"\t"+pasta+"\t"+card+"\t"+money+"\t"+str);}
	
	void list(){
		System.out.println(num+"\t"+steak+"\t"+spaghetti+"\t"+pasta+"\t"+card+"\t"+str);}}
	


class L02{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		ArrayList<customer> u = new ArrayList<customer>();
		
		while(true){
			System.out.println("------------------------------------------");
			System.out.print("1)주문   2)결제   3)리스트   4)종료   ==> ");
			int select = s.nextInt();
			System.out.println("------------------------------------------");
			
			if(select==1){
				u.add(new customer());
				u.get(u.size()-1).order();
				System.out.println("");}
			
			else if(select==2){
				System.out.println("번호"+"\t"+"손님수"+"\t"+"스테이크"+"\t"+"스파게티"+"\t"+"파스타"+"\t"+"멤버쉽"+"\t"+"결제금액"+"\t"+"입장시간");
				for(int I=0; I<u.size(); I++){
					System.out.print("["+(I+1)+"]"+"\t");
					u.get(I).paylist();}
				System.out.print("==> 결제하실 번호를 입력하세요 : ");
				int pay = s.nextInt();
				u.remove(pay-1);
				System.out.println("==> 결제완료되었습니다.");
				System.out.println("");}
			
			else if(select==3){
				System.out.println("번호"+"\t"+"손님수"+"\t"+"스테이크"+"\t"+"스파게티"+"\t"+"파스타"+"\t"+"멤버쉽"+"\t"+"입장시간");
				for(int I=0; I<u.size(); I++){
					System.out.print("["+(I+1)+"]"+"\t");
					u.get(I).list();}
				System.out.println("");}
			
			else {
				System.out.println("종료되었습니다.");
				break;}
			
			
		}
		
	}
}