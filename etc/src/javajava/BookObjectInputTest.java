package javajava;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class BookObjectInputTest{

	public static void main(String[] args) {
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try{
			fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin); //���� �о���� ��
			
			ArrayList list = (ArrayList)ois.readObject();
			Book b1 = (Book)list.get(0);
			Book b2 = (Book)list.get(1);
			Book b3 = (Book)list.get(5);
			Book b4 = (Book)list.get(3);
			ArrayList list2 = (ArrayList)ois.readObject();
			Book b5 = (Book)list2.get(1); //�̷������� �о�ü��� �ֵ�!
			
			System.out.println(b1.toString());
			System.out.println(b2.toString());
			System.out.println(b3.toString());
			System.out.println(b4.toString());
			System.out.println(b5.toString());
			
		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		} // finally
	} // main end
} // class end

