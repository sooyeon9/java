package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ListenerMouseEx extends JFrame {
	ListenerMouseEx() {
		setTitle("버튼에 Mouse 이벤트 리스너 작성");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 버튼 컴포넌트를 생성하고 MouseListener를 단다.
		JButton btn = new JButton("Mouse Event 테스트 버튼");
		btn.setBackground(Color.YELLOW);
		MyMouseListener listener = new MyMouseListener(); // 마우스 리스너를 생성한다.
		btn.addMouseListener(listener); // 마우스 리스너를 단다.
		
		// 버튼을 컨텐트팬에 단다
		add(btn);
		
		setSize(300,150);
		setVisible(true);
	}

	public static void main(String [] args) {
		new ListenerMouseEx();
	}
} 

// MouseListener을 상속받아 Mouse 리스너를 작성한다.
// MouseListener의 5개 메소드를 모두 구현한다.
class MyMouseListener implements MouseListener {
	public void mouseEntered(MouseEvent e) {// 마우스가 버튼에 올라올때 호출
		JButton btn = (JButton)e.getSource(); //마우스가 올라간 버튼의 주소를 알아낸다.
		btn.setBackground(Color.RED); // 버튼의 배경색을 파란색으로 변경
	}
	public void mouseExited(MouseEvent e) {// 마우스가 버튼에서 내려갈때 호출
		JButton btn = (JButton)e.getSource(); //마우스가 올라간 버튼의 주소를 알아낸다.		
		btn.setBackground(Color.YELLOW); // 버튼의 배경색을 노란색으로 변경		
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
}
