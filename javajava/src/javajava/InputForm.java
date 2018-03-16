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
    //TextField(�Է��ʵ�)�� ���� �迭���� 
    private JTextField[] fields;
    
    public InputForm(String[] labels, int[] widths) {
        super(new BorderLayout());
        
        //label�� ���� panel ���� 
        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        //TextField�� ���� Panel ���� 
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));

        add(labelPanel, BorderLayout.WEST);
        add(fieldPanel, BorderLayout.CENTER);
        
        //�� �Է��ʵ� ũ�� �Ҵ� 
        fields = new JTextField[labels.length];
        
        //�� label�� TextField �߰� 
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

    //�Է��ʵ忡�� ����ڰ� �Է��� ���� �޾ƿ��� �Լ� 
    public String getText(int i) {
        return (fields[i].getText()); }
    
    

}

