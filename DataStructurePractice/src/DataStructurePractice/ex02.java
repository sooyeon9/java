package DataStructurePractice;

class CardDeck { //20개 짜리 한뭉치
	final int CARD_NUM = 20;
	Card[] cards = new Card[CARD_NUM]; //아직 비어있는 상태
	CardDeck(){ //카드에 정보 입력
		for(int i=0; i<cards.length; i++){
			if(i==0){cards[0] = new Card(1,true);}
			else if(i==2){cards[2] = new Card(3,true);}
			else if(i==7){cards[7] = new Card(8,true);}
			else if(i>9) {cards[i] = new Card(i-9,false);}
			else {cards[i] = new Card(i+1,false);}
			}
		}
	Card getcard(int i){return cards[i];} //deck에서 지정 위치의 카드를 리턴
	
	void shuffle(){ //카드 random하게 섞음
		for(int i=0; i<20; i++){
			int n = (int)(Math.random()*19+0);
			Card temp = cards[i];
			cards[i] = cards[n];
			cards[n] = temp;}}
	
	Card pick(int index){ //배열 cards에서 지정된 위치의 Card를 리턴
		Card choose = cards[index];
		return choose;}
	
	
	Card pick(){  // 배열 cards에서 임의의 위치의 Card를 리턴
		int n = (int)(Math.random()*19+0);
		Card choose = cards[n];
		return choose;} 
	}


class Card {
	int num;
	boolean isKwang;
	
	Card(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;}
	
	String cardinfo(){ //card정보를 스트링으로 리턴
		if(isKwang==true){return String.valueOf(num)+"k";}
		else{return String.valueOf(num);}}

}


public class ex02 {
	public static void main(String[] args){
		CardDeck deck = new CardDeck();
		
		for(int i=0; i<20; i++){ //기본 카드 출력
			System.out.print(deck.getcard(i).cardinfo()+",");}
		System.out.println();
		
		System.out.println(deck.pick(0).cardinfo());
		System.out.println(deck.pick().cardinfo());
		deck.shuffle();
		for(int i=0; i<20; i++){ //카드를 섞은 후 출력
			System.out.print(deck.getcard(i).cardinfo()+",");}

		System.out.println();
		System.out.println(deck.pick(0).cardinfo());
		
		
	}

}