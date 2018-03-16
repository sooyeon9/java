package javajava;

import java.io.Serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;

//리스트로 목록보여주기
public class Show extends javax.swing.JFrame {

	private javax.swing.JScrollPane scrollpane;
	private javax.swing.JTable tableBook;
	List<Music> musics = new ArrayList<Music>();

	
	public Show(List<Music> musics) {
		initComponents(musics);
	}

	private void initComponents(List<Music> musics) {

		scrollpane = new javax.swing.JScrollPane();
		tableBook = new javax.swing.JTable();

		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("검색된 목록");
		tableBook.setModel(new ListTable(new ArrayList<Music>()));
		scrollpane.setViewportView(tableBook);
		getContentPane().add(scrollpane, java.awt.BorderLayout.CENTER);
		pack();
		
		SwingWorker worker = new SwingWorker() {
			
			@Override
			protected Object doInBackground() throws Exception {

				tableBook.setModel(new ListTable(musics));

				return null;
			}
		};
		worker.execute();
	}
}