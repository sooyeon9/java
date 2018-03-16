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

//총괄 프로그램
public class MusicPro extends JFrame{

	public static void main(String[] args) {
		JFrame f = new JFrame("Text Form Example");
		
		f.setTitle("MusicPro"); // 프레임의 타이틀  달기
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램 종료
		f.setLayout(new FlowLayout(FlowLayout.CENTER,100,15));
		JButton show =  new JButton("리스트 보기");
		JButton add =  new JButton("   추가하기   ");
		JButton delete =  new JButton("   삭제하기   ");
		JButton change =  new JButton("   수정하기   ");
		JButton search =  new JButton("   검색하기   ");
		JButton popular =  new JButton("인기곡 찾기");
		f.add(show);
		f.add(add);
		f.add(delete);
		f.add(change);
		f.add(search);
		f.add(popular);
		f.setSize(299, 330); // 프레임 크기
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
    
	
	//추가-----------------------------------------
	
    public static void Adding(boolean a) {

    	MusicManager mm = new MusicManager();
    	mm.datTOlist();
   
        String[] labels = { "          곡명", "          가수명", "          앨범명", "          발매년도", "          인기도(1~5)" };
        int[] widths = { 13, 13, 13, 5, 7 };
        final InputForm form = new InputForm(labels, widths);
        
        JButton submit = new JButton("추가");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String name = form.getText(0);
				String singer = form.getText(1);
				String title = form.getText(2);
				int year = Integer.parseInt(form.getText(3));
				int star = Integer.parseInt(form.getText(4));
				Music new_music = new Music(name, singer, title, year, star);
				mm.getMusics().add(new_music);
                System.out.println(" 곡명 : " + form.getText(0)
                        + "\n 가수명 : " + form.getText(1)
                        + "\n 앨범명 : " + form.getText(2)
                        + "\n 발매년도 : " + form.getText(3)
                        + "\n 인기도 : " + form.getText(4));
                System.out.println("추가완료");
            }
        });
        
 
        JButton save = new JButton("저장");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mm.saveDat();  
                System.out.println("파일에 저장완료");
            }
        });
        //GUI packing과 버튼 추가
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
    
    
  //삭제-----------------------------------------
    
    public static void Deleting(boolean a) {

    	MusicManager mm = new MusicManager();
    	mm.datTOlist();
   
        String[] labels = {"       삭제할 곡명"};
        int[] widths = {13};
        final InputForm form = new InputForm(labels, widths);
        
        JButton del = new JButton("삭제");
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String name = form.getText(0);
            	mm.deleteMusic(name);
            	mm.saveDat();
                System.out.println("삭제완료");
                
            }
        });
        
        //GUI packing과 버튼 추가
        JFrame f = new JFrame("Deleting");
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.add(del);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setSize(300, 150);
        f.setVisible(a); }
    
    
  //수정-----------------------------------------
    
    public static void Changing(boolean a) {

    	MusicManager mm = new MusicManager();
    	mm.datTOlist();
   
        String[] labels = { "         수정할 곡의 리스트 번호","            수정 곡명", "            수정 가수명", "            수정 앨범명", "            수정 발매년도", "            수정 인기도(1~5)" };
        int[] widths = { 5, 13, 13, 13, 5, 7 };
        final InputForm form = new InputForm(labels, widths);
        
        JButton change = new JButton("수정");
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
                System.out.println(" 곡명 : " + form.getText(1)
                        + "\n 가수명 : " + form.getText(2)
                        + "\n 앨범명 : " + form.getText(3)
                        + "\n 발매년도 : " + form.getText(4)
                        + "\n 인기도 : " + form.getText(5));
                System.out.println("수정완료");
                mm.saveDat();
            }
        });
        
        //GUI packing과 버튼 추가
        JFrame f = new JFrame("Changing");
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.add(change);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setSize(380, 300);
        f.setVisible(a); }
    
    
  //검색-----------------------------------------
    
    public static void Searching(boolean a) {

    	MusicManager mm = new MusicManager();
    	mm.datTOlist();
   
    	String[] labels = {"              검색할 항목 선택 후 입력"};
        int[] widths = {13};
        final InputForm form = new InputForm(labels, widths);
        
        ButtonGroup g = new ButtonGroup();
        JRadioButton name = new JRadioButton("곡명",true);
		JRadioButton title = new JRadioButton("앨범명");
		JRadioButton singer = new JRadioButton("가수명");
		JRadioButton year = new JRadioButton("발매년도");
		
		// 버튼 그룹 객체에 4개의 라디오버튼 삽입
		g.add(name);
		g.add(title);
		g.add(singer);
		g.add(year);
		
        JButton search = new JButton("검색");
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
        
        //GUI packing과 버튼 추가
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
    
    
  //인기곡찾기-----------------------------------------
    
    public static void Populars(boolean a) {

    	MusicManager mm = new MusicManager();
    	mm.datTOlist();
   
    	String[] labels = {"            찾고싶은 항목 선택 후 입력"};
        int[] widths = {13};
        final InputForm form = new InputForm(labels, widths);
        
        ButtonGroup g = new ButtonGroup();
        JRadioButton all = new JRadioButton("인기도",true);
        JRadioButton singer = new JRadioButton("가수명");
		JRadioButton year = new JRadioButton("발매년도");
		
		// 버튼 그룹 객체에 2개의 라디오버튼 삽입
		g.add(all);
		g.add(singer);
		g.add(year);
		
        JButton search = new JButton("찾기");
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
        
        //GUI packing과 버튼 추가
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
    
    
  //보여주기-----------------------------------------
    
    public static void Showing(boolean a) {
    	Musics show = new Musics();
    	show.setVisible(a);
    }




}
