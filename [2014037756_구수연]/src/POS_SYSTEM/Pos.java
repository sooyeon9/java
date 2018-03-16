package POS_SYSTEM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Pos implements ActionListener{
	Connection db;
	String sql;
	PreparedStatement stmt;
	ResultSet rs;
	
	String connector = "null"; // 현재 접속한 사원 이름
	String connector_rank = "null"; // 현재 접속한 사원 직급
	Calendar cal = Calendar.getInstance();
	String today = cal.get(Calendar.YEAR) + "/"
				+ (cal.get(Calendar.MONTH)+1) + "/"
				+ cal.get(Calendar.DATE);
	int c_id=1000, w_id=2000; //customer id와 worker id지정
	
	JFrame background = new JFrame();
	JPanel all = new JPanel();
	JPanel grid_layout = new JPanel();
	
	/**********메뉴바**********/
	JMenuBar bar = new JMenuBar();
	JMenu bar_menu = new JMenu("Menu");
	JMenuItem b_m_open = new JMenuItem("Open");
	JMenuItem b_m_login = new JMenuItem("Log in");

	/**********타이틀**********/
	JPanel title_area = new JPanel();
	JLabel title = new JLabel("식당 주문관리");
	
	/**********1.테이블 현황**********/
	JPanel table_area = new JPanel();
	JButton[] tables = new JButton[20];
	
	/**********2.주문내역**********/
	JPanel order_area = new JPanel();
	JTextArea t_order = new JTextArea();
	String t_order_string = "";
	JLabel l_customer_name = new JLabel("고객명");
	JTextField f_customer_name = new JTextField();
	JLabel l_table_name = new JLabel("테이블명");
	JComboBox<String> c_table_name = new JComboBox<String>();
	JButton b_order = new JButton("주문");
	JButton b_cancle = new JButton("취소");
	JButton b_pay = new JButton("결제");
	
	/**********3.메뉴**********/
	JPanel menu_area = new JPanel();
	JButton[] menus = new JButton[20];
	
	/**********4.등록 조회**********/
	JPanel enroll_area = new JPanel();
	JTabbedPane tp = new JTabbedPane();
	//고객
	JPanel tab_customer = new JPanel();
	JLabel l_customer_name4 = new JLabel("고객명");
	JTextField f_customer_name4 = new JTextField();
	JButton b_sign = new JButton("가입");
	JButton b_find = new JButton("조회");
	JTextArea t_customer = new JTextArea();
	//매출
	JPanel tab_sales = new JPanel();
	JLabel l_period = new JLabel("기간");
	JComboBox<String> c_date = new JComboBox<String>();
	JTextArea t_sales_area = new JTextArea(); 
	//직원
	JPanel tab_staff = new JPanel();
	JLabel l_staff_name = new JLabel("직원명");
	JTextField f_staff_name = new JTextField();
	JButton b_add_staff = new JButton("직원등록");
	JButton b_find_staff = new JButton("조회");
	JTextArea t_staff_area = new JTextArea();
	//메뉴
	JPanel tab_menu = new JPanel();
	JLabel l_menu_name = new JLabel("메뉴명");
	JTextField f_menu_name = new JTextField();
	JButton b_menu_add = new JButton("메뉴등록");
	JButton b_find_m = new JButton("조회");
	JTextArea t_menu_area = new JTextArea();
	

	public Pos(Connection db){ //Pos GUI 생성자
		this.db = db;
		
		/**********메뉴바**********/
		b_m_open.addActionListener(this);
		b_m_login.addActionListener(this);
		bar_menu.add(b_m_open);
		bar_menu.add(b_m_login);
		bar.add(bar_menu);
		
		/**********타이틀**********/
		title.setFont(new Font("필기체", 1, 40));
		title_area.add(title);
		title_area.setBackground(Color.WHITE);
		title_area.setBorder(new LineBorder(Color.BLACK, 3));

		
		/**********1.테이블 현황**********/
		table_area.setBorder(new TitledBorder("테이블 현황"));
		table_area.setLayout(new GridLayout(4, 5));
		for (int i = 0; i < 20; i++) {
			tables[i] = new JButton((i+1)+"");
			tables[i].setBackground(Color.WHITE);
			tables[i].setFont(new Font("필기체", 1, 20));
			tables[i].addActionListener(this);
			table_area.add(tables[i]);
		}
		
		
		/**********2.주문내역**********/
		//출력부
		order_area.setBorder(new TitledBorder("주문 내역"));
		order_area.setLayout(null);
		t_order.setBorder(new LineBorder(Color.gray, 2));
		t_order.setEditable(false);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(t_order);
		for (int i = 0; i < 20; i++) {
			c_table_name.addItem((i + 1) +"");
		}
		c_table_name.addActionListener(this);
		b_order.addActionListener(this);
		b_order.setBackground(Color.WHITE);
		b_cancle.addActionListener(this);
		b_cancle.setBackground(Color.WHITE);
		b_pay.addActionListener(this);
		b_pay.setBackground(Color.WHITE);
		//입력부
		scroll.setBounds(15, 18, 200, 330);
		l_customer_name.setBounds(230, 15, 100, 30);
		f_customer_name.setBounds(230, 50, 100, 30);
		l_table_name.setBounds(230, 85, 100, 30);
		c_table_name.setBounds(230, 110, 100, 30);
		b_order.setBounds(230, 170, 100, 30);
		b_cancle.setBounds(230, 220, 100, 30);
		b_pay.setBounds(230, 270, 100, 30);
		
		order_area.add(scroll);
		order_area.add(l_customer_name);
		order_area.add(f_customer_name);
		order_area.add(l_table_name);
		order_area.add(c_table_name);
		order_area.add(b_order);
		order_area.add(b_cancle);
		order_area.add(b_pay);
		
		
		/**********3.메뉴**********/
		menu_area.setBorder(new TitledBorder("메뉴"));
		menu_area.setLayout(new GridLayout(10, 2));
		for (int i = 0; i < 20; i++) {
			menus[i] = new JButton();
			menus[i].addActionListener(this);
			menus[i].setBackground(Color.WHITE);
			menu_area.add(menus[i]);
		}
		
		
		/**********4.등록 조회**********/
		enroll_area.setBorder(new TitledBorder("등록/조회"));
		enroll_area.setLayout(new BorderLayout());
		//고객
		tab_customer.setLayout(null);
		l_customer_name4.setBounds(15, 15, 100, 30);
		f_customer_name4.setBounds(15, 50, 100, 30);
		b_sign.setBounds(180, 50, 60, 30);
		b_find.setBounds(250, 50, 60, 30);
		t_customer.setBounds(15, 90, 300, 200);
		t_customer.setBorder(new LineBorder(Color.gray, 2));
		b_sign.addActionListener(this);
		b_find.addActionListener(this);
		b_sign.setBackground(Color.WHITE);
		b_find.setBackground(Color.WHITE);
		tab_customer.add(l_customer_name4);
		tab_customer.add(f_customer_name4);
		tab_customer.add(b_sign);
		tab_customer.add(b_find);
		tab_customer.add(t_customer);
		//매출
		tab_sales.setLayout(null);
		l_period.setBounds(15, 15, 100, 30);
		c_date.setBounds(150, 15, 100, 30);
		t_sales_area.setBounds(15, 50, 300, 240);
		t_sales_area.setBorder(new LineBorder(Color.gray, 2));
		tab_sales.add(l_period);
		tab_sales.add(c_date);
		tab_sales.add(t_sales_area);
		if(isDataOpened())
			addDatesCombobox();
		//직원
		tab_staff.setLayout(null);
		l_staff_name.setBounds(15, 15, 100, 30);
		f_staff_name.setBounds(15, 50, 100, 30);
		b_add_staff.setBounds(150, 50, 90, 30);
		b_find_staff.setBounds(250, 50, 60, 30);
		t_staff_area.setBounds(15, 90, 300, 200);
		t_staff_area.setBorder(new LineBorder(Color.gray, 2));
		b_add_staff.addActionListener(this);
		b_find_staff.addActionListener(this);
		b_add_staff.setBackground(Color.WHITE);
		b_find_staff.setBackground(Color.WHITE);
		tab_staff.add(l_staff_name);
		tab_staff.add(f_staff_name);
		tab_staff.add(b_add_staff);
		tab_staff.add(b_find_staff);
		tab_staff.add(t_staff_area);
		//메뉴
		tab_menu.setLayout(null);
		l_menu_name.setBounds(15, 15, 100, 30);
		f_menu_name.setBounds(15, 50, 120, 30);
		b_menu_add.setBounds(150, 50, 90, 30);
		b_find_m.setBounds(250, 50, 60, 30);
		t_menu_area.setBounds(15, 90, 300, 200);
		t_menu_area.setBorder(new LineBorder(Color.gray, 2));
		b_menu_add.addActionListener(this);
		b_find_m.addActionListener(this);
		b_menu_add.setBackground(Color.WHITE);
		b_find_m.setBackground(Color.WHITE);
		tab_menu.add(l_menu_name);
		tab_menu.add(f_menu_name);
		tab_menu.add(b_menu_add);
		tab_menu.add(b_find_m);
		tab_menu.add(t_menu_area);

		tp.addTab("고객", tab_customer);
		tp.addTab("매출", tab_sales);
		tp.addTab("직원", tab_staff);
		tp.addTab("메뉴", tab_menu);
		enroll_area.add(tp, BorderLayout.CENTER);
		
		
		/**********전체 부착하기**********/
		grid_layout.setLayout(new GridLayout(2, 2));
		grid_layout.add(table_area);
		grid_layout.add(order_area);
		grid_layout.add(menu_area);
		grid_layout.add(enroll_area);
		
		all.setLayout(new BorderLayout());
		all.add(title_area, BorderLayout.NORTH);
		all.add(grid_layout, BorderLayout.CENTER);

		background.setJMenuBar(bar);
		background.add(all);
		background.setTitle("식당 관리 시스템 (로그인이 필요합니다)");
		background.setBounds(0, 0, 700, 850);
		background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		background.setVisible(true);
		if(isDataOpened())
			try {
				this.menuUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			JOptionPane.showMessageDialog(null, "최초 접속 - data open 필요!");
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b_m_open){ //<메뉴바> 'open'버튼 - open하고 login하기까지 선택안되도록하는거
			if(!isDataOpened()){
				JFileChooser c = new JFileChooser();
				FileNameExtensionFilter f = new FileNameExtensionFilter("텍스트파일(.txt)", "txt");
				c.setFileFilter(f);
				int result = c.showOpenDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
					try {
						createTable(c.getSelectedFile());
						menuUpdate();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			} else
				JOptionPane.showMessageDialog(null, "데이터가 이미 로드되었습니다.");
		} else if(e.getSource()==b_m_login){ //<메뉴바> 'login'버튼
			new Login(db,this);
			f_customer_name.setText("");
			f_customer_name4.setText("");
			t_customer.setText("");
			t_sales_area.setText("");
			f_staff_name.setText("");
			t_staff_area.setText("");
			f_menu_name.setText("");
			t_menu_area.setText("");
		} else if(e.getSource()==c_table_name){ //<2.주문 내역> '테이블번호'콤보박스
			t_order.setText(tableOrderText());
		} else if(e.getSource()==b_order){ //<2.주문 내역> '주문'버튼 
			String t_num = (String) c_table_name.getSelectedItem();
			StringTokenizer st = new StringTokenizer(t_order.getText(),"\n");
			while(st.hasMoreTokens()){
				StringTokenizer ordering = new StringTokenizer(st.nextToken(),"\t");
				sql = "insert into orders values('"
						+ today + "',"
						+ t_num +",'"
						+ ordering.nextToken() +"',"
						+ ordering.nextToken() +","
						+ "null,'" + connector + "',1)"; 
				//날짜,테이블번호,메뉴이름,가격,주문자,판매자,상태
				try {
					stmt = db.prepareStatement(sql);
					stmt.executeUpdate();
					t_order.setText(tableOrderText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			int i = Integer.parseInt(t_num);
			tables[i-1].setBackground(Color.YELLOW);
			t_order_string = "";
			JOptionPane.showMessageDialog(null, "주문되었습니다.");
		} else if(e.getSource() == b_cancle){ //<2.주문 내역> '취소'버튼
			t_order.setText("");
			String t_num = (String) c_table_name.getSelectedItem();
			sql = "delete FROM orders WHERE dates = '"+ today 
					+ "' and status = 1 and t_num = " + t_num;
			try {
				stmt = db.prepareStatement(sql);
				stmt.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int i = Integer.parseInt(t_num);
			tables[i-1].setBackground(Color.WHITE);
			JOptionPane.showMessageDialog(null, "주문이 취소되었습니다.");
		} else if (e.getSource() == b_pay){ //<2.주문 내역> '결제'버튼
			if(!t_order.getText().contains("---"))
				JOptionPane.showMessageDialog(null, "결제할 주문이 존재하지 않습니다.");
			else {
				String t_num = (String) c_table_name.getSelectedItem();
				String orderer = f_customer_name.getText();
				try {
					payment(t_num,orderer);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "결제되었습니다.");
				t_order.setText("결제되었습니다.");
				f_customer_name.setText("");
				int i = Integer.parseInt(t_num);
				tables[i-1].setBackground(Color.WHITE);
				addDatesCombobox();
			}
		} else if (e.getSource() == b_sign){ //<4.등록 조회-고객탭> '가입'버튼
			if(connector_rank.equals("Supervisor"))
				new Join(db);
			else
				JOptionPane.showMessageDialog(null, "등록 권한이 없습니다.");
		} else if (e.getSource() == b_find){ //<4.등록 조회-고객탭> '조회'버튼
			String name = f_customer_name4.getText();
			sql = "SELECT name FROM customer";
			try {
				stmt = db.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()){
					if(name.equals(rs.getString("name")))
						printFindedCustomer(name);
					else
						t_customer.setText("해당 고객이 존재하지 않습니다.");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == c_date){ //<4.등록 조회-매출탭> '기간'콤보박스
			String date = (String) c_date.getSelectedItem();
			try {
				printSales(date);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == b_add_staff){ //<4.등록 조회-직원탭> '직원등록'버튼
			
		} else if (e.getSource() == b_find_staff){ //<4.등록 조회-직원탭> '조회'버튼
			if(connector_rank.equals("Supervisor")){
				String name = f_staff_name.getText();
				sql = "SELECT name FROM worker";
				try {
					stmt = db.prepareStatement(sql);
					rs = stmt.executeQuery();
					while(rs.next()){
						if(name.equals(rs.getString("name")))
							printFindedWorker(name);
						else
							t_staff_area.setText("해당 직원이 존재하지 않습니다.");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
				JOptionPane.showMessageDialog(null, "조회 권한이 없습니다.");
		} else if (e.getSource() == b_menu_add){ //<4.등록 조회-메뉴탭> '메뉴등록'버튼
			
		} else if (e.getSource() == b_find_m){ //<4.등록 조회-메뉴탭> '조회'버튼
			String menu = f_menu_name.getText();
			try {
				printFindedMenu(menu);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		for(int i=0; i<20; i++)
			if(e.getSource()==menus[i]) //<3.메뉴> 메뉴버튼들
				addMenuToOrder(menus[i]);
			
		for(int i=0; i<20; i++)
			if(e.getSource()==tables[i]){ //<1.테이블 현황> 테이블버튼들
				t_order.setText(tableOrderText());
				c_table_name.setSelectedIndex(i);
			}
	}
	
	
	/**********메소드**********/
	
	//↓ 테이블 생성 및 txt파일로부터 데이터 읽어서 입력해줌
	public void createTable(File f) throws SQLException, IOException{
		String c_table = "create table customer ("
						+"name		varchar(20),"
						+"c_id		integer,"
						+"birth		varchar(10),"
						+"tel		integer,"
						+"grade		varchar(20),"
						+"primary key (name) )";
		stmt = db.prepareStatement(c_table); 
		stmt.executeQuery(); stmt.close();
		
		String w_table = "create table worker ("
						+"name		varchar(20),"
						+"w_id		integer,"
						+"rank		varchar(20),"
						+"primary key (name) )";
		stmt = db.prepareStatement(w_table); 
		stmt.executeQuery(); stmt.close();
		
		String m_table = "create table menu ("
						+"menu		varchar(40),"
						+"price		integer,"
						+"primary key (menu) )";
		stmt = db.prepareStatement(m_table); 
		stmt.executeQuery(); stmt.close();
		
		String o_table = "create table orders ("
						+"dates			date,"
						+"t_num			integer,"
						+"menu			varchar(40),"
						+"price			integer,"
						+"orderer		varchar(20),"
						+"contractor	varchar(20),"
						+"status		integer )";
		stmt = db.prepareStatement(o_table); 
		stmt.executeQuery(); stmt.close();
		db.commit();
		
		File file = new File(f.getAbsolutePath());
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		while((line=br.readLine())!=null){
			sb.append(line);
			sb.append("\n");
		}
		line = sb.toString();
		StringTokenizer token = new StringTokenizer(line,"\t\n");
		
		int temp = Integer.parseInt(token.nextToken());
		for(int i=0; i<temp; i++){
			String sqlStr = "insert into customer values('"
									+token.nextToken()+"','"
									+c_id+"','"
									+token.nextToken()+"','"
									+token.nextToken()+"','"
									+token.nextToken()+"')";
			System.out.println(sqlStr);
			PreparedStatement stmt = db.prepareStatement(sqlStr); 
			stmt.executeQuery(); stmt.close();
			db.commit();
			c_id++;
		}
		
		temp = Integer.parseInt(token.nextToken());
		for(int i=0; i<temp; i++){
			String sqlStr = "insert into worker values('"
									+token.nextToken()+"','"
									+w_id+"','"
									+token.nextToken()+"')";
			System.out.println(sqlStr);
			PreparedStatement stmt = db.prepareStatement(sqlStr); 
			stmt.executeQuery(); stmt.close();
			db.commit();
			w_id++;
		}
		
		temp = Integer.parseInt(token.nextToken());
		for(int i=0; i<temp; i++){
			String sqlStr = "insert into menu values('"
									+token.nextToken()+"','"
									+token.nextToken()+"')";
			System.out.println(sqlStr);
			PreparedStatement stmt = db.prepareStatement(sqlStr); 
			stmt.executeQuery(); stmt.close();
			db.commit();
		}
		
		JOptionPane.showMessageDialog(null, "테이블 생성, 데이터 입력 완료");
	}
	
	//↓ 테이블 생성 되었는지 확인
	public boolean isDataOpened() {
		boolean check;
		sql = "SELECT name FROM customer";
		try {
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			String a = rs.getString("name");
			check = true;
		} catch (SQLException e) {
			check = false;
		}
		return check;
	}
	
	//↓ 테이블 선택시 주문내역 보여줌
	public String tableOrderText() {
		String order_text = "";
		String t_num = (String)c_table_name.getSelectedItem();
		sql = "SELECT menu,price FROM orders WHERE dates = '"+ today 
				+ "'and t_num = "+ t_num + "and status = 1";
		try {
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
				order_text += rs.getString("menu")+"\t"+ rs.getString("price")+"\n";
			order_text += "\n------------------------------\n";
			sql = "SELECT sum(price) FROM orders WHERE dates = '"+ today 
					+ "'and t_num = "+ t_num + "and status = 1";
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			order_text += "총 합계\t" + rs.getString("sum(price)");
			if (rs.getString("sum(price)") == null)
				order_text = "내역이 존재하지 않습니다.";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order_text;
	}
	
	//↓ 메뉴버튼으로 주문내역에 추가
	public void addMenuToOrder(JButton b_menu) {
		if(!b_menu.getText().equals("")){
			sql = "SELECT menu,price FROM menu WHERE menu = '"+b_menu.getText()+"'";
			try {
				stmt = db.prepareStatement(sql);
				rs = stmt.executeQuery();
				rs.next();
				t_order_string += rs.getString("menu") + "\t" + rs.getString("price")+"\n";
				t_order.setText(t_order_string);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//↓ 메뉴판 업데이트 해주고 총 메뉴 개수 리턴
	public int menuUpdate() throws SQLException{
		int count = 0;
		sql = "SELECT menu FROM menu";
		stmt = db.prepareStatement(sql);
		rs = stmt.executeQuery();
		for (int i = 0; rs.next(); i++){
			menus[i].setText(rs.getString("menu"));
			count++;
		}
		return count;
	}
	
	//↓ 결제시 db작업
	public void payment(String t_num, String orderer) throws SQLException{
		int sum_price = 0;
		String grade = "";
		if(orderer.equals(""))
			orderer = "비회원";
		sql = "SELECT sum(price) FROM orders WHERE dates = '"+ today 
				+ "' and status = 1 and t_num = "+ t_num;
		stmt = db.prepareStatement(sql);
		rs = stmt.executeQuery();
		rs.next();
		sum_price = rs.getInt("sum(price)");
		if(!orderer.equals("비회원")){
			sql = "SELECT grade FROM customer WHERE name = '"+orderer+ "'";
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			grade = rs.getString("grade");
			if (grade.equals("Gold"))
				sum_price = sum_price * 70/100;
			else if (grade.equals("Silver"))
				sum_price = sum_price * 80/100;
			else if (grade.equals("Bronze"))
				sum_price = sum_price * 90/100;
		}
		sql = "UPDATE orders SET status = 0, orderer = '"+ orderer 
				+ "' WHERE dates = '"+ today + 
				"' and status = 1 and t_num = "+ t_num;
		stmt = db.prepareStatement(sql);
		stmt.executeUpdate();
	}
	
	//↓ 고객 검색 결과 띄움
	public void printFindedCustomer(String name) throws SQLException{
		String result = "";
		sql = "SELECT * FROM customer WHERE name = '"+name+"'";
		stmt = db.prepareStatement(sql);
		rs = stmt.executeQuery();
		rs.next();
		result += "고객명 : " + rs.getString("name") + "\n";
		result += "고객ID : " + rs.getString("c_id") + "\n";
		result += "생일 : " + rs.getString("birth") + "\n";
		result += "전화번호 : " + rs.getString("tel") + "\n";
		result += "고객등급 : " + rs.getString("grade") + "\n";
		result += "총 구매금액 : " + totalPurchase(name) + "\n";
		t_customer.setText(result);
	}
	
	//↓ 직원 검색 결과 띄움
	public void printFindedWorker(String name) throws SQLException{
		String result = "";
		sql = "SELECT * FROM worker WHERE name = '"+name+"'";
		stmt = db.prepareStatement(sql);
		rs = stmt.executeQuery();
		rs.next();
		result += "직원명 : " + rs.getString("name") + "\n";
		result += "직급 : " + rs.getString("rank") + "\n";
		sql = "SELECT sum(price) FROM orders WHERE contractor = '"+name+"'";
		stmt = db.prepareStatement(sql);
		rs = stmt.executeQuery();
		rs.next();
		result += "총 실적 : " + rs.getInt("sum(price)") + "\n";
		t_staff_area.setText(result);
	}
	
	//↓ 메뉴 검색 결과 띄움
	public void printFindedMenu(String menu) throws SQLException{
		String result = "";
		Boolean exist = false;
		sql = "SELECT menu FROM menu";
		stmt = db.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next())
			if(rs.getString("menu").equals(menu))
				exist = true;	
		if(exist){
			sql = "SELECT * FROM menu WHERE menu = '"+menu+"'";
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			result += "메뉴명 : " + rs.getString("menu") + "\n";
			result += "가격 : " + rs.getInt("price") + "\n";
			t_menu_area.setText(result);
		}
		else
			t_menu_area.setText("검색 결과 없음");
	}
	
	//↓ 해당 고객의 총 구매금액 리턴
	public int totalPurchase(String name){
		int totalPurchase = 0;
		String grade = "";
		String sql2;
		PreparedStatement stmt2;
		ResultSet rs2;
		sql = "SELECT sum(price) FROM orders WHERE orderer = '"+name+"'";
		sql2 = "SELECT grade FROM customer WHERE name = '"+name+"'";
		try {
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			totalPurchase = rs.getInt("sum(price)");
			stmt2 = db.prepareStatement(sql2);
			rs2 = stmt2.executeQuery();
			rs2.next();
			grade = rs2.getString("grade");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(grade.equals("Gold"))
			totalPurchase += 1000000;
		else if(grade.equals("Silver"))
			totalPurchase += 500000;
		else if(grade.equals("Bronze"))
			totalPurchase += 300000;
		
		return totalPurchase;
	}
	
	//↓ 매출 콤보박스에 날짜 추가
	public void addDatesCombobox(){
		c_date.removeAllItems();
		sql = "SELECT distinct dates FROM orders WHERE status = 0 ORDER BY dates";
		try {
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next())
				c_date.addItem(rs.getString("dates").substring(0, 10));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c_date.addActionListener(this);
	}
	
	//↓ 해당 날짜 매출 보여줌
	public void printSales(String date) throws SQLException{
		String result="", maxmenu="", minmenu="";
		int count=0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
		if(date != null){
			//일매출
			sql = "SELECT sum(price) FROM orders WHERE dates = '"+date+"' and status = 0";
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			result += "일 매출 : " + rs.getString("sum(price)");
			result += "\n------------------------------\n";
			//최다 판매 및 최소 판매 메뉴
			sql = "SELECT menu,count(menu) FROM orders WHERE status = 0 GROUP BY menu";
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				count = rs.getInt("count(menu)");
				if(count>max){
					max = count;
					maxmenu = rs.getString("menu");
				}
				if(count<min){
					min = count;
					minmenu = rs.getString("menu");
				}
			}
			result += "가장 많이 팔린 메뉴\n → " + maxmenu + "\n\n";
			result += "가장 적게 팔린 메뉴\n → " + minmenu + "\n";
			//누적매출
			sql = "SELECT sum(price) FROM orders WHERE dates <= '"+date+"' and status = 0";
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			result += "\n------------------------------\n";
			result += "누적 매출 : " + rs.getString("sum(price)");
			t_sales_area.setText(result);
		}
	}
	
}