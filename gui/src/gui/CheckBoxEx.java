package gui;

import javax.swing.*;
import java.awt.*;

public class CheckBoxEx extends JFrame {
	Container contentPane;
	CheckBoxEx() {
		setTitle("체크박스 만들기  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		// 이미지 체크박스를 만들기 위해 2개의 이미지 객체를 생성한다.
		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg"); // 보통 이미지
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg"); // 선택 상태를 표시하는 이미지
		
		// 3 개의 체크 박스 컴포넌트를 생성한다.
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배", true);
		JCheckBox cherry = new JCheckBox("체리", cherryIcon);//보통 이미지를 가진 체크박스
		cherry.setBorderPainted(true); // 이미지의 외곽선이 보이도록 설정
		cherry.setSelectedIcon(selectedCherryIcon); //선택 상태를 표시하는 이미지 등록
		
		// 컨텐트팬에 3개의 체크박스 컴포넌트 삽입
		contentPane.add(apple);
		contentPane.add(pear);
		contentPane.add(cherry);

		setSize(250,150);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new CheckBoxEx();
	}
} 


