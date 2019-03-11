package domain;

import java.util.Scanner;

public class GameService {

	private static final String REPONSE_POSITIVE = "O";
	private static final String REPONSE_NEGATIVE = "N";
	private DeckBean deck;
	private HandBean handPlayer;
	private HandBean handBank;

	/*
	 * methodes
	 */

	// initialise la partie
	public void setUpGame() {
		deck = new DeckBean();
		deck = prepare();
		handPlayer = setUpPlayersHand();
		handBank = setUpBankersHand();
	}

	public DeckBean prepare() {
		deck = new DeckBean();
		// deck.printDeck();
		System.out.println("Le paquet contient " + deck.getDeckNbOfCards() + " cartes. \n");
		deck.shuffle();
		// afficher le deck
		System.out.println(deck);
		return deck;
	}

	public void printNbOfCardsInDeck() {
		System.out.println("Le paquet contient " + deck.getDeckNbOfCards() + " cartes. \n");
		System.out.println();
		System.out.println();
	}

	public HandBean setUpPlayersHand() {
		CardBean pickedCard1 = deck.pickACard();
		CardBean pickedCard2 = deck.pickACard();
		HandBean handPlayer = new HandBean(pickedCard1, pickedCard2);
		return handPlayer;
	}

	public int getScorePlayer() {
		int scoreP1;
		scoreP1 = handPlayer.calculateHandScore();
		return scoreP1;
	}

	public void printPlayerHand() {
		// methode d'affichage
		System.out.println("La main du joueur est :" + handPlayer.getHand());
	}

	public void printPlayerScore() {
		System.out.println("Le score du joueur est de " + getScorePlayer() + ".");
		System.out.println();
	}

	public HandBean setUpBankersHand() {
		CardBean pickedCard1 = deck.pickACard();
		CardBean pickedCard2 = deck.pickACard();
		HandBean handBank = new HandBean(pickedCard1, pickedCard2);
		return handBank;
	}

	public void printBankerHand() {
		// methode d'affichage
		System.out.println("La main de la banque est : " + handBank.getHand());
	}

	public void printBankerScore() {
		System.out.println("La main de la banque est : " + getScoreBanker() + ".");
		System.out.println();
	}

	public int getScoreBanker() {
		int scoreBank = handBank.calculateHandScore();
		return scoreBank;
	}

	// Tour du joueur
	public boolean PlayersTurn() {
		boolean lauchBankerTurn = true;
		boolean playersAnswserYes = askPlayerPickNewCard();
		while (IsScorePlayerInferiorTo22() && playersAnswserYes) {
			// On lui donner une carte
			pickANewCard(handPlayer);
			printPlayerHand();
			printPlayerScore();
			if (!IsScorePlayerInferiorTo22()) {
				System.out.println("PERDU !!");
				lauchBankerTurn = false;
			} else {
				playersAnswserYes = askPlayerPickNewCard();
			}
		}
		if (!playersAnswserYes) {
			System.out.println("TOUR DE LA BANQUE");
		}
		return lauchBankerTurn;
	}

	public boolean askPlayerPickNewCard() {
		String playersAnswer = "";
		boolean playersAnswserYes = true;
		do {
			// méthode askForNewCardPlayer();
			Scanner sc = new Scanner(System.in);
			System.out.println("MERCI DE SAISIR O POUR TIRER UNE NOUVELLE CARTE OU N POUR FINIR LE TOUR");
			playersAnswer = sc.nextLine();
			System.out.println();
			System.out.println("Vous avez saisi : " + playersAnswer);
		} while (!playersAnswer.equals(REPONSE_POSITIVE) && !playersAnswer.equals(REPONSE_NEGATIVE));
		if (playersAnswer.equals(REPONSE_NEGATIVE)) {
			playersAnswserYes = false;
		}
		return playersAnswserYes;
	}

	public boolean IsScorePlayerInferiorTo22() {
		int scoreP1 = getScorePlayer();
		return (scoreP1 <= 21);
//		boolean validScore = true;
//		if (scoreP1 > 21) {
//			System.out.println("VOUS AVEZ PERDU !");
//			validScore = false;
//		}
//		return validScore;
	}

	public boolean IsScoreBankerInferiorTo22() {
		int scoreP1 = getScoreBanker();
		return (scoreP1 <= 21);
	}

	public void pickANewCard(HandBean hand) {
		CardBean pickedCard = deck.pickACard();
		hand.addCard(pickedCard);
	}

	// Tour de la banque
	public void BankersTurn() {
		while (IsScoreBankerInferiorTo22() && getScoreBanker() < 17) {
			// On lui donner une carte
			pickANewCard(handBank);
			printBankerHand();
			printBankerScore();
			if (!IsScoreBankerInferiorTo22()) {
				System.out.println("GAGNE !!");
			}
		}
	}

	public void winner() {
		compareScores(getScorePlayer(), getScoreBanker());
		printWinner();
	}

	// comparaison des scores

	// A TERMINER
	public String compareScores(int scorePlayer, int scoreBank) {
		String winner = "Joueur";
		if (scorePlayer < scoreBank) {
			winner = "Banque";
		}
		return winner;
	}

	public void printWinner() {
		System.out.println("Le gagnant est : " + compareScores(getScorePlayer(), getScoreBanker()));
	}

	/*
	 * getters/setters
	 */

	public DeckBean getDeck() {
		return deck;
	}

	public void setDeck(DeckBean deck) {
		this.deck = deck;
	}

	public HandBean getHandPlayer() {
		return handPlayer;
	}

	public void setHandPlayer(HandBean handPlayer) {
		this.handPlayer = handPlayer;
	}

	public HandBean geHandBank() {
		return handBank;
	}

	public void setHandBank(HandBean handBank) {
		this.handBank = handBank;
	}
}
