class BST{
	private Node root;
	private class Node{
		private int key;
		private Node lchild;
		private Node rchild;
		Node (int key){
			this.key = key;
			this.lchild = null;
			this.rchild = null;
		}
		
		
		public void print_inorder(){
			if(lchild != null)
				lchild.print_inorder();
			System.out.print(key+" ");
			if(rchild != null)
				rchild.print_inorder();
		}
		
		public void print_postorder(){
			if(lchild != null)
				lchild.print_postorder();
			if(rchild != null)
				rchild.print_postorder();
			System.out.print(key+" ");
		}
		
		public void print_preorder(){
			System.out.print(key+" ");
			if(lchild != null && lchild.key !=0)
				lchild.print_preorder();
			if(rchild != null && rchild.key!=0)
				rchild.print_preorder();
		}
		
		
	}

	void insert(int key){
		Node newnode = new Node(key);
		Node pointer;
		boolean complete = false;
		if(root ==null)
			root = newnode;
		else{
			pointer = root;
			while(!complete){
				if(pointer.key > key){
					if(pointer.lchild != null)
						pointer = pointer.lchild;
					else {
						pointer.lchild = newnode;
						complete = true;
						break;
					}
				}
				else if(pointer.key < key) {
					if(pointer.rchild != null)
						pointer = pointer.rchild;
					else {
						pointer.rchild = newnode;
						complete = true;
						break;
					}
				}
				else
					break;
			}
		}
	}
	
	
	void delete(int key){
		Node pointer, parent;
		pointer = parent = root;
		while(pointer!=null && pointer.key!=key){
			parent = pointer;
			if(pointer.key > key)
				pointer = pointer.lchild;
			else
				pointer = pointer.rchild;
		}
		
		if(pointer==root && pointer.lchild==null)
			root = root.rchild;

		else if(pointer!=root && pointer.lchild==null){

			if(pointer == parent.lchild)
				parent.lchild = pointer.rchild;

			else
				parent.rchild = pointer.rchild;
		}

		else {
			Node rightMostNode = pointer.lchild;
			while(rightMostNode.rchild != null)
				rightMostNode = rightMostNode.rchild;
			
			pointer.key = rightMostNode.key;
			rightMostNode.key = 0;
			rightMostNode = null;
		}		
	}

	
	
	void search(int key){
		Node pointer;
		if(root.key == key)
			System.out.println(key+" 있음");
		else {
			pointer = root;
			while(pointer != null){
				if(pointer.key > key)
					pointer = pointer.lchild;
				else if(pointer.key < key)
					pointer = pointer.rchild;
				else
					break;
			}
			if(pointer!=null)
				System.out.println(key+" 있음");
			else
				System.out.println(key+" 없음"); 
		}
	}
	
	void preorder(){
		root.print_preorder();
		System.out.println();}

	void inorder(){
		root.print_inorder();
		System.out.println();}

	void postorder(){
		root.print_postorder();
		System.out.println();}

	
}


public class Run {
	public static void main(String[] args){
		BST t1 = new BST();
		// 5 3 2 1 4  8 6 7 10 9 순으로 insert 
		t1.insert(5);
		t1.insert(3);
		t1.insert(2);
		t1.insert(1);
		t1.insert(4);
		t1.insert(8);
		t1.insert(6);
		t1.insert(7);
		t1.insert(10);
		t1.insert(9);
		
		// search(7)  “7 있음” 혹은 “7 없음” 출력
		t1.search(7);
		
		// preorder, inorder, postorder 출력
		System.out.print("preorder : ");
		t1.preorder();
		System.out.print("inorder : ");
		t1.inorder();
		System.out.print("postorder : ");
		t1.postorder();
		
		// delete(8), delete(5), delete(2)
		t1.delete(8);
		t1.delete(5);
		t1.delete(2);
		
		// search(8) “8 있음” 혹은 “8없음” 출력
		t1.search(8);
		
		// preorder 출력
		t1.preorder();
	}

}
