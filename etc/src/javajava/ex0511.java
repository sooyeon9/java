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
		
		Container cn = jf.getContentPane(); //Container은 센터와 노쓰를 조인해주는 클래스
		
		cn.add(new North(), BorderLayout.NORTH); //Layout을 정해주는 메소드 점뒤에 것은 위치를 뜻함
		cn.add(new Center(), BorderLayout.CENTER);
		
		jf.setPreferredSize(new Dimension(500, 300)); //프레임의 크기를 정해줌
	
		jf.pack(); //포장해주어야함
		jf.setVisible(true); //보여주기!	

	}
}


class North extends JPanel{
	
	public North(){
		setLayout(new FlowLayout()); //레이아웃 지정해줌
		add(new JButton("open")); //버튼에 표지를 넣어줌
		add(new JButton("read"));
		add(new JButton("close"));
		setSize(300, 200); //버튼 크기 정함
		setBackground(Color.LIGHT_GRAY); //버튼 색깔 정함
		setVisible(true); //보여주기!
		
	}
}


class Center extends JPanel{
	
	public Center(){
		setLayout(new BorderLayout()); //레이아웃 지정해줌
		add(new JLabel("            Hello"),BorderLayout.NORTH); //라벨에 넣어질 것과 위치 지정
		add(new JLabel("                     Love"),BorderLayout.CENTER);
		add(new JLabel("Java"),BorderLayout.SOUTH);
		setSize(300, 200); //라벨 크기 정함
		setVisible(true); //보여주기!
		
	}
	
}


