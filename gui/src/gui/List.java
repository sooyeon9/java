package gui;

import javax.swing.*;
import java.awt.*;

public class List extends JFrame {
	Container contentPane;
	String [] fruits= {"apple", "banana", "kiwi", "mango", "pear", 
			"peach", "berry", "strawberry", "blackberry"};
	ImageIcon [] images = {new ImageIcon("images/icon1.png"),
			new ImageIcon("images/icon2.png"),
			new ImageIcon("images/icon3.png"),
			new ImageIcon("images/icon4.png")
	};
	List() {
		setTitle("����Ʈ �����  ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		JList strList = new JList(fruits); // ����Ʈ ������Ʈ ����
		contentPane.add(strList);
	
		JList imageList = new JList(); // ����Ʈ ������Ʈ ����
		imageList.setListData(images);
		contentPane.add(imageList);	
		
		JList scrollList = new JList(fruits); // ����Ʈ ������Ʈ ����
		contentPane.add(new JScrollPane(scrollList)); // ����Ʈ�� JScrollPane�� ����

		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new List();
	}
} 




