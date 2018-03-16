package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBoxItemEventEx extends JFrame {
	Container contentPane;
	JCheckBox [] fruits = new JCheckBox [3]; // 체크박스 배열
	String [] names = {"사과", "배", "체리"}; // 체크박스 문자열로 사용할 문자열 배열
	JLabel sumLabel; // 계산 합을 출력할 레이블
	int sum = 0; // 가격의 합
	
	CheckBoxItemEventEx() {
		setTitle("체크박스와 ItemEvent  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		contentPane.add(new JLabel("사과  100원, 배 500원, 체리 20000원"));
		
		// 3개의 체크박스 컴포넌트를 생성하고 컨텐트팬에 삽입, Item 리스너 등록
		for(int i=0; i<fruits.length; i++) { // fruits.length=3
			fruits[i] = new JCheckBox(names[i]); // 배열 names[]의 문자열로 체크박스 생성
			fruits[i].setBorderPainted(true); // 체크박스의 외곽선이 보이도록 설정
			contentPane.add(fruits[i]); // 체크박스 컴포넌트를 컨텐트팬에 삽입
			fruits[i].addItemListener(new MyItemListener()); // 체크박스에 Item 리스너 등록
		}
		
		sumLabel = new JLabel("현재 0 원 입니다."); // 가격 합을 출력하는 레이블 생성
		contentPane.add(sumLabel);
		
		setSize(250,200);
		setVisible(true);
	}
	
	// Item 리스너 구현
	class MyItemListener implements ItemListener {
		// 체크박스의 선택 상태가 변하면 itemStateChanged()가 호출됨
		public void itemStateChanged(ItemEvent e) {
			int selected=1; // 1이면 선택 상태, -1이면 해제 상태
			
			// 선택 상태인지 판별
			if(e.getStateChange() == ItemEvent.SELECTED)
				selected = 1; // 선택 상태 의미
			else
				selected = -1; // 선택 해제 의미
			
			// 어떤 체크 박스인지 판별
			if(e.getItem() == fruits[0]) // 사과 체크박스 
				sum = sum + selected*100;
			else if(e.getItem() == fruits[1]) // 배 체크박스
				sum = sum + selected*500;
			else // 체리 체그박스
				sum = sum + selected*20000;
			
			sumLabel.setText("현재 "+sum+"원 입니다."); // 합 출력
		}
	}
	public static void main(String [] args) {
		new CheckBoxItemEventEx();
	}
} 