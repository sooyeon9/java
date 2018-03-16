
public class Node {
	int keySize;
	int childrenSize;
	int[] key;
	Node[] children;
	
	public Node(int size) {
		keySize = size;
		childrenSize = 0;
		key = new int[4];
		children = new Node[5];
	}
}