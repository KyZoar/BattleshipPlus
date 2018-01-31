import java.util.LinkedList;

public class Player {

	/* 
	   ------------------------
	   --------GAME MODS-------
	   ------------------------
	*/
	//                     1 Aircraft Carrier
	//                     1 Cruiser
	//classical mod with : 1 Destroyer
	//					   1 Submarine
	//                     1 Torpedo
	private static final int[] CLASSICAL_MOD = {1,1,1,1,1};


	/* 
	   ------------------------
	   --------ATTRIBUTS-------
	   ------------------------
	*/
	//liste l'ensemble des navires d'un joueur
	private LinkedList<Ship> _myShips = new LinkedList<Ship>();
	//représente le joueur adverse
	private Player _opponent;


	/* 
	   ------------------------
	   ------CONSTRUCTORS------
	   ------------------------
	*/
	public Player() {
		this(CLASSICAL_MOD, null);
	}
	
	public Player(int[] gameMod) {
		this(gameMod,null);
	}
	
	public Player(Player opponent) {
		this(CLASSICAL_MOD, opponent);
	}
	
	public Player(int[] gameMod, Player opponent) {
		createList(gameMod);
		_opponent = opponent;
	}


	/* 
	   ------------------------
	   ---------SETTERS--------
	   ------------------------
	*/
	public void setOpponent(Player p) {
		_opponent = p;
	}

	
	/* 
	   ------------------------
	   ---------METHODS--------
	   ------------------------
	*/
	private void createList(int[] gameMod) {
		addNAircraftCarrier(gameMod[0]);
		addNCruiser(gameMod[1]);
		addNDestroyer(gameMod[2]);
		addNSubmarine(gameMod[3]);
		addNTorpedo(gameMod[4]);
	}
	
	private void addNAircraftCarrier(int nb) {
		for(int i=0; i<nb; i++) {
			_myShips.add(new AircraftCarrier());
		}
	}
	
	private void addNCruiser(int nb) {
		for(int i=0; i<nb; i++) {
			_myShips.add(new Cruiser());
		}
	}
	
	private void addNDestroyer(int nb) {
		for(int i=0; i<nb; i++) {
			_myShips.add(new Destroyer());
		}
	}
	
	private void addNSubmarine(int nb) {
		for(int i=0; i<nb; i++) {
			_myShips.add(new Submarine());
		}
	}
	
	private void addNTorpedo(int nb) {
		for(int i=0; i<nb; i++) {
			_myShips.add(new Torpedo());
		}
	}
}
