package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseAdapterEx extends JFrame {
	JPanel contentPane = new JPanel();
	JLabel la;
	
	MouseAdapterEx() {
		setTitle("Mouse �̺�Ʈ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(contentPane); // ����Ʈ�� ����
		contentPane.setLayout(null); // ����Ʈ���� ��ġ������ ����
		contentPane.addMouseListener(new MyMouseAdapter()); // ����Ʈ�ҿ� Mouse ������ �ޱ�
		la = new JLabel("hello"); //"hello" ���̺� ������Ʈ ����
		la.setSize(50, 20); // ���̺��� ũ�� 50x20�� ����
		la.setLocation(30, 30);// ���̺��� ��ġ (30,30)���� ����
		contentPane.add(la); //���̺� ������Ʈ�� ����Ʈ���� �߰�
		setSize(200,200);
		setVisible(true);		
	}
	
	// MouseAdapter�� ��ӹ޾� �̺�Ʈ ������ ����
	class MyMouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int x = e.getX(); // ���콺 Ŭ�� ��ǥ x
			int y = e.getY(); // ���콺 Ŭ�� ��ǥ y
			la.setLocation(x, y); // ���̺��� ��ġ�� (x,y)�� �̵�
		}
	}
	
	public static void main(String [] args) {
		new MouseAdapterEx();
	}
} 


