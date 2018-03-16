package javajava;

import java.util.*;


class BankAccount {
	int num;
	String name;
	int balance;
	int grade;
	
	BankAccount(int num, String name, int balance, int grade){
		this.num = num;
		this.name = name;
		this.balance = balance;
		this.grade = grade;}
	
	public void save(int money){
		balance += money;}
	
	public void draw(int money){
		if(grade==1){
			balance -= money;}
		
		else {
			if(balance>=money){
				balance -= money;}
			else {System.out.println("����� �� �����ϴ�.");}}}

	public void print(){
		System.out.println(num+"\t"+name+"\t"+balance+"\t"+grade);}
	
	public int getAmount(){
		return balance;}
	
	public int getgrade(){
		return grade;}
	
}


class AccountManager {
	Scanner s = new Scanner(System.in);
	BankAccount[] account = new BankAccount[10];
	int num=0;
	int select,balance,grade;
	String name;
	
	public void start(){
		while(true){
			System.out.println("------------------------------------------------------------");
			System.out.print("1)����   2)�Ա�   3)���   4)�۱�   5)��������   6)���峻������   7)����   ==> ");
			select = s.nextInt();
			System.out.println("------------------------------------------------------------");
			
			if(select==1){
				addAccount();
				System.out.println("������ �����Ǿ����ϴ�.");
				viewAccount(num-1);}
			
			else if(select==2){
				System.out.print("�Ա��� �����ȣ�� �Է��Ͻÿ�. : ");
				int putnum = s.nextInt();
				System.out.print("�Աݾ��� �Է��Ͻÿ�. : ");
				int putmoney = s.nextInt();
				saveMoney(putnum-1, putmoney);
				printbalance(putnum-1);
				System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");}
				
			
			else if(select==3){
				System.out.print("����� �����ȣ�� �Է��Ͻÿ�. : ");
				int outnum = s.nextInt();
				System.out.print("��ݾ��� �Է��Ͻÿ�. : ");
				int outmoney = s.nextInt();
				drawMoney(outnum-1, outmoney);
				printbalance(outnum-1);
				System.out.println("����� �Ϸ�Ǿ����ϴ�.");}
			
			else if(select==4){
				System.out.print("��������ȣ�� �Ա������ȣ�� ������� �Է��Ͻÿ�. : ");
				int outnum = s.nextInt();
				int putnum = s.nextInt();
				System.out.print("�۱ݾ��� �Է��Ͻÿ�. : ");
				int sendmoney = s.nextInt();
				transferMoney(outnum-1, putnum-1, sendmoney);
				printbalance(outnum-1);
				System.out.println("�۱��� �Ϸ�Ǿ����ϴ�.");}
			
			else if(select==5){
				putInterest();}
			
			else if(select==6){
				printAccount();}
			
			else {
				System.out.println("����Ǿ����ϴ�.");
				break;}}
	}
	
	public void addAccount(){
		if(num<account.length){
			
			System.out.print("�������̸��� �Է��Ͻÿ�. : ");
			name = s.next();
			System.out.print("�ܾ��� �Է��Ͻÿ�. : ");
			balance = s.nextInt();
			System.out.print("�ſ����� �Է��Ͻÿ�.(1~3) : ");
			grade = s.nextInt();
			account[num] = new BankAccount((num+1),name,balance,grade);
			
			num++;}
		
		else {System.out.print("���̻� ������ ���� �� �����ϴ�.");}}
	
	public void saveMoney(int num, int money){
		account[num].save(money);}
	
	public void drawMoney(int num, int money){
		account[num].draw(money);}
	
	public void printbalance(int num){
		int a = account[num].getAmount();
		System.out.println("�����ȣ "+(num+1)+"�� ���� �ܾ��� " + a + "�� �Դϴ�.");}
	
	public void printAccount(){
		System.out.println("�����ȣ"+"\t"+"�������̸�"+"\t"+"�����ܾ�"+"\t"+"�ſ���");
		for(int i=0; i<num; i++){
			account[i].print();}}
	
	public void viewAccount(int num){
		System.out.println("�����ȣ"+"\t"+"�������̸�"+"\t"+"�����ܾ�"+"\t"+"�ſ���");
		account[num].print();}
	
	public void transferMoney(int num1, int num2, int money){
		account[num1].save(money);
		account[num2].draw(money);}
	
	public void putInterest(){
		for(int i=0; i<num; i++){
			int g = account[i].getgrade();
			int b = account[i].getAmount();
			if(g==1){
				if(b>0){
					account[i].save(b*3/100);}}
			else if(g==2){account[i].save(b*2/100);}
			else {account[i].save(b*1/100);}}}
	
	
	static public void main(String args[]){
		AccountManager bank = new AccountManager();
		bank.start();}
	
}


