package simulatore;

import java.util.Random;

/**
 * @author walsl
 *a type of organism (“PartialCooperator”) that cooperates with probability 0.5. 
 *That is, it acts as if it is cooperator 50% of the time and as a defector 50% of the time.
 */
public class PartialCooperator extends Organism {
	Random cooperatorGenerator;



	public PartialCooperator() {
		cooperatorGenerator = new Random();
	}

	/**
	 *
	 */
	@Override
	public String GetType() {
		// TODO Auto-generated method stub
		return "PartialCooperator";
	}

	@Override
	public Organism reproduce() {
		// TODO Auto-generated method stub

		return new PartialCooperator() ;
	}


	@Override
	public double getCooperationProbability() {
		return 0.5;
	}

	/**
	 *@return true when random number generated between 0-100 is greater than 50
	 *else will return false;
	 */
	@Override
	public boolean cooperates() {
		int coperateDeterminator = cooperatorGenerator.nextInt(101);
		if(coperateDeterminator >50) {

			return true;
		}
		else {
			return false;
		}
	}

}
