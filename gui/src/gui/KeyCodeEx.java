package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyCodeEx extends JFrame {
	JPanel contentPane = new JPanel();// ����Ʈ������ ����� �г�
	JLabel la = new JLabel(); // �� ���̺� ������Ʈ ����
	
	KeyCodeEx() {
		setTitle("Key Code ���� : F1Ű:�ʷϻ�, % Ű �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(contentPane);
		contentPane.addKeyListener(new MyKeyListener());
		contentPane.add(la);
		setSize(300,150);
		setVisible(true);
		
		// ����Ʈ���� Ű �Է��� ���� �� �ֵ��� ��Ŀ�� ���� ����
		contentPane.requestFocus();		
	}
	
	// Key ������ ����
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			// la�� �Էµ� Ű�� Ű �̸� ���ڿ��� ����Ͽ� ����ڿ��� ������
			la.setText(e.getKeyText(e.getKeyCode())+"Ű�� �ԷµǾ���");
			
			if(e.getKeyChar() == '%') // �Էµ� Ű�� %�ΰ� 
				contentPane.setBackground(Color.YELLOW);
			else if(e.getKeyCode() == KeyEvent.VK_F1) // �Էµ� Ű�� F1 �ΰ�
				contentPane.setBackground(Color.GREEN);
		}
	}
	
	public static void main(String [] args) {
		new KeyCodeEx();
	}
} 


