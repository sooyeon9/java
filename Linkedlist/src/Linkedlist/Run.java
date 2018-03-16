package Linkedlist;

class LinkedList{
	private Node head;
	private int count; // ����Ʈ�� ��尹��
	private class Node{
		int data;
		Node next;
		Node(int input){
			this.data = input;
			this.next = null;
		}
	}
	
	
	public Node findnode(int i){  //Ư�� ��带 ã�Ƽ� ����
		Node a = head;
		for(int k=0; k<i; k++){a = a.next;}
		return a;
	}
	
	
	public void insert(int position, int input){ //�����͸� �޾� position ��ġ�� �� ��带 �߰�
		if(position==0){
			Node newadd = new Node(input);
			newadd.next = head;
			head = newadd;
			count++;
		}
		else {
			Node temp1 = findnode(position-1);
			Node temp2 = temp1.next;
			Node newadd = new Node(input);
			temp1.next = newadd;
			newadd.next = temp2;
			count++;
		}	
	}
	
	
	public void delete(int position){ //�ش� ��ġ�� ��带 ����
		if(position==0){
			Node temp = head;
			head = temp.next;
			temp = null;
			count--;
		}
		else {
			Node temp = findnode(position-1);
			Node del = temp.next;
			temp.next = temp.next.next;
			del = null;
			count--;
		}
		
	}
	
	
	public void print_list(){ //����Ʈ�� ��� ��带 ������� ���
		if(head==null){System.out.println("[]");}
		else {
			Node temp = head;
			String lists = "[";
			while(temp.next!=null){
				lists += temp.data + ",";
				temp = temp.next;
			}
			lists += temp.data;
			System.out.println(lists + "]");
		}
	}
	
	
	public void get_data(int position){ //�ش��ϴ� ��ġ�� ������ �� ���
		System.out.println(findnode(position).data);
	}
	
}

	
public class Run {
	public static void main(String[] args){
		LinkedList list1 = new LinkedList();
		list1.insert(0,99);
		list1.insert(1,100);
		list1.insert(2,101);
		list1.insert(3,102); // 4���� ���ڸ� ����Ʈ�� ����
		list1.print_list();
		
		list1.insert(2,77); //Ư�� ��ġ�� ���ڸ� ����
		list1.print_list();
		
		list1.delete(3); //Ư�� ��ġ ���ڸ� ����
		list1.print_list();
		
		list1.get_data(1); //Ư�� ��ġ�� ���ڸ� ����Ʈ
	}
}

