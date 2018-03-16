import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
	BTree bt;
	public Controller() {
		bt = new BTree();
	}
	public void start() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("1. ����\n2. ����\n3. �˻�\n4. ���\n9. �ϰ� ����\n0. ����\n���� : ");
			int choice = sc.nextInt();
			// 1. ����
			if (choice == 1) {
				while (true) {
					System.out.print("������ Ű (����: -1) : ");
					int input = sc.nextInt();
					if (input == -1) {
						break;
					} else {
						bt.add(input);
					}
				}
			}
			// 2. ����
			else if (choice == 2) {
				while (true) {
					 System.out.print("������ Ű (���� : -1) : ");
					 int input = sc.nextInt();
					 if (input == -1) {
						 break;
					 } else {
						 bt.delete(input);
					 }
				}
			}
			// 3. �˻�
			else if (choice == 3) {
				while (true) {
					System.out.print("�˻��� Ű (����: -1) : ");
					int input = sc.nextInt();
					if (input == -1) {
						break;
					} else {
						bt.search(input);
					}
				}
			}
			// 4. ���
			else if (choice == 4) {
				System.out.println("B-Ʈ�� ���");
				bt.printTree(bt.root, "", 1);
				System.out.println("");
			}
			// 9. �ϰ� ����
			else if (choice == 9) {
				System.out.print("������ ���� : ");
				String addr = sc.next();
				//String addr = "/Users/Taesung/Downloads/rand100.txt";
				try {
					BufferedReader br = new BufferedReader(new FileReader(addr));
					while (true) {
						String line = br.readLine();
						if (line == null)
							break;
						bt.add(new Integer(line).intValue());
					}
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 0. ����
			else if (choice == 0) {
				sc.close();
				break;
			}
		}
	}
}
