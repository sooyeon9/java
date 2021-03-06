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
			System.out.print("1. 삽입\n2. 삭제\n3. 검색\n4. 출력\n9. 일괄 삽입\n0. 종료\n선택 : ");
			select = s.nextInt();
			
			if(select==1){ //1.삽입
				while(true){
					System.out.print("삽입할 키 (종료: -1) : ");
					input = s.nextInt();
					if(input==-1)
						break;
					else
						b.insert(input);
				}
			} 
			
			else if(select==2){ //2.삭제
				while(true){
					System.out.print("삭제할 키 (종료: -1) : ");
					input = s.nextInt();
					if(input==-1)
						break;
					else
						b.delete(input);
				}
			}
			
			else if(select==3){ //3.검색
				while(true){
					System.out.print("검색할 키 (종료: -1) : ");
					input = s.nextInt();
					if(input==-1)
						break;
					else
						b.search(input);
				}
			}
			
			else if(select==4){ //4.출력
				System.out.println("B-tree 출력");
				b.printing();
				System.out.println("");
			}
			
			else if(select==9){ //9.일괄삽입
				System.out.print("데이터 파일(경로) : ");
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
		
			else if(select==0){ //0.종료
				System.out.println("종료합니다.\n");
				break;
			}
			
			else { //잘못된 입력
				System.out.println("잘못된 입력 - 다시 입력하세요.\n");
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		menu menu = new menu();
		menu.start();
	}

}
