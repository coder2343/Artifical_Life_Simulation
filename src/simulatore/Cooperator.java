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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCooperationProbability() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 *@return true 100% of the tiems because this organism always cooperates with peers
	 */
	@Override
	public boolean cooperates() {
		// TODO Auto-generated method stub
		return true;
	}

}
