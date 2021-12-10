package simulatore;

/**
 * @author walsl
 * a type of organism (“Defector”) that never cooperates with its peers.
 */
public class Defector extends Organism{


	@Override
	public String GetType() {
		return "Defector";
	}


	@Override
	public Organism reproduce() {
		return new Defector();
	}


	@Override
	public double getCooperationProbability() {
		return 0;
	}


	@Override
	public boolean cooperates() {
		return false;
	}

}
