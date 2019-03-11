import java.util.Scanner;

import domain.CardBean;
import domain.DeckBean;
import domain.HandBean;

public class Main {

	public static void main(String[] args) {

		System.out.println("METHODE LANCER LA PARTIE");
		System.out.println();

		DeckBean deck = new DeckBean();
		// deck.printDeck();
		System.out.println("Le paquet contient " + deck.getDeckNbOfCards() + " cartes. \n");
		deck.shuffle();
		// afficher le deck
		System.out.println(deck);

		// pioche les cartes de la main de joueur
		CardBean pickedCard1 = deck.pickACard();
		CardBean pickedCard2 = deck.pickACard();
		HandBean handPlayer = new HandBean(pickedCard1, pickedCard2);
		System.out.println("La main du joueur est :" + handPlayer.getHand());
		// calculer le score de la main du joueur
		int scoreP1 = handPlayer.calculateHandScore(handPlayer.getHand());
		System.out.println("Le score du joueur est de " + scoreP1 + ".");
		System.out.println();

		// pioche les cartes de la main de la banque
		CardBean pickedCard3 = deck.pickACard();
		CardBean pickedCard4 = deck.pickACard();
		HandBean handBank = new HandBean(pickedCard3, pickedCard4);
		System.out.println("La main de la banque est :" + handBank.getHand());
		// calculer le score de la main du joueur
		int scoreBank = handBank.calculateHandScore(handBank.getHand());
		System.out.println("Le score de la banque est de " + scoreBank + ".");
		System.out.println();
		System.out.println("Le paquet contient " + deck.getDeckNbOfCards() + " cartes. \n");
		System.out.println();
		System.out.println();

		System.out.println("METHODE TOUR JOUEUR");
		System.out.println();

		// Proposer au joueur de tirer une nouvelle carte

		String str = "";

		do {

			// tant que le joueur ne répond pas par O ou N, on repose la question
			do {
				// méthode askForNewCardPlayer();
				Scanner sc = new Scanner(System.in);
				System.out.println("MERCI DE SAISIR O POUR TIRER UNE NOUVELLE CARTE OU N POUR FINIR LE TOUR");
				str = sc.nextLine();
				System.out.println();
				System.out.println("Vous avez saisi : " + str);
			} while (!str.equals("O") && !str.equals("N"));

			// le joueur répond O
			if (str.equals("O")) {
				// ajouter une carte à la main du joueur
				CardBean pickedCard5 = deck.pickACard();
				handPlayer.addCard(pickedCard5);
				System.out.println("La main du joueur est :" + handPlayer.getHand());
				System.out.println("Le paquet contient " + deck.getDeckNbOfCards() + " cartes. \n");

				// calculer le score de la main du joueur
				scoreP1 = handPlayer.calculateHandScore(handPlayer.getHand());
				System.out.println("Le score du joueur est de " + scoreP1 + ".");
				System.out.println();
			}

			// le joueur répond N
			else if (str.equals("N")) {
				System.out.println("TOUR DE LA BANQUE");
			}
		} while (scoreP1 < 21);

		// si score <21, propose de tirer une carte
		if (scoreP1 > 21) {
			System.out.println("VOUS AVEZ PERDU !");

			System.out.println();
			System.out.println();
		} else {

		}

	}
}
