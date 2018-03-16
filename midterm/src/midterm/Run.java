package midterm;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		DCLinkedList list = new DCLinkedList();
		
		//TODO #4 
		//list 안에 2부터 20까지 10개의 짝수를 집어넣는다
		// 2,4,6,8...,18,20
		
		for(int i=0; i<10; i++){
			list.insert(i, (i+1)*2);
		}

		list.print_list_backward(0);
		
		list.print_list_backward(5);
		
		list.insert(1,1);
		
		list.print_list_backward(5);
		
		list.insert(4,3);
		
		list.print_list_backward(5);
		
		list.insert(11,19);
		
		list.print_list_backward(5);
		
		list.delete(1);
		list.delete(11);
		
		list.print_list_backward(0);
	
		
		list.delete(2);
		list.delete(2);
		
		list.print_list_backward(0);
		
		list.print_list_backward(5);
	
	}
	
}

