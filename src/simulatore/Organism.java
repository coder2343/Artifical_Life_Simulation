package simulatore;

/**
 * @author walsl
 * base class which all organism types are derived from
 */
public abstract class Organism {
	private int organisimEnergy;
	public Organism(){
		organisimEnergy =0;
	}
	/**
	 * updates the given organism. 
	 * By default, an organism gains one new energy point.
	 */
	public void update (){
		incrementEnergy();
	}


	/**
	 * @return the current energy of this organism.
	 */ 
	public int getEnergy() {
		return organisimEnergy;

	}
	/**
	 * increments this organism’s energy by 1.
	 */
	public void incrementEnergy() {
		organisimEnergy +=1;

	}
	/**
	 * decrements this organism’s energy by 1. 
	 * An organism’s energy cannot be decremented below 0.
	 */
	public void decmentEnergy() {
		if(organisimEnergy >1) {
			organisimEnergy -=1;
		}
	}

	/**
	 * @return returns the type of this Organism as a string.
	 */
	public abstract String GetType();


	/**
	 * @return called by update when the organism can reproduce. 
	 * Creates an offspring organism and returns it.
	 */
	public abstract Organism reproduce();

	/**
	 * @return the cooperation probability of this organism.
	 */
	public abstract double getCooperationProbability();

	/**
	 * @return returns whether or not the organism cooperates.
	 */
	public abstract boolean cooperates();


}
