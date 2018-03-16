package javajava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Music객체 관리 메소드들
public class MusicManager {
	
	Scanner s = new Scanner(System.in);
	ArrayList<Music> Musics = new ArrayList<Music>();
	
	
	//Music가져오기
	public ArrayList<Music> getMusics(){return Musics;}
	
	
	//년도별로 정렬하기
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
	
	
	//삭제
	public void deleteMusic(String name){
		for(int i=0; i<Musics.size();i++){
			if(name.equals(Musics.get(i).getName())){Musics.remove(i);}} }
	
	public void deleteMusic(int num){Musics.remove(num-1);}
	
	
	//검색
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
	
	
	//인기곡 찾기
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
	
	
	//저장 및 읽어오기
	public void saveDat(){ //파일에 저장
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try{
			fout = new FileOutputStream("musiclist.dat");
			oos = new ObjectOutputStream(fout); //파일 넣는 것
			
			oos.writeObject(Musics);
			oos.reset();
	
		}catch(Exception ex){
		}finally{
			try{
				oos.close();
				fout.close();
			}catch(IOException ioe){}
		} }
	
	
	public void readDat(){ //파일 읽기
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try{
			fin = new FileInputStream("musiclist.dat");
			ois = new ObjectInputStream(fin); //파일 읽어오는 것
			
			ArrayList a = (ArrayList)ois.readObject();
			
			System.out.println("현재 저장된 모든 노래는 아래와 같습니다.");
			for(int i=0; i<a.size();i++){
				System.out.println("["+(i+1)+"] "+a.get(i).toString());}
		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		} }
	
	
	public void datTOlist(){ //파일을 읽어서 리스트에 추가함 -> 실행시킬 때 한번만 해야함
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try{
			fin = new FileInputStream("musiclist.dat");
			ois = new ObjectInputStream(fin); //파일 읽어오는 것
			
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
