package final_mon;

public class BST {
	private BSTNode root;

	/* Constructor */
	public BST() {
		root = null;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	/* Functions to insert data */
	public void insert(int data) {
		root = insert(root, data);
	}

	/* Function to insert data recursively */
	private BSTNode insert(BSTNode node, int data) {
	//////////////////////////////////////////////////////TODO #1 2pt
		if(node == null){
			node = new BSTNode(data);
			return node;
		}
		if(node.data > data)
			node.left = insert(node.left,data);
		else if(node.data < data)
			node.right = insert(node.right,data);
		
		return node;
	}

	/* Functions to delete data */
	public void delete(int k) {
		if (isEmpty())
			System.out.println("Tree Empty");
		else if (search(k) == false)
			System.out.println("Sorry " + k + " is not present");
		else {
			root = delete(root, k);
			System.out.println(k + " deleted from the tree");
		}
	}

	private BSTNode delete(BSTNode root, int k) {
	//////////////////////////////////////////////////TODO #2 3pt
		if(root == null) return root;
		if(root.data > k)
			root.left = delete(root.left,k);
		else if (root.data < k)
			root.right = delete(root.right,k);
		else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			root.data = minvalue(root.right);
			root.right = delete(root.right,root.data);
		}
		return root;
	}

	int minvalue(BSTNode root){
		int min = root.data;
		while(root.left != null){
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
	/* Functions to count number of nodes */
	public int countNodes() {
		return countNodes(root);
	}

	/* Function to count number of nodes recursively */
	private int countNodes(BSTNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}

	/* Functions to search for an element */
	public boolean search(int val) {
		return search(root, val);
	}

	/* Function to search for an element recursively */
	private boolean search(BSTNode r, int val) {
		boolean found = false;
/////////////////////////////////////////////////////////TODO #3 2pt
		if(r.data == val)
			found = true;
		else{
			while(r != null){
				if(r.data > val)
					r = r.left;
				else if(r.data < val)
					r = r.right;
				else
					break;
			}
			if(r != null)
				found = true;
		}
		return found;
	}

	/* Function for inorder traversal */
	public void inorder() {
		inorder(root);
	}

	private void inorder(BSTNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + " ");
			inorder(r.getRight());
		}
	}

	/* Function for preorder traversal */
	public void preorder() {
		preorder(root);
	}

	private void preorder(BSTNode r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}

	/* Function for postorder traversal */
	public void postorder() {
		postorder(root);
	}

	private void postorder(BSTNode r) {
	////////////////////////////////////////TODO #4 2pt
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + " ");
		}
	}

	class BSTNode {
		BSTNode left, right;
		int data;

		/* Constructor */
		public BSTNode() {
			left = null;
			right = null;
			data = 0;
		}

		/* Constructor */
		public BSTNode(int n) {
			left = null;
			right = null;
			data = n;
		}

		/* Function to set left node */
		public void setLeft(BSTNode n) {
			left = n;
		}

		/* Function to set right node */
		public void setRight(BSTNode n) {
			right = n;
		}

		/* Function to get left node */
		public BSTNode getLeft() {
			return left;
		}

		/* Function to get right node */
		public BSTNode getRight() {
			return right;
		}

		/* Function to set data to node */
		public void setData(int d) {
			data = d;
		}

		/* Function to get data from node */
		public int getData() {
			return data;
		}
	}

}