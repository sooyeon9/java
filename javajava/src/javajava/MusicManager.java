package javajava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Music��ü ���� �޼ҵ��
public class MusicManager {
	
	Scanner s = new Scanner(System.in);
	ArrayList<Music> Musics = new ArrayList<Music>();
	
	
	//Music��������
	public ArrayList<Music> getMusics(){return Musics;}
	
	
	//�⵵���� �����ϱ�
	public List<Music> LineUp(ArrayList<Music> a){
		List<Music> lineup = new ArrayList<Music>();
		int z = a.size();
		for(int i=0; i<z; i++){
			int maxyear = 0, maxindex=0;
			for(int j=0; j<a.size(); j++){
				if(a.get(j).getYear()>maxyear){
					maxyear = a.get(j).getYear();
					maxindex = j;}}
			lineup.add(a.get(maxindex));
			a.remove(maxindex);}
		
		return lineup;}
	
	
	//����
	public void deleteMusic(String name){
		for(int i=0; i<Musics.size();i++){
			if(name.equals(Musics.get(i).getName())){Musics.remove(i);}} }
	
	public void deleteMusic(int num){Musics.remove(num-1);}
	
	
	//�˻�
	public void findName(String name){
		ArrayList<Music> musics = new ArrayList<Music>();
		for(int i=0; i<Musics.size();i++){
			if(name.equals(Musics.get(i).getName())){
				musics.add(Musics.get(i));}}
		List<Music> lineup = LineUp(musics);
		Show s = new Show(lineup);
		s.setVisible(true);}
	
	public void findTitle(String title){
		List<Music> musics = new ArrayList<Music>();
		for(int i=0; i<Musics.size();i++){
			if(title.equals(Musics.get(i).getTitle())){
				musics.add(Musics.get(i));}}
		Show s = new Show(musics);
		s.setVisible(true);}
	
	public void findSinger(String singer){
		ArrayList<Music> musics = new ArrayList<Music>();
		for(int i=0; i<Musics.size();i++){
			if(singer.equals(Musics.get(i).getSinger())){
				musics.add(Musics.get(i));}}
		List<Music> lineup = LineUp(musics);
		Show s = new Show(lineup);
		s.setVisible(true);}
	
	public void findYear(int year){
		List<Music> musics = new ArrayList<Music>();
		for(int i=0; i<Musics.size();i++){
			if(year == Musics.get(i).getYear()){
				musics.add(Musics.get(i));}}
		Show s = new Show(musics);
		s.setVisible(true);}
	
	
	//�α�� ã��
	public void star(int a){
		ArrayList<Music> musics = new ArrayList<Music>();
		for(int i=0; i<Musics.size();i++){
			if(Musics.get(i).getStar()==a){
				musics.add(Musics.get(i));}}
		List<Music> lineup = LineUp(musics);
		Show s = new Show(lineup);
		s.setVisible(true);}
	
	public void starSinger(String singer){
		ArrayList<Music> musics = new ArrayList<Music>();
		for(int i=0; i<Musics.size();i++){
			if(singer.equals(Musics.get(i).getSinger())){
				if(Musics.get(i).getStar()==5){
					musics.add(Musics.get(i));}}}
		List<Music> lineup = LineUp(musics);
		Show s = new Show(lineup);
		s.setVisible(true);}
	
	public void starYear(int year){
		List<Music> musics = new ArrayList<Music>();
		for(int i=0; i<Musics.size();i++){
			if(year == Musics.get(i).getYear()){
				if(Musics.get(i).getStar()==5){
					musics.add(Musics.get(i));}}}
		Show s = new Show(musics);
		s.setVisible(true);}
	
	
	//���� �� �о����
	public void saveDat(){ //���Ͽ� ����
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try{
			fout = new FileOutputStream("musiclist.dat");
			oos = new ObjectOutputStream(fout); //���� �ִ� ��
			
			oos.writeObject(Musics);
			oos.reset();
	
		}catch(Exception ex){
		}finally{
			try{
				oos.close();
				fout.close();
			}catch(IOException ioe){}
		} }
	
	
	public void readDat(){ //���� �б�
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try{
			fin = new FileInputStream("musiclist.dat");
			ois = new ObjectInputStream(fin); //���� �о���� ��
			
			ArrayList a = (ArrayList)ois.readObject();
			
			System.out.println("���� ����� ��� �뷡�� �Ʒ��� �����ϴ�.");
			for(int i=0; i<a.size();i++){
				System.out.println("["+(i+1)+"] "+a.get(i).toString());}
		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		} }
	
	
	public void datTOlist(){ //������ �о ����Ʈ�� �߰��� -> �����ų �� �ѹ��� �ؾ���
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try{
			fin = new FileInputStream("musiclist.dat");
			ois = new ObjectInputStream(fin); //���� �о���� ��
			
			ArrayList list = (ArrayList)ois.readObject();
			
			for(int i=0; i<list.size();i++){
				Musics.add((Music) list.get(i));}
	
		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		} }
	
	
	
	
	static public void main(String[] args){}


	
}
