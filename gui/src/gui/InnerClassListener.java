package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InnerClassListener extends JFrame {
	InnerClassListener() {
		setTitle("Action 이벤트 리스너 작성");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn = new JButton("Action");
		add(btn);
		
		setSize(300,150);
		setVisible(true);
		
		// 버튼에 내부 클래스 MyActionListener를 Action 리스너로 등록한다.
		btn.addActionListener(new MyActionListener());
	}
	
	// 내부 클래스 형식으로 Action 리스너를 작성한다.
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action")) 
				b.setText("액션");
			else 
				b.setText("Action");
			
			// InnerClassListener의 멤버나 JFrame의 멤버를 호출할 수 있음
			// 프레임 타이틀을 버튼 문자열로 변경한다.
			setTitle(b.getText());
		}
	}
	
	public static void main(String [] args) {
		new InnerClassListener();
	}
} 



