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
			System.out.print((i+1)+"�� �л��� ����, ����, ���� ������ �Է��Ͻÿ�. : ");
			for(j=0;j<3;j++){
				jumsu[i][j] = s.nextInt();}}
		
		System.out.println();
		System.out.println("1) �� ���� ������ ��� ����");
		for(i=0;i<5;i++){
			kor += jumsu[i][0];
			eng += jumsu[i][1];
			mat += jumsu[i][2];}
		System.out.println("������ ������ "+kor+"�̰�, ����� "+((double)kor/5)+"�Դϴ�.");
		System.out.println("������ ������ "+eng+"�̰�, ����� "+((double)eng/5)+"�Դϴ�.");
		System.out.println("������ ������ "+mat+"�̰�, ����� "+((double)mat/5)+"�Դϴ�.");
		
		System.out.println();
		System.out.println("2) �� �л��� ������ ��� ����");
		for(i=0;i<5;i++){
			for(j=0;j<3;j++){total[i] += jumsu[i][j];}
			double aver = ((double)total[i]/3);
			if(90<=aver){grade[i]="A";}
			else if(80<=aver & aver<90){grade[i]="B";}
			else if(70<=aver & aver<80){grade[i]="C";}
			else if(60<=aver & aver<70){grade[i]="D";}
			else {grade[i]="F";}	
			System.out.println((i+1)+"�� �л� ���� : ����"+total[i]+", ���"+aver+", ���"+grade[i]);
		}

		
	}
}
