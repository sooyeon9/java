package javajava;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class Books extends javax.swing.JFrame {

	/**
	 * Creates new form Students
	 */
	public Books() {
		initComponents();
	}

	private void initComponents() {

		scrollpane = new javax.swing.JScrollPane();
		tableBook = new javax.swing.JTable();
		loadButton = new javax.swing.JButton();
		addButton = new javax.swing.JButton();
		
		JPanel j = new JPanel(new GridLayout());
		
		j.add(addButton);
		j.add(loadButton);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Book Management System");

		tableBook.setModel(new BookTableModel(new ArrayList<Book>()));
		scrollpane.setViewportView(tableBook);

		getContentPane().add(scrollpane, java.awt.BorderLayout.CENTER);

		loadButton.setText("Load");
		loadButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadButtonActionPerformed(evt);
			}
		});
		
		addButton.setText("add");
		addButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Adding(true);
			}
		});

		getContentPane().add(j, java.awt.BorderLayout.PAGE_END);
		//getContentPane().add(loadButton, java.awt.BorderLayout.PAGE_END);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	
	private void Adding(boolean a) {

    	BookManager bm = new BookManager();
    	bm.datTOlist();
   
        String[] labels = { "          isbn코드", "          책제목", "          저자명", "          가격(원)", "          출판년도","          출판사","          인기도(1~5)" };
        int[] widths = { 7, 13, 13, 7, 5, 7, 3 };
        final BookAddForm form = new BookAddForm(labels, widths);
        
        JButton submit = new JButton("추가");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String isbn = form.getText(0);
				String title = form.getText(1);
				String author = form.getText(2);
				int price = Integer.parseInt(form.getText(3));
				int year = Integer.parseInt(form.getText(4));
				String company = form.getText(5);
				int star = Integer.parseInt(form.getText(6));
				Book new_music = new Book(isbn, title, author, price, year, company, star);
				bm.getMusics().add(new_music);
                System.out.println(" isbn코드 : " + form.getText(0)
                        + "\n 책제목 : " + form.getText(1)
                        + "\n 저자명 : " + form.getText(2)
                        + "\n 가격(원) : " + form.getText(3)
                        + "\n 출판년도 : " + form.getText(4)
                        + "\n 출판사 : " + form.getText(5)
                        + "\n 인기도 : " + form.getText(6));
                System.out.println("추가완료");
            }
        });
        JButton save = new JButton("저장");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bm.saveF();  
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
        f.setSize(330, 330);
        f.setVisible(a); }
	
	private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_okButtonActionPerformed
		// And this is where the magic happens.

		SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				// test for books
				List<Book> books = new ArrayList<Book>();
				FileInputStream fin = null;
				ObjectInputStream ois = null;

				try {
					fin = new FileInputStream("booklist.dat");
					ois = new ObjectInputStream(fin);
					ArrayList list = (ArrayList) ois.readObject();
					for (int i = 0; i < list.size(); i++)
						books.add((Book) list.get(i));

				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						ois.close();
						fin.close();
					} catch (IOException ioe) {
					}
				}
				tableBook.setModel(new BookTableModel(books));

				return null;
			}
		};
		worker.execute();
	}

	public static void main(String args[]) {

		/* Create and display the form */
		new Books().setVisible(true);

	}

	private javax.swing.JButton loadButton;
	private javax.swing.JButton addButton;
	private javax.swing.JScrollPane scrollpane;
	private javax.swing.JTable tableBook;

}

