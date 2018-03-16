class Queue {
	private Node front = null;
	private Node rear = null;
	private class Node{
		char data;
		Node nextNode;
		Node (char input){
			this.data = input;
			this.nextNode = null;
		}
	}

	public void Enqueue(char data){ 
		Node newnode = new Node(data);
		if(empty()){
			rear = newnode;
			front = newnode;}
		else {
			rear.nextNode=newnode;
			rear=newnode;}
	}
	
	public char Dequeue(){
		if(empty()){
			return 0;}
		else {
			Node delnode = front;
			front=front.nextNode;
			if(front==null)
				rear=null;
			return delnode.data;}
		
	}
	
	public void printQueue(){
		Node printing = front;
		while(printing!=null){
			System.out.print(printing.data);
			printing = printing.nextNode;}
		System.out.println();
	}
	
	
	public boolean empty(){
		return front==null;}
	
}


class Stack {
	private Node top = null;
	private class Node{
		char data;
		Node nextNode;
		Node (char input){
			this.data = input;
			this.nextNode = nextNode;
		}
	}
	
	
	public void push(char input){
		if (top==null){
			 Node newnode = new Node(input);
			 top = newnode;
			 newnode.nextNode = null;}
		else {
			 Node newnode = new Node(input);
			 newnode.nextNode = top;
			 top = newnode;}
	}
	
	
	public char pop(){ //stack�� ��������� ����ó��
		if(top==null){
			return 0;
			}
		else {
			Node del = top;
			top = top.nextNode;
			return del.data;}	
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
}


public class Run{
	public static void bracketCheck(String a){
		Stack st = new Stack();
		Queue qu = new Queue();
		char[] input = a.toCharArray(); //���ڿ��� ���ڹ迭�� ��ȯ
		for(int i=0; i<input.length; i++){
			qu.Enqueue(input[i]);}
		
		while(!qu.empty()){
			char check = qu.Dequeue();
			if(check=='('){
				st.push(check);
				st.printStack();}
			else if(check==')'){
				if(st.pop()=='(')
					;
				else {
					st.push(check);
					st.printStack();
					break;}
				}
			}
		
		if(st.empty()==false)
			System.out.print(a+" : Error \n");
		else
			System.out.print(a+" : ok \n");
		
	}
	
	public static void main(String[] args){
		////�����Ӱ� �ڵ屸��////

		String a1 = "((142+(2+(3-24)))+23)+(1414+(14-11))";
		String a2 = "(142+2(32)4+14((1))4+(1(4-11)";
		String a3 = "(142+2324)+1414)+14";
		String a4 = "(((((())))()()))((((((()))()))(((())((((()))))))))";
				
		bracketCheck(a1);
		bracketCheck(a2);
		bracketCheck(a3);	
		bracketCheck(a4);	
		
		/*Queue bb = new Queue();
		bb.Enqueue('1');
		bb.Enqueue('c');
		bb.Enqueue('3');
		bb.printQueue();
		System.out.println(bb.Dequeue());*/
		
	}

}