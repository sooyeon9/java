package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RadioButtonItemEventEx extends JFrame {
	Container contentPane;
	JRadioButton [] radio = new JRadioButton [3];// ������ư �迭
	String [] text = {"���", "��", "ü��"}; // ������ư�� ���ڿ�
	ImageIcon [] image = {  // �̹��� ��ü �迭
			new ImageIcon("images/apple.jpg"), 
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg")};
	JLabel imageLabel = new JLabel(); // �̹����� ��µ� ���̺� ������Ʈ
	
	RadioButtonItemEventEx() {
		setTitle("������ư Item Event ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel radioPanel = new JPanel(); // 3 ���� ������ư�� ������ �г�
		radioPanel.setBackground(Color.GRAY);
		
		ButtonGroup g = new ButtonGroup(); // ��ư �׷� ��ü ����
		for(int i=0; i<radio.length; i++) { // 3 ���� ������ư�� ����
			radio[i] = new JRadioButton(text[i]); //  ����
			g.add(radio[i]); // ��ư �׷쿡 ����
			radioPanel.add(radio[i]); // �гο� ����
			radio[i].addItemListener(new MyItemListener()); // ������ư�� Item ������ ���
		}
		
		radio[2].setSelected(true); // ü�� ������ư�� �ʱ� ���û��·� ����
		contentPane.add(radioPanel, BorderLayout.NORTH); // ����Ʈ�ҿ� �����г� ����
		contentPane.add(imageLabel, BorderLayout.CENTER); // ����Ʈ�ҿ� �̹��� ���̺� ����
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // �̹����� �߾�����
		
		setSize(250,200);		
		setVisible(true);
	}
	
	// Item ������ ����
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.DESELECTED)  
				return; // ������ư�� ���������� ��� �׳� �����Ѵ�.
			if(radio[0].isSelected()) // ��� ������ư�� ���õ� ���
				imageLabel.setIcon(image[0]);
			else if(radio[1].isSelected()) // �� ������ư�� ���õ� ���
				imageLabel.setIcon(image[1]);
			else // ü�� ������ư�� ���õ� ���
				imageLabel.setIcon(image[2]);
		}
	}
	
	public static void main(String [] args) {
		new RadioButtonItemEventEx();
	}
} 








