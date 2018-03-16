package midtermExercise;


class LinkedList {
	private Node head;
	private int size;
	private class Node {
		Object data; //데이터와
		Node next; //다음을 가르키는 포인터를 지닌 node객체를 만듦
		Node(Object elem){
			this.data = elem; //node에 값을 넣을때 쓸 생성자
			this.next = null;
		}
	}
	
	
	public Node findNode(int index){
		Node finding = head;
		for(int i=0; i<index; i++)
			finding = finding.next; //head에서 index로 까지 node를 찾는다
		return finding;
	}
	
	
	public void insert(int position, Object elem){ //특정 위치(position)에 elem을 넣는다
		Node inserting = new Node(elem); //inserting할 node를 생성
		if(position==0){
			inserting.next = head; //새 node의 포인터를 맨 앞의 node와 연결
			head = inserting; //head를 바꿔준다
		}
		else {
			Node inserting_left = findNode(position-1); //새 node의 왼쪽과
			Node inserting_right = inserting_left.next; //오른쪽 node를 찾아둔다
			
			inserting.next = inserting_right;
			inserting_left.next = inserting; //★ 순서중요
			}
		size++;
	}
	
	public Object delete(int position){
		Object deleting_elem = null;
		if(position==0){
			deleting_elem = head.data;
			head = head.next; //head를 삭제할 node의 뒤쪽 node로 지정한다
		}
		else {
			Node deleting_left = findNode(position-1); //삭제할 node의 왼쪽을 찾는다
			deleting_left.next = deleting_left.next.next; //왼쪽 node의 포인터를 오른쪽 node노드에 연결해준다
			deleting_elem = deleting_left.next.data; //삭제할 node의 elem을 리턴할 수 있도록 저장
		}
		size--;
		return deleting_elem;
	}
	
	public void printing(){
		if(head==null)
			System.out.println("empty list"); //비어있는 리스트일때 예외처리
		Node read = head; //head를 읽어오고
		while(read != null){ //리스트가 더이상 없을때까지
			System.out.print(read.data + ","); //데이터들을 출력 
			read = read.next; //read를 뒤로 넘김
		}
		System.out.println();
	}
	
	public void getData(int position){System.out.println(findNode(position).data);}
	
	public void sizes(){System.out.println(size);}
	
}


public class MidRun {
	public static void main(String[] args){
		LinkedList list1 = new LinkedList();
		for(int i=0; i<10; i++){
			list1.insert(i,(char)('A'+i));}
		list1.printing();
		list1.delete(3);
		list1.printing();
		list1.insert(4,'X');
		list1.printing();
		list1.getData(9);
		list1.sizes();
	}

}
