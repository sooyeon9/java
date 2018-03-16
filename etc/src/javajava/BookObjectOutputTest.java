package javajava;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookObjectOutputTest{

	public static void main(String[] args) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		ArrayList list = new ArrayList();
		
		 
		try{
			fout = new FileOutputStream("musiclist.dat");
			oos = new ObjectOutputStream(fout); //���� �ִ� ��
			
			oos.writeObject(list);
			oos.reset();
			oos.writeObject(list); 
			oos.reset();
			
			System.out.println("����Ǿ����ϴ�.");
			
		}catch(Exception ex){
		}finally{
			try{
				oos.close();
				fout.close();
			}catch(IOException ioe){}
		} // finally
	} // main end
} // class end
