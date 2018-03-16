package gui;

import javax.swing.*;
import java.awt.*;

public class RadioButtonEx extends JFrame {
	Container contentPane;
	RadioButtonEx() {
		setTitle("������ư �����  ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		 // ��ư �׷� ��ü ����
		ButtonGroup g = new ButtonGroup();
		
		// ������ư 3 �� ����
		JRadioButton apple = new JRadioButton("���");
		JRadioButton pear = new JRadioButton("��", true);
		
		
		// ��ư �׷� ��ü�� 3���� ������ư ����
		g.add(apple);
		g.add(pear);

		// ����Ʈ�ҿ� 3 ���� ������ư ����
		contentPane.add(apple);
		contentPane.add(pear);

		setSize(250,150);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new RadioButtonEx();
	}
} 





