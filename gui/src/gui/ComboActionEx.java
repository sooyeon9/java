package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ComboActionEx extends JFrame {
	Container contentPane;
	String [] fruits = {"apple", "banana", "kiwi", "mango"}; // �޺��ڽ��� ������
	ImageIcon [] images = { // �̹��� ��ü �迭
			new ImageIcon("../images/apple.jpg"),
			new ImageIcon("../images/banana.jpg"),
			new ImageIcon("../images/kiwi.jpg"),
			new ImageIcon("../images/mango.jpg")};
	JLabel imgLabel = new JLabel(images[0]); // �̹��� ���̺� ������Ʈ ����
	
	ComboActionEx() {
		setTitle("�޺��ڽ� Ȱ��  ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		JComboBox strCombo = new JComboBox(fruits); // �޺��ڽ� ����
		// Action ������ ���
		strCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource(); // Action �̺�Ʈ�� �߻��� �޺��ڽ� �˾Ƴ���
				int index = cb.getSelectedIndex(); // �޺��ڽ��� ���õ� �������� �ε��� ��ȣ �˾Ƴ���
				imgLabel.setIcon(images[index]); // �ε����� �̹����� �̹��� ���̺� ������Ʈ�� ���
			}
		});
		contentPane.add(strCombo);
		contentPane.add(imgLabel);
		
		setSize(300,250);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new ComboActionEx();
	}
} 



