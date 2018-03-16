package testjava;

import java.util.Scanner;
public class B01 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);

		System.out.println("태어난 년도를 입력하세요.");
		int birth_year = s.nextInt();
		int age = 2015 - birth_year + 1;
		
		if(age < 20){
		System.out.println("미성년자입니다.");
		} else {
		System.out.println("미성년자가 아닙니다.");
		}

	}

}
