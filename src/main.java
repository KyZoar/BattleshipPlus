
public class main {

	public static void main(String[] args) {

		/*
		 * PHASE D'INITIALISATION DES JOUEURS
		 */
		Player p1 = new Player(Player.CLASSICAL_MOD);
		Player p2 = new Player(p1);
		p1.setOpponent(p2);
		
		/*
		 * PHASE DE PREPARATION
		 * MISE EN PLACE DES BATEAUX
		 */
		p1.placeBoats();
		p2.placeBoats();
	}

}
