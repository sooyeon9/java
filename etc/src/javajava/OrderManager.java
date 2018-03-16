package javajava;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



class Order {
	int num;
	int menunum[] = new int[4];
	String name;
	int price;
	
	static int menuprice[] = {10100, 12500, 14400, 12600}; //Order.manuprice[i]�� ��밡��
	
	Order(int num, int menunum[], String name, int price){
		this.num = num;
		this.menunum = menunum;
		this.name = name;
		this.price = price;}
	
	@Override 
	public String toString(){
		return num+"\t"+menunum[0]+"\t"+menunum[1]+"\t"+menunum[2]+"\t"+menunum[3]+"\t"+name+"\t"+price;}

	public int getnum(){return num;}
	public String getname(){return name;}
	public int getprice(){return price;}
	public int getmenunum1(){return menunum[0];}
	public int getmenunum2(){return menunum[1];}
	public int getmenunum3(){return menunum[2];}
	public int getmenunum4(){return menunum[3];}}
	

//-----------------------------------------------------

class OrderManager {
	Scanner s = new Scanner(System.in);
	ArrayList<Order> orders = new ArrayList<Order>();
	String menuname[] = {"�Ķ��̵�","���","�Ĵ�","����"};
	
	//OrderManager(ArrayList<Order> orders, int totalmenunum[], int totalprice, String menuname[]){
		//this.orders = orders;
		//this.totalmenunum = totalmenunum;
		//this.totalprice = totalprice;
		//this.menuname = menuname;}
	
	
	public void addOrder(int num){
		System.out.print("�޴��� �ֹ������� ������� �Է��Ͻÿ�. (�Ķ��̵�, ���, �Ĵ�, ����) : " );
		int menunum[] = new int[4];
		menunum[0] = s.nextInt();
		menunum[1] = s.nextInt();
		menunum[2] = s.nextInt();
		menunum[3] = s.nextInt();
		System.out.print("������ �Է��Ͻÿ�. : ");
		String name = s.next();
		int price = menunum[0]*Order.menuprice[0] + menunum[1]*Order.menuprice[1] + menunum[2]*Order.menuprice[2] + menunum[3]*Order.menuprice[3];
		orders.add(new Order(num, menunum, name, price));
		System.out.println("�ֹ���ȣ ["+num+"] "+name+" �մ�, �� "+price+"������ �ֹ� �Ϸ�Ǿ����ϴ�.");}
	
	
	public void cancelOrder(int delnum){
		for(int i=0; i<orders.size();i++){
			if(delnum==orders.get(i).getnum()){orders.remove(i);}}}
	
	public void printOrder(int i){
		System.out.println(orders.get(i).toString());}
	
	public void findOrder(int n){
		System.out.println("�ֹ���ȣ"+"\t"+menuname[0]+"\t"+menuname[1]+"\t"+menuname[2]+"\t"+menuname[3]+"\t"+"����"+"\t"+"�ֹ� �ݾ�");
		if(n>=100){
			for(int i=0;i<orders.size();i++){
				if(orders.get(i).getprice()>=50000){printOrder(i);}}}
		else if(n==1){
			for(int i=0;i<orders.size();i++){
				if(orders.get(i).getmenunum1()>0){printOrder(i);}}}
		else if(n==2){
			for(int i=0;i<orders.size();i++){
				if(orders.get(i).getmenunum2()>0){printOrder(i);}}}
		else if(n==3){
			for(int i=0;i<orders.size();i++){
				if(orders.get(i).getmenunum3()>0){printOrder(i);}}}
		else if(n==4){
			for(int i=0;i<orders.size();i++){
				if(orders.get(i).getmenunum4()>0){printOrder(i);}}}}
	
	//��������̵��� �Ǿ���
	public void findOrder(String n){
		System.out.println("�ֹ���ȣ"+"\t"+menuname[0]+"\t"+menuname[1]+"\t"+menuname[2]+"\t"+menuname[3]+"\t"+"����"+"\t"+"�ֹ� �ݾ�");
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getname().equals(n)){printOrder(i);}}}
	
	public void viewStatus(){
		int totalmenunum[] = new int[4];
		int totalprice=0;
		System.out.println("�� �ֹ��� ����"+"\t"+"�Ķ��̵� �ֹ� ����"+"\t"+"��� �ֹ� ����"+"\t"+"�Ĵ� �ֹ� ����"+"\t"+"���� �ֹ� ����"+"\t"+"�Ǹűݾ� �Ѿ�");
		for(int i=0;i<orders.size();i++){
			totalmenunum[0] += orders.get(i).getmenunum1();
			totalmenunum[1] += orders.get(i).getmenunum2();
			totalmenunum[2] += orders.get(i).getmenunum3();
			totalmenunum[3] += orders.get(i).getmenunum4();
			totalprice += orders.get(i).getprice();}
		System.out.println(orders.size()+"\t\t"+totalmenunum[0]+"\t\t"+totalmenunum[1]+"\t\t"+totalmenunum[2]+"\t\t"+totalmenunum[3]+"\t\t"+totalprice);}
	
	public void findBestCustomer(){
		HashMap<String, Integer> eachPrice = new HashMap<String, Integer>();
		int maxPrice=0;
		String best = null;
		for(int i=0;i<orders.size();i++){
			String key = orders.get(i).getname();
			int sumPrice=0;
			eachPrice.put(key, 0);
			for(int j=0;j<orders.size();j++){
				if(key.equals(orders.get(j).getname())){
					sumPrice += orders.get(j).getprice();}}
			eachPrice.replace(key, 0, sumPrice);}
		for(int i=0;i<orders.size();i++){
			if(eachPrice.get(orders.get(i).getname())>=maxPrice){
				best = orders.get(i).getname();
				maxPrice = eachPrice.get(best);}}
		System.out.println("����Ʈ���� "+eachPrice.get(best)+"���� �ֹ��Ͻ� "+best+"���� �Դϴ�.");}
	
	public void start(){
		int select;
		int num=0;
		while(true){
			System.out.println("---------------------------------------------------------------------");
			System.out.print("1)�ֹ��߰�   2)�ֹ����   3)�ֹ�������   4)�ֹ���ã��   5)�Ǹ���Ȳ����  6)����Ʈ��  7)����   ==> ");
			select = s.nextInt();
			System.out.println("---------------------------------------------------------------------");
			
			if(select==1){
				num++;
				addOrder(num);}
			
			else if(select==2){
				System.out.print("����� �ֹ���ȣ�� �Է��Ͻÿ�. : ");
				int delnum = s.nextInt();
				cancelOrder(delnum);
				System.out.println("��ҵǾ����ϴ�.");}
			
			else if(select==3){
				System.out.println("�ֹ���ȣ"+"\t"+menuname[0]+"\t"+menuname[1]+"\t"+menuname[2]+"\t"+menuname[3]+"\t"+"����"+"\t"+"�ֹ� �ݾ�");
				for(int i=0;i<orders.size();i++){
					printOrder(i);}}
			
			else if(select==4){
				System.out.print("Ư���޴��� �����ϴ� �ֹ����� ã���ø� 1��, Ư�� ���̸��� �ֹ����� ã���ø� 2�� �Է��ϼ���. : ");
				int what = s.nextInt();
				if(what==1){
					System.out.println("�� �ֹ� �ݾ��� 5���� �̻��� �ֹ����� ã���ø�  100�̻��� ���ڸ� �Է��ϼ���.");
					System.out.print("ã���ô� �޴��� �˸´� ���ڸ� �Է��ϼ���. (�Ķ��̵�=1, ���=2, �Ĵ�=3, ����=4) : ");
					int whatmenu = s.nextInt();
					findOrder(whatmenu);}
				else if(what==2){
					System.out.print("ã���ô� �ֹ����� ���̸��� �Է��ϼ���. : ");
					String who = s.next();
					findOrder(who);}}
			
			else if(select==5){
				System.out.println("���ݱ����� �Ǹ���Ȳ�Դϴ�.");
				viewStatus();}
			
			else if(select==6){
				findBestCustomer();}
			
			else {
				System.out.println("����Ǿ����ϴ�.");
				break;}}}
	

	static public void main(String[] args){
		//Auto-generated method stub
		OrderManager chicken = new OrderManager();
		chicken.start();
		//float a = 1;
		//String b = a.toString(); //��Ʈ������ Ÿ���� �ٲپ��ִ� �޼ҵ�
		}

}
