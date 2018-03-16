package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SwingAPIEx extends JFrame {
	Container contentPane;
	JButton b1, b2, b3, b4; // 4 개의 버튼
	
	SwingAPIEx() {
		setTitle("Swing 공통 메소드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		// 위치와 크기 정보 버튼 생성
		b1 = new JButton("위치와 크기 정보");
		b1.addActionListener(new MyButtonListener());
		contentPane.add(b1);

		// 모양 정보 버튼 생성
		b2 = new JButton("모양 정보");
		b2.setOpaque(true); // 배경색 변경이  가능하도록 설정
		b2.setForeground(Color.MAGENTA);
		b2.setBackground(Color.YELLOW);
		b2.setFont(new Font("고딕체", Font.ITALIC, 20));//고딕체 20픽셀 폰트 지정		
		b2.addActionListener(new MyButtonListener());
		contentPane.add(b2);

		// 작동하지 않는 버튼 생성
		b3 = new JButton("작동하지 않는 버튼");
		b3.setEnabled(false); // 클릭해도 반응없도록 설정
		b3.addActionListener(new MyButtonListener()); // Action 리스너에 이벤트 발생하지 않음
		contentPane.add(b3);

		// 숨기기/보이기 토글 버튼 생성
		b4 = new JButton("숨기기/보이기");
		b4.addActionListener(new MyButtonListener());
		contentPane.add(b4);
		
		setSize(250,200);		
		setVisible(true);
	}
	
	// 버튼에 등록된 Action 리스너 구현
	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); // 선택된 버튼의 주소 알아내기
			
			// source가 어떤 버튼인지 구분하고 이벤트 처리
			if(source == b1) { // "위치와 크기 정보" 버튼이 선택된 경우
				System.out.println("버튼의 위치와 크기");
				System.out.println("위치 = (" + b1.getX() + "," + b1.getY() + ")");
				System.out.println("크기 = (" + b1.getWidth() + "x" + b1.getHeight() + ")");
				
				JPanel c = (JPanel)b2.getParent();// 부모 컨테이너의 주소를 알아낸다. 부모는 컨텐트팬 
				System.out.println("컨텐트팬의 위치와 크기");
				System.out.println("위치 = (" + c.getX() + "," + c.getY() + ")");
				System.out.println("크기 = (" + c.getWidth() + "x" + c.getHeight() + ")");				
			}
			else if(source == b2) { // "모양 정보" 버튼이 선택된 경우
				System.out.println("폰트 = " + b2.getFont()); // 폰트 이름 출력
				System.out.println("배경색 = " + b2.getBackground()); //배경색 출력
				System.out.println("글자색 = " + b2.getForeground());	//글자색 출력			
			}
			else {  // "숨기기/보이기" 버튼이 선택된 경우
				if(b1.isVisible()) { // 현재 다른 버튼이 보이는 상태이면 모두 보이지 않게 한다.
					b1.setVisible(false);
					b2.setVisible(false);
					b3.setVisible(false);
				}
				else { // 현재 다른 버튼이 보이지않는 상태이면 모두 보이게 한다.
					b1.setVisible(true);
					b2.setVisible(true);
					b3.setVisible(true);					
				}
			}
			// "작동하지 않는 버튼"에 의해 Action 이벤트는 발생하지 않는다.
		}
	}
	
	public static void main(String [] args) {
		new SwingAPIEx();
	}
} 
