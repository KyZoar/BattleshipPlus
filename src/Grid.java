import java.util.LinkedList;
import java.util.Map;

public class Grid {


	/* 
	   ------------------------
	   --------ATTRIBUTS-------
	   ------------------------
	*/
	//dimension de la grille de jeu
	private static int _dimGrid;
	//liste l'ensemble des cases occupées
	private Map<Ship, LinkedList<Integer>> _boats;


	/* 
	   ------------------------
	   ------CONSTRUCTORS------
	   ------------------------
	*/

	public Grid(int dim) {
		_dimGrid = dim;
	}


	/* 
	   ------------------------
	   ---------GETTERS--------
	   ------------------------
	*/

	public static int getDim() {
		return _dimGrid;
	}


	/* 
	   ------------------------
	   ---------METHODS--------
	   ------------------------
	*/
	
	public void addBoat(Ship boat, Position position) {
		LinkedList<Integer> pos = new LinkedList<Integer>();
		if(position.getDirection() == Position.dir.HAUT) {
			for(int i=0; i<boat.getLength(); i++) {
				pos.add(position.getX()+(position.getY()-i)*Grid.getDim());
			}		
		}
		else if(position.getDirection() == Position.dir.DROITE) {
			for(int i=0; i<boat.getLength(); i++) {
				pos.add((position.getX()+i)+position.getY()*Grid.getDim());
			}		
		}
		else if(position.getDirection() == Position.dir.BAS) {
			for(int i=0; i<boat.getLength(); i++) {
				pos.add(position.getX()+(position.getY()+i)*Grid.getDim());
			}		
		}
		else if(position.getDirection() == Position.dir.HAUT) {
			for(int i=0; i<boat.getLength(); i++) {
				pos.add((position.getX()-i)+position.getY()*Grid.getDim());
			}		
		}
		_boats.put(boat, pos);
	}
}