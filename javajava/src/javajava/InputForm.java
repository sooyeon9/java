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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InputForm extends JPanel{
    //TextField(입력필드)를 위한 배열선언 
    private JTextField[] fields;
    
    public InputForm(String[] labels, int[] widths) {
        super(new BorderLayout());
        
        //label을 위한 panel 생성 
        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        //TextField를 위한 Panel 생성 
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));

        add(labelPanel, BorderLayout.WEST);
        add(fieldPanel, BorderLayout.CENTER);
        
        //각 입력필드 크기 할당 
        fields = new JTextField[labels.length];
        
        //각 label에 TextField 추가 
        for (int i = 0; i < labels.length; i += 1) {
            fields[i] = new JTextField();
            if (i < widths.length)
                fields[i].setColumns(widths[i]);
            JLabel lab = new JLabel(labels[i], JLabel.RIGHT);
            lab.setLabelFor(fields[i]);
            labelPanel.add(lab);
            JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p.add(fields[i]);
            fieldPanel.add(p); }
    }

    //입력필드에서 사용자가 입력한 값을 받아오는 함수 
    public String getText(int i) {
        return (fields[i].getText()); }
    
    

}

