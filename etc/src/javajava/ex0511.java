package javajava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ex0511 {
	public static void main(String[] args){
		JFrame jf = new JFrame();
		
		Container cn = jf.getContentPane(); //Container�� ���Ϳ� �뾲�� �������ִ� Ŭ����
		
		cn.add(new North(), BorderLayout.NORTH); //Layout�� �����ִ� �޼ҵ� ���ڿ� ���� ��ġ�� ����
		cn.add(new Center(), BorderLayout.CENTER);
		
		jf.setPreferredSize(new Dimension(500, 300)); //�������� ũ�⸦ ������
	
		jf.pack(); //�������־����
		jf.setVisible(true); //�����ֱ�!	

	}
}


class North extends JPanel{
	
	public North(){
		setLayout(new FlowLayout()); //���̾ƿ� ��������
		add(new JButton("open")); //��ư�� ǥ���� �־���
		add(new JButton("read"));
		add(new JButton("close"));
		setSize(300, 200); //��ư ũ�� ����
		setBackground(Color.LIGHT_GRAY); //��ư ���� ����
		setVisible(true); //�����ֱ�!
		
	}
}


class Center extends JPanel{
	
	public Center(){
		setLayout(new BorderLayout()); //���̾ƿ� ��������
		add(new JLabel("            Hello"),BorderLayout.NORTH); //�󺧿� �־��� �Ͱ� ��ġ ����
		add(new JLabel("                     Love"),BorderLayout.CENTER);
		add(new JLabel("Java"),BorderLayout.SOUTH);
		setSize(300, 200); //�� ũ�� ����
		setVisible(true); //�����ֱ�!
		
	}
	
}


