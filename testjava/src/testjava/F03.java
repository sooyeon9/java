package testjava;

import java.util.Scanner;
public class F03 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		int jumsu[][] = new int[5][3];
		int kor=0;
		int eng=0; 
		int mat=0;
		int i,j;
		
		for(i=0;i<5;i++){
			System.out.print((i+1)+"번 학생의 국어, 영어, 수학 점수를 입력하시오. : ");
			for(j=0;j<3;j++){
				jumsu[i][j] = s.nextInt();}}
		
		for(i=0;i<5;i++){
			kor += jumsu[i][0];
			eng += jumsu[i][1];
			mat += jumsu[i][2];}
		
		System.out.println("국어의 총점은 "+kor+"이고, 평균은 "+((double)kor/5)+"입니다.");
		System.out.println("영어의 총점은 "+eng+"이고, 평균은 "+((double)eng/5)+"입니다.");
		System.out.println("수학의 총점은 "+mat+"이고, 평균은 "+((double)mat/5)+"입니다.");

	}
}