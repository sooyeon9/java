package testjava;

import java.util.Scanner;
public class J02 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		J02 obj = new J02();
		
		double score[] = new double[10];
		double total=0;
		
		for(int i=0;i<10;i++){
			System.out.print((i+1)+"�� ° �ɻ������� �Է��Ͻÿ�. : ");
			score[i] = s.nextInt();
			total += score[i];}
		
		double aver = (total-obj.Max(score)-obj.Min(score))/8;
		System.out.println("���� ū ������ ���� ���� ������ ������ 8���� ������ ���� ����� "+aver+"�Դϴ�.");
	}
	
	double Max(double num[]){
		double max=0;
		for(int i=0;i<10;i++){
			if(num[i]>=max){max=num[i];}}
		return max;}
	
	double Min(double num[]){
		double min=1000;
		for(int i=0;i<10;i++){
			if(num[i]<=min){min=num[i];}}
		return min;}
	
	

}
