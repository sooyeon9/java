import java.util.Arrays;

public class Btree {
	private Node root;
	private class Node{
		int keySize;
		int childrenSize;
		int[] key;
		Node[] children;
		Node(int size){
			this.keySize = size;
			this.childrenSize = 0;
			this.key = new int[4];
			this.children = new Node[5];
		}
	}
	public Btree(){
		root = new Node(0);
	}

	
	/**********삽입**********/
	public void insert(int input){
		Node growing = insert(root, input);
		if(growing!=null){ //root가 가득찼다면,
			Node newroot = new Node(1);
			newroot.key[0] = growing.key[0]; //루트올려줌
			for(int i=0; i<growing.keySize-1; i++) 
				growing.key[i] = growing.key[i+1]; //growing 애들 땡겨줌
			//root를 newroot로 바꿔주기전 재설정
			growing.keySize = 2; 
			newroot.children[0] = root;
			newroot.children[1] = growing;
			newroot.childrenSize = 2;
			root = newroot;
		}
	}
	
	public Node insert(Node node, int key){ //split할게 없으면 null 있으면 해당 노드 리턴
		if(exist(root,key)){
			System.out.println("키 값이 중복되었습니다.");
			return null;
		} //↑ 중복처리
		int position = index(node,key);
		//1. Internal노드(자식노드 o)이면 아래로 내려가서 insert
		if(node.children[0] != null){
			Node check = insert(node.children[position], key);
			if(check == null) 
				return null;
			else { //check 노드 split 필요
				key = check.key[0];
				check.keySize = 2;
				for(int i=0; i<check.keySize; i++)
					check.key[i] = check.key[i+1];
				//1-1. key갱신 후 node로 넘어왔는데 얘도 꽉찬 상태 -> node도 split해야함
				if(node.keySize == 4){
					position = index(node,key);
					//↓ 위로 올릴 newnode를 만들어줌
					int[] lineup = {0,0,0,0,key};
					System.arraycopy(node.key, 0, lineup, 0, 4);
					Arrays.sort(lineup);
					System.arraycopy(lineup, 0, node.key, 0, 2);
					node.keySize = 2;
					Node newnode = new Node(3);
					System.arraycopy(lineup, 2, newnode.key, 0, 3);
					//↓ position에 따라 split된 노드들을 정리
					switch(position){
					case 0 : 
						newnode.children[0] = node.children[2];
						newnode.children[1] = node.children[3];
						newnode.children[2] = node.children[4];
						node.children[2] = node.children[1];
						node.children[1] = check;
						break;
					case 1 :
						newnode.children[0] = node.children[2];
						newnode.children[1] = node.children[3];
						newnode.children[2] = node.children[4];
						node.children[2] = check;
						break;
					case 2 : 
						newnode.children[0] = check;
						newnode.children[1] = node.children[3];
						newnode.children[2] = node.children[4];
						break;
					case 3 :
						newnode.children[0] = node.children[3];
						newnode.children[1] = check;
						newnode.children[2] = node.children[4];
						break;
					case 4 :
						newnode.children[0] = node.children[3];
						newnode.children[1] = node.children[4];
						newnode.children[2] = check;
						break;
					}
					newnode.childrenSize = 3;
					for (int i=3; i<5; i++)
						node.children[i] = null;
					node.childrenSize = 3;
					return newnode;
				}
				//1-2. 자리 넉넉한 node에 갱신된 key넣고 check 자식으로 받기
				else { 
					//↓ key 삽입
					for(int i=node.keySize; i>position; i--)
						node.key[i] = node.key[i-1];
					node.key[position] = key;
					node.keySize++;
					//↓ check를 자식노드로 삽입
					for(int i=node.childrenSize; i>position; i--)
						node.children[i] = node.children[i-1];
					node.children[position+1] = check;
					node.childrenSize++;
					return null;
				}
			}
		}
		//2. External노드(자식노드 x)이면 key 삽입
		else {
			//2-1. node에 key자리 없으면 split
			if(node.keySize == 4){
				int[] lineup = {0,0,0,0,key};
				System.arraycopy(node.key, 0, lineup, 0, 4);
				Arrays.sort(lineup);
				System.arraycopy(lineup, 0, node.key, 0, 2);
				node.keySize = 2;
				Node newnode = new Node(3);
				System.arraycopy(lineup, 2, newnode.key, 0, 3);
				return newnode;
			}
			//2-2. node에 key자리 있음
			else {
				for (int i=node.keySize; i>position; i--)
					node.key[i] = node.key[i-1];
				node.key[position] = key;
				node.keySize++;
				return null;
			}
		}
	}
	
	/**********삭제**********/
	public void delete(int input){
		if(!exist(root,input))
			System.out.println("키 값이 없어 삭제할 수 없습니다.");
		else {
			int position = index(root,input);
		}
	}
	
	
	/**********검색**********/
	public void search(int input){
		if(exist(root, input)){
			System.out.println("검색 경로 : ");
			search(root,input,1,"");
		}
		else //키값 없을 때 예외처리
			System.out.println("찾는 키 값이 없습니다.");
	}
	
	public void search(Node node, int key, int depth, String tab){
		int i;
		System.out.print(tab+"["+depth+"] ");
		for(i=0; i<node.keySize; i++){
			if(node.key[i]==key){ //찾으면 *출력해주고 끝냄
				System.out.println("*"+node.key[i]+" ");
				return;
			}
			System.out.print(node.key[i]+" ");
			if(key<node.key[i])
				break;
		}
		System.out.println("");
		if(node.childrenSize!=0) //자식 노드 있으면 밑으로 내려가면서 계속 찾아줌
			search(node.children[i], key, depth+1, tab+"\t");
	}
	
	
	/**********출력**********/
	public void printing(){
		printing(root, 1, "");
	}
	
	public void printing(Node node, int depth, String tab){
		System.out.print(tab+"["+depth+"] ");
		for(int i=0; i<node.keySize; i++)
			System.out.print(node.key[i]+" ");
		System.out.println(""); //현재 depth의 key들 출력
		if(node.childrenSize!=0){ //자식노드 존재시 밑으로 내려감
			for(int i=0; i<node.childrenSize; i++)
				printing(node.children[i], depth+1, tab+"\t");
		}		
	}
	
	/**********추가함수들**********/
	public boolean exist(Node node, int key){
		boolean result = false;
		for(int i=0; i<node.keySize; i++){ //현재 node에서 존재여부 검사
			if(node.key[i]==key)
				return true;
		}
		if(node.childrenSize!=0){ //없으면 자식 노드로 내려가서 검사를 계속함
			for(int i=0; i<node.childrenSize; i++){
				result = exist(node.children[i], key);
				if(result)
					return true;
			}
		}
		return result;
	}
	
	public int index(Node node, int key){ //key의 자리 찾아줌
		int i;
		for(i=0; i<node.keySize; i++){
			if(key < node.key[i])
				break;
			else if(key == node.key[i])
				break;
		}
		return i;
	}
	
	
	
	

}
