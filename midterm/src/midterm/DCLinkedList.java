package midterm;

public class DCLinkedList {
	private Node head;
	private int count;
	private class Node
	{
		int data;
		Node next;
		Node prev;
		Node(int input){
			this.data = input;
			this.next = null;
			this.prev = null;
		}
	}
	
	public Node findNode(int index){
		Node finding = head;
		for(int i=0; i<index; i++)
			finding = finding.next;
		return finding;
	}
	
	
	public void insert(int position, int input)
	{
		Node inserting = new Node(input);
		if(position==0){
			inserting.next = head;
			
			if(head != null)
				head.prev = inserting;
			
			head = inserting;
		}
		else {
			Node left = findNode(position-1);
			Node right = left.next;
			
			inserting.next = right;
			inserting.prev = left;
			
			if(right != null)
				right.prev = inserting;
			left.next = inserting;
		}
		count++;
	}
	
	
	public void delete(int position)
	{
		if(position==0){
			head = head.next;
			
			if(head != null)
				head.prev = null;
		}
		else {
			Node left = findNode(position-1);
			Node right = left.next.next;
			
			//left.next = null;
			
			left.next = right;
			
			if(right != null)
				right.prev = left;
			
		}
		count--;
	}
	
	public void printing()
	{
		Node read = head;
		if(read == null) {
			System.out.print("nothing");
		}
		else {
			for(int i=0; i<count; i++){
				System.out.print(read.data + ",");
				read = read.next;
				}
		}
		System.out.println();
	}
	
	public void print_list_backward(int position)
	{
		Node start = findNode(position);
		for(int i=0; i<count; i++){
			if(start==null){
				start = findNode(count-1);
			}
			System.out.print(start.data+",");
			start = start.prev;
		}
		System.out.println();
	}
	
}
