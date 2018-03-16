

class DCLinkedList{
	private Node head;
	private int count; // ����Ʈ�� ��尹��
	private class Node{
		int data;
		Node next;
		Node prev;
		Node(int input){
			this.data = input;
			this.next = null;
			this.prev = null;}
	}
	
	public Node findnode(int i){  //Ư�� ��带 ã�Ƽ� ����
		Node a = head;
		for(int k=0; k<i; k++){a = a.next;}
			return a;
	}
	
	
	public void insert(int position, int input){ //�����͸� �޾� position�� �� ��� �߰�
		if(position==0){
			Node newadd = new Node(input);
			newadd.next = head;
			if(head != null)
				head.prev = newadd;
			head = newadd;
			count++;
		}
		else {
			Node temp1 = findnode(position-1);
			Node temp2 = temp1.next;
			Node newadd = new Node(input);
			temp1.next = newadd;
			newadd.next = temp2;
			if (temp2 != null)
				temp2.prev = newadd;
			newadd.prev = temp1;
			count++;
		}
	}
	
	
	public void delete(int position){ //�ش� ��ġ ��� ����
		if(position==0){
			Node temp = head;
			head = temp.next;
			temp = null;
			if(head != null)
				head.prev = null;
			count--;
		}
		else {
			Node temp = findnode(position-1);
			Node del = temp.next;
			temp.next = temp.next.next;
			if(temp.next != null)
				temp.next.prev = temp;
			del = null;
			count--;
		}
	}
	
	
	public void print_list_forward(int position){ //��ġ���� ������� ���
		Node a = findnode(position);
		for(int i=position; i<count; i++){
			System.out.print(a.data+",");
			a = a.next;}
		System.out.println();
		}
	
	
	public void print_list_backward(int position){ //��ġ���� �������� ���
		Node a = findnode(position);
		for(int i=position-1; i>-2; i--){
			System.out.print(a.data+",");
			a = a.prev;}
		System.out.println();
	}
	
	
	public void get_data(int position){ //�ش� ��ġ�� ������ ���� ���
		System.out.println("["+findnode(position).data+"]");}

}



public class Run {
	public static void main(String[] args){
		DCLinkedList list1 = new DCLinkedList();

		//Math.Random�� ����Ͽ� 20���� ���� ����Ʈ�� ����(50���� �ʹ� ���Ƽ��Ф�)
		for(int i=0; i<20; i++){
			int n = (int)(Math.random()*98+0);
			list1.insert(i,n);}
		
		list1.print_list_forward(0); //��ó������ ������� ���
		list1.print_list_backward(0); //��ó������ �������� ���
		list1.delete(2); 
		list1.delete(2);
		list1.print_list_forward(15);
		list1.print_list_backward(15);
		list1.get_data(2);
	}

}
