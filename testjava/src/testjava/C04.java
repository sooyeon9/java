package testjava;

import java.util.Scanner;
public class C04 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("아파트의 분양면적(제곱미터)를 입력하시오. ");
		double area = s.nextDouble();
		double pyung = area / 3.305;
		
		System.out.println("아파트의 평형은 " + pyung + "입니다.");
		if(pyung < 15){System.out.println("소형 아파트 입니다.");}
		else if(15<=pyung & pyung<30){System.out.println("중소형 아파트 입니다.");}
		else if(30<=pyung & pyung<50){System.out.println("중형 아파트 입니다.");}
		else{System.out.println("대형 아파트 입니다.");}

	}

}
