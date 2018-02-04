
public class Position {

	public enum dir {HAUT, DROITE, BAS, GAUCHE};
	
	/* 
	   ------------------------
	   --------ATTRIBUTS-------
	   ------------------------
	*/
	//coordX & coordY are point's coordinates
	private int _coordX, _coordY;
	//orientation is the direction of the object
	// 0: horizontal, 1; vertical
	private dir _orientation;

	
	/* 
	   ------------------------
	   -------CONSTUCTOR-------
	   ------------------------
	*/
	public Position(int x, int y, dir direction){
		_coordX = x;
		_coordY = y;
		_orientation = direction;
	}

	
	/* 
	   ------------------------
	   ---------GETTERS--------
	   ------------------------
	*/
	public int getX() {
		return _coordX;
	}
	
	public int getY() {
		return _coordY;
	}
	
	public dir getDirection() {
		return _orientation;
	}

	
	/* 
	   ------------------------
	   ---------SETTERS--------
	   ------------------------
	*/
	public void setX(int x) {
		_coordX = x;
	}
	
	public void setY(int y) {
		_coordY = y;
	}
	
	public void setDir(dir direction) {
		_orientation = direction;
	}
}
