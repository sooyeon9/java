package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ListenerMouseEx extends JFrame {
	ListenerMouseEx() {
		setTitle("��ư�� Mouse �̺�Ʈ ������ �ۼ�");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ��ư ������Ʈ�� �����ϰ� MouseListener�� �ܴ�.
		JButton btn = new JButton("Mouse Event �׽�Ʈ ��ư");
		btn.setBackground(Color.YELLOW);
		MyMouseListener listener = new MyMouseListener(); // ���콺 �����ʸ� �����Ѵ�.
		btn.addMouseListener(listener); // ���콺 �����ʸ� �ܴ�.
		
		// ��ư�� ����Ʈ�ҿ� �ܴ�
		add(btn);
		
		setSize(300,150);
		setVisible(true);
	}

	public static void main(String [] args) {
		new ListenerMouseEx();
	}
} 

// MouseListener�� ��ӹ޾� Mouse �����ʸ� �ۼ��Ѵ�.
// MouseListener�� 5�� �޼ҵ带 ��� �����Ѵ�.
class MyMouseListener implements MouseListener {
	public void mouseEntered(MouseEvent e) {// ���콺�� ��ư�� �ö�ö� ȣ��
		JButton btn = (JButton)e.getSource(); //���콺�� �ö� ��ư�� �ּҸ� �˾Ƴ���.
		btn.setBackground(Color.RED); // ��ư�� ������ �Ķ������� ����
	}
	public void mouseExited(MouseEvent e) {// ���콺�� ��ư���� �������� ȣ��
		JButton btn = (JButton)e.getSource(); //���콺�� �ö� ��ư�� �ּҸ� �˾Ƴ���.		
		btn.setBackground(Color.YELLOW); // ��ư�� ������ ��������� ����		
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
}