package testjava;

import java.util.Scanner;
public class G07 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("오늘 방문한 팀 수를 입력하시오. : ");
		int tim = s.nextInt();
		
		int don1[] = {5000, 10000, 15000, 3000};
		int agenum[] = new int[4];
		int agesum[] = new int[4];
		int membership=0;
		int total=0;
		int totalp=0;
		int i,j;
		
		for(i=0;i<tim;i++){
			System.out.print((i+1)+"번팀 인원수(초등학생,청소년,일반,경로대상)를 입력하시오. : ");
			int don2=0;
			for(j=0;j<4;j++){
				agenum[j] = s.nextInt();
				agesum[j]+=agenum[j];}
			
			System.out.print((i+1)+"번팀 할인카드 종류(카드없음:0, 일반등급:1, VIP등급:2)를 입력하시오. : ");
			membership = s.nextInt();
			
			for(j=0;j<4;j++){don2 += agenum[j]*don1[j];}
			if(membership==1){don2=don2*90/100;}
			else if(membership==2){don2=don2*80/100;}
			System.out.println((i+1)+"번팀 입장료는 "+don2+"원 입니다.");
			total += don2;}
		
		System.out.println();
		System.out.println("오늘 총 방문자 수는 "+(agesum[0]+agesum[1]+agesum[2]+agesum[3])+"명 입니다.");
		System.out.println("초등학생 수는 "+agesum[0]+"명 입니다.");
		System.out.println("청소년 수는 "+agesum[1]+"명 입니다.");
		System.out.println("일반인 수는 "+agesum[2]+"명 입니다.");
		System.out.println("경로대상 수는 "+agesum[3]+"명 입니다.");
		System.out.println();
		System.out.println("총 입장료는 "+total+"원 입니다.");
		
	}
}