
public class BTree {
	int debug = 0;
	Node root;
	public BTree() {
		root = new Node(0);
	}

	// existKey �޼ҵ� : ����Լ�
	// ��� �ȿ� �� key�� �����ϴ��� �˻��Ѵ�.
	boolean existKey(Node node, int key) {
		boolean result = false;
		// ���� ��忡�� key�� �����ϴ��� �˻��Ѵ�.
		// ���� Ű�� �����Ѵٸ� true�� ��ȯ�Ѵ�.
		for (int i = 0; i < node.keySize; i++) {
			if (node.key[i] == key) {
				return true;
			}
		}
		// ���� ��忡 key�� ���� ��, �ڽĳ�带 �˻��ϵ��� �Ѵ�.
		if (node.childrenSize != 0) {
			for (int i = 0; i < node.childrenSize; i++) {
				result = existKey(node.children[i], key); // ����Լ��� �ڽĵ鿡�Լ� key�� �ִ��� �˻��Ѵ�.
				// �׷��� �ڽĵ鵵 �Ȱ��� �� �ڽı��� �������� �˻縦 �ϴµ�,
				// ���� �� �� �� �ڽ��̶� key�� �߰��ϸ� true�� ��ȯ�Ͽ� ������ �ö�´�.
				if (result)
					return true;
			}
		}
		// �� ���� �� ����� �ڽĵ� key�� ���� ��� ������ ���� false�� ��ȯ�Ѵ�.
		return result;
	}
	
	// search �޼ҵ�
	// existKey �޼ҵ带 �̿��Ͽ� key�� �����ϴ��� ���� �˻��� ���� ��������� ����Ѵ�.
	public void search(int key) {
		if (existKey(root, key)) { // key�� tree �ȿ� �����Ѵٸ�,
			System.out.println("�˻� ��� : ");
			this.search(root, "", 1, key);
		}
		else {
			System.out.println("ã�� Ű ���� �����ϴ�.");
		}
	}
	
	// search �޼ҵ� : ����Լ�
	// existKey �޼ҵ带 �̿��Ͽ� key�� �����Ѵٸ� ����Լ��� �̿��Ͽ� key�� ��ġ�� ����Ѵ�.
	public void search(Node node, String indent, int height, int key) {
		int i;
		System.out.print(indent + "[" + height + "] "); // ���� ���
		for (i = 0; i < node.keySize; i++) { // ��� �ȿ� key�� �ִ��� �˻�
			if (node.key[i] == key) { // key�� �ִٸ� ��� �� ����
				System.out.println("*" + node.key[i] + " ");
				return;
			}
			System.out.print(node.key[i] + " ");
			// key ������ ���鸸 ����Ϸ��� ���⸦ �ּ� ����, �� ��ġ���� Ž���ϴ� ��� key���� ������ �ּ�
			if (key < node.key[i]) // key ���� ū �༮���� ����ϸ� �� �Ǵϱ� cutting
				break;	
		}
		System.out.println("");
		if (node.childrenSize != 0) { // �ڽ����� ����Լ� ��ȣ��
			this.search(node.children[i], indent + "\t", height+1, key);
		}
	}
	
	// printTree �޼ҵ� : ����Լ�
	public void printTree(Node node, String indent, int height) {
		System.out.print(indent + "[" + height + "] ");
		for (int i = 0; i < node.keySize; i++) { // ���� ���� ����� key�� ��� ���
			System.out.print(node.key[i] + " ");
		}
		System.out.println("");
		if (node.childrenSize != 0) { // �� ��忡 �ڽ��� ������ ��� �ڽĵ� �� ����Լ��� ��
			for (int i = 0; i < node.childrenSize; i++) {
				printTree(node.children[i], indent + "\t", height+1);
			}
		}
	}
	
	// add �޼ҵ�
	// key�� tree�� �����ϴ��� �˻��� ���� ���ٸ� insert ����Լ��� ���Ͽ� key�� �����Ѵ�.
	public void add(int key) {
		if (existKey(root, key)) {
			System.out.println("Ű ���� �ߺ��Ǿ����ϴ�.");
			return;
		}
		if (debug == 1) System.out.println("MethodCall:add("+key+")");
		// tree�� key�� �����Ѵ�.
		Node checkNode = insert(root, key);
		// return �Ǵ� checkNode�� ���� ���� ���ο� key�� �߰��Ǿ
		// ���� ���� �ִ� ����� root�� key�� 5����� ���ε�, ��尡 ���� �� �ִ� key�� 4���̹Ƿ�
		// 5���� �����Ͽ� ���� 2���� ���� root�� �ΰ�, ���� 3���� checkNode�� ��Ƽ� ��ȯ�޾ƿ´�.
		// �׷��� root�� �״�� �θ鼭 root�� ���� �ڽ����� ��´�.
		// checkNode�� ù ��° [0�� �ε���] key�� ���ο� root�� ���,
		// checkNode�� key���� ������ ��ܼ� checkNode�� ���ο� root�� ���� �ڽ����� ��´�.
		if (checkNode != null) { // ��ȯ�Ǵ� ��尡 �ִٸ� tree�� root�� �������� ������ �ʿ��ϴٴ� ���̴�.
			if (debug == 1) System.out.println("NeedTreeGrow:inNode:");
			if (debug == 1) for (int i = 0; i < checkNode.keySize; i++) System.out.print(checkNode.key[i] + " ");
			if (debug == 1) System.out.println("");
			// tree�� ������ ������ ���� root�� key�� 5����� ���̴�.
			// ��尡 ���� �� �ִ� key�� ������ 4���̹Ƿ� �� ���� key�� ���� �÷��� �Ѵ�.
			Node newRoot = new Node(1); // key�� 1�� �������� ��带 ����
			newRoot.key[0] = checkNode.key[0]; // �����ڽ��̵� checkNode�� ù �ڸ��� newRoot�� ���� key�� �������
			for (int i = 0; i < checkNode.keySize-1; i++) // checkNode.keySize�� 3�� �Ǿ������״� 2�������� �о�� �Ѵ�.
				checkNode.key[i] = checkNode.key[i+1]; // key�� ������ ����.
			checkNode.keySize = 2; // checkNode�� key�� ���� ����
			newRoot.children[0] = root; // ���ο� newRoot�� ���� �ڽ��� root
			newRoot.children[1] = checkNode; // ���ο� newRoot�� ���� �ڽ��� checkNode
			newRoot.childrenSize = 2; // ���ο� newRoot�� �ڽ� ���� ����
			root = newRoot; // ���ο� root
		}
		if (debug == 1) this.printTree(root, "", 1);
	}
	
	// insert �޼ҵ� : ����Լ�
	// insert �޼ҵ�� 2���� ��Ȳ�� �����Ѵ�.
	// 1. key�� �����ϱ� ���� Ž���ϸ� tree ������ ���� ��Ȳ
	// 2. key�� �����ߴ��� split ������ �߹��Ͽ� ���� key�� �ö���� ��Ȳ
	// �׸��� ���� ��Ȳ�� ���Ͽ� internal ���� external ��忡 ���� �ൿ�� �ٸ���.
	// 1-1. internal ��忡 �����ϴ� ���� �ƴϱ⿡ ��ġ�� Ž���Ͽ� external ���� key�� �Ѱ��ָ� ����Լ� ���� �Ѵ�.
	// 1-2. external ���� key�� ���� �� �ִ��� ������ �˻��Ͽ� split�� �ؾ� �ϴ��� �˻��Ѵ�.
	// 2-1. internal ����� �ڽĿ��� split�ؼ� �ö���� ��尡 �����ϸ�, �� ��忡�� �� key�� ���� �ڸ��� �ִ��� �˻��ϰ�, ������ ���� ��� �Ȱ��� split�� �����Ͽ� ���� �÷��ش�.
	// 2-2. external ���� split�Ͽ� key�� �÷��ִ� ��ü�̹Ƿ� �� ��Ȳ�� ���� �ൿ�� ����.
	//
	// ��ü���� �Լ��� �÷ο�
	// 1. Internal ����̶��,
	// 1-1. key�� ������ �ڸ��� Ž���ؼ� �� �ڸ��� �ڽĿ��� key�� �ָ鼭 ����Լ��� ��
	// 1-2. ����Լ��� ���� ��ȯ���� ��尡 ���ƿ´ٸ�, split�� �Ʒ��� �߻��߾��ٴ� ���̴ϱ� ���� ��忡 key�� �����ؾ� �Ѵ�.
	// 1-2-1. ���� ��忡 key�� ���� �ڸ��� �ִٸ� �����ϰ� null�� ��ȯ�ϸ� ����
	// 1-2-2. ���� ��忡 key�� ���� �ڸ��� ���ٸ� �� split�� �߻����Ѽ� ��带 ��ȯ�ϸ� ����
	// 1-3. ����Լ��� ���� ��ȯ���� ��尡 ���� �ʾҴٸ�, �Ʒ��� �ذ�� ���̹Ƿ� ����
	// 2. External ����̶��,
	// 2-1. ���� ��忡 key�� ���� �ڸ��� �����Ѵٸ�, key�� �ְ� null�� ��ȯ�ϸ� ����
	// 2-2. ���� ��忡 key�� ���� �ڸ��� ���ٸ�, split�� �߻���Ű�� ��带 ��ȯ�ϸ� ����
	Node insert(Node node, int key) {
		// ���� ��忡 key�� ��� �ڸ��� �������� index�� ����
		int index;
		for (index = 0; index < node.keySize; index++) {
			if (key < node.key[index]) {
				break;
			}
		}
		// Internal node : �ڽ��� ����
		if (node.children[0] != null) {
			// �ش� ��ġ�� �ڽĿ��� ����Լ� ��
			Node checkNode = insert(node.children[index], key);
			
			// split ������ �߻����� ���� : �� ��忡�� �Ұ� ����.
			if (checkNode == null) {
				return null;
			}
			// split ������ �߻�
			// checkNode ���� ���� ���� �ڽ��� �� ��尡 ���� ��忡 ���� Ű�� ���� �����̴�.
			// checkNode : [0] node�� �� key, [1] checkNode�� ���� ù key, [2] checkNode�� ���� �� ��° key
			
			else {
				// ���� �ַ� ���Ǵ� key�� checkNode�� ����ִ� ���̹Ƿ� ���� ����
				key = checkNode.key[0];
				checkNode.keySize = 2; // �����ϸ鼭 checkNode�� ���� key���� �����
				for (int i = 0; i < checkNode.keySize; i++)
					checkNode.key[i] = checkNode.key[i+1];
				
				// split �Ͽ� key�� �Ѿ�Դµ� ���� ��忡 �ڸ��� �������� �ʾƼ� ���� ��嵵 split�� �ؾ� �Ѵ�.
				if (node.keySize == 4) {
					// �ٷ���� key�� �ٲ�����Ƿ� ���� ��忡�� key�� �� �ڸ��� �ٽ� ���
					for (index = 0; index < node.keySize; index++) {
						if (key < node.key[index]) {
							break;
						}
					}
					// ���ο� key�� ������ ũ�� 5�� �迭
					// 0, 1 : ���� ��忡 ���� key
					// 2 : ������ �ø� key
					// 3, 4 : ���ο� ��带 �����Ͽ� key�� �־��ְ� ������ �ø� ���
					// �� �ڵ��� ��Ŀ����� 2, 3, 4�� ���� ��忡 �� ������ �ø���.
					int[] store = arrangedArray(node.key, key, index);
					
					// ���� ��忡 ���� key�� �����ϰ� ũ�� ����
					for (int i = 0; i < 2; i++)
						node.key[i] = store[i];
					node.keySize = 2;
					
					// ���ο� ��� ����
					Node newNode = new Node(3);
					for (int i = 0; i < 3; i++) {
						newNode.key[i] = store[i + 2];
					}
					
					// ���� ���� ���� �� ��忡�� �ٷ�� �ִ� �ڽĵ鵵 ��尡 2���� �ɰ����� ������
					// �׿� ���� �ڽĵ鵵 �� �� ���鿡�� ���� �й��� �־�� �Ѵ�.
					// ���� ��尡 ���� �κ��� �� ����̹Ƿ� ���� ��忡 �Ҽӵ� �ڽĵ��� 
					// ���� ��� (newNode) �� �Ѱ��ָ鼭 ���� ��嵵 ������ �ؾ� �Ѵ�.
					
					// ���� index�� ���� �����ؾ��ϴ� �ڽĵ��� ��ġ�� split�Ǿ�� ��带 �����ؾ��� ���� ���� �ٸ���.
					// �Ƹ� ����� �� �ִ� ������ ���� �� ������ �ϴ� �̷��� �صΰ� ���߿� ����
					// ���� �����ϸ� �� index �ڸ��� �ڽ��� ������ �ִ� ���̰�,
					// �� �ڽ��� split�Ǿ����� �� �ڽ��� �ڸ��� index+1 �� split �Ǿ�� checkNode�̰�,
					// �̷� ���� ������ �ڽĵ��� �ڷ� �и��µ� �̷��� �� 6���� ��尡 �����
					// ������ ���� ��忡 3��, ������ ���ο� ��忡 3���� ���� ������� �й��ϴ� ���̴�.
					
					if (index == 0) {
						// index�� 0�̴ϱ� 0��° �ִ� ��带 split�� ��
						// �׷� 0��°�� �ΰ�, �� �ڷ� �̷������ 1��°�� checkNode�� �д�.
						// 0 1 2 3 4 >> 0 * 1 2 3 4
						// ���� 3���� 0 * 1 �� node��, ���� 3���� 2 3 4 �� newNode�� �ڽ�����
						newNode.children[0] = node.children[2];
						newNode.children[1] = node.children[3];
						newNode.children[2] = node.children[4];
						node.children[2] = node.children[1];
						node.children[1] = checkNode;
					}
					else if (index == 1) {
						newNode.children[0] = node.children[2];
						newNode.children[1] = node.children[3];
						newNode.children[2] = node.children[4];
						node.children[2] = checkNode;
					}
					else if (index == 2) {
						newNode.children[0] = checkNode;
						newNode.children[1] = node.children[3];
						newNode.children[2] = node.children[4];
					}
					else if (index == 3) {
						newNode.children[0] = node.children[3];
						newNode.children[1] = checkNode;
						newNode.children[2] = node.children[4];
					}
					else if (index == 4) {
						newNode.children[0] = node.children[3];
						newNode.children[1] = node.children[4];
						newNode.children[2] = checkNode;
					}
					newNode.childrenSize = 3; // ���ο� ����� �ڽ� �� ����
					// ���� ��忡�� �ڽ��� ���� �� �ִ� 5ĭ �� ���� 2ĭ�� ���� ����.
					for (int i = 3; i < 5; i++)
						node.children[i] = null;
					node.childrenSize = 3; // ���� ����� �ڽ� �� ����
					return newNode;
				}
				// split ���� ���� ���� ��忡 key�� �����ؾ� �ϸ�, �ڸ��� ���
				// �ڸ��� �˳��ϹǷ� key�� �ְ�, split �Ǿ�� checkNode�� �־�� �Ѵ�.
				else {
					// ���� key ����
					// key�� �ֱ� ���� key���� �ڷ� �̷��.
					for (int i = node.keySize; i > index; i--) {
						node.key[i] = node.key[i-1];
					}
					// index �ڸ��� key ����
					node.key[index] = key;
					node.keySize++;
					// checkNode�� �ֱ� ���� ���� ����� �ڽĵ鵵 �ڷ� �̷��.
					for (int i = node.childrenSize; i > index; i--) {
						node.children[i] = node.children[i-1];
					}
					// index+1 �ڸ��� key ����
					node.children[index+1] = checkNode;
					node.childrenSize++;
					return null;
				}
			}
		}
		
		// External node : �� ��忡 key�� �����ϰ�, �����÷ο� �߻� �� split 
		else {
			// key�� �� �ڸ��� ���� ���, �ְ� split
			if (node.keySize == 4) {
				// store�� key���� 5�� ���ĵ�
				int[] store = arrangedArray(node.key, key, index);
				
				// ���� ��尡 ���� ��尡 �ǹǷ� 0, 1�� ��
				for (int i = 0; i < 2; i++)
					node.key[i] = store[i];
				node.keySize = 2;
				
				// ���ο� ��尡 ���� ��尡 �ǹǷ� 2, 3, 4�� ��, ���⼭ 2�� ���� �ø� key
				Node newNode = new Node(3);
				for (int i = 0; i < 3; i++) {
					newNode.key[i] = store[i + 2];
				}
				return newNode;
			}
			// key ���� �ڸ��� ����
			else {
				// key���� �ڷ� �̷�� index �ڸ��� key�� �ְ� ������ ������Ű�� ��
				for (int i = node.keySize; i > index; i--) {
					node.key[i] = node.key[i-1];
				}
				node.key[index] = key;
				node.keySize++;
				return null;
			}
		}
	}
	
	// ���ĵ� �迭�� ��ȯ�ϴ� �޼ҵ�
	// keyArray���� 4���� key�� ����ִ�.
	// keyArray�� ���� 4���� key�� key�� �� index�� ���� key�� �����Ͽ� ũ�Ⱑ 5�� �迭�� ��ȯ�Ѵ�.
	public int[] arrangedArray(int[] keyArray, int key, int index) {
		int[] storage = new int[5];
		int help = 0;
		for (int i = 0; i < 5; i++) {
			if (i == index) {
				storage[i] = key;
			}
			else {
				storage[i] = keyArray[help];
				help++;
			}
		}
		return storage;
	}
	
	public void delete(int key) {
		if (!existKey(root, key)) {
			System.out.println("Ű ���� ���� ������ �� �����ϴ�.");
		}
		else {
			Node checkNode = remove(root, key);
			if (checkNode != null) {
				System.out.println("�����־�");
			}
		}
	}
	
	// external������ ����
	// 1. �����Ϸ��� ����� Ű�� 2���� �۾����� ������, �����ϰ� ��
	// 2. �����Ϸ��� ����� Ű�� 2���� �۾�����, �ֺ��� ��带 ���ɴ�. 
	// 2-1. ���� �� ��庸�� ���� ��忡�� key�� ������ �� �ִٸ�,
	// 2-1-1. �� �� ���� ��尡 key�� 3�� �̻��̶��,
	// 2-1-1-1. ���� ����� �� ���� key�� ������ �ø���,
	// 2-1-1-2. ������ �ִ� key�� �� ���� �����´�.
	// 2-1-2. ���� ����� key�� 2�� ���϶��,
	// 2-1-2-1. ������ �ִ� key�� �� ���� ��������, ���� ����� ��� key�� �� ���� ������ ����
	// 2-1-2-2. ���� ���鵵 ��� ������ ����, �ڽĵ鵵 ��� ����.
	public Node remove(Node node, int key) {
		int index;
		boolean check = false;
		for (index = 0; index < node.keySize; index++) {
			if (key == node.key[index])
				check = true;
			if (key <= node.key[index])
				break;
		}
		// internal node
		// internal ��忡 �ִ� ���� ���� ���� �� ���� ��Ȳ�� �����Ѵ�.
		// 1. internal ��忡�� ������µ� ���� �ڽ� ��尡 external�̸鼭 ���� key ������ ���� 4�� ���
		// 1-1. �׳� ���� �ڽ��� ��带 �����ϰ� �ٿ��� ����
		// 2. �׳� �����ϰ� �� �ָ� �ִ� ���� Ʈ������ ���� ���� ���� ������ �� �ִ� ���
		// 2-1. ���� ���� Ʈ������ ���� ���� ���� �����ͼ� ���� key�� index�� �����ϰ�
		// 2-2. ���� ���� Ʈ������ �� ���� ���� ���� �����ϸ� �ȴ�.
		if (node.childrenSize != 0) {
			if (check) { // �� internal ��忡 key�� �ִ� ��
//				if (node.children[index].children[0] == null) { // �ڽ��� external ����� ��� (�˻�� ���ڰ� �ִ��� �����ķ�)
//					if (node.children[index].keySize + node.children[index+1].keySize <= 4) { // ���� �ڽ��� ���� 4���� �� �Ǵ� ���
//						// ���� �ڽ��� external�̸鼭 ���� 4���̹Ƿ� �׳� ������ �����ؾ� �Ѵ�.
//						// ���ο� ��� ����
//						Node helpNode = new Node(4);
//						helpNode.key[0] = node.children[index].key[0];
//						helpNode.key[1] = node.children[index].key[1];
//						helpNode.key[2] = node.children[index+1].key[0];
//						helpNode.key[3] = node.children[index+1].key[1];
//						// ���� �� ��尡 root �̸鼭 �� ��忡�� key�� ����� �������� ��� ���ο� root�� �Ǿ�� �ȴٴ� ��
//						if (node == root && node.keySize == 1) {
//							root = helpNode;
//							return null;
//						}
//						node.children[index] = helpNode;
//						node.keySize--;
//						for (int i = index; i < node.keySize; i++) {
//							node.key[i] = node.key[i+1];
//						}
//						node.childrenSize--;
//						for (int i = index+1; i < node.childrenSize; i++) {
//							node.children[i] = node.children[i+1];
//						}
//						return null;
//					}
//				}
				// �ڽ��� external ��尡 �ƴϰų�, external ����ε� ����� �����ٸ��� ������ ����
				// �׷��� �� �Ʒ��� �ְų� ��� ���� ���̴ϱ� �˾Ƽ� ������ ����
				int miniKey = findMiniKey(node.children[index+1]);
//				node.key[index] = miniKey;
//				remove(node.children[index+1], miniKey);
				remove(root, miniKey);
				root = changeKey(root, key, miniKey);
				return null;
			}
			else { // external ���� ������
				Node checkNode = remove(node.children[index], key);
				if (checkNode == null) { // �Ʒ� ��忡�� �� �ذ�Ǿ ������ �����Ƿ� ������ null ��ȯ
					return null;
				}
				else { 
					// �Ʒ� ��忡�� �ذ���� �ʾ����Ƿ� ���� ��忡�� ������ �䱸 
					// 1. ��� ����� ������ �ڽĵ鿡�Լ� ������ ��� (���� ���� ���� ��忴�� ��� ������ ��)
					// 2. �� ����� �¿쿡�� ���� �� ���� ��� ������ �ϴ� ���
					// 1������ �ذ��� �Ǹ� ��, 1������ �ذ��� ���� ������ 2���� ����
					if (index == 0) { // �� ���� ����� ��� �������� key�� ��´�.
						if (node.children[index+1].keySize <= 2) { // ���� ����� �ڽ��� 2�� ������ ��� ���� ����
							// ���ο� ��带 �����ؼ� ���� �����ؾ��� ��� key���� �־��ش�.
							// ���� �ڽ� (checkNode) 1�� + [index] �ڸ��� key + ���� �ڽ� 2�� = 4���� �ȴ�.
							Node helpNode = new Node(4);
							// checkNode���� key�� 1���� ����ִ�. : �׷��� ������ �䱸�� ����
							helpNode.key[0] = checkNode.key[0];
							// ���� index �ڸ��� key�� ���� ���յ� ��
							helpNode.key[1] = node.key[index];
							// node.children[index+1] : ���� ��� �ڽ��ε� 2�� �ۿ� ����.
							helpNode.key[2] = node.children[index+1].key[0];
							helpNode.key[3] = node.children[index+1].key[1];
							// ���� ���� ��尡 root �̶�� helpNode�� ���ο� root�� �ȴ�.
							// ��, root������ key�� ����� �����ϸ� root�� ���ŵ��� �ʴ´�.
							// ��, root �̸鼭 key�� ��� �������� ��, ������ �پ��� ��
							if (node == root && node.keySize == 1) {
								root = helpNode;
								return null;
							}
							// �� ��带 ���� �˻� ���̴� ����� �ڽ��� �ڸ��� �־��ָ� �ȴ�.
							node.children[index] = helpNode;
							// �׸��� ���� ����� key�� children�� �����ϱ� ���� ����ָ� �ȴ�.
							node.keySize--;
							for (int i = index; i < node.keySize; i++)
								node.key[i] = node.key[i+1];
							node.childrenSize--;
							for (int i = index+1; i < node.childrenSize; i++)
								node.children[i] = node.children[i+1];
							// �� ����־����� ����
							return null;
						}
						// �Ʒ� ��忡�� ������ �ߴ��� key�� ������ ���ڶ� borrow�� �ʿ��� ��Ȳ
						// �� �Ʒ� ����� ���� ��带 �ô��� �����ֱ� ����ϱ� ������ �����ְ� ����
						else { // �������� �����ͼ� ���� ���� ���� ��忡 �ΰ�, ���� ��忡 �ִ� ���� �������� �ش�.
							Node helpNode = node.children[index+1];
							// ���� ����� 0��° �ڸ� key�� ������
							int help = helpNode.key[0];
							// key���� ���� size�� ����
							helpNode.keySize--;
							for (int i = 0; i < helpNode.keySize; i++) {
								helpNode.key[i] = helpNode.key[i+1];
							}
							// ���� ����� index �ڸ��� ���� key�� ���� �ڽ� (checkNode) ���� �Ѱ���
							// ���� �ڽ��� ���� ������ �ڸ��� ���� �ȴ�.
							checkNode.key[checkNode.keySize] = node.key[index];
							checkNode.keySize++;
							node.key[index] = help; // ���� ����� key�� ���� ��ȭ�� ����
							// ��ȭ�� �� ��� ���� : �ڽ� ����� ���� ������ ���� ��ȭ�� ����
							node.children[index] = checkNode;
							node.children[index+1] = helpNode; 
							return null;
						}
					}
					else { // �� ���� ��尡 �ƴ� ���
						if (node.children[index-1].keySize <= 2) { // ���� ����� �ڽ��� 2�� ������ ��� ���� ����
							// ���ο� ��带 �����ؼ� ���� �����ؾ��� ��� key���� �־��ش�.
							Node helpNode = new Node(4);
							// ���⼭�� ���� 2�� + [index-1] �ڸ��� key + ���� �ڽ� (checkNode) 1�� = 4���� key �� �ȴ�.
							helpNode.key[0] = node.children[index-1].key[0];
							helpNode.key[1] = node.children[index-1].key[1];
							helpNode.key[2] = node.key[index-1];
							helpNode.key[3] = checkNode.key[0];
							// ���� ���� ��尡 root �̶�� helpNode�� ���ο� root�� �ȴ�.
							// ��, root������ key�� ����� �����ϸ� root�� ���ŵ��� �ʴ´�.
							// ��, root �̸鼭 key�� ��� ������ ��Ȳ�̶��, ���ο� root�� �Ǵ� ��
							if (node == root && node.keySize == 1) {
								root = helpNode;
								return null;
							}
							// ���ο� ��带 ���� ����� ���� �ڽ�, [index-1] �ڸ��� �־��ָ� �ȴ�.
							node.children[index-1] = helpNode;
							node.keySize--;
							for (int i = index-1; i < node.keySize; i++)
								node.key[i] = node.key[i+1];
							node.childrenSize--;
							for (int i = index; i < node.childrenSize; i++)
								node.children[i] = node.children[i+1];
							return null;
						}
						else { // ���� ��忡�� ��������
							// ���� ��� ������
							Node helpNode = node.children[index-1]; 
							// ���� ����� ������ key ������
							int help = helpNode.key[helpNode.keySize-1];
							helpNode.keySize--; // ������ key �̹Ƿ� ��� �ʿ� ����
							// ���� �� ����� index�� �ִ� key�� ���� �ڽ� ����� ���� �տ� �ΰ�,
							// ��� ������ key�� ���� �� ����� index �ڸ��� �д�.
							// ���� ������ �䱸�ϴ� ��� (checkNode) �� key ���� �ڷ� �о �ڸ� Ȯ��
							// ������ ���� checkNode�� �ڽ��� 2�� �����̱� ������ �о �����ϴ�.
							for (int i = checkNode.keySize; i > 0; i--) {
								checkNode.key[i] = checkNode.key[i-1]; 
							}
							checkNode.key[0] = node.key[index-1]; // ���� �ڸ��� ���� ��忡 �ִ� key�� �ְ�
							checkNode.keySize++; // ���� ����
							node.key[index-1] = help; // ���� key�ڸ��� �����ص� key ����
							node.children[index-1] = helpNode;
							node.children[index] = checkNode;
							return null;
						}
					}
				}
			}
		}
		// external node
		// external ���� �Դٸ� �� ��忡 ������ key�� �ִ� ��
		else {
			// �ϴ� ���� ��忡�� key�� �����.
			node.keySize--;
			for (int i = index; i < node.keySize; i++)
				node.key[i] = node.key[i+1];
			if (node.keySize < 2) { // ���� ��忡�� key�� ����� ����� 1�� �������� ���
				return node;
			}
			else { // ����� 2 �̻��̹Ƿ� ��� ����
				return null;
			}
		}
	}
	
	// tree ���ο��� ���� ���� ���� ã���ִ� �޼ҵ�
	// internal ��忡���� ���� �޼ҵ带 ���� ���� �޼ҵ�
	public int findMiniKey(Node node) {
		if (node.children[0] != null) {
			return findMiniKey(node.children[0]);
		}
		else {
			return node.key[0];
		}
	}
	
	// tree���� oldKey�� ã�� ���� newKey�� ��ü�Ͽ��ش�.
	public Node changeKey(Node node, int oldKey, int newKey) {
		for (int i = 0; i < node.keySize; i++) {
			if (node.key[i] == oldKey) { // key�� �ִٸ� ��� �� ����
				node.key[i] = newKey;
				return node;
			}
		}
		if (node.childrenSize != 0) { // �ڽ����� ����Լ� ��ȣ��
			for (int i =0; i < node.childrenSize; i++) {
				Node checkNode = changeKey(node.children[i], oldKey, newKey);
				if (checkNode != null) {
					node.children[i] = checkNode;
					return node;
				}
			}
		}
		return null;
	}
}

