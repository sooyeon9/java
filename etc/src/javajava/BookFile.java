package javajava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookFile {
	
	//객체를 통째로 갖다놓고 다시 가져다 쓸 수 있도록 한다 (텍스트파일로 하지않고) - booklist.dat
	
	//파일에 입력
	public static ArrayList<Book> LineUp(ArrayList<Book> a){
		ArrayList<Book> lineup = new ArrayList<Book>();
		int z = a.size();
		for(int i=0; i<z; i++){
			int maxyear = 0, maxindex=0;
			for(int j=0; j<a.size(); j++){
				if(a.get(j).getYear()>maxyear){
					maxyear = a.get(j).getYear();
					maxindex = j;}}
			lineup.add(a.get(maxindex));
			a.remove(maxindex);}
		
		return lineup;}
	
		public static void OutputTest(){
			FileOutputStream fout = null;
			ObjectOutputStream oos = null;

			ArrayList list = new ArrayList();
			Book b1 = new Book("a0001", "자바완성", "홍길동", 10000, 1995, "삼성", 5);
			Book b2 = new Book("a0002", "스트럿츠", "김유신", 20000, 2012, "룰루", 4);
			Book b3 = new Book("a0003", "기초 EJB", "김성박", 25000, 2011, "셜록", 3);
			Book b4 = new Book("a0004", "인생한방", "구수연", 55000, 2015, "수연", 5);
			list.add(b1);
			list.add(b2);
			list.add(b3);
			list.add(b4);
			
			 
			try{
				fout = new FileOutputStream("booklist.dat");
				oos = new ObjectOutputStream(fout); //파일 넣는 것
				
				oos.writeObject(list);
				oos.reset();
				oos.writeObject(list); //리스트를 하나 더 넣은 것 
				oos.reset();
				
				System.out.println("저장되었습니다.");
				
			}catch(Exception ex){
			}finally{
				try{
					oos.close();
					fout.close();
				}catch(IOException ioe){}
			} // finally
		}
		
		
		
		//파일에서 가져옴
		public static void InputTest(){
			FileInputStream fin = null;
			ObjectInputStream ois = null;

			try{
				fin = new FileInputStream("booklist.dat");
				ois = new ObjectInputStream(fin); //파일 읽어오는 것
				
				ArrayList list = (ArrayList)ois.readObject();
				ArrayList a = LineUp(list);
				Book b1 = (Book)a.get(0);
				Book b2 = (Book)a.get(1);
				Book b3 = (Book)a.get(2);
				Book b4 = (Book)a.get(3);
				
				System.out.println(b1.toString());
				System.out.println(b2.toString());
				System.out.println(b3.toString());
				System.out.println(b4.toString());
				
			}catch(Exception ex){
			}finally{
				try{
					ois.close();
					fin.close();
				}catch(IOException ioe){}
			}
		}
		
		public static void main(String[] args) {
			OutputTest();
			InputTest();
		}

}
