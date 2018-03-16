package Hashtable;

class LinkedList{
	private Node head;
	private int count; // 리스트의 노드갯수
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
	
	public String findvalue(String key){  //인풋 key에 해당하는 value를 찾아주는 함수
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
	
	
	public void print_list(int i){ //리스트의 모든 노드를 순서대로 출력
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