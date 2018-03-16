package testjava;

public class J06 {
	int fibo(int n){
		if (n==1 || n==2){return 1;}
		else {return fibo(n-1)+fibo(n-2);}}
	
	
	public static void main(String[] args){
		J06 obj = new J06();
		
		System.out.println("1부터 20까지 피보나치 수는 다음과 같습니다.");
		for(int i=0; i<20; i++){
			System.out.println((i+1)+"번째 : "+obj.fibo(i+1));}}

}
