class AVLTree{
	private Node root;
	AVLTree(){
		root = null; }
	private class Node{
		private int key;
		private Node lchild;
		private Node rchild;
		private int height,lh,rh; //lh,rh -> lchild,rchild의 height
		Node (int key){
			this.key = key;
			this.lchild = null;
			this.rchild = null;
			this.height = 0;
			this.lh = 0;
			this.rh = 0;	
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
			if(lchild != null)
				lchild.print_preorder();
			if(rchild != null)
				rchild.print_preorder();
		}
		
		void print_preorder_diff(){
			if(rchild == null && lchild == null)
				System.out.print(key+"("+0+","+0+") ");
			else if(lchild == null)
				System.out.print(key+"("+0+","+rh+") ");
			else if(rchild == null)
				System.out.print(key+"("+lh+","+0+") ");
			else
				System.out.print(key+"("+lh+","+rh+") ");
			if(lchild != null)
				lchild.print_preorder_diff();
			if(rchild != null)
				rchild.print_preorder_diff();
		}
		
	}
	
	void preorder(){
		root.print_preorder();
		System.out.println(); }

	void inorder(){
		root.print_inorder();
		System.out.println(); }

	void postorder(){
		root.print_postorder();
		System.out.println(); }
	
	void preorder_diff(){
		setheight(root.lchild);
		setheight(root.rchild);
		setheight(root);
		root.print_preorder_diff();
		System.out.println(); }
	
	int height(Node t){ //null인 node의 height관리
		return t==null ? -1:t.height; }
	
	int max(int x,int y){ //크기비교
		if(x>y) return x;
		else return y; }

	Node rotateLchild(Node n2){ //insert의 Left rotate
		Node n1 = n2.lchild;
		n2.lchild = n1.rchild;
		n1.rchild = n2;
		n2.height = max(height(n2.lchild),height(n2.rchild))+1;
		n1.height = max(height(n1.lchild),n2.height)+1;
		return n1;
	}
	
	Node rotateRchild(Node n1){ //insert의 Right rotate
		Node n2 = n1.rchild;
		n1.rchild = n2.lchild;
		n2.lchild = n1;
		n1.height = max(height(n1.lchild),height(n1.rchild))+1;
		n2.height = max(height(n2.rchild),n1.height)+1;
		return n2;
	}
	
	Node doubleLchild(Node n){ //insert의 Left double일때 처리
		n.lchild = rotateRchild(n.lchild);
		return rotateLchild(n);
	}
	
	Node doubleRchild(Node n){ //insert의 Right double일때 처리
		n.rchild = rotateLchild(n.rchild);
		return rotateRchild(n);
	}
	
	void insert(int key){
		root = insert(key, root);
	}
	
	Node insert(int key, Node t){
		if(t == null)
			t = new Node(key);
		else if (key < t.key){
			t.lchild = insert(key,t.lchild);
			if(height(t.lchild)-height(t.rchild) == 2){
				if(key < t.lchild.key)
					t = rotateLchild(t);
				else
					t = doubleLchild(t);
				}
			}
		else if(key > t.key){
			t.rchild = insert(key, t.rchild);
			if(height(t.rchild)-height(t.lchild) == 2){
				if(key > t.rchild.key)
					t = rotateRchild(t);
				else
					t = doubleRchild(t);
				}
			}
		else
			;
		t.height = max(height(t.lchild),height(t.rchild))+1;
		return t;
	}
	
	void setheight(Node n) { //delete 후 각 node의 height 재설정
		if (n != null) {
			setheight(n.lchild);
			setheight(n.rchild);
			if (n.lchild == null)
				n.lh = 0;
			if (n.rchild == null)
				n.rh = 0;
			if (n.lchild != null) {
				if (n.lchild.lh >= n.lchild.rh)
					n.lh = n.lchild.lh + 1;
				else
					n.lh = n.lchild.rh + 1;
			}
			if (n.rchild != null) {
				if (n.rchild.lh >= n.rchild.rh)
					n.rh = n.rchild.lh + 1;
				else
					n.rh = n.rchild.rh + 1;
			}
		}
	}
	
	void rotate(Node n){ //delete 후 rotate
		setheight(n.lchild);
		setheight(n.rchild);
		setheight(n);
		if (n.height > n.lh+1) {
			if(n.rchild.lh > n.rchild.rh){
				Node a = n;
				Node c = a.rchild;
				Node b = c.lchild;
				a.rchild = b.lchild;
				c.lchild = b.rchild;
				b.lchild = a;
				b.rchild = c;
				root = b;
			}
			else{
				Node a = n;
				Node b = a.rchild;
				Node c = b.rchild;
				c.lchild = b.lchild;
				b.lchild = a;
				a.rchild = null;
				root = b;
			}
		}
	}
	
	void delete(int key){
		Node r = root;
		Node parent = null;
		setheight(r.lchild);
		setheight(r.rchild);
		setheight(r);
		while(key != r.key){
			if (key < r.key){
				parent = r;
				r = r.lchild; }
			else{
				parent = r;
				r = r.rchild; } 
		}
		if(parent.lchild!=null && parent.lchild.key==key)
			parent.lchild = null;
		else
			parent.rchild = null;
		rotate(root);
	}
	
	boolean search(int key){
		return search(root,key);
	}
	
	boolean search(Node r,int key){
		boolean found = false;
		while((r!=null) && !found){
			int rkey = r.key;
			if(key < rkey)
				r = r.lchild;
			else if (key > rkey)
				r = r.rchild;
			else{
				found = true;
				break;
			}
			found = search(r,key);
		}
		return found;
	}
	
}

public class Run {
	public static void main(String[] args){
		AVLTree t1 = new AVLTree();
		// 10 15 20 25 23 5 1 18 19순으로 insert
		t1.insert(10);
		t1.insert(15);
		t1.insert(20);
		t1.insert(25);
		t1.insert(23);
		t1.insert(5);
		t1.insert(1);
		t1.insert(18);
		t1.insert(19);
		
		t1.preorder();
		t1.preorder_diff();
		
		// delete(1), delete(10)
		t1.delete(1);
		t1.delete(10);
		t1.preorder_diff();

		//delete(5), insert(30), delete(18)
		t1.delete(5);
		t1.insert(30);
		t1.delete(18);
		t1.preorder_diff();
	}
}
