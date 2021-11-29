package simulatore;

public abstract class Organism {
	int organisimEnergy;
	public Organism(){
		organisimEnergy =0;
	}
	/**
	 * updates the given organism. 
	 * By default, an organism gains one new energy point.
	 */
	public void update (){
		
	}
	

	/**
	 * @return the current energy of this organism.
	 */ 
	public int getEnergy() {
		
	}
	/**
	 * increments this organism’s energy by 1.
	 */
	public void incrementEnergy() {
		
	}
	/**
	 * decrements this organism’s energy by 1. 
	 * An organism’s energy cannot be decremented below 0.
	 */
	public void decmentEnergy() {
		
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
