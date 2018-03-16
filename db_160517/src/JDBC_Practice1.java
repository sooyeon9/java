import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;


public class JDBC_Practice1  implements ActionListener {
	private static Connection dbTest;
    private String username;
    private String password;
    private int tnumber=0;

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel idLabel = new JLabel("���̵�");
	private JLabel pwdLabel = new JLabel("��й�ȣ");
	private JTextField idInput = new JTextField();
	private JPasswordField pwdInput = new JPasswordField();
	private JButton loginButton = new JButton("�α���");
	
	private JTextArea check_area = new JTextArea();
    private JComboBox<String> check_box = new JComboBox<String>();
    private JComboBox<String> buy_box = new JComboBox<String>();
    private JTextField model_field = new JTextField();
    private JButton buyButton = new JButton("����");
    
	

	public JDBC_Practice1() {
		panel.setLayout(null);
		idLabel.setBounds(20, 10, 60, 30);
		pwdLabel.setBounds(20, 50, 60, 30);
		idInput.setBounds(100, 10, 80, 30);
		pwdInput.setBounds(100, 50, 80, 30);
		loginButton.setBounds(200, 25, 80, 35);
		
		loginButton.addActionListener(this);

		panel.add(idLabel);
		panel.add(pwdLabel);
		panel.add(idInput);
		panel.add(pwdInput);
		panel.add(loginButton);
		frame.add(panel);
		
		frame.setTitle("JDBC_Practice 1");
		frame.setSize(320, 130);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//PCstore GUI �� Eventó��
    private void PCstore(){
        frame.setVisible(false);
        frame = new JFrame();
        panel = new JPanel();

        panel.setFont(new Font("�ʱ�ü", 1, 12));
        panel.setBorder(new TitledBorder("��ȸ"));
        panel.setBounds(380,80,490,280);
        panel.setLayout(null);

        check_box.addItem("PC");
        check_box.addItem("Laptop");
        check_box.addItem("Printer");

        for(int i=1;i<=10;i++) buy_box.addItem(String.valueOf(i));

        check_area.setBorder(new LineBorder(Color.gray, 2));
        check_area.setEditable(false);

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(check_area);

        check_box.setBounds(20,40,70,30);
        model_field.setBounds(100,40,80,30);
        buy_box.setBounds(200,40,50,30);
        buyButton.setBounds(300,40,70,30);
        scroll.setBounds(10,80,360,170);

        //Checkbox�� ���̺�� ���� �� ���̺� �� ���
        check_box.addActionListener(this);

        //���Ź�ư Ŭ�� �� �����۾� ����
        buyButton.addActionListener(this);

        panel.add(check_box);
        panel.add(model_field);
        panel.add(buy_box);
        panel.add(buyButton);
        panel.add(scroll);

        frame.add(panel);

        frame.setTitle("PC Store");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton){
            username = idInput.getText();
            password = new String(pwdInput.getPassword());

            connectDB();
            PCstore();
        }
        //Checkbox�� ���̺�� ���� �� ���̺� �� ���
        else if(e.getSource() == check_box){
            try{
                showTable();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        //���Ź�ư Ŭ�� �� �����۾� ����
        else if(e.getSource() == buyButton){
            try{
                insertTransaction();
            }
            catch (SQLException se){
                se.printStackTrace();
            }
        }
    }

    private void insertTransaction() throws SQLException{
        String specification = "";
        String modelname = model_field.getText();
        String count = (String)buy_box.getSelectedItem();
        String Tablename = ((String) check_box.getSelectedItem()).toUpperCase();
        int price;

        try{
            /*
                fill out this area
            */
        	String sqlStr = "SELECT price FROM "+ Tablename + " WHERE model = "+modelname;
			PreparedStatement stmt = dbTest.prepareStatement(sqlStr);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			price = rs.getInt("price");
			rs.close();
			stmt.close();
			
        	specification = "insert into transaction values("
					+ (tnumber+1) + ","
					+ Integer.parseInt(modelname) + ","
					+ Integer.parseInt(count) + ","
					+ (price*Integer.parseInt(count)) + ")";
        	
        	stmt = dbTest.prepareStatement(specification);
			stmt.executeQuery();
			
			JOptionPane.showMessageDialog(null, (String)"���Ÿ� �� �� �����ϴ�","�޽���",2);
        	
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, (String)"���Ÿ� �� �� �����ϴ�","�޽���",2);
        }


    }

    private void showTable() throws SQLException{
        String specification = "";

        String sqlStr = "select count(column_name) num from cols where table_name = '"
                + ((String) check_box.getSelectedItem()).toUpperCase() +"'";
        PreparedStatement stmt = dbTest.prepareStatement(sqlStr);
        ResultSet rs = stmt.executeQuery();

        rs.next();
        int number = rs.getInt("num");
        String[] tables = new String[number];

        sqlStr = "select column_name from cols where table_name = '"
                + ((String)check_box.getSelectedItem()).toUpperCase()+"'";

        stmt = dbTest.prepareStatement(sqlStr);
        rs = stmt.executeQuery();

        for(number = 0; rs.next();number++){
            tables[number] = rs.getString("column_name");
            specification+=tables[number]+'\t';
        }
        for(specification+="\n";number>0;number--){
            specification += "--------------------";
        }
        specification += "\n";

        sqlStr = "select * from "+(String)check_box.getSelectedItem();
        stmt = dbTest.prepareStatement(sqlStr);
        rs = stmt.executeQuery();

        for(number=0;rs.next();number++){
            for(int i=0;i<tables.length;i++){
                specification+=rs.getString(tables[i])+'\t';
            }
            specification+="\n";
        }
        check_area.setText(specification);
        rs.close();
        stmt.close();
    }
    private void connectDB(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            dbTest = DriverManager.getConnection("jdbc:oracle:thin:" + "@localhost:1521:XE", username, password);
            System.out.println("�����ͺ��̽����� ���� - id: "+username);
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("����");
        }
        catch(Exception e){
            System.out.println("Exception:"+e);
        }
    }
	
	/*
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton) {
			String username = idInput.getText();
			String password = new String(pwdInput.getPassword());
			
			connectDB(username,password);
		}
		
	}
	
	
	private void connectDB(String a, String b) {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			dbTest = DriverManager.getConnection("jdbc:oracle:thin:"+"@localhost:1521:XE",a,b);
			System.out.println("������ ���̽��� ���� �Ǿ����ϴ�.");
			frame.setVisible(false);
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("������ ���̽� ���ῡ �����Ͽ����ϴ�.");
			System.out.println("SQLException : "+e);
		} catch (Exception e){
			System.out.println("Exception : " + e);
		}
	}
	*/
	
	public static void main(String[] args) {
		new JDBC_Practice1();
	}
	
	

}
