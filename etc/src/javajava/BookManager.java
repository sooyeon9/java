package javajava;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {

	Scanner s = new Scanner(System.in);
	ArrayList<Book> Books = new ArrayList<Book>();

	public ArrayList<Book> getMusics(){return Books;}
	
	public void addBook(){
		System.out.print("isbn코드를 입력하시오 : ");
		String isbn = s.next();
		System.out.print("제목,저자,출판사를 차례로 입력하시오 : ");
		String title = s.next();
		String author = s.next();
		String company = s.next();
		System.out.print("가격(원),출판년도,인기도(1~5)를 차례로 입력하시오 : ");
		int price = s.nextInt();
		int year = s.nextInt();
		int star = s.nextInt();
		
		Books.add(new Book(isbn, title, author, price, year, company, star));
		System.out.println("["+title+"] 도서 추가완료!"); }
	
	
	public void changeBook(){
		System.out.print("정보 변경할 도서의 제목을 입력하시오 : ");
		String chantitle = s.next();
		for(int i=0; i<Books.size();i++){
			if(chantitle.equals(Books.get(i).getTitle())){
				System.out.println("현재 ["+chantitle+"] 도서의 정보는 아래와 같습니다.");
				System.out.println(">> "+Books.get(i).toString());
				Books.remove(i);}}
		System.out.print("수정할 isbn코드를 입력하시오 : ");
		String isbn = s.next();
		System.out.print("수정할 저자,출판사를 차례로 입력하시오 : ");
		String author = s.next();
		String company = s.next();
		System.out.print("수정할 가격(원),출판년도,인기도(1~5)를 차례로 입력하시오 : ");
		int price = s.nextInt();
		int year = s.nextInt();
		int star = s.nextInt();
		Books.add(new Book(isbn, chantitle, author, price, year, company, star));
		System.out.println("["+chantitle+"] 도서 정보 수정완료!"); }
	
	
	public void deleteBook(){
		System.out.print("삭제할 도서의 제목을 입력하시오 : ");
		String deltitle = s.next();
		for(int i=0; i<Books.size();i++){
			if(deltitle.equals(Books.get(i).getTitle())){Books.remove(i);}}
		System.out.println("["+deltitle+"] 도서 삭제완료!"); }
	
	
	public void findBook(){
		System.out.print("검색할 항목을 선택하시오(1=저자명, 2=가격, 3=출판사, 4=isbn, 5=출판년도) : ");
		int chanitem = s.nextInt();
		
		if(chanitem==1){
			System.out.print("검색할 저자명을 입력하시오 : ");
			String author = s.next();
			for(int i=0; i<Books.size();i++){
				if(author.equals(Books.get(i).getAuthor())){
					System.out.println(">>"+Books.get(i).toString());}}}
		
		else if(chanitem==2){
			System.out.print("검색할 가격을 입력하시오 : ");
			int price = s.nextInt();
			for(int i=0; i<Books.size();i++){
				if(price==Books.get(i).getPrice()){
					System.out.println(">>"+Books.get(i).toString());}}}
		
		else if(chanitem==3){
			System.out.print("검색할 출판사를 입력하시오 : ");
			String company = s.next();
			for(int i=0; i<Books.size();i++){
				if(company.equals(Books.get(i).getCompany())){
					System.out.println(">>"+Books.get(i).toString());}}}

		else if(chanitem==4){
			System.out.print("검색할 isbn코드를 입력하시오 : ");
			String isbn = s.next();
			for(int i=0; i<Books.size();i++){
				if(isbn.equals(Books.get(i).getIsbn())){
					System.out.println(">>"+Books.get(i).toString());}}}
		else {
			System.out.print("검색할 출판년도를 입력하시오 : ");
			int year = s.nextInt();
			for(int i=0; i<Books.size();i++){
				if(year==Books.get(i).getYear()){
					System.out.println(">>"+Books.get(i).toString());}}} }
	
	//파일 저장
	public void saveF(){
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		//FileInputStream fin = null;
		//ObjectInputStream ois = null;
		
		try{
			//fin = new FileInputStream("booklist.dat");
			//ois = new ObjectInputStream(fin); //파일 읽어오는 것
			
			//ArrayList list2 = (ArrayList)ois.readObject();

			//for(int i=num+1;i<Books.size();i++){
			//	list2.add(Books.get(i));}
			
			fout = new FileOutputStream("booklist.dat");
			oos = new ObjectOutputStream(fout); //파일 넣는 것
			
			oos.writeObject(Books);
			//oos.writeObject(list2);
			oos.reset();
			
			System.out.println("도서정보가 저장되었습니다.");
			
		}catch(Exception ex){
		}finally{
			try{
				oos.close();
				fout.close();
				//ois.close();
				//fin.close();
			}catch(IOException ioe){}
		} }
	
	//파일 읽기
	public void readF(){
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		//Book books[] = new Book[Books.size()];

		try{
			fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin); //파일 읽어오는 것
			
			ArrayList list = (ArrayList)ois.readObject();
			
			//for(int i=0; i<list.size();i++){
			//	books[i] = (Book)list.get(i);}
			
			System.out.println("현재 저장된 모든 도서 정보는 아래와 같습니다.");
			for(int i=0; i<list.size();i++){
				System.out.println(">> "+list.get(i).toString());}
	
			
		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		} }
	
	
	//파일을 읽어서 리스트에 추가함
	public void datTOlist(){ 
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		
		try{
			fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin); //파일 읽어오는 것
			
			ArrayList list = (ArrayList)ois.readObject();
			

			for(int i=0; i<list.size();i++){
				Books.add((Book) list.get(i));}
	
			
		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		} }
	
	
	public void start(){
		int select;
		datTOlist();
		
		
		while(true){
			System.out.println("---------------------------------------------------------------------");
			System.out.print("1)도서추가   2)도서정보변경   3)도서삭제   4)도서검색   5)파일읽기  6)파일저장 7)종료   ==> ");
			select = s.nextInt();
			System.out.println("---------------------------------------------------------------------");
			
			if(select==1){addBook();}
			
			else if(select==2){changeBook();}
			
			else if(select==3){deleteBook();}
			
			else if(select==4){findBook();}
			
			else if(select==5){readF();}
			
			else if(select==6){saveF();}
			
			else {
				System.out.println("종료되었습니다.");
				break;}} }
	
	
	static public void main(String[] args){
		BookManager bm = new BookManager();
		bm.start();}
	
	
	
}
