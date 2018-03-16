package midtermExercise;


class LinkedList {
	private Node head;
	private int size;
	private class Node {
		Object data; //�����Ϳ�
		Node next; //������ ����Ű�� �����͸� ���� node��ü�� ����
		Node(Object elem){
			this.data = elem; //node�� ���� ������ �� ������
			this.next = null;
		}
	}
	
	
	public Node findNode(int index){
		Node finding = head;
		for(int i=0; i<index; i++)
			finding = finding.next; //head���� index�� ���� node�� ã�´�
		return finding;
	}
	
	
	public void insert(int position, Object elem){ //Ư�� ��ġ(position)�� elem�� �ִ´�
		Node inserting = new Node(elem); //inserting�� node�� ����
		if(position==0){
			inserting.next = head; //�� node�� �����͸� �� ���� node�� ����
			head = inserting; //head�� �ٲ��ش�
		}
		else {
			Node inserting_left = findNode(position-1); //�� node�� ���ʰ�
			Node inserting_right = inserting_left.next; //������ node�� ã�Ƶд�
			
			inserting.next = inserting_right;
			inserting_left.next = inserting; //�� �����߿�
			}
		size++;
	}
	
	public Object delete(int position){
		Object deleting_elem = null;
		if(position==0){
			deleting_elem = head.data;
			head = head.next; //head�� ������ node�� ���� node�� �����Ѵ�
		}
		else {
			Node deleting_left = findNode(position-1); //������ node�� ������ ã�´�
			deleting_left.next = deleting_left.next.next; //���� node�� �����͸� ������ node��忡 �������ش�
			deleting_elem = deleting_left.next.data; //������ node�� elem�� ������ �� �ֵ��� ����
		}
		size--;
		return deleting_elem;
	}
	
	public void printing(){
		if(head==null)
			System.out.println("empty list"); //����ִ� ����Ʈ�϶� ����ó��
		Node read = head; //head�� �о����
		while(read != null){ //����Ʈ�� ���̻� ����������
			System.out.print(read.data + ","); //�����͵��� ��� 
			read = read.next; //read�� �ڷ� �ѱ�
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
