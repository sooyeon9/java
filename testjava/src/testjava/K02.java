package testjava;

import java.util.Scanner;
class MenuPan {
	int num;
	String name;
	String from;
	int money;
	
	void input(){
		Scanner s = new Scanner(System.in);
		System.out.print("�޴��� ��ȣ, �޴���, ������, ������ �Է��Ͻÿ�.");
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
		System.out.print("����Ͻ� �޴��� ������ �Է��Ͻÿ�.");
		int menucount = s.nextInt();
		
		MenuPan mp[] = new MenuPan[menucount];
		for(int i=0; i<menucount; i++) {
			mp[i] = new MenuPan();
			System.out.print((i+1)+"�� ");
			mp[i].input();}
		
		System.out.println("===========================================");
		System.out.println("�޴���ȣ"+"\t"+"�޴��̸�"+"\t"+"������"+"\t"+"1�κа���");
		for(int i=0; i<menucount; i++){
			mp[i].print();
		}
		
	}
}
