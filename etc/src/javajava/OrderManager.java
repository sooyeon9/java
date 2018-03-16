package javajava;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



class Order {
	int num;
	int menunum[] = new int[4];
	String name;
	int price;
	
	static int menuprice[] = {10100, 12500, 14400, 12600}; //Order.manuprice[i]로 사용가능
	
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
	String menuname[] = {"후라이드","양념","파닭","간장"};
	
	//OrderManager(ArrayList<Order> orders, int totalmenunum[], int totalprice, String menuname[]){
		//this.orders = orders;
		//this.totalmenunum = totalmenunum;
		//this.totalprice = totalprice;
		//this.menuname = menuname;}
	
	
	public void addOrder(int num){
		System.out.print("메뉴별 주문개수를 순서대로 입력하시오. (후라이드, 양념, 파닭, 간장) : " );
		int menunum[] = new int[4];
		menunum[0] = s.nextInt();
		menunum[1] = s.nextInt();
		menunum[2] = s.nextInt();
		menunum[3] = s.nextInt();
		System.out.print("고객명을 입력하시오. : ");
		String name = s.next();
		int price = menunum[0]*Order.menuprice[0] + menunum[1]*Order.menuprice[1] + menunum[2]*Order.menuprice[2] + menunum[3]*Order.menuprice[3];
		orders.add(new Order(num, menunum, name, price));
		System.out.println("주문번호 ["+num+"] "+name+" 손님, 총 "+price+"원으로 주문 완료되었습니다.");}
	
	
	public void cancelOrder(int delnum){
		for(int i=0; i<orders.size();i++){
			if(delnum==orders.get(i).getnum()){orders.remove(i);}}}
	
	public void printOrder(int i){
		System.out.println(orders.get(i).toString());}
	
	public void findOrder(int n){
		System.out.println("주문번호"+"\t"+menuname[0]+"\t"+menuname[1]+"\t"+menuname[2]+"\t"+menuname[3]+"\t"+"고객명"+"\t"+"주문 금액");
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
	
	//↓오버라이딩이 되었다
	public void findOrder(String n){
		System.out.println("주문번호"+"\t"+menuname[0]+"\t"+menuname[1]+"\t"+menuname[2]+"\t"+menuname[3]+"\t"+"고객명"+"\t"+"주문 금액");
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getname().equals(n)){printOrder(i);}}}
	
	public void viewStatus(){
		int totalmenunum[] = new int[4];
		int totalprice=0;
		System.out.println("총 주문서 개수"+"\t"+"후라이드 주문 개수"+"\t"+"양념 주문 개수"+"\t"+"파닭 주문 개수"+"\t"+"간장 주문 개수"+"\t"+"판매금액 총액");
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
		System.out.println("베스트고객은 "+eachPrice.get(best)+"원을 주문하신 "+best+"고객님 입니다.");}
	
	public void start(){
		int select;
		int num=0;
		while(true){
			System.out.println("---------------------------------------------------------------------");
			System.out.print("1)주문추가   2)주문취소   3)주문서보기   4)주문서찾기   5)판매현황보기  6)베스트고객  7)종료   ==> ");
			select = s.nextInt();
			System.out.println("---------------------------------------------------------------------");
			
			if(select==1){
				num++;
				addOrder(num);}
			
			else if(select==2){
				System.out.print("취소할 주문번호를 입력하시오. : ");
				int delnum = s.nextInt();
				cancelOrder(delnum);
				System.out.println("취소되었습니다.");}
			
			else if(select==3){
				System.out.println("주문번호"+"\t"+menuname[0]+"\t"+menuname[1]+"\t"+menuname[2]+"\t"+menuname[3]+"\t"+"고객명"+"\t"+"주문 금액");
				for(int i=0;i<orders.size();i++){
					printOrder(i);}}
			
			else if(select==4){
				System.out.print("특정메뉴를 포함하는 주문서를 찾으시면 1을, 특정 고객이름의 주문서를 찾으시면 2를 입력하세요. : ");
				int what = s.nextInt();
				if(what==1){
					System.out.println("※ 주문 금액이 5만원 이상인 주문서를 찾으시면  100이상의 숫자를 입력하세요.");
					System.out.print("찾으시는 메뉴에 알맞는 숫자를 입력하세요. (후라이드=1, 양념=2, 파닭=3, 간장=4) : ");
					int whatmenu = s.nextInt();
					findOrder(whatmenu);}
				else if(what==2){
					System.out.print("찾으시는 주문서의 고객이름을 입력하세요. : ");
					String who = s.next();
					findOrder(who);}}
			
			else if(select==5){
				System.out.println("지금까지의 판매현황입니다.");
				viewStatus();}
			
			else if(select==6){
				findBestCustomer();}
			
			else {
				System.out.println("종료되었습니다.");
				break;}}}
	

	static public void main(String[] args){
		//Auto-generated method stub
		OrderManager chicken = new OrderManager();
		chicken.start();
		//float a = 1;
		//String b = a.toString(); //스트링으로 타입을 바꾸어주는 메소드
		}

}
