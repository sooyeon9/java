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
			else {System.out.println("출금할 수 없습니다.");}}}

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
			System.out.print("1)개설   2)입금   3)출금   4)송금   5)이자지급   6)통장내역츨력   7)종료   ==> ");
			select = s.nextInt();
			System.out.println("------------------------------------------------------------");
			
			if(select==1){
				addAccount();
				System.out.println("통장이 개설되었습니다.");
				viewAccount(num-1);}
			
			else if(select==2){
				System.out.print("입금할 통장번호를 입력하시오. : ");
				int putnum = s.nextInt();
				System.out.print("입금액을 입력하시오. : ");
				int putmoney = s.nextInt();
				saveMoney(putnum-1, putmoney);
				printbalance(putnum-1);
				System.out.println("입금이 완료되었습니다.");}
				
			
			else if(select==3){
				System.out.print("출금할 통장번호를 입력하시오. : ");
				int outnum = s.nextInt();
				System.out.print("출금액을 입력하시오. : ");
				int outmoney = s.nextInt();
				drawMoney(outnum-1, outmoney);
				printbalance(outnum-1);
				System.out.println("출금이 완료되었습니다.");}
			
			else if(select==4){
				System.out.print("출금통장번호와 입금통장번호를 순서대로 입력하시오. : ");
				int outnum = s.nextInt();
				int putnum = s.nextInt();
				System.out.print("송금액을 입력하시오. : ");
				int sendmoney = s.nextInt();
				transferMoney(outnum-1, putnum-1, sendmoney);
				printbalance(outnum-1);
				System.out.println("송금이 완료되었습니다.");}
			
			else if(select==5){
				putInterest();}
			
			else if(select==6){
				printAccount();}
			
			else {
				System.out.println("종료되었습니다.");
				break;}}
	}
	
	public void addAccount(){
		if(num<account.length){
			
			System.out.print("예금주이름을 입력하시오. : ");
			name = s.next();
			System.out.print("잔액을 입력하시오. : ");
			balance = s.nextInt();
			System.out.print("신용등급을 입력하시오.(1~3) : ");
			grade = s.nextInt();
			account[num] = new BankAccount((num+1),name,balance,grade);
			
			num++;}
		
		else {System.out.print("더이상 통장을 만들 수 없습니다.");}}
	
	public void saveMoney(int num, int money){
		account[num].save(money);}
	
	public void drawMoney(int num, int money){
		account[num].draw(money);}
	
	public void printbalance(int num){
		int a = account[num].getAmount();
		System.out.println("통장번호 "+(num+1)+"의 현재 잔액은 " + a + "원 입니다.");}
	
	public void printAccount(){
		System.out.println("통장번호"+"\t"+"예금주이름"+"\t"+"통장잔액"+"\t"+"신용등급");
		for(int i=0; i<num; i++){
			account[i].print();}}
	
	public void viewAccount(int num){
		System.out.println("통장번호"+"\t"+"예금주이름"+"\t"+"통장잔액"+"\t"+"신용등급");
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


