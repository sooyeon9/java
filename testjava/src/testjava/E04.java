package testjava;

import java.util.Scanner;
public class E04 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("�������� ��¸�� (1:Ȧ����, 2:¦����)�� �Է��Ͻÿ�.");
		int mode = s.nextInt();
		int i,j;
		if (mode == 1){
			for (i=1;i<=4;i++){
				for (j=1;j<=9;j++){
					if (j==4||j==7){
						System.out.println("");
					}
					System.out.print((2*i+1)+"X"+j+"="+(2*i*j+j)+"   ");	
				}
				
				System.out.println("");
				System.out.println("");
			}
		}
		if (mode == 2){
			for (i=1;i<=4;i++){
				for (j=1;j<=9;j++){
					if (j==4||j==7){
						System.out.println("");
					}
					System.out.print((2*i)+"X"+j+"="+(2*i*j)+"   ");	
				}
				
				System.out.println("");
				System.out.println("");
			}
		}
		
	}

}
