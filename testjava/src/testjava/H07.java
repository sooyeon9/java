package testjava;

import java.util.Scanner;
public class H07 {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      while(true){
         System.out.println("=====================================");
         System.out.print("=> ���ڿ��� �Է��Ͻÿ�. (x: ����) : ");
         String input = s.nextLine();
         
         if(input.equals("x")){break;}
         
         System.out.println("=> �� ������ ������ "+input.length()+"�� �Դϴ�.");
         for(int i=0;i<input.length();i++){
            System.out.println("=> "+input.charAt(i));}
         
         System.out.println();}
      
      System.out.println("* ����Ǿ����ϴ�.");
   }
}