package javajava;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;


//dat파일에서 로드해서 목록 보여주기
public class Musics extends javax.swing.JFrame {

	private javax.swing.JButton loadButton;
	private javax.swing.JScrollPane scrollpane;
	private javax.swing.JTable tableBook;
	
	public Musics() {
		initComponents(); }

	
	private void initComponents() {

		scrollpane = new javax.swing.JScrollPane();
		tableBook = new javax.swing.JTable();
		loadButton = new javax.swing.JButton();

		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("저장된 목록");

		tableBook.setModel(new ListTable(new ArrayList<Music>()));
		scrollpane.setViewportView(tableBook);

		getContentPane().add(scrollpane, java.awt.BorderLayout.CENTER);

		loadButton.setText("Load");
		loadButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadButtonActionPerformed(evt);
			}
		});
		getContentPane().add(loadButton, java.awt.BorderLayout.PAGE_END);

		pack();
	}

	private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {

		SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				// test for books
				List<Music> musics = new ArrayList<Music>();
				FileInputStream fin = null;
				ObjectInputStream ois = null;

				try {
					fin = new FileInputStream("musiclist.dat");
					ois = new ObjectInputStream(fin);
					ArrayList list = (ArrayList) ois.readObject();
					for (int i = 0; i < list.size(); i++)
						musics.add((Music) list.get(i));

				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						ois.close();
						fin.close();
					} catch (IOException ioe) {
					}
				}
				

				
				tableBook.setModel(new ListTable(musics));

				return null;
			}
		};
		worker.execute();
	}

	public static void main(String args[]) {

		new Musics().setVisible(true);

	}

}
