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
			System.out.print((i+1)+"�� �л��� ����, ����, ���� ������ �Է��Ͻÿ�. : ");
			for(j=0;j<3;j++){
				jumsu[i][j] = s.nextInt();}}
		
		for(i=0;i<5;i++){
			kor += jumsu[i][0];
			eng += jumsu[i][1];
			mat += jumsu[i][2];}
		
		System.out.println("������ ������ "+kor+"�̰�, ����� "+((double)kor/5)+"�Դϴ�.");
		System.out.println("������ ������ "+eng+"�̰�, ����� "+((double)eng/5)+"�Դϴ�.");
		System.out.println("������ ������ "+mat+"�̰�, ����� "+((double)mat/5)+"�Դϴ�.");

	}
}