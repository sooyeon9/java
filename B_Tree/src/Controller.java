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
			System.out.print("1. 삽입\n2. 삭제\n3. 검색\n4. 출력\n9. 일괄 삽입\n0. 종료\n선택 : ");
			int choice = sc.nextInt();
			// 1. 삽입
			if (choice == 1) {
				while (true) {
					System.out.print("삽입할 키 (종료: -1) : ");
					int input = sc.nextInt();
					if (input == -1) {
						break;
					} else {
						bt.add(input);
					}
				}
			}
			// 2. 삭제
			else if (choice == 2) {
				while (true) {
					 System.out.print("삭제할 키 (종료 : -1) : ");
					 int input = sc.nextInt();
					 if (input == -1) {
						 break;
					 } else {
						 bt.delete(input);
					 }
				}
			}
			// 3. 검색
			else if (choice == 3) {
				while (true) {
					System.out.print("검색할 키 (종료: -1) : ");
					int input = sc.nextInt();
					if (input == -1) {
						break;
					} else {
						bt.search(input);
					}
				}
			}
			// 4. 출력
			else if (choice == 4) {
				System.out.println("B-트리 출력");
				bt.printTree(bt.root, "", 1);
				System.out.println("");
			}
			// 9. 일괄 삽입
			else if (choice == 9) {
				System.out.print("데이터 파일 : ");
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
			// 0. 종료
			else if (choice == 0) {
				sc.close();
				break;
			}
		}
	}
}
