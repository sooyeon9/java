package javajava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class TextF extends JPanel {
    //TextField�� ���� �迭���� 
    private JTextField[] fields;
    
    // TextForm ������ �޼ҵ�
    public TextF(String[] labels, int[] widths) {
        super(new BorderLayout());
        //label(date,home,away,home_score,away_score)�� ���� panel ���� 
        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        //TextField(�Է��ʵ�)�� ���� Panel ���� 
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
        //���� ���ķ� label panel �߰� 
        add(labelPanel, BorderLayout.WEST);
        //����� ���ķ� field panel �߰� 
        add(fieldPanel, BorderLayout.CENTER);
        //fileds �迭 ũ�� �Ҵ� 
        fields = new JTextField[labels.length];
        //�ݺ�������Ͽ� label�̶� �� �Է� �ޱ����� textfield �߰� 
        for (int i = 0; i < labels.length; i += 1) {
            fields[i] = new JTextField();
            if (i < widths.length)
                fields[i].setColumns(widths[i]);
            JLabel lab = new JLabel(labels[i], JLabel.RIGHT);
            lab.setLabelFor(fields[i]);
            labelPanel.add(lab);
            JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p.add(fields[i]);
            fieldPanel.add(p);
        }
    }

    //textfields���� ����ڰ� �Է��� ���� �޾ƿ������� �Լ� 
    public String getText(int i) {
        return (fields[i].getText());
    }
    
    public static void main(String[] args) {
    	boolean a = false;
    	Scanner s = new Scanner(System.in);
    	System.out.print("1�Ǵ� 0 �Է� : ");
    	int num = s.nextInt();
    	if(num==1){a=true;}
    	start(a);
    }

    public static void start(boolean a) {
    	
    	ArrayList<Score> sl = new ArrayList<Score>();
		String[] team_names = { "�Ｚ", "�λ�", "�Ե�", "SK", "��ȭ", "�ؼ�", "LG",
				"KIA", "NC", "KT" };
		int[] no_team_plays = new int[10];
		int[] no_team_wins = new int[10];
		int[] no_team_loses = new int[10];
		int[] no_team_draws = new int[10];
		double[] no_team_ratios = new double[10];
		ScoreManager sm = new ScoreManager(sl, team_names, no_team_plays,
				no_team_wins, no_team_loses, no_team_draws, no_team_ratios);
    	

		
        //labels �迭 
        String[] labels = { "date", "home", "away", "home_score", "away_scoe" };
        //textfield�� ũ�⸦ ���� �迭 
        int[] widths = { 15, 10, 10, 5, 5 };

        //���� labels�� width�� ������ textform ���� 
        final TextF form = new TextF(labels, widths);
        
        //JButton (add button) ���� 
        JButton submit = new JButton("add");

        //add button�� ���� action event listener �߰� 
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO
                //Score a = new Score()
            	String date = form.getText(0);
				String home_team = form.getText(1);
				String away_team = form.getText(2);
				int home_score = Integer.parseInt(form.getText(3));
				int away_score = Integer.parseInt(form.getText(4));
				Score new_score = new Score((sm.get_sl().size()+1), date, sm.get_team_number(home_team), sm.get_team_number(away_team), home_score, away_score);
				sm.get_sl().add(new_score);
            	
            	
                System.out.println(" date : " + form.getText(0)
                        + "\n home team: " + form.getText(1)
                        + "\n away_team : " + form.getText(2)
                        + "\n home score: " + form.getText(3)
                        + "\n away_score : " + form.getText(4));
             
                sm.listScores();
            }
        });
        //JButton (open button) ����
        //���� ���������� action event listener �߰� 
        JButton open = new JButton("open");
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO
                System.out.println("open button");
                BufferedReader br = null;
				String sCurrentLine;
				try {
					
					br = new BufferedReader(new FileReader("scoredata.txt"));
					while((sCurrentLine = br.readLine())!=null){
						String[] info = sCurrentLine.split(" ");
						int h_score = Integer.parseInt(info[2]);
						int a_score = Integer.parseInt(info[4]);
						Score a = new Score(sm.get_sl().size()+1, info[0], sm.get_team_number(info[1]),
								sm.get_team_number(info[5]), h_score, a_score);
						sm.add_score(a);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(sm.get_sl().size());
            }
        });
        // JButton (save button) ����
        // action event listener �߰� 
        

        
        JButton save = new JButton("save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO
                System.out.println("save button");
                
                BufferedWriter bw = null;
                try {
					bw = new BufferedWriter(new FileWriter("scoredata.txt"));
					for(int i=0; i<sm.get_sl().size(); i++){
						bw.write(sm.get_sl().get(i).get_play_date()+" "+
								sm.get_team_name(sm.get_sl().get(i).get_home_no())+" "+
								sm.get_sl().get(i).get_home_score()+" : "+
								sm.get_sl().get(i).get_away_score()+" "+
								sm.get_team_name(sm.get_sl().get(i).get_away_no_())+"\n");}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        //GUI packing�� ��ư �߰�
        JFrame f = new JFrame("Text Form Example");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.add(open);
        p.add(submit);
        p.add(save);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setSize(300, 300);
        f.setVisible(a);
    }
}