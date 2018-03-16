package javajava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//�Ѱ� ���α׷�
public class MusicPro extends JFrame{

	public static void main(String[] args) {
		JFrame f = new JFrame("Text Form Example");
		
		f.setTitle("MusicPro"); // �������� Ÿ��Ʋ  �ޱ�
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ �����츦 ������ ���α׷� ����
		f.setLayout(new FlowLayout(FlowLayout.CENTER,100,15));
		JButton show =  new JButton("����Ʈ ����");
		JButton add =  new JButton("   �߰��ϱ�   ");
		JButton delete =  new JButton("   �����ϱ�   ");
		JButton change =  new JButton("   �����ϱ�   ");
		JButton search =  new JButton("   �˻��ϱ�   ");
		JButton popular =  new JButton("�α�� ã��");
		f.add(show);
		f.add(add);
		f.add(delete);
		f.add(change);
		f.add(search);
		f.add(popular);
		f.setSize(299, 330); // ������ ũ��
		f.setVisible(true);
		
		add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Adding(true);}
        });
		
		delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Deleting(true);}
        });
		
		change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Changing(true);}
        });
		
		search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Searching(true);}
        });
		
		popular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Populars(true);}
        });
		
		show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Showing(true);}
        });
		
		
		
		
	}
    
	
	//�߰�-----------------------------------------
	
    public static void Adding(boolean a) {

    	MusicManager mm = new MusicManager();
    	mm.datTOlist();
   
        String[] labels = { "          ���", "          ������", "          �ٹ���", "          �߸ų⵵", "          �α⵵(1~5)" };
        int[] widths = { 13, 13, 13, 5, 7 };
        final InputForm form = new InputForm(labels, widths);
        
        JButton submit = new JButton("�߰�");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String name = form.getText(0);
				String singer = form.getText(1);
				String title = form.getText(2);
				int year = Integer.parseInt(form.getText(3));
				int star = Integer.parseInt(form.getText(4));
				Music new_music = new Music(name, singer, title, year, star);
				mm.getMusics().add(new_music);
                System.out.println(" ��� : " + form.getText(0)
                        + "\n ������ : " + form.getText(1)
                        + "\n �ٹ��� : " + form.getText(2)
                        + "\n �߸ų⵵ : " + form.getText(3)
                        + "\n �α⵵ : " + form.getText(4));
                System.out.println("�߰��Ϸ�");
            }
        });
        
 
        JButton save = new JButton("����");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mm.saveDat();  
                System.out.println("���Ͽ� ����Ϸ�");
            }
        });
        //GUI packing�� ��ư �߰�
        JFrame f = new JFrame("Adding");
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.add(submit);
        p.add(save);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setSize(340, 280);
        f.setVisible(a); }
    
    
  //����-----------------------------------------
    
    public static void Deleting(boolean a) {

    	MusicManager mm = new MusicManager();
    	mm.datTOlist();
   
        String[] labels = {"       ������ ���"};
        int[] widths = {13};
        final InputForm form = new InputForm(labels, widths);
        
        JButton del = new JButton("����");
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String name = form.getText(0);
            	mm.deleteMusic(name);
            	mm.saveDat();
                System.out.println("�����Ϸ�");
                
            }
        });
        
        //GUI packing�� ��ư �߰�
        JFrame f = new JFrame("Deleting");
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.add(del);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setSize(300, 150);
        f.setVisible(a); }
    
    
  //����-----------------------------------------
    
    public static void Changing(boolean a) {

    	MusicManager mm = new MusicManager();
    	mm.datTOlist();
   
        String[] labels = { "         ������ ���� ����Ʈ ��ȣ","            ���� ���", "            ���� ������", "            ���� �ٹ���", "            ���� �߸ų⵵", "            ���� �α⵵(1~5)" };
        int[] widths = { 5, 13, 13, 13, 5, 7 };
        final InputForm form = new InputForm(labels, widths);
        
        JButton change = new JButton("����");
        change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int num = Integer.parseInt(form.getText(0));
            	mm.deleteMusic(num);
            	String name = form.getText(1);
				String singer = form.getText(2);
				String title = form.getText(3);
				int year = Integer.parseInt(form.getText(4));
				int star = Integer.parseInt(form.getText(5));
				Music new_music = new Music(name, singer, title, year, star);
				mm.getMusics().add(new_music);
                System.out.println(" ��� : " + form.getText(1)
                        + "\n ������ : " + form.getText(2)
                        + "\n �ٹ��� : " + form.getText(3)
                        + "\n �߸ų⵵ : " + form.getText(4)
                        + "\n �α⵵ : " + form.getText(5));
                System.out.println("�����Ϸ�");
                mm.saveDat();
            }
        });
        
        //GUI packing�� ��ư �߰�
        JFrame f = new JFrame("Changing");
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.add(change);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setSize(380, 300);
        f.setVisible(a); }
    
    
  //�˻�-----------------------------------------
    
    public static void Searching(boolean a) {

    	MusicManager mm = new MusicManager();
    	mm.datTOlist();
   
    	String[] labels = {"              �˻��� �׸� ���� �� �Է�"};
        int[] widths = {13};
        final InputForm form = new InputForm(labels, widths);
        
        ButtonGroup g = new ButtonGroup();
        JRadioButton name = new JRadioButton("���",true);
		JRadioButton title = new JRadioButton("�ٹ���");
		JRadioButton singer = new JRadioButton("������");
		JRadioButton year = new JRadioButton("�߸ų⵵");
		
		// ��ư �׷� ��ü�� 4���� ������ư ����
		g.add(name);
		g.add(title);
		g.add(singer);
		g.add(year);
		
        JButton search = new JButton("�˻�");
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(name.isSelected()){
            		String n = form.getText(0);
            		mm.findName(n);}
        		else if(title.isSelected()){
        			String t = form.getText(0);
        			mm.findTitle(t);}
        		else if(singer.isSelected()){
        			String s = form.getText(0);
        			mm.findSinger(s);}
        		else {
        			int y = Integer.parseInt(form.getText(0));
        			mm.findYear(y);}
            }
        });
        
        //GUI packing�� ��ư �߰�
        JFrame f = new JFrame("Searching");
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        JPanel q = new JPanel();
        q.add(name);
		q.add(title);
		q.add(singer);
		q.add(year);
        p.add(search);
        f.add(q, BorderLayout.NORTH);
        f.add(p, BorderLayout.SOUTH);
        f.getContentPane().add(form, BorderLayout.CENTER);
        f.pack();
        f.setSize(400, 165);
        f.setVisible(a);}
    
    
  //�α��ã��-----------------------------------------
    
    public static void Populars(boolean a) {

    	MusicManager mm = new MusicManager();
    	mm.datTOlist();
   
    	String[] labels = {"            ã����� �׸� ���� �� �Է�"};
        int[] widths = {13};
        final InputForm form = new InputForm(labels, widths);
        
        ButtonGroup g = new ButtonGroup();
        JRadioButton all = new JRadioButton("�α⵵",true);
        JRadioButton singer = new JRadioButton("������");
		JRadioButton year = new JRadioButton("�߸ų⵵");
		
		// ��ư �׷� ��ü�� 2���� ������ư ����
		g.add(all);
		g.add(singer);
		g.add(year);
		
        JButton search = new JButton("ã��");
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(all.isSelected()){
            		int a = Integer.parseInt(form.getText(0));
            		mm.star(a);}
            	else if(singer.isSelected()){
            		String s = form.getText(0);
            		mm.starSinger(s);}
        		else {
        			int y = Integer.parseInt(form.getText(0));
        			mm.starYear(y);}
            }
        });
        
        //GUI packing�� ��ư �߰�
        JFrame f = new JFrame("Populars");
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        JPanel q = new JPanel();
        q.add(all);
        q.add(singer);
		q.add(year);
        p.add(search);
        f.add(q, BorderLayout.NORTH);
        f.add(p, BorderLayout.SOUTH);
        f.getContentPane().add(form, BorderLayout.CENTER);
        f.pack();
        f.setSize(400, 165);
        f.setVisible(a);}
    
    
  //�����ֱ�-----------------------------------------
    
    public static void Showing(boolean a) {
    	Musics show = new Musics();
    	show.setVisible(a);
    }




}
