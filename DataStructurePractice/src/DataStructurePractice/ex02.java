package DataStructurePractice;

class CardDeck { //20�� ¥�� �ѹ�ġ
	final int CARD_NUM = 20;
	Card[] cards = new Card[CARD_NUM]; //���� ����ִ� ����
	CardDeck(){ //ī�忡 ���� �Է�
		for(int i=0; i<cards.length; i++){
			if(i==0){cards[0] = new Card(1,true);}
			else if(i==2){cards[2] = new Card(3,true);}
			else if(i==7){cards[7] = new Card(8,true);}
			else if(i>9) {cards[i] = new Card(i-9,false);}
			else {cards[i] = new Card(i+1,false);}
			}
		}
	Card getcard(int i){return cards[i];} //deck���� ���� ��ġ�� ī�带 ����
	
	void shuffle(){ //ī�� random�ϰ� ����
		for(int i=0; i<20; i++){
			int n = (int)(Math.random()*19+0);
			Card temp = cards[i];
			cards[i] = cards[n];
			cards[n] = temp;}}
	
	Card pick(int index){ //�迭 cards���� ������ ��ġ�� Card�� ����
		Card choose = cards[index];
		return choose;}
	
	
	Card pick(){  // �迭 cards���� ������ ��ġ�� Card�� ����
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
	
	String cardinfo(){ //card������ ��Ʈ������ ����
		if(isKwang==true){return String.valueOf(num)+"k";}
		else{return String.valueOf(num);}}

}


public class ex02 {
	public static void main(String[] args){
		CardDeck deck = new CardDeck();
		
		for(int i=0; i<20; i++){ //�⺻ ī�� ���
			System.out.print(deck.getcard(i).cardinfo()+",");}
		System.out.println();
		
		System.out.println(deck.pick(0).cardinfo());
		System.out.println(deck.pick().cardinfo());
		deck.shuffle();
		for(int i=0; i<20; i++){ //ī�带 ���� �� ���
			System.out.print(deck.getcard(i).cardinfo()+",");}

		System.out.println();
		System.out.println(deck.pick(0).cardinfo());
		
		
	}

}