package testjava;

import java.util.Scanner;
public class E05 {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("구구단의 출력모드 (1:홀수단, 2:짝수단)을 입력하시오.");
		int mode = s.nextInt();
		System.out.println("한줄에 출력할 갯수를 입력하시오.");
		int column = s.nextInt();
		int i,j;
		if (mode == 1){
			for (i=1;i<=column+1;i++){
				for (j=1;j<=9;j++){
					if (j==column+1||j==2*column+1){
						System.out.println("");
					}
					System.out.print((2*i+1)+"X"+j+"="+(2*i*j+j)+"   ");	
				}
				
				System.out.println("");
				System.out.println("");
			}
		}
		if (mode == 2){
			for (i=1;i<=column+1;i++){
				for (j=1;j<=9;j++){
					if (j==column+1||j==2*column+1){
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
