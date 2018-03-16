import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class menu {
	Btree b;
	public menu() {
		b = new Btree();
	}
	
	public void start(){
		Scanner s = new Scanner(System.in);
		int select,input;
		
		while(true){
			System.out.print("1. ����\n2. ����\n3. �˻�\n4. ���\n9. �ϰ� ����\n0. ����\n���� : ");
			select = s.nextInt();
			
			if(select==1){ //1.����
				while(true){
					System.out.print("������ Ű (����: -1) : ");
					input = s.nextInt();
					if(input==-1)
						break;
					else
						b.insert(input);
				}
			} 
			
			else if(select==2){ //2.����
				while(true){
					System.out.print("������ Ű (����: -1) : ");
					input = s.nextInt();
					if(input==-1)
						break;
					else
						b.delete(input);
				}
			}
			
			else if(select==3){ //3.�˻�
				while(true){
					System.out.print("�˻��� Ű (����: -1) : ");
					input = s.nextInt();
					if(input==-1)
						break;
					else
						b.search(input);
				}
			}
			
			else if(select==4){ //4.���
				System.out.println("B-tree ���");
				b.printing();
				System.out.println("");
			}
			
			else if(select==9){ //9.�ϰ�����
				System.out.print("������ ����(���) : ");
				// C:\Users\user-pc\Desktop\rand100.txt
				String path = s.next();
				try {
					BufferedReader br = new BufferedReader(new FileReader(path));
					while(true){
						String line = br.readLine();
						if(line==null)
							break;
						b.insert(new Integer(line).intValue());
					}
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			else if(select==0){ //0.����
				System.out.println("�����մϴ�.\n");
				break;
			}
			
			else { //�߸��� �Է�
				System.out.println("�߸��� �Է� - �ٽ� �Է��ϼ���.\n");
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		menu menu = new menu();
		menu.start();
	}

}