package testjava;

public class J06 {
	int fibo(int n){
		if (n==1 || n==2){return 1;}
		else {return fibo(n-1)+fibo(n-2);}}
	
	
	public static void main(String[] args){
		J06 obj = new J06();
		
		System.out.println("1���� 20���� �Ǻ���ġ ���� ������ �����ϴ�.");
		for(int i=0; i<20; i++){
			System.out.println((i+1)+"��° : "+obj.fibo(i+1));}}

}
