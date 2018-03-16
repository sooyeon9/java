package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBoxItemEventEx extends JFrame {
	Container contentPane;
	JCheckBox [] fruits = new JCheckBox [3]; // üũ�ڽ� �迭
	String [] names = {"���", "��", "ü��"}; // üũ�ڽ� ���ڿ��� ����� ���ڿ� �迭
	JLabel sumLabel; // ��� ���� ����� ���̺�
	int sum = 0; // ������ ��
	
	CheckBoxItemEventEx() {
		setTitle("üũ�ڽ��� ItemEvent  ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		contentPane.add(new JLabel("���  100��, �� 500��, ü�� 20000��"));
		
		// 3���� üũ�ڽ� ������Ʈ�� �����ϰ� ����Ʈ�ҿ� ����, Item ������ ���
		for(int i=0; i<fruits.length; i++) { // fruits.length=3
			fruits[i] = new JCheckBox(names[i]); // �迭 names[]�� ���ڿ��� üũ�ڽ� ����
			fruits[i].setBorderPainted(true); // üũ�ڽ��� �ܰ����� ���̵��� ����
			contentPane.add(fruits[i]); // üũ�ڽ� ������Ʈ�� ����Ʈ�ҿ� ����
			fruits[i].addItemListener(new MyItemListener()); // üũ�ڽ��� Item ������ ���
		}
		
		sumLabel = new JLabel("���� 0 �� �Դϴ�."); // ���� ���� ����ϴ� ���̺� ����
		contentPane.add(sumLabel);
		
		setSize(250,200);
		setVisible(true);
	}
	
	// Item ������ ����
	class MyItemListener implements ItemListener {
		// üũ�ڽ��� ���� ���°� ���ϸ� itemStateChanged()�� ȣ���
		public void itemStateChanged(ItemEvent e) {
			int selected=1; // 1�̸� ���� ����, -1�̸� ���� ����
			
			// ���� �������� �Ǻ�
			if(e.getStateChange() == ItemEvent.SELECTED)
				selected = 1; // ���� ���� �ǹ�
			else
				selected = -1; // ���� ���� �ǹ�
			
			// � üũ �ڽ����� �Ǻ�
			if(e.getItem() == fruits[0]) // ��� üũ�ڽ� 
				sum = sum + selected*100;
			else if(e.getItem() == fruits[1]) // �� üũ�ڽ�
				sum = sum + selected*500;
			else // ü�� ü�׹ڽ�
				sum = sum + selected*20000;
			
			sumLabel.setText("���� "+sum+"�� �Դϴ�."); // �� ���
		}
	}
	public static void main(String [] args) {
		new CheckBoxItemEventEx();
	}
} 