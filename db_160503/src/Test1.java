import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Test1 {
			private String username="system"; // Oracle user ID
			private String password="system"; // Password
			private static Connection dbTest;
			
			Test1(){
				connectDB();
			}
			
			private void connectDB(){
				try {
					// JDBC Driver Loading
					Class.forName("oracle.jdbc.OracleDriver");
					dbTest = DriverManager.getConnection("jdbc:oracle:thin:"+
						"@localhost:1521:XE", username, password);
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("SQLException:"+e);
					} catch (Exception e) {
						System.out.println("Exception : "+e);
					}
				
			}
			
			/*public void execute_query() throws SQLException{
				String sqlStr = "SELECT maker, type FROM product WHERE model=2004";
						PreparedStatement stmt = dbTest.prepareStatement(sqlStr);
						ResultSet rs = stmt.executeQuery();
						
						while(rs.next()){
							System.out.println("make: "+rs.getString("MAKER"));
							System.out.println("type: " + rs.getString("TYPE"));
						}
						rs.close();
						stmt.close();	
			}*/
			
			
			public void execute_query() throws SQLException{
				String sqlStr = "SELECT avg(speed) FROM pc";
						PreparedStatement stmt = dbTest.prepareStatement(sqlStr);
						ResultSet rs = stmt.executeQuery();
						
						while(rs.next()){
							System.out.println("����1. pc�� ��� �ӷ��� ���϶�.");
							System.out.println("avg(speed): "+rs.getString("avg(speed)"));
							System.out.println("----------------------------------");
						}
						rs.close();
						stmt.close();
				
				String sqlStr2 = "SELECT price FROM pc WHERE price>=2000";
						PreparedStatement stmt2 = dbTest.prepareStatement(sqlStr2);
						ResultSet rs2 = stmt2.executeQuery();
						
						System.out.println("����2. pc���� price�� 2000�̻��� ������ ���϶�.");
						while(rs2.next()){
							System.out.println("price: "+rs2.getString("price"));
						}
						System.out.println("----------------------------------");
						rs2.close();
						stmt2.close();
						
				String sqlStr3 = "SELECT model,speed,hd FROM pc WHERE price<2000";
						PreparedStatement stmt3 = dbTest.prepareStatement(sqlStr3);
						ResultSet rs3 = stmt3.executeQuery();
						
						System.out.println("����3. 6����̳� 8����� CD�� ���� ������ ������ 2000�̸��� PC���� �𵨹�ȣ,�ӵ�,�ϵ� ��ũ �뷮�� ���϶�.");
						while(rs3.next()){
							System.out.println("model: "+rs3.getString("model")+"| speed: "+rs3.getString("speed")+"| hd: "+rs3.getString("hd"));
						}
						System.out.println("----------------------------------");
						rs3.close();
						stmt3.close();
				
			}
			
			public static void main(String[] args)
			{
				Test1 t1 = new Test1();
				try{
						t1.execute_query();
						dbTest.close();
				}catch(SQLException e) {
						e.printStackTrace();
						System.out.println("SQLException:"+e);
				}
			}
}
