import domain.GameService;

public class Main {

	public static void main(String[] args) {

		/**** IHM et mécanique d'interaction ****/

		// Initialiser une partie
		GameService gameService = new GameService();
		gameService.setUpGame();

		// Faire afficher les éléments du jeu (main de chaque joueur)

		gameService.printBankerHand();
		gameService.printBankerScore();
		gameService.printPlayerHand();
		gameService.printPlayerScore();
		gameService.printNbOfCardsInDeck();

		// Faire tirer des cartes au joueur
		gameService.PlayersTurn();

		// Faire tirer les cartes à la banque
		gameService.BankersTurn();

		// Détermination du gagnant
		gameService.winner();
	}

}
