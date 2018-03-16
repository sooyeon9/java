package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SwingAPIEx extends JFrame {
	Container contentPane;
	JButton b1, b2, b3, b4; // 4 ���� ��ư
	
	SwingAPIEx() {
		setTitle("Swing ���� �޼ҵ� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		// ��ġ�� ũ�� ���� ��ư ����
		b1 = new JButton("��ġ�� ũ�� ����");
		b1.addActionListener(new MyButtonListener());
		contentPane.add(b1);

		// ��� ���� ��ư ����
		b2 = new JButton("��� ����");
		b2.setOpaque(true); // ���� ������  �����ϵ��� ����
		b2.setForeground(Color.MAGENTA);
		b2.setBackground(Color.YELLOW);
		b2.setFont(new Font("���ü", Font.ITALIC, 20));//���ü 20�ȼ� ��Ʈ ����		
		b2.addActionListener(new MyButtonListener());
		contentPane.add(b2);

		// �۵����� �ʴ� ��ư ����
		b3 = new JButton("�۵����� �ʴ� ��ư");
		b3.setEnabled(false); // Ŭ���ص� ���������� ����
		b3.addActionListener(new MyButtonListener()); // Action �����ʿ� �̺�Ʈ �߻����� ����
		contentPane.add(b3);

		// �����/���̱� ��� ��ư ����
		b4 = new JButton("�����/���̱�");
		b4.addActionListener(new MyButtonListener());
		contentPane.add(b4);
		
		setSize(250,200);		
		setVisible(true);
	}
	
	// ��ư�� ��ϵ� Action ������ ����
	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); // ���õ� ��ư�� �ּ� �˾Ƴ���
			
			// source�� � ��ư���� �����ϰ� �̺�Ʈ ó��
			if(source == b1) { // "��ġ�� ũ�� ����" ��ư�� ���õ� ���
				System.out.println("��ư�� ��ġ�� ũ��");
				System.out.println("��ġ = (" + b1.getX() + "," + b1.getY() + ")");
				System.out.println("ũ�� = (" + b1.getWidth() + "x" + b1.getHeight() + ")");
				
				JPanel c = (JPanel)b2.getParent();// �θ� �����̳��� �ּҸ� �˾Ƴ���. �θ�� ����Ʈ�� 
				System.out.println("����Ʈ���� ��ġ�� ũ��");
				System.out.println("��ġ = (" + c.getX() + "," + c.getY() + ")");
				System.out.println("ũ�� = (" + c.getWidth() + "x" + c.getHeight() + ")");				
			}
			else if(source == b2) { // "��� ����" ��ư�� ���õ� ���
				System.out.println("��Ʈ = " + b2.getFont()); // ��Ʈ �̸� ���
				System.out.println("���� = " + b2.getBackground()); //���� ���
				System.out.println("���ڻ� = " + b2.getForeground());	//���ڻ� ���			
			}
			else {  // "�����/���̱�" ��ư�� ���õ� ���
				if(b1.isVisible()) { // ���� �ٸ� ��ư�� ���̴� �����̸� ��� ������ �ʰ� �Ѵ�.
					b1.setVisible(false);
					b2.setVisible(false);
					b3.setVisible(false);
				}
				else { // ���� �ٸ� ��ư�� �������ʴ� �����̸� ��� ���̰� �Ѵ�.
					b1.setVisible(true);
					b2.setVisible(true);
					b3.setVisible(true);					
				}
			}
			// "�۵����� �ʴ� ��ư"�� ���� Action �̺�Ʈ�� �߻����� �ʴ´�.
		}
	}
	
	public static void main(String [] args) {
		new SwingAPIEx();
	}
} 
