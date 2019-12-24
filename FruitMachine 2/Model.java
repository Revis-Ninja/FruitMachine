//ZHENG ZHAOHUO
//2455448z

import java.util.Random;
public class Model {
	
public int Balance;
private String[] fruit =  {"Jack","Queen","King","Ace","Joker"};
public String card1="King",card2="Queen",card3="Jack";


	public Model() {
		Balance = 100;
	}
	
	public void spin() {
		// randomly assign value to card
		Random r = new Random();
		int count1 = r.nextInt(5);
		int count2 = r.nextInt(5);
		int count3 = r.nextInt(5);
		
	    card1=fruit[count1];
		card2=fruit[count2];
		card3=fruit[count3];
	
	}
	
	public int balanceUpdate() {
		
		String[] poker = {card1,card2,card3};
		
		if(   card1.equals("Joker")
			||card2.equals("Joker")
			||card3.equals("Joker")){
			for(int i = 0;i<3;i++) {
				if(poker[i].equals("Joker")) {
					Balance = Balance - 25;
				}
			}		
		}
		
		
		else if(  (card1.equals(card2)&&!card3.equals(card1))	  // remember to exclude situation that all three cards are the same
				||(card1.equals(card3)&&!card2.equals(card1))
				||(card2.equals(card3)&&!card1.equals(card2))){
			Balance = Balance + 20;
		}
		
		else if(card1.equals(card2)&&card2.equals(card3)) {
			Balance = Balance + 50;
		}
		
		return Balance;
	}
	
	
	
public String ResultUpdate() {
		String result = null;
		String[] poker = {card1,card2,card3};
		int sum = 0;
		int point;
		if(   card1.equals("Joker")
			||card2.equals("Joker")
			||card3.equals("Joker")){
			for(int i = 0;i<3;i++) {
				if(poker[i].equals("Joker")) {
					sum++;
					
				}
			}
			point = sum*25;
			result = ""+sum+" jokers: you lose "+point+" points";
		}
		
		
		else if(  (card1.equals(card2)&&!card3.equals(card1))
				||(card1.equals(card3)&&!card2.equals(card1))
				||(card2.equals(card3)&&!card1.equals(card2))){
			result = "Two of a kind-you win 20 points";
		}
		
		else if(card1.equals(card2)&&card2.equals(card3)) {
			result = "Three of kinds - you win 50 points";
		}
		else {
			result = "Balance unchanged !";
		}
		
		return result;
	}
}
