
public class Stack {
	private Node top = null;
	private class Node{
		int data;
		Node nextNode;
		Node (int input){
			this.data = input;
			this.nextNode = nextNode;
		}
	}
	
	
	public void push(int input){
		if (top==null){
			 Node newnode = new Node(input);
			 top = newnode;
			 newnode.nextNode = null;}
		else {
			 Node newnode = new Node(input);
			 newnode.nextNode = top;
			 top = newnode;}
	}
	
	
	public void pop(){ //stack�� ��������� ����ó��
		if(top==null){
			System.out.println("stack�� ����ֽ��ϴ�.");}
		else {
			System.out.println(top.data);
			top = top.nextNode;}	
	}
	
	
	public boolean empty(){
		if(top == null){return true;}
		else {return false;}
	}
	
	
	public void printStack(){ //����Ʈ�� stack�� ��������� ����ó��
		if(top==null){
			System.out.print("stack�� ����ֽ��ϴ�. ");}
		Node temp = top;
		
		while(temp.nextNode != null){
			System.out.print(temp.data+",");
			temp = temp.nextNode;}
		
		System.out.println(temp.data); //���������� ����Ʈ�ϰ� �ٹٲ�!
	}

	
public static void main(String[] args) {
	Stack st1 = new Stack();
	st1.pop();
	
	// 2�� ����� 5�� push
	for(int i=1; i<6; i++){
		st1.push(i*2);}
	st1.printStack();
	
	// 3�� pop,  push(��1��)
	st1.pop();
	st1.pop();
	st1.pop();
	st1.push(1);
	
	st1.printStack();
}
}
