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
		System.out.print("�մ� ���� �Է��Ͻÿ�.");
		num = s.nextInt();
		
		System.out.print("������ũ, ���İ�Ƽ, �Ľ�Ÿ�� ������ �Է��Ͻÿ�.");
		steak = s.nextInt();
		spaghetti = s.nextInt();
		pasta = s.nextInt();
		
		System.out.print("����� ī�尡 �ֽ��ϱ�?(Y/N)");
		card = s.next();
		
		if(card.equals("Y")){money = (steak*25000 + spaghetti*15000 + pasta*17000)*90/100;}
		else {money = steak*25000 + spaghetti*15000 + pasta*17000;}
		if(money>=100000){money = money + money*10/100;}
		else {money = money + money*7/100;}
		money = money + money*10/100;
		
		System.out.println("������ �ð��� "+str+"�Դϴ�.");
		System.out.println("�� �ݾ��� "+money+"�� �Դϴ�.");}

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
			System.out.print("1)�ֹ�   2)����   3)����Ʈ   4)����   ==> ");
			int select = s.nextInt();
			System.out.println("------------------------------------------");
			
			if(select==1){
				u.add(new customer());
				u.get(u.size()-1).order();
				System.out.println("");}
			
			else if(select==2){
				System.out.println("��ȣ"+"\t"+"�մԼ�"+"\t"+"������ũ"+"\t"+"���İ�Ƽ"+"\t"+"�Ľ�Ÿ"+"\t"+"�����"+"\t"+"�����ݾ�"+"\t"+"����ð�");
				for(int I=0; I<u.size(); I++){
					System.out.print("["+(I+1)+"]"+"\t");
					u.get(I).paylist();}
				System.out.print("==> �����Ͻ� ��ȣ�� �Է��ϼ��� : ");
				int pay = s.nextInt();
				u.remove(pay-1);
				System.out.println("==> �����Ϸ�Ǿ����ϴ�.");
				System.out.println("");}
			
			else if(select==3){
				System.out.println("��ȣ"+"\t"+"�մԼ�"+"\t"+"������ũ"+"\t"+"���İ�Ƽ"+"\t"+"�Ľ�Ÿ"+"\t"+"�����"+"\t"+"����ð�");
				for(int I=0; I<u.size(); I++){
					System.out.print("["+(I+1)+"]"+"\t");
					u.get(I).list();}
				System.out.println("");}
			
			else {
				System.out.println("����Ǿ����ϴ�.");
				break;}
			
			
		}
		
	}
}