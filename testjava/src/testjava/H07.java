package testjava;

import java.util.Scanner;
public class H07 {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      while(true){
         System.out.println("=====================================");
         System.out.print("=> 문자열을 입력하시오. (x: 종료) : ");
         String input = s.nextLine();
         
         if(input.equals("x")){break;}
         
         System.out.println("=> 총 문자의 개수는 "+input.length()+"개 입니다.");
         for(int i=0;i<input.length();i++){
            System.out.println("=> "+input.charAt(i));}
         
         System.out.println();}
      
      System.out.println("* 종료되었습니다.");
   }
}