package testjava;

import java.util.Scanner;
public class G07 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("���� �湮�� �� ���� �Է��Ͻÿ�. : ");
		int tim = s.nextInt();
		
		int don1[] = {5000, 10000, 15000, 3000};
		int agenum[] = new int[4];
		int agesum[] = new int[4];
		int membership=0;
		int total=0;
		int totalp=0;
		int i,j;
		
		for(i=0;i<tim;i++){
			System.out.print((i+1)+"���� �ο���(�ʵ��л�,û�ҳ�,�Ϲ�,��δ��)�� �Է��Ͻÿ�. : ");
			int don2=0;
			for(j=0;j<4;j++){
				agenum[j] = s.nextInt();
				agesum[j]+=agenum[j];}
			
			System.out.print((i+1)+"���� ����ī�� ����(ī�����:0, �Ϲݵ��:1, VIP���:2)�� �Է��Ͻÿ�. : ");
			membership = s.nextInt();
			
			for(j=0;j<4;j++){don2 += agenum[j]*don1[j];}
			if(membership==1){don2=don2*90/100;}
			else if(membership==2){don2=don2*80/100;}
			System.out.println((i+1)+"���� ������ "+don2+"�� �Դϴ�.");
			total += don2;}
		
		System.out.println();
		System.out.println("���� �� �湮�� ���� "+(agesum[0]+agesum[1]+agesum[2]+agesum[3])+"�� �Դϴ�.");
		System.out.println("�ʵ��л� ���� "+agesum[0]+"�� �Դϴ�.");
		System.out.println("û�ҳ� ���� "+agesum[1]+"�� �Դϴ�.");
		System.out.println("�Ϲ��� ���� "+agesum[2]+"�� �Դϴ�.");
		System.out.println("��δ�� ���� "+agesum[3]+"�� �Դϴ�.");
		System.out.println();
		System.out.println("�� ������ "+total+"�� �Դϴ�.");
		
	}
}