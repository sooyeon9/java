package midtermExercise;


class DoublyLinkedList {
	private Node header = new Node(null);
	private Node trailer = new Node(null);
	private int size;
	private class Node {
		Object data;
		Node next;
		Node prev;
		Node(Object elem){
			this.data = elem;
			this.next = null;
			this.prev = null;
		}
	}
	
	public Node findNode(int index){
		Node finding = null;
		if(index+1<(size/2)){ //앞부분쪽에 있을때는 header부터 살피고
			finding = header;
			for(int i=0; i<index; i++)
				finding = finding.next;
			}
		else {
			finding = trailer; //뒷쪽에 있을때는 trailer부터 살핀다
			for(int i=0; i<(size-index); i++)
				finding = finding.prev;
		}
		return finding;
	}
	
	public void insert(int position, Object elem){
		Node inserting = new Node(elem); //새로 넣을 node를 생성
		if(position==0){ //앞에 붙일때
			inserting.next = header.next;
			inserting.prev = header;
			
			if(header.next != null)
				header.next.prev = inserting;
			header.next = inserting;
			size++;
		}
		else if(position==size){ //끝에 붙일때
			inserting.next = trailer;
			inserting.prev = trailer.prev;
			
			if(trailer.prev != null)
				trailer.prev.next = inserting;
			trailer.prev = inserting;			
			size++;
		}
		else { //중간에 넣을때
			Node inserting_left = findNode(position-1);
			Node inserting_right = inserting_left.next;
			
			inserting.next = inserting_right;
			inserting.prev = inserting_left;
			
			inserting_left.next = inserting;
			inserting_right.prev = inserting;
			size++;
		}
	}
	
	public Object delete(int position){
		
		return null;
	}
	
	public void printing(){
		if(header.next==null)
			System.out.println("empty list"); //비어있는 리스트일때 예외처리
		Node read = header.next; //head를 읽어오고
		while(read != null){ //리스트가 더이상 없을때까지
			System.out.print(read.data + ","); //데이터들을 출력 
			read = read.next; //read를 뒤로 넘김
		}
		System.out.println();
	}
	
	public void getData(int position){System.out.println(findNode(position).data);}
	
}


public class MidRun2 {
	public static void main(String[] args){
		DoublyLinkedList list1 = new DoublyLinkedList();
		for(int i=0; i<10; i++){
			list1.insert(i,(char)('A'+i));}
		list1.printing();
		list1.delete(3);
		list1.printing();
		list1.insert(4,'X');
		list1.printing();
		list1.getData(9);
	}

}
