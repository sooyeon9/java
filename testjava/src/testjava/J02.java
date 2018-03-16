package testjava;

import java.util.Scanner;
public class J02 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		J02 obj = new J02();
		
		double score[] = new double[10];
		double total=0;
		
		for(int i=0;i<10;i++){
			System.out.print((i+1)+"번 째 심사점수를 입력하시오. : ");
			score[i] = s.nextInt();
			total += score[i];}
		
		double aver = (total-obj.Max(score)-obj.Min(score))/8;
		System.out.println("가장 큰 점수와 가장 작은 점수를 제외한 8개의 점수에 대한 평균은 "+aver+"입니다.");
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
