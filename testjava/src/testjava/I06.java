package testjava;


import java.util.Random;
public class I06 {
	
	public static void main(String[] args){
		I06 obj = new I06();
		
		int d = 0, j = 0, s = 0;
		System.out.println("10���� ���ڸ� �����մϴ�.");
		for (int i=0; i<10; i++){
			if (obj.GetRandom() == 0)
				d += 1;
			else if (obj.GetRandom() == 1)
				j += 1;
			else
				s += 1;}
		
		System.out.println();
		System.out.println("1. �� : "+d+"ȸ ����");
		System.out.println("2. �� : "+j+"ȸ ����");
		System.out.println("3. �� : "+s+"ȸ ����");
	}
	
	byte GetRandom(){
		Random r = new Random();
		int num=r.nextInt(100)+1;
		System.out.println("������ ������ ���ڴ� "+num+"�Դϴ�.");
		
		if (num>=70)
			return 0;
		else if (70>num & num>=40)
			return 1;
		else
			return 2;}

		
	}

