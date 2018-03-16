package testing;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class DB_connect {
	private static Connection dbTest;
	
	DB_connect(){
		connectDB();
	}
	
	private void connectDB() {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			dbTest = DriverManager.getConnection("jdbc:oracle:thin:"+"@localhost:1521:XE","system","system");
			System.out.println("������ ���̽��� ���� �Ǿ����ϴ�.");
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("������ ���̽� ���ῡ �����Ͽ����ϴ�.");
			System.out.println("SQLException : "+e);
		} catch (Exception e){
			System.out.println("Exception : " + e);
		}
	}
	
	
	public static void main(String[] argv) {
		new DB_connect();
		try{
			dbTest.close();
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("SQLException : "+e);
		}
	}

}
