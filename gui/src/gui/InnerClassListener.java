package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InnerClassListener extends JFrame {
	InnerClassListener() {
		setTitle("Action �̺�Ʈ ������ �ۼ�");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn = new JButton("Action");
		add(btn);
		
		setSize(300,150);
		setVisible(true);
		
		// ��ư�� ���� Ŭ���� MyActionListener�� Action �����ʷ� ����Ѵ�.
		btn.addActionListener(new MyActionListener());
	}
	
	// ���� Ŭ���� �������� Action �����ʸ� �ۼ��Ѵ�.
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action")) 
				b.setText("�׼�");
			else 
				b.setText("Action");
			
			// InnerClassListener�� ����� JFrame�� ����� ȣ���� �� ����
			// ������ Ÿ��Ʋ�� ��ư ���ڿ��� �����Ѵ�.
			setTitle(b.getText());
		}
	}
	
	public static void main(String [] args) {
		new InnerClassListener();
	}
} 



