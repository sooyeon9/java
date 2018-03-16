package testjava;

import java.util.Scanner;
class MenuPan {
	int num;
	String name;
	String from;
	int money;
	
	void input(){
		Scanner s = new Scanner(System.in);
		System.out.print("메뉴의 번호, 메뉴명, 원산지, 가격을 입력하시오.");
		num = s.nextInt();
		name = s.next();
		from = s.next();
		money = s.nextInt();}
		
	void print(){
		System.out.println(num+"\t"+name+"\t"+from+"\t"+money);}
	
}

class K02{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		System.out.print("등록하실 메뉴의 개수를 입력하시오.");
		int menucount = s.nextInt();
		
		MenuPan mp[] = new MenuPan[menucount];
		for(int i=0; i<menucount; i++) {
			mp[i] = new MenuPan();
			System.out.print((i+1)+"번 ");
			mp[i].input();}
		
		System.out.println("===========================================");
		System.out.println("메뉴번호"+"\t"+"메뉴이름"+"\t"+"원산지"+"\t"+"1인분가격");
		for(int i=0; i<menucount; i++){
			mp[i].print();
		}
		
	}
}
