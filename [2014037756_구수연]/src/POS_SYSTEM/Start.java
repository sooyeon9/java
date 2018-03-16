package POS_SYSTEM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.View;


public class Start implements ActionListener {
	Connection db;
	String sql;
	PreparedStatement stmt;
	ResultSet rs;
    private String username;
    private String password;
    
	private JFrame loginFrame = new JFrame();
	private JPanel loginPanel = new JPanel();
	private JLabel idLabel = new JLabel("아이디");
	private JLabel pwdLabel = new JLabel("비밀번호");
	private JTextField idInput = new JTextField();
	private JPasswordField pwdInput = new JPasswordField();
	private JButton db_loginButton = new JButton("로그인");
	
	public void db_login(){ //데이터베이스 로그인 GUI 생성자
		loginPanel.setLayout(null);
		idLabel.setBounds(20, 10, 60, 30);
		pwdLabel.setBounds(20, 50, 60, 30);
		idInput.setBounds(100, 10, 80, 30);
		pwdInput.setBounds(100, 50, 80, 30);
		db_loginButton.setBounds(200, 25, 80, 35);
		
		db_loginButton.addActionListener(this);

		loginPanel.add(idLabel);
		loginPanel.add(pwdLabel);
		loginPanel.add(idInput);
		loginPanel.add(pwdInput);
		loginPanel.add(db_loginButton);
		loginFrame.add(loginPanel);
		
		loginFrame.setTitle("데이터베이스 로그인");
		loginFrame.setSize(320, 130);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
        if(e.getSource() == db_loginButton){ //데이터베이스 로그인 관장
            username = idInput.getText();
            password = new String(pwdInput.getPassword());
            connectDB();
        }
	}

	
	private void connectDB(){ //데이터베이스 연결
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            db = DriverManager.getConnection("jdbc:oracle:thin:" + "@localhost:1521:XE", username, password);
            //System.out.println("데이터베이스접속 성공 - id: "+username);
            new Pos(db);
            loginFrame.setVisible(false);
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "데이터베이스 연결 실패");
        }
        catch(Exception e){
        	JOptionPane.showMessageDialog(null, "데이터베이스 연결 실패");
        }
    }
	
	public static void main(String[] args) {
		Start s = new Start();
		s.db_login();
	}

}
