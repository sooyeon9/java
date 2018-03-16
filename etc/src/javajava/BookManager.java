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
		System.out.print("isbn�ڵ带 �Է��Ͻÿ� : ");
		String isbn = s.next();
		System.out.print("����,����,���ǻ縦 ���ʷ� �Է��Ͻÿ� : ");
		String title = s.next();
		String author = s.next();
		String company = s.next();
		System.out.print("����(��),���ǳ⵵,�α⵵(1~5)�� ���ʷ� �Է��Ͻÿ� : ");
		int price = s.nextInt();
		int year = s.nextInt();
		int star = s.nextInt();
		
		Books.add(new Book(isbn, title, author, price, year, company, star));
		System.out.println("["+title+"] ���� �߰��Ϸ�!"); }
	
	
	public void changeBook(){
		System.out.print("���� ������ ������ ������ �Է��Ͻÿ� : ");
		String chantitle = s.next();
		for(int i=0; i<Books.size();i++){
			if(chantitle.equals(Books.get(i).getTitle())){
				System.out.println("���� ["+chantitle+"] ������ ������ �Ʒ��� �����ϴ�.");
				System.out.println(">> "+Books.get(i).toString());
				Books.remove(i);}}
		System.out.print("������ isbn�ڵ带 �Է��Ͻÿ� : ");
		String isbn = s.next();
		System.out.print("������ ����,���ǻ縦 ���ʷ� �Է��Ͻÿ� : ");
		String author = s.next();
		String company = s.next();
		System.out.print("������ ����(��),���ǳ⵵,�α⵵(1~5)�� ���ʷ� �Է��Ͻÿ� : ");
		int price = s.nextInt();
		int year = s.nextInt();
		int star = s.nextInt();
		Books.add(new Book(isbn, chantitle, author, price, year, company, star));
		System.out.println("["+chantitle+"] ���� ���� �����Ϸ�!"); }
	
	
	public void deleteBook(){
		System.out.print("������ ������ ������ �Է��Ͻÿ� : ");
		String deltitle = s.next();
		for(int i=0; i<Books.size();i++){
			if(deltitle.equals(Books.get(i).getTitle())){Books.remove(i);}}
		System.out.println("["+deltitle+"] ���� �����Ϸ�!"); }
	
	
	public void findBook(){
		System.out.print("�˻��� �׸��� �����Ͻÿ�(1=���ڸ�, 2=����, 3=���ǻ�, 4=isbn, 5=���ǳ⵵) : ");
		int chanitem = s.nextInt();
		
		if(chanitem==1){
			System.out.print("�˻��� ���ڸ��� �Է��Ͻÿ� : ");
			String author = s.next();
			for(int i=0; i<Books.size();i++){
				if(author.equals(Books.get(i).getAuthor())){
					System.out.println(">>"+Books.get(i).toString());}}}
		
		else if(chanitem==2){
			System.out.print("�˻��� ������ �Է��Ͻÿ� : ");
			int price = s.nextInt();
			for(int i=0; i<Books.size();i++){
				if(price==Books.get(i).getPrice()){
					System.out.println(">>"+Books.get(i).toString());}}}
		
		else if(chanitem==3){
			System.out.print("�˻��� ���ǻ縦 �Է��Ͻÿ� : ");
			String company = s.next();
			for(int i=0; i<Books.size();i++){
				if(company.equals(Books.get(i).getCompany())){
					System.out.println(">>"+Books.get(i).toString());}}}

		else if(chanitem==4){
			System.out.print("�˻��� isbn�ڵ带 �Է��Ͻÿ� : ");
			String isbn = s.next();
			for(int i=0; i<Books.size();i++){
				if(isbn.equals(Books.get(i).getIsbn())){
					System.out.println(">>"+Books.get(i).toString());}}}
		else {
			System.out.print("�˻��� ���ǳ⵵�� �Է��Ͻÿ� : ");
			int year = s.nextInt();
			for(int i=0; i<Books.size();i++){
				if(year==Books.get(i).getYear()){
					System.out.println(">>"+Books.get(i).toString());}}} }
	
	//���� ����
	public void saveF(){
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		//FileInputStream fin = null;
		//ObjectInputStream ois = null;
		
		try{
			//fin = new FileInputStream("booklist.dat");
			//ois = new ObjectInputStream(fin); //���� �о���� ��
			
			//ArrayList list2 = (ArrayList)ois.readObject();

			//for(int i=num+1;i<Books.size();i++){
			//	list2.add(Books.get(i));}
			
			fout = new FileOutputStream("booklist.dat");
			oos = new ObjectOutputStream(fout); //���� �ִ� ��
			
			oos.writeObject(Books);
			//oos.writeObject(list2);
			oos.reset();
			
			System.out.println("���������� ����Ǿ����ϴ�.");
			
		}catch(Exception ex){
		}finally{
			try{
				oos.close();
				fout.close();
				//ois.close();
				//fin.close();
			}catch(IOException ioe){}
		} }
	
	//���� �б�
	public void readF(){
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		//Book books[] = new Book[Books.size()];

		try{
			fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin); //���� �о���� ��
			
			ArrayList list = (ArrayList)ois.readObject();
			
			//for(int i=0; i<list.size();i++){
			//	books[i] = (Book)list.get(i);}
			
			System.out.println("���� ����� ��� ���� ������ �Ʒ��� �����ϴ�.");
			for(int i=0; i<list.size();i++){
				System.out.println(">> "+list.get(i).toString());}
	
			
		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		} }
	
	
	//������ �о ����Ʈ�� �߰���
	public void datTOlist(){ 
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		
		try{
			fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin); //���� �о���� ��
			
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
			System.out.print("1)�����߰�   2)������������   3)��������   4)�����˻�   5)�����б�  6)�������� 7)����   ==> ");
			select = s.nextInt();
			System.out.println("---------------------------------------------------------------------");
			
			if(select==1){addBook();}
			
			else if(select==2){changeBook();}
			
			else if(select==3){deleteBook();}
			
			else if(select==4){findBook();}
			
			else if(select==5){readF();}
			
			else if(select==6){saveF();}
			
			else {
				System.out.println("����Ǿ����ϴ�.");
				break;}} }
	
	
	static public void main(String[] args){
		BookManager bm = new BookManager();
		bm.start();}
	
	
	
}
