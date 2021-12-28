package simulatore;

/**
 * @author walsl
 * a type of organism (“Cooperator”) that always cooperates with its peers.
 */
public class Cooperator extends Organism {
	@Override
	public String GetType() {
		return "Cooperator";
	}


	@Override
	public Organism reproduce() {
		return new Cooperator();
	}


	@Override
	public double getCooperationProbability() {
		return 1;
	}

	/**
	 * When an organism cooperates, it loses one of its energy units and in exchange it gives eight other organisms an energy unit. 
	 * (You will randomly select which other organisms to give energy to.)
	 *@return true 100% of the tiems because this organism always cooperates with peers
	 */
	@Override
	public boolean cooperates() {
		return true;
	}

}
