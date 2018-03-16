package gui;

import javax.swing.*;
import java.awt.*;

public class CheckBoxEx extends JFrame {
	Container contentPane;
	CheckBoxEx() {
		setTitle("üũ�ڽ� �����  ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		// �̹��� üũ�ڽ��� ����� ���� 2���� �̹��� ��ü�� �����Ѵ�.
		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg"); // ���� �̹���
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg"); // ���� ���¸� ǥ���ϴ� �̹���
		
		// 3 ���� üũ �ڽ� ������Ʈ�� �����Ѵ�.
		JCheckBox apple = new JCheckBox("���");
		JCheckBox pear = new JCheckBox("��", true);
		JCheckBox cherry = new JCheckBox("ü��", cherryIcon);//���� �̹����� ���� üũ�ڽ�
		cherry.setBorderPainted(true); // �̹����� �ܰ����� ���̵��� ����
		cherry.setSelectedIcon(selectedCherryIcon); //���� ���¸� ǥ���ϴ� �̹��� ���
		
		// ����Ʈ�ҿ� 3���� üũ�ڽ� ������Ʈ ����
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


