import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

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
	public static final int[] CLASSICAL_MOD = {1,1,1,1,1};


	/* 
	   ------------------------
	   --------ATTRIBUTS-------
	   ------------------------
	*/
	//liste l'ensemble des navires d'un joueur
	private LinkedList<Ship> _myShips = new LinkedList<Ship>();
	//représente le joueur adverse
	private Player _opponent;
	//mode de jeu actif
	private int[] _gameMod;
	//grille de jeu du joueur
	private Grid _grid = new Grid(10);


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
		this(opponent._gameMod, opponent);
	}
	
	public Player(int[] gameMod, Player opponent) {
		createList(gameMod);
		_opponent = opponent;
		_gameMod = gameMod;
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
	
	//méthode de placement des bateaux
	public void placeBoats() {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<_myShips.size(); i++) {
			System.out.println("Placez maintenant un "+_myShips.get(i).getName()+" ("+_myShips.get(i).getLength()+") : \n");
			System.out.println("Coordonnee X : ");
			int x = sc.nextInt();
			System.out.println("\nCoordonnee Y : ");
			int y = sc.nextInt();
			System.out.println("\n Dans quelle direction voulez-vous le placer ? 0: HAUT, 1: DROITE, 2: BAS, 3: GAUCHE");
			int d = sc.nextInt();
			
			Position.dir direction;
			if(d == 0)      direction = Position.dir.HAUT;
			else if(d == 1) direction = Position.dir.DROITE;
			else if(d == 2) direction = Position.dir.BAS;
			else            direction = Position.dir.GAUCHE;
			_myShips.get(i).place(x, y, direction, _grid);			
		}
	}
}
