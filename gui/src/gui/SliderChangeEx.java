package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class SliderChangeEx extends JFrame {
	Container contentPane;	
	JLabel colorLabel;
	JSlider [] sl = new JSlider [3]; // 3���� �����̴� �迭 ����
	SliderChangeEx() {
		setTitle("�����̴��� ChangeEvent ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());		

		colorLabel = new JLabel("        SLIDER EXAMPLE        ");
		
		// �����̴��� 3 �� �����ϰ� ����� �����Ѵ�.
		for(int i=0; i<sl.length; i++) {
			//0~255 ������ ���� ������ �� �ִ� �����̴� ����. �ʱⰪ�� 128
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128); 
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			
			// �����̴��� Change ������ ���
			sl[i].addChangeListener(new MyChangeListener());
			contentPane.add(sl[i]); // �����̴��� ����Ʈ�ҿ� ����
		}
		
		sl[0].setForeground(Color.RED); //s[0] �����̴��� RED �� ����
		sl[1].setForeground(Color.GREEN); //s[1] �����̴��� GREEN �� ����
		sl[2].setForeground(Color.BLUE); //s[0] �����̴��� BLUE �� ����
		colorLabel.setOpaque(true);	// colorLabel�� ������ ��µǵ��� ������ ����
		
		// ���� 3���� �����̴��κ��� ���� ��� �ʱ� colorLabel�� ���� ����
		int r = sl[0].getValue(); // ù��° �����̴��κ��� R ���� �� ���
		int g = sl[1].getValue(); // �ι�° �����̴��κ��� G ���� �� ���
		int b = sl[2].getValue(); // ����° �����̴��κ��� B ���� �� ���
		colorLabel.setBackground(new Color(r,g,b)); // r,g,b ���� �̿��Ͽ� ���ο� �� ����
		
		contentPane.add(colorLabel);		
		setSize(300,230);
		setVisible(true);
	}

	// Change ������ ����
	class MyChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) { //�����̴� ������Ʈ�� ���� ����Ǹ� ȣ���
			// ���� 3���� �����̴��κ��� ���� ��� colorLabel�� ���� ����
			int r = sl[0].getValue(); // ù��° �����̴��κ��� R ���� �� ���
			int g = sl[1].getValue(); // �ι�° �����̴��κ��� G ���� �� ���
			int b = sl[2].getValue(); // ����° �����̴��κ��� B ���� �� ���
			colorLabel.setBackground(new Color(r,g,b)); // r,g,b ���� �̿��Ͽ� ���ο� �� ����
		}
	}
	public static void main(String [] args) {
		new SliderChangeEx();
	}
} 





