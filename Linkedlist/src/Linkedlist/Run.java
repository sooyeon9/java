package Linkedlist;

class LinkedList{
	private Node head;
	private int count; // 리스트의 노드갯수
	private class Node{
		int data;
		Node next;
		Node(int input){
			this.data = input;
			this.next = null;
		}
	}
	
	
	public Node findnode(int i){  //특정 노드를 찾아서 리턴
		Node a = head;
		for(int k=0; k<i; k++){a = a.next;}
		return a;
	}
	
	
	public void insert(int position, int input){ //데이터를 받아 position 위치에 새 노드를 추가
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
	
	
	public void delete(int position){ //해당 위치의 노드를 삭제
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
	
	
	public void print_list(){ //리스트의 모든 노드를 순서대로 출력
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
	
	
	public void get_data(int position){ //해당하는 위치에 데이터 값 출력
		System.out.println(findnode(position).data);
	}
	
}

	
public class Run {
	public static void main(String[] args){
		LinkedList list1 = new LinkedList();
		list1.insert(0,99);
		list1.insert(1,100);
		list1.insert(2,101);
		list1.insert(3,102); // 4개의 숫자를 리스트에 넣음
		list1.print_list();
		
		list1.insert(2,77); //특정 위치에 숫자를 삽입
		list1.print_list();
		
		list1.delete(3); //특정 위치 숫자를 삭제
		list1.print_list();
		
		list1.get_data(1); //특정 위치의 숫자를 프린트
	}
}

