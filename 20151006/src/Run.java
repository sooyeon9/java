
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
		for(int k=0; k<i-1; k++){a = a.next;}
		return a;
	}
	
	
	public Object recursive_insert(int size){
		//size는 0부터시작
		if(size==0)
			return 0;
		Node newadd = new Node(5*(size-1));
		newadd.next = head;
		head = newadd;
		count++;
		return recursive_insert(size-1);

	}
	

	public Object recursive_delete(int position){
		if(position==0)
			return 0;
		delete(count);
		return recursive_delete(position-1);
	}
	//맨 뒤에서부터  Size만큼의 노드를 제거한다

	
	
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

}

public class Run {	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.recursive_insert(20);
		list1.print_list();
		
		list1.recursive_delete(15);
		list1.print_list();
		}
	}
