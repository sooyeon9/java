package testjava;

import java.util.Scanner;
public class H06 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		int num[] = new int[5];
		int pow[][] = new int[5][5];
		int max=0;
		int min=999999999;
		int max_a=0, max_b=0;
		int min_a=0, min_b=0;
		int i,j;
		
		System.out.print("2에서 9사이의 숫자 5개를 입력하시오. : ");
		for(i=0;i<5;i++){num[i]=s.nextInt();}
		
		for(i=0;i<5;i++){
			for(j=0;j<5;j++){
				pow[i][j] = (int)Math.pow(num[i], num[j]);}}
		
		for(i=0;i<5;i++){
			for(j=0;j<5;j++){
				if(i!=j){
				if(pow[i][j]>=max){max=pow[i][j];max_a=num[i];max_b=num[j];}
				if(pow[i][j]<=min){min=pow[i][j];min_a=num[i];min_b=num[j];}}}}
		
		System.out.println();
		System.out.println("입력하신 5개의 수로 제곱수를 만들면...");
		System.out.println("가장 큰 수는 "+max_a+"의 "+max_b+"승인 "+max+"입니다.");
		System.out.println("가장 작은 수는 "+min_a+"의 "+min_b+"승인 "+min+"입니다.");
		
	}
}
