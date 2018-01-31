
public abstract class Ship {


	/* 
	   ------------------------
	   --------ATTRIBUTS-------
	   ------------------------
	*/
	//maximum of damage that a ship can take
	private int _resistance;
	
	//number of cases occupied by the ship
	private int _cases;
	//range for shooting
	private int _shootingRange;
	//the number of times the boat has been shot
	private int _damageTaken;
	//indicates if the boat sank
	private boolean _isSank;

	
	/* 
	   ------------------------
	   -------CONSTUCTOR-------
	   ------------------------
	*/
	public Ship(int nbCases, int shootingRange, int resistance){
		_cases = nbCases;
		_shootingRange = shootingRange;
		_resistance = resistance;
		_damageTaken = 0;
		_isSank = false;
	}


	/* 
	   ------------------------
	   ---------GETTERS--------
	   ------------------------
	*/
	public int getLength() {
		return _cases;
	}
	
	public int getRange() {
		return _shootingRange;
	}
	
	public int getPV() {
		return _resistance-_damageTaken;
	}
	
	public boolean isSank() {
		return _isSank;
	}


	
	/* 
	   ------------------------
	   ---------METHODS--------
	   ------------------------
	*/
	public void touch() {
		_damageTaken++;
		if(_damageTaken == _resistance) _isSank = true;
	}
}
