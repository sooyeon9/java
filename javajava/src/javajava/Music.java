package javajava;

import java.io.Serializable;

//±âº» °´Ã¼
public class Music implements Serializable {
	
	private String name;
	private String singer;
	private String title;
	private int year;
	private int star;
	
	
	public Music(String name, String singer, String title, int year, int star){
		this.name = name;
		this.singer = singer;
		this.title = title;
		this.year = year;
		this.star = star;}
	
	//getter
	public String getTitle() {return title;}
	public String getSinger() {return singer;}
	public String getName() {return name;}
	public int getYear() {return year;}
	public int getStar() {return star;}
	
	//setter
	public void setTitle(String title) {this.title = title;}
	public void setSinger(String singer) {this.singer = singer;}
	public void setName(String name) {this.name = name;}
	public void setYear(int year) {this.year = year;}
	public void setStar(int star) {this.star = star;}
	
	
	public String toString(){
		return getName() +","+ getSinger() +","+ getTitle() +","+ getYear() +"³â,¡Úx"+ getStar();}
	
	
	

}
