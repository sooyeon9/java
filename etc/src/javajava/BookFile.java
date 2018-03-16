package javajava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookFile {
	
	//��ü�� ��°�� ���ٳ��� �ٽ� ������ �� �� �ֵ��� �Ѵ� (�ؽ�Ʈ���Ϸ� �����ʰ�) - booklist.dat
	
	//���Ͽ� �Է�
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
			Book b1 = new Book("a0001", "�ڹٿϼ�", "ȫ�浿", 10000, 1995, "�Ｚ", 5);
			Book b2 = new Book("a0002", "��Ʈ����", "������", 20000, 2012, "���", 4);
			Book b3 = new Book("a0003", "���� EJB", "�輺��", 25000, 2011, "�ȷ�", 3);
			Book b4 = new Book("a0004", "�λ��ѹ�", "������", 55000, 2015, "����", 5);
			list.add(b1);
			list.add(b2);
			list.add(b3);
			list.add(b4);
			
			 
			try{
				fout = new FileOutputStream("booklist.dat");
				oos = new ObjectOutputStream(fout); //���� �ִ� ��
				
				oos.writeObject(list);
				oos.reset();
				oos.writeObject(list); //����Ʈ�� �ϳ� �� ���� �� 
				oos.reset();
				
				System.out.println("����Ǿ����ϴ�.");
				
			}catch(Exception ex){
			}finally{
				try{
					oos.close();
					fout.close();
				}catch(IOException ioe){}
			} // finally
		}
		
		
		
		//���Ͽ��� ������
		public static void InputTest(){
			FileInputStream fin = null;
			ObjectInputStream ois = null;

			try{
				fin = new FileInputStream("booklist.dat");
				ois = new ObjectInputStream(fin); //���� �о���� ��
				
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
