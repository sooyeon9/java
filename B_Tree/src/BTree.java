
public class BTree {
	int debug = 0;
	Node root;
	public BTree() {
		root = new Node(0);
	}

	// existKey 메소드 : 재귀함수
	// 노드 안에 그 key가 존재하는지 검사한다.
	boolean existKey(Node node, int key) {
		boolean result = false;
		// 현재 노드에서 key가 존재하는지 검사한다.
		// 만약 키가 존재한다면 true를 반환한다.
		for (int i = 0; i < node.keySize; i++) {
			if (node.key[i] == key) {
				return true;
			}
		}
		// 현재 노드에 key가 없을 때, 자식노드를 검사하도록 한다.
		if (node.childrenSize != 0) {
			for (int i = 0; i < node.childrenSize; i++) {
				result = existKey(node.children[i], key); // 재귀함수로 자식들에게서 key가 있는지 검사한다.
				// 그러면 자식들도 똑같이 그 자식까지 내려가서 검사를 하는데,
				// 만약 그 중 한 자식이라도 key를 발견하면 true를 반환하여 위까지 올라온다.
				if (result)
					return true;
			}
		}
		// 본 노드와 그 노드의 자식도 key가 없을 경우 기존의 값인 false를 반환한다.
		return result;
	}
	
	// search 메소드
	// existKey 메소드를 이용하여 key가 존재하는지 먼저 검사한 다음 결과내용을 출력한다.
	public void search(int key) {
		if (existKey(root, key)) { // key가 tree 안에 존재한다면,
			System.out.println("검색 경로 : ");
			this.search(root, "", 1, key);
		}
		else {
			System.out.println("찾는 키 값이 없습니다.");
		}
	}
	
	// search 메소드 : 재귀함수
	// existKey 메소드를 이용하여 key가 존재한다면 재귀함수를 이용하여 key의 위치를 출력한다.
	public void search(Node node, String indent, int height, int key) {
		int i;
		System.out.print(indent + "[" + height + "] "); // 높이 출력
		for (i = 0; i < node.keySize; i++) { // 노드 안에 key가 있는지 검사
			if (node.key[i] == key) { // key가 있다면 출력 후 종료
				System.out.println("*" + node.key[i] + " ");
				return;
			}
			System.out.print(node.key[i] + " ");
			// key 이전의 값들만 출력하려면 여기를 주석 해제, 그 위치까지 탐색하는 모든 key들을 보려면 주석
			if (key < node.key[i]) // key 보다 큰 녀석들은 출력하면 안 되니까 cutting
				break;	
		}
		System.out.println("");
		if (node.childrenSize != 0) { // 자식으로 재귀함수 재호출
			this.search(node.children[i], indent + "\t", height+1, key);
		}
	}
	
	// printTree 메소드 : 재귀함수
	public void printTree(Node node, String indent, int height) {
		System.out.print(indent + "[" + height + "] ");
		for (int i = 0; i < node.keySize; i++) { // 먼저 현재 노드의 key를 모두 출력
			System.out.print(node.key[i] + " ");
		}
		System.out.println("");
		if (node.childrenSize != 0) { // 이 노드에 자식이 존재할 경우 자식도 이 재귀함수를 콜
			for (int i = 0; i < node.childrenSize; i++) {
				printTree(node.children[i], indent + "\t", height+1);
			}
		}
	}
	
	// add 메소드
	// key가 tree에 존재하는지 검사한 다음 없다면 insert 재귀함수를 콜하여 key를 삽입한다.
	public void add(int key) {
		if (existKey(root, key)) {
			System.out.println("키 값이 중복되었습니다.");
			return;
		}
		if (debug == 1) System.out.println("MethodCall:add("+key+")");
		// tree에 key를 삽입한다.
		Node checkNode = insert(root, key);
		// return 되는 checkNode에 들어가는 것은 새로운 key가 추가되어서
		// 현재 보고 있는 노드인 root에 key가 5개라는 것인데, 노드가 가질 수 있는 key가 4개이므로
		// 5개를 정렬하여 좌측 2개는 원래 root에 두고, 우측 3개를 checkNode에 담아서 반환받아온다.
		// 그러면 root는 그대로 두면서 root의 좌측 자식으로 삼는다.
		// checkNode의 첫 번째 [0번 인덱스] key를 새로운 root에 담고,
		// checkNode의 key들을 앞으로 당겨서 checkNode를 새로운 root의 우측 자식으로 삼는다.
		if (checkNode != null) { // 반환되는 노드가 있다면 tree의 root가 가득차서 신장이 필요하다는 것이다.
			if (debug == 1) System.out.println("NeedTreeGrow:inNode:");
			if (debug == 1) for (int i = 0; i < checkNode.keySize; i++) System.out.print(checkNode.key[i] + " ");
			if (debug == 1) System.out.println("");
			// tree를 신장할 때에는 현재 root가 key가 5개라는 것이다.
			// 노드가 가질 수 있는 key의 제한이 4개이므로 한 개의 key를 위로 올려야 한다.
			Node newRoot = new Node(1); // key를 1개 가지도록 노드를 생성
			newRoot.key[0] = checkNode.key[0]; // 우측자식이될 checkNode의 첫 자리에 newRoot에 담을 key가 들어있음
			for (int i = 0; i < checkNode.keySize-1; i++) // checkNode.keySize가 3이 되어있을테니 2개까지만 읽어야 한다.
				checkNode.key[i] = checkNode.key[i+1]; // key를 앞으로 당긴다.
			checkNode.keySize = 2; // checkNode의 key의 수를 설정
			newRoot.children[0] = root; // 새로운 newRoot의 좌측 자식은 root
			newRoot.children[1] = checkNode; // 새로운 newRoot의 우측 자식은 checkNode
			newRoot.childrenSize = 2; // 새로운 newRoot의 자식 수를 설정
			root = newRoot; // 새로운 root
		}
		if (debug == 1) this.printTree(root, "", 1);
	}
	
	// insert 메소드 : 재귀함수
	// insert 메소드는 2가지 상황이 존재한다.
	// 1. key를 삽입하기 위해 탐색하며 tree 안으로 들어가는 상황
	// 2. key를 삽입했더니 split 현상이 발발하여 위로 key가 올라오는 상황
	// 그리고 각자 상황에 대하여 internal 노드와 external 노드에 따라 행동이 다르다.
	// 1-1. internal 노드에 삽입하는 것이 아니기에 위치를 탐색하여 external 노드로 key를 넘겨주며 재귀함수 콜을 한다.
	// 1-2. external 노드는 key를 넣을 수 있는지 없는지 검사하여 split을 해야 하는지 검사한다.
	// 2-1. internal 노드의 자식에서 split해서 올라오는 노드가 존재하면, 이 노드에도 그 key를 담을 자리가 있는지 검사하고, 문제가 있을 경우 똑같이 split을 실행하여 위로 올려준다.
	// 2-2. external 노드는 split하여 key를 올려주는 주체이므로 현 상황에 대한 행동은 없다.
	//
	// 전체적인 함수의 플로우
	// 1. Internal 노드이라면,
	// 1-1. key가 들어갈만한 자리를 탐색해서 그 자리의 자식에게 key를 주면서 재귀함수를 콜
	// 1-2. 재귀함수의 콜의 반환으로 노드가 돌아온다면, split이 아래서 발생했었다는 것이니까 현재 노드에 key를 삽입해야 한다.
	// 1-2-1. 현재 노드에 key를 넣을 자리가 있다면 삽입하고 null을 반환하며 종료
	// 1-2-2. 현재 노드에 key를 넣을 자리가 없다면 또 split을 발생시켜서 노드를 반환하며 종료
	// 1-3. 재귀함수의 콜의 반환으로 노드가 오지 않았다면, 아래서 해결된 것이므로 종료
	// 2. External 노드이라면,
	// 2-1. 현재 노드에 key를 넣을 자리가 존재한다면, key를 넣고 null을 반환하며 종료
	// 2-2. 현재 노드에 key를 넣을 자리가 없다면, split을 발생시키고 노드를 반환하며 종료
	Node insert(Node node, int key) {
		// 현재 노드에 key가 어느 자리에 들어가야할지 index를 설정
		int index;
		for (index = 0; index < node.keySize; index++) {
			if (key < node.key[index]) {
				break;
			}
		}
		// Internal node : 자식이 존재
		if (node.children[0] != null) {
			// 해당 위치의 자식에게 재귀함수 콜
			Node checkNode = insert(node.children[index], key);
			
			// split 현상이 발생하지 않음 : 이 노드에서 할게 없다.
			if (checkNode == null) {
				return null;
			}
			// split 현상이 발생
			// checkNode 에는 현재 우측 자식이 될 노드가 현재 노드에 들어올 키를 가진 상태이다.
			// checkNode : [0] node에 들어갈 key, [1] checkNode가 가질 첫 key, [2] checkNode가 가질 두 번째 key
			
			else {
				// 이제 주로 사용되는 key는 checkNode에 들어있던 것이므로 새로 갱신
				key = checkNode.key[0];
				checkNode.keySize = 2; // 갱신하면서 checkNode에 들은 key들을 당겨줌
				for (int i = 0; i < checkNode.keySize; i++)
					checkNode.key[i] = checkNode.key[i+1];
				
				// split 하여 key가 넘어왔는데 현재 노드에 자리가 존재하지 않아서 현재 노드도 split을 해야 한다.
				if (node.keySize == 4) {
					// 다루어줄 key가 바뀌었으므로 현재 노드에서 key가 들어갈 자리를 다시 계산
					for (index = 0; index < node.keySize; index++) {
						if (key < node.key[index]) {
							break;
						}
					}
					// 새로운 key를 포함한 크기 5의 배열
					// 0, 1 : 현재 노드에 남을 key
					// 2 : 상위로 올릴 key
					// 3, 4 : 새로운 노드를 생성하여 key를 넣어주고 상위로 올릴 노드
					// 현 코드의 방식에서는 2, 3, 4가 같은 노드에 들어가 상위로 올린다.
					int[] store = arrangedArray(node.key, key, index);
					
					// 현재 노드에 남을 key를 저장하고 크기 설정
					for (int i = 0; i < 2; i++)
						node.key[i] = store[i];
					node.keySize = 2;
					
					// 새로운 노드 생성
					Node newNode = new Node(3);
					for (int i = 0; i < 3; i++) {
						newNode.key[i] = store[i + 2];
					}
					
					// 이제 현재 원래 이 노드에서 다루고 있던 자식들도 노드가 2개로 쪼개지기 때문에
					// 그에 따라서 자식들도 이 두 노드들에게 따로 분배해 주어야 한다.
					// 현재 노드가 좌측 부분이 될 노드이므로 현재 노드에 소속된 자식들을 
					// 우측 노드 (newNode) 에 넘겨주면서 현재 노드도 정리를 해야 한다.
					
					// 계산된 index에 따라서 정리해야하는 자식들의 위치나 split되어온 노드를 저장해야할 곳이 서로 다르다.
					// 아마 계산할 수 있는 공식이 있을 것 같은데 일단 이렇게 해두고 나중에 생각
					// 쉽게 생각하면 그 index 자리의 자식은 가만히 있는 것이고,
					// 그 자식이 split되었으니 그 자식의 자리인 index+1 이 split 되어온 checkNode이고,
					// 이로 인해 나머지 자식들이 뒤로 밀리는데 이렇게 총 6개의 노드가 생기면
					// 좌측인 현재 노드에 3개, 우측인 새로운 노드에 3개를 각각 순서대로 분배하는 것이다.
					
					if (index == 0) {
						// index가 0이니까 0번째 있던 노드를 split한 것
						// 그럼 0번째는 두고, 다 뒤로 미룬다음에 1번째에 checkNode를 둔다.
						// 0 1 2 3 4 >> 0 * 1 2 3 4
						// 좌측 3개인 0 * 1 은 node에, 우측 3개인 2 3 4 는 newNode의 자식으로
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
					newNode.childrenSize = 3; // 새로운 노드의 자식 수 설정
					// 현재 노드에서 자식을 담을 수 있는 5칸 중 뒤의 2칸은 이제 비운다.
					for (int i = 3; i < 5; i++)
						node.children[i] = null;
					node.childrenSize = 3; // 현재 노드의 자식 수 설정
					return newNode;
				}
				// split 으로 인해 현재 노드에 key를 저장해야 하며, 자리가 충분
				// 자리가 넉넉하므로 key도 넣고, split 되어온 checkNode도 넣어야 한다.
				else {
					// 먼저 key 삽입
					// key를 넣기 위해 key들을 뒤로 미룬다.
					for (int i = node.keySize; i > index; i--) {
						node.key[i] = node.key[i-1];
					}
					// index 자리에 key 삽입
					node.key[index] = key;
					node.keySize++;
					// checkNode를 넣기 위해 현재 노드의 자식들도 뒤로 미룬다.
					for (int i = node.childrenSize; i > index; i--) {
						node.children[i] = node.children[i-1];
					}
					// index+1 자리에 key 삽입
					node.children[index+1] = checkNode;
					node.childrenSize++;
					return null;
				}
			}
		}
		
		// External node : 이 노드에 key를 삽입하고, 오버플로우 발생 시 split 
		else {
			// key가 들어갈 자리가 없을 경우, 넣고 split
			if (node.keySize == 4) {
				// store에 key들이 5개 정렬됨
				int[] store = arrangedArray(node.key, key, index);
				
				// 현재 노드가 좌측 노드가 되므로 0, 1이 들어감
				for (int i = 0; i < 2; i++)
					node.key[i] = store[i];
				node.keySize = 2;
				
				// 새로운 노드가 우측 노드가 되므로 2, 3, 4가 들어감, 여기서 2는 위에 올릴 key
				Node newNode = new Node(3);
				for (int i = 0; i < 3; i++) {
					newNode.key[i] = store[i + 2];
				}
				return newNode;
			}
			// key 넣을 자리가 존재
			else {
				// key들을 뒤로 미루고 index 자리에 key를 넣고 사이즈 증가시키면 끝
				for (int i = node.keySize; i > index; i--) {
					node.key[i] = node.key[i-1];
				}
				node.key[index] = key;
				node.keySize++;
				return null;
			}
		}
	}
	
	// 정렬된 배열을 반환하는 메소드
	// keyArray에는 4개의 key가 들어있다.
	// keyArray에 들은 4개의 key와 key가 들어갈 index를 통해 key를 삽입하여 크기가 5인 배열을 반환한다.
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
			System.out.println("키 값이 없어 삭제할 수 없습니다.");
		}
		else {
			Node checkNode = remove(root, key);
			if (checkNode != null) {
				System.out.println("문제있어");
			}
		}
	}
	
	// external에서의 삭제
	// 1. 삭제하려는 노드의 키가 2보다 작아지지 않으면, 삭제하고 끝
	// 2. 삭제하려는 노드의 키가 2보다 작아지면, 주변의 노드를 살핀다. 
	// 2-1. 만약 이 노드보다 우측 노드에서 key를 빌려올 수 있다면,
	// 2-1-1. 이 때 우측 노드가 key가 3개 이상이라면,
	// 2-1-1-1. 우측 노드의 맨 앞의 key를 상위로 올리고,
	// 2-1-1-2. 상위에 있던 key를 이 노드로 가져온다.
	// 2-1-2. 우측 노드의 key가 2개 이하라면,
	// 2-1-2-1. 상위에 있던 key를 이 노드로 가져오고, 우측 노드의 모든 key를 이 노드로 가져온 다음
	// 2-1-2-2. 상위 노드들도 모두 앞으로 당기고, 자식들도 모두 당긴다.
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
		// internal 노드에 있는 것을 지울 때는 두 가지 상황이 존재한다.
		// 1. internal 노드에서 지우려는데 양쪽 자식 노드가 external이면서 둘의 key 개수의 합이 4인 경우
		// 1-1. 그냥 양쪽 자식의 노드를 병합하고 붙여서 끝냄
		// 2. 그냥 무난하게 저 멀리 있는 하위 트리에서 가장 작은 값을 가져올 수 있는 경우
		// 2-1. 우측 하위 트리에서 가장 작은 값을 가져와서 지울 key의 index에 저장하고
		// 2-2. 우측 하위 트리에서 그 가장 작은 값을 삭제하면 된다.
		if (node.childrenSize != 0) {
			if (check) { // 이 internal 노드에 key가 있는 것
//				if (node.children[index].children[0] == null) { // 자식이 external 노드인 경우 (검사는 손자가 있느냐 없느냐로)
//					if (node.children[index].keySize + node.children[index+1].keySize <= 4) { // 양쪽 자식이 합이 4개가 안 되는 경우
//						// 양쪽 자식이 external이면서 합이 4개이므로 그냥 병합을 실행해야 한다.
//						// 새로운 노드 생성
//						Node helpNode = new Node(4);
//						helpNode.key[0] = node.children[index].key[0];
//						helpNode.key[1] = node.children[index].key[1];
//						helpNode.key[2] = node.children[index+1].key[0];
//						helpNode.key[3] = node.children[index+1].key[1];
//						// 만약 이 노드가 root 이면서 이 노드에서 key를 지우면 비어버리는 경우 새로운 root가 되어야 된다는 것
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
				// 자식이 external 노드가 아니거나, external 노드인데 충분히 빌려줄만한 여력이 있음
				// 그러면 저 아래에 있거나 상관 없는 것이니까 알아서 지우라고 실행
				int miniKey = findMiniKey(node.children[index+1]);
//				node.key[index] = miniKey;
//				remove(node.children[index+1], miniKey);
				remove(root, miniKey);
				root = changeKey(root, key, miniKey);
				return null;
			}
			else { // external 노드로 가야함
				Node checkNode = remove(node.children[index], key);
				if (checkNode == null) { // 아래 노드에서 잘 해결되어서 문제가 없으므로 상위로 null 반환
					return null;
				}
				else { 
					// 아래 노드에서 해결되지 않았으므로 현재 노드에서 수정을 요구 
					// 1. 방금 노드의 우측의 자식들에게서 빌리는 방식 (만약 가장 우측 노드였을 경우 좌측을 봄)
					// 2. 그 노드의 좌우에서 빌릴 수 없는 경우 병합을 하는 방식
					// 1번으로 해결이 되면 끝, 1번으로 해결이 되지 않으면 2번을 실행
					if (index == 0) { // 맨 좌측 노드일 경우 우측에서 key를 얻는다.
						if (node.children[index+1].keySize <= 2) { // 우측 노드의 자식이 2개 이하일 경우 병합 시행
							// 새로운 노드를 생성해서 현재 병합해야할 모든 key들을 넣어준다.
							// 좌측 자식 (checkNode) 1개 + [index] 자리의 key + 우측 자식 2개 = 4개가 된다.
							Node helpNode = new Node(4);
							// checkNode에는 key가 1개만 들어있다. : 그래서 수정을 요구한 상태
							helpNode.key[0] = checkNode.key[0];
							// 현재 index 자리의 key가 같이 병합될 것
							helpNode.key[1] = node.key[index];
							// node.children[index+1] : 우측 노드 자식인데 2개 밖에 없다.
							helpNode.key[2] = node.children[index+1].key[0];
							helpNode.key[3] = node.children[index+1].key[1];
							// 만약 현재 노드가 root 이라면 helpNode가 새로운 root가 된다.
							// 단, root일지라도 key가 충분히 존재하면 root가 갱신되지 않는다.
							// 즉, root 이면서 key가 모두 없어졌을 때, 신장이 줄어드는 것
							if (node == root && node.keySize == 1) {
								root = helpNode;
								return null;
							}
							// 이 노드를 현재 검사 중이던 노드의 자식의 자리에 넣어주면 된다.
							node.children[index] = helpNode;
							// 그리고 이제 노드의 key와 children을 정리하기 위해 당겨주면 된다.
							node.keySize--;
							for (int i = index; i < node.keySize; i++)
								node.key[i] = node.key[i+1];
							node.childrenSize--;
							for (int i = index+1; i < node.childrenSize; i++)
								node.children[i] = node.children[i+1];
							// 다 당겨주었으면 종료
							return null;
						}
						// 아래 노드에서 삭제를 했더니 key의 개수가 모자라서 borrow가 필요한 상황
						// 그 아래 노드의 우측 노드를 봤더니 빌려주기 충분하기 때문에 빌려주고 종료
						else { // 우측에서 빌려와서 우측 것을 현재 노드에 두고, 현재 노드에 있는 것을 좌측으로 준다.
							Node helpNode = node.children[index+1];
							// 우측 노드의 0번째 자리 key를 가져옴
							int help = helpNode.key[0];
							// key들을 당기고 size를 감소
							helpNode.keySize--;
							for (int i = 0; i < helpNode.keySize; i++) {
								helpNode.key[i] = helpNode.key[i+1];
							}
							// 현재 노드의 index 자리에 놓인 key를 좌측 자식 (checkNode) 에게 넘겨줌
							// 좌측 자식의 가장 마지막 자리에 들어가면 된다.
							checkNode.key[checkNode.keySize] = node.key[index];
							checkNode.keySize++;
							node.key[index] = help; // 현재 노드의 key의 개수 변화는 없음
							// 변화를 준 노드 갱신 : 자식 노드의 수는 같으니 개수 변화는 없음
							node.children[index] = checkNode;
							node.children[index+1] = helpNode; 
							return null;
						}
					}
					else { // 맨 좌측 노드가 아닐 경우
						if (node.children[index-1].keySize <= 2) { // 좌측 노드의 자식이 2개 이하일 경우 병합 시행
							// 새로운 노드를 생성해서 현재 병합해야할 모든 key들을 넣어준다.
							Node helpNode = new Node(4);
							// 여기서는 좌측 2개 + [index-1] 자리의 key + 우측 자식 (checkNode) 1개 = 4개의 key 가 된다.
							helpNode.key[0] = node.children[index-1].key[0];
							helpNode.key[1] = node.children[index-1].key[1];
							helpNode.key[2] = node.key[index-1];
							helpNode.key[3] = checkNode.key[0];
							// 만약 현재 노드가 root 이라면 helpNode가 새로운 root가 된다.
							// 단, root일지라도 key가 충분히 존재하면 root가 갱신되지 않는다.
							// 즉, root 이면서 key가 모두 없어질 상황이라면, 새로운 root가 되는 것
							if (node == root && node.keySize == 1) {
								root = helpNode;
								return null;
							}
							// 새로운 노드를 현재 노드의 좌측 자식, [index-1] 자리에 넣어주면 된다.
							node.children[index-1] = helpNode;
							node.keySize--;
							for (int i = index-1; i < node.keySize; i++)
								node.key[i] = node.key[i+1];
							node.childrenSize--;
							for (int i = index; i < node.childrenSize; i++)
								node.children[i] = node.children[i+1];
							return null;
						}
						else { // 좌측 노드에서 빌릴만함
							// 좌측 노드 가져옴
							Node helpNode = node.children[index-1]; 
							// 좌측 노드의 마지막 key 가져옴
							int help = helpNode.key[helpNode.keySize-1];
							helpNode.keySize--; // 마지막 key 이므로 당길 필요 없음
							// 현재 이 노드의 index에 있는 key를 우측 자식 노드의 가장 앞에 두고,
							// 방금 가져온 key를 현재 이 노드의 index 자리에 둔다.
							// 먼저 수정을 요구하는 노드 (checkNode) 의 key 들을 뒤로 밀어서 자리 확보
							// 어차피 들어온 checkNode는 자식이 2개 이하이기 때문에 밀어도 무방하다.
							for (int i = checkNode.keySize; i > 0; i--) {
								checkNode.key[i] = checkNode.key[i-1]; 
							}
							checkNode.key[0] = node.key[index-1]; // 밀은 자리에 현재 노드에 있던 key를 주고
							checkNode.keySize++; // 개수 증가
							node.key[index-1] = help; // 현재 key자리에 저장해둔 key 저장
							node.children[index-1] = helpNode;
							node.children[index] = checkNode;
							return null;
						}
					}
				}
			}
		}
		// external node
		// external 노드로 왔다면 이 노드에 무조건 key가 있는 것
		else {
			// 일단 현재 노드에서 key를 지운다.
			node.keySize--;
			for (int i = index; i < node.keySize; i++)
				node.key[i] = node.key[i+1];
			if (node.keySize < 2) { // 현재 노드에서 key를 지우면 사이즈가 1로 떨어지는 경우
				return node;
			}
			else { // 사이즈가 2 이상이므로 상관 없음
				return null;
			}
		}
	}
	
	// tree 내부에서 가장 작은 값을 찾아주는 메소드
	// internal 노드에서의 삭제 메소드를 돕기 위한 메소드
	public int findMiniKey(Node node) {
		if (node.children[0] != null) {
			return findMiniKey(node.children[0]);
		}
		else {
			return node.key[0];
		}
	}
	
	// tree에서 oldKey를 찾은 다음 newKey로 교체하여준다.
	public Node changeKey(Node node, int oldKey, int newKey) {
		for (int i = 0; i < node.keySize; i++) {
			if (node.key[i] == oldKey) { // key가 있다면 출력 후 종료
				node.key[i] = newKey;
				return node;
			}
		}
		if (node.childrenSize != 0) { // 자식으로 재귀함수 재호출
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

