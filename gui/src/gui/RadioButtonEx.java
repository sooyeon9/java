package gui;

import javax.swing.*;
import java.awt.*;

public class RadioButtonEx extends JFrame {
	Container contentPane;
	RadioButtonEx() {
		setTitle("라디오버튼 만들기  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		 // 버튼 그룹 객체 생성
		ButtonGroup g = new ButtonGroup();
		
		// 라디오버튼 3 개 생성
		JRadioButton apple = new JRadioButton("사과");
		JRadioButton pear = new JRadioButton("배", true);
		
		
		// 버튼 그룹 객체에 3개의 라디오버튼 삽입
		g.add(apple);
		g.add(pear);

		// 컨텐트팬에 3 개의 라디오버튼 삽입
		contentPane.add(apple);
		contentPane.add(pear);

		setSize(250,150);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new RadioButtonEx();
	}
} 





