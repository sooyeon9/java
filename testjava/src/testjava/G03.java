package testjava;

import java.util.Scanner;
public class G03 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		int jumsu[][] = new int[5][3];
		int total[] = new int[5];
		String grade[] = new String[5];
		int kor=0,eng=0,mat=0;
		int i,j;
		
		for(i=0;i<5;i++){
			System.out.print((i+1)+"번 학생의 국어, 영어, 수학 점수를 입력하시오. : ");
			for(j=0;j<3;j++){
				jumsu[i][j] = s.nextInt();}}
		
		System.out.println();
		System.out.println("1) 각 과목별 총점과 평균 점수");
		for(i=0;i<5;i++){
			kor += jumsu[i][0];
			eng += jumsu[i][1];
			mat += jumsu[i][2];}
		System.out.println("국어의 총점은 "+kor+"이고, 평균은 "+((double)kor/5)+"입니다.");
		System.out.println("영어의 총점은 "+eng+"이고, 평균은 "+((double)eng/5)+"입니다.");
		System.out.println("수학의 총점은 "+mat+"이고, 평균은 "+((double)mat/5)+"입니다.");
		
		System.out.println();
		System.out.println("2) 각 학생별 총점과 평균 점수");
		for(i=0;i<5;i++){
			for(j=0;j<3;j++){total[i] += jumsu[i][j];}
			double aver = ((double)total[i]/3);
			if(90<=aver){grade[i]="A";}
			else if(80<=aver & aver<90){grade[i]="B";}
			else if(70<=aver & aver<80){grade[i]="C";}
			else if(60<=aver & aver<70){grade[i]="D";}
			else {grade[i]="F";}	
			System.out.println((i+1)+"번 학생 점수 : 총점"+total[i]+", 평균"+aver+", 등급"+grade[i]);
		}

		
	}
}
