package simulatore;

import java.util.Map;

/**
 * @author walsl
 *SYntax error.
 */
public class Population {
	private Map<String, Integer> populationMap;
	
	
	/**
	 * @param counts
	 * Constructs a population of organisms dictated by the given set of pairs 
	 * that associate (case-sensitive) names of organisms to counts of that type of organism.
	 *  Organisms not mentioned in the mapping do not appear in the population. 
	 *  Throws an IllegalArgumentException if the mapping mentions organism types that do not exist in the program.
	 */
	public Population(Map<String, Integer> counts) {
		populationMap = counts;
		
	}
	
	/**
	 * oops through all the organisms in the population and (
	 * 1) updates them (by calling their update method), 
	 * (2) checks to see if they cooperate as described above and 
	 * (3) checks to see if they reproduce. We check to see if an organism reproduces 
	 * by first checking its energy level. 
	 * If the organism has at least 10 energy units, 
	 *then it reproduces a
	 *and that new organism replaces a random organism in the population.
	 *    --- QUESTION FOR BARB 
	 *    		DOES THAT mean any organism will be replaced or organism of some other type
	 */
	public void update() {
		
	}
	
	/**
	 * @return calculates the mean cooperation probability of all the organisms 
	 * in the population�the average of 
	 * the cooperation probabilities of all the organisms in the population.
	 */
	public double calcuateCooperationMean() {
		int cooperatorNumber = populationMap.get("Cooperator");
		int defectorNumber = populationMap.get("Defector");
		int  partialCooperatorNumber  = populationMap.get("PartialCooperator");
		
		return ( (double) cooperatorNumber +


		
	}
	
	/**
	 * @return the counts of all the organisms in the population.
	 */
	public Map<String, Integer> getPopulationCounts(){
		int cooperatorNumber = populationMap.get("Cooperator");
		int defectorNumber = populationMap.get("Defector");
		int  partialCooperatorNumber  = populationMap.get("PartialCooperator");
		return cooperatorNumber+ defectorNumber +partialCooperatorNumber;
	}
}
