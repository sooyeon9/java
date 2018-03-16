package javajava;
import java.io.Serializable; //송수신이 가능해짐

public class Book implements Serializable {
	private String isbn;
	private String title;
	private String author;
	private int price;
	private int year;
	private String company;
	private int star;
	
	public Book(String isbn, String title, String author, int price, int year, String company, int star){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.year = year;
		this.company = company;
		this.star = star;
	}
	
	//getter - 가져오기

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getCompany() {
		return company;
	}
	
	public int getStar() {
		return star;
	}

	//setter - 수정하기
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public void setStar(int star) {
		this.star = star;
	}
	
	public String toString(){
		return getIsbn() + "," + getTitle() + "," + getAuthor() + "," + getPrice() + "원," + getYear() + "년," + getCompany() + ",★x" + getStar();
	}

}

