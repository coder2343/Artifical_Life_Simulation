package simulatore;

/**
 * @author walsl
 * a type of organism (“Defector”) that never cooperates with its peers.
 */
public class Defector extends Organism{

	@Override
	public String GetType() {
		// TODO Auto-generated method stub
		return "Defector";
	}

	@Override
	public Organism reproduce() {
		// TODO Auto-generated method stub
		return new Defector();
	}

	@Override
	public double getCooperationProbability() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean cooperates() {
		// TODO Auto-generated method stub
		return false;
	}

}
