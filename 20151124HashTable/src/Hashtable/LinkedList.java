package Hashtable;

class LinkedList{
	private Node head;
	private int count; // ����Ʈ�� ��尹��
	private class Node{
		String key;
		String data;
		Node next;
		Node(String key,String data){
			this.key = key;
			this.data = data;
			this.next = null;
		}
	}
	
	public boolean isEmpty(){
		return head==null;}
	
	public String findvalue(String key){  //��ǲ key�� �ش��ϴ� value�� ã���ִ� �Լ�
		Node a = head;
		while(a != null){
			if(a.key.equals(key))
				break;
			else
				a = a.next;
		}
		if (a==null)
			return "None"; 
		else
			return a.data;
	}
	
	public void insert(String key,String data){
		Node newnode = new Node(key,data);
		if(head==null)
			head = newnode;
		else 
			head.next = newnode;
		count++;
	}
	
	
	public void print_list(int i){ //����Ʈ�� ��� ��带 ������� ���
		if(head==null){System.out.println("[]");}
		else {
			Node temp = head;
			String lists = "";
			while(temp.next!=null){
				lists += "["+i+","+temp.key+","+temp.data + "] ";
				temp = temp.next;
			}
			lists += "["+i+","+temp.key+","+temp.data + "] ";
			System.out.println(lists);
		}
	}
	
}