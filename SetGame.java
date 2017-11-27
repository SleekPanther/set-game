import java.util.*;

public class SetGame {
	private ArrayList<Card> cards = new ArrayList<Card>();

	public void setCards(Card[] inputCards){
		for(int i=0; i<inputCards.length; i++){
			cards.add(inputCards[i]);
		}
	}

	public void findSets(){
		int combinationCount=0;
		for(int i=0; i<cards.size(); i++){
			for(int j=i+1; j<cards.size(); j++){
				for(int k=j+1; k<cards.size(); k++){
					System.out.println(cards.get(i)+", " + cards.get(j) +", " + cards.get(k));
					combinationCount++;
				}
			}
		}
		System.out.println("Combination Count = " + combinationCount);
	}


	public static void main(String[] args) {
		SetGame game = new SetGame();
		game.setCards(new Card[] {
				// new Card(1, 2, 3),
				// new Card(3, 2, 1),
				// new Card(1, 1, 2),
				// new Card(1, 1, 1)
				new Card(1, 1, 1), 
				new Card(2, 2, 2), 
				new Card(3, 3, 3), 
				new Card(4, 4, 4), 
				new Card(5, 5, 5)
			}
		);
		
		game.findSets();

	}
}

class Card{
	public int number;
	public int shape;
	public int color;

	public Card(int number, int shape, int color){
		this.number=number;
		this.shape=shape;
		this.color=color;
	}

	@Override
	public String toString(){
		return "[" + number + " " + shape + " " + color + "]";
	}
}