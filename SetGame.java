import java.util.*;

public class SetGame {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private ArrayList<Card[]> validSets = new ArrayList<Card[]>();

	public void addCards(Card[] inputCards){
		for(int i=0; i<inputCards.length; i++){
			cards.add(inputCards[i]);
		}
	}

	public ArrayList<Card> getCards(){
		return cards;
	}

	public void findSets(){
		//Find all possible sets (n choose 3 combinations)
		for(int i=0; i<cards.size(); i++){
			for(int j=i+1; j<cards.size(); j++){
				for(int k=j+1; k<cards.size(); k++){
					if(isSetValid(cards.get(i), cards.get(j), cards.get(k))){
						validSets.add(new Card[]{cards.get(i), cards.get(j), cards.get(k)});
					}
				}
			}
		}

		if(validSets.isEmpty()){
			System.out.println("No Valid Sets. Must Draw more cards.");
		}
		else{
			System.out.println("Valid Sets");
			for(Card[] set : validSets){
				for(Card card : set){
					System.out.print(card +" ");
				}
				System.out.println();
			}
		}
	}

	//Valid sets must either have all different numbers, shapes & colors, or all the same
	private boolean isSetValid(Card card1, Card card2, Card card3){
		if(!areAllEqual(card1.number, card2.number, card3.number) && !areAllDifferent(card1.number, card2.number, card3.number)){
			return false;
		}
		if(!areAllEqual(card1.shape, card2.shape, card3.shape) && !areAllDifferent(card1.shape, card2.shape, card3.shape)){
			return false;
		}
		if(!areAllEqual(card1.color, card2.color, card3.color) && !areAllDifferent(card1.color, card2.color, card3.color)){
			return false;
		}
		return true;
	}

	private boolean areAllEqual(int num1, int num2, int num3){
		return num1==num2 && num2==num3;
	}

	private boolean areAllDifferent(int num1, int num2, int num3){
		return num1 != num2 && num2 != num3 && num1 != num3;
	}

	//Iterative implementation of n choose 3 for combinations
	public void printCombinations(ArrayList<Card> cards){
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
		game.addCards(new Card[] {
				new Card(1, 2, 3),
				new Card(2, 1, 2),
				new Card(3, 3, 1),
				new Card(2, 2, 1),
				new Card(2, 2, 1),
				new Card(2, 2, 1),
			}
		);

		System.out.println("Available Cards");
		for(Card card : game.getCards()){
			System.out.println(card);
		}

		System.out.println("\nAll Combinations");
		game.printCombinations(game.getCards());
		
		System.out.println();
		game.findSets();
	}
}

class Card{
	//Internal representation of cards are integers for ease of calculation
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