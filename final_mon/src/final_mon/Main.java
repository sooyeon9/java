package final_mon;

public class Main {

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(5);
		bst.insert(3);
		bst.insert(2);
		bst.insert(1);
		bst.insert(4);
		bst.insert(8);
		bst.insert(6);
		bst.insert(7);
		bst.insert(10);
		bst.insert(9);

		bst.postorder();
		System.out.println();
		bst.preorder();
		
		System.out.println();
		bst.delete(5);
		bst.delete(6);
		
		bst.inorder();
		System.out.println(bst.search(11));
		
		bst.postorder();
		System.out.println();
		bst.preorder();

	}

}
