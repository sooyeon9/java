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

	
	/**********����**********/
	public void insert(int input){
		Node growing = insert(root, input);
		if(growing!=null){ //root�� ����á�ٸ�,
			Node newroot = new Node(1);
			newroot.key[0] = growing.key[0]; //��Ʈ�÷���
			for(int i=0; i<growing.keySize-1; i++) 
				growing.key[i] = growing.key[i+1]; //growing �ֵ� ������
			//root�� newroot�� �ٲ��ֱ��� �缳��
			growing.keySize = 2; 
			newroot.children[0] = root;
			newroot.children[1] = growing;
			newroot.childrenSize = 2;
			root = newroot;
		}
	}
	
	public Node insert(Node node, int key){ //split�Ұ� ������ null ������ �ش� ��� ����
		if(exist(root,key)){
			System.out.println("Ű ���� �ߺ��Ǿ����ϴ�.");
			return null;
		} //�� �ߺ�ó��
		int position = index(node,key);
		//1. Internal���(�ڽĳ�� o)�̸� �Ʒ��� �������� insert
		if(node.children[0] != null){
			Node check = insert(node.children[position], key);
			if(check == null) 
				return null;
			else { //check ��� split �ʿ�
				key = check.key[0];
				check.keySize = 2;
				for(int i=0; i<check.keySize; i++)
					check.key[i] = check.key[i+1];
				//1-1. key���� �� node�� �Ѿ�Դµ� �굵 ���� ���� -> node�� split�ؾ���
				if(node.keySize == 4){
					position = index(node,key);
					//�� ���� �ø� newnode�� �������
					int[] lineup = {0,0,0,0,key};
					System.arraycopy(node.key, 0, lineup, 0, 4);
					Arrays.sort(lineup);
					System.arraycopy(lineup, 0, node.key, 0, 2);
					node.keySize = 2;
					Node newnode = new Node(3);
					System.arraycopy(lineup, 2, newnode.key, 0, 3);
					//�� position�� ���� split�� ������ ����
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
				//1-2. �ڸ� �˳��� node�� ���ŵ� key�ְ� check �ڽ����� �ޱ�
				else { 
					//�� key ����
					for(int i=node.keySize; i>position; i--)
						node.key[i] = node.key[i-1];
					node.key[position] = key;
					node.keySize++;
					//�� check�� �ڽĳ��� ����
					for(int i=node.childrenSize; i>position; i--)
						node.children[i] = node.children[i-1];
					node.children[position+1] = check;
					node.childrenSize++;
					return null;
				}
			}
		}
		//2. External���(�ڽĳ�� x)�̸� key ����
		else {
			//2-1. node�� key�ڸ� ������ split
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
			//2-2. node�� key�ڸ� ����
			else {
				for (int i=node.keySize; i>position; i--)
					node.key[i] = node.key[i-1];
				node.key[position] = key;
				node.keySize++;
				return null;
			}
		}
	}
	
	/**********����**********/
	public void delete(int input){
		if(!exist(root,input))
			System.out.println("Ű ���� ���� ������ �� �����ϴ�.");
		else {
			int position = index(root,input);
		}
	}
	
	
	/**********�˻�**********/
	public void search(int input){
		if(exist(root, input)){
			System.out.println("�˻� ��� : ");
			search(root,input,1,"");
		}
		else //Ű�� ���� �� ����ó��
			System.out.println("ã�� Ű ���� �����ϴ�.");
	}
	
	public void search(Node node, int key, int depth, String tab){
		int i;
		System.out.print(tab+"["+depth+"] ");
		for(i=0; i<node.keySize; i++){
			if(node.key[i]==key){ //ã���� *������ְ� ����
				System.out.println("*"+node.key[i]+" ");
				return;
			}
			System.out.print(node.key[i]+" ");
			if(key<node.key[i])
				break;
		}
		System.out.println("");
		if(node.childrenSize!=0) //�ڽ� ��� ������ ������ �������鼭 ��� ã����
			search(node.children[i], key, depth+1, tab+"\t");
	}
	
	
	/**********���**********/
	public void printing(){
		printing(root, 1, "");
	}
	
	public void printing(Node node, int depth, String tab){
		System.out.print(tab+"["+depth+"] ");
		for(int i=0; i<node.keySize; i++)
			System.out.print(node.key[i]+" ");
		System.out.println(""); //���� depth�� key�� ���
		if(node.childrenSize!=0){ //�ڽĳ�� ����� ������ ������
			for(int i=0; i<node.childrenSize; i++)
				printing(node.children[i], depth+1, tab+"\t");
		}		
	}
	
	/**********�߰��Լ���**********/
	public boolean exist(Node node, int key){
		boolean result = false;
		for(int i=0; i<node.keySize; i++){ //���� node���� ���翩�� �˻�
			if(node.key[i]==key)
				return true;
		}
		if(node.childrenSize!=0){ //������ �ڽ� ���� �������� �˻縦 �����
			for(int i=0; i<node.childrenSize; i++){
				result = exist(node.children[i], key);
				if(result)
					return true;
			}
		}
		return result;
	}
	
	public int index(Node node, int key){ //key�� �ڸ� ã����
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