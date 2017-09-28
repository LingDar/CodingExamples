 


/**
 * This class models a simple die object, which can have any number of sides.
 *   @author Dave Reed
 *   @version 9/10/09
 */
public class Die {
	private int numSides;
	private int numRolls;

	/**
	 * Constructs a 6-sided die object
	 */
	public Die() {
		this.numSides = 6;
		this.numRolls = 0;
	}
	
	/**
	 * Constructs an arbitrary die object.
	 *   @param sides the number of sides on the die
	 */
	public Die(int sides) {
		this.numSides = sides;
		this.numRolls = 0;
	}
	
	/**
	 * Gets the number of sides on the die object.
	 *   @return  the number of sides (an N-sided die can roll 1 through N)
	 */
	public int getNumberOfSides() {
		return this.numSides;
	}
	
	/**
	 * Gets the number of rolls by on the die object.
	 *   @return  the number of times roll has been called
	 */
	public int getNumberOfRolls() {
		return this.numRolls;
	}
		
	/**
	 * Simulates a random roll of the die.
	 *   @return  the value of the roll (for an N-sided die, the roll is between 1 and N)
	 */
	public int roll() {
	    this.numRolls = this.numRolls + 1;
	    
	    int currentRoll = (int)(Math.random()*this.numSides + 1);
		return currentRoll;
	}
}
