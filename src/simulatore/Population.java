package simulatore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author walsl
 *SYntax error.
 */
public class Population {
	//private HashMap<String, Integer> populationMap;

	// create types of organisms as private feilds
	private ArrayList<Organism> lifeForms ;
	private Integer numberCooperator;
	private Integer numberDefector;
	private Integer numberPartialCooperator;

	/**
	 * @param counts
	 * Constructs a population of organisms dictated by the given set of pairs 
	 * that associate (case-sensitive) names of organisms to counts of that type of organism.
	 *  Organisms not mentioned in the mapping do not appear in the population. 
	 *  Throws an IllegalArgumentException if the mapping mentions organism types that do not exist in the program.
	 */


	public Population(HashMap<String, Integer> counts) {
		//populationMap = counts;
		lifeForms = new ArrayList<>();
		//HashMap<String, Integer> entry;
		for(Map.Entry<String,Integer> entry : counts.entrySet()) {
			if( entry.getKey().equals("Cooperators")){
				//System.out.println()
				numberCooperator = entry.getValue();

			}
			else if( entry.getKey().equals("Defectors")){
				numberDefector = entry.getValue();

			}
			else if( entry.getKey().equals("partialCooperators")){
				numberPartialCooperator = entry.getValue();

			}


		}
		//System.out.println(numberCooperator);

		for(int i =0; i<numberCooperator; i++  ) {
			lifeForms.add(new Cooperator());
		}
		for(int i =0; i<numberDefector; i++  ) {
			lifeForms.add(new Defector());
		}
		for(int i =0; i<numberPartialCooperator; i++  ) {
			lifeForms.add(new PartialCooperator());
		}


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
		Random replace = new Random();
		int replaceIndex = replace.nextInt(lifeForms.size());
		int replaceType = replace.nextInt(2);
		for(int i = 0; i <lifeForms.size(); i++) {
			lifeForms.get(i).update();
			if(lifeForms.get(i).cooperates()&& (lifeForms.get(i).getEnergy())>=10) {
				if(lifeForms.get(i).GetType().equals("Cooperator")) {
					if(replaceType ==1) {
						lifeForms.set(replaceIndex, new PartialCooperator());
					}
					else {
						lifeForms.set(replaceIndex, new Defector());

					}

				}
				else if(lifeForms.get(i).GetType().equals("Defector")){
					if(replaceType ==1) {
						lifeForms.set(replaceIndex, new PartialCooperator());
					}
					else {
						lifeForms.set(replaceIndex, new Cooperator());

					}

				}
				else if(lifeForms.get(i).GetType().equals("PartialCooperator")){
					if(replaceType ==1) {
						lifeForms.set(i, new Cooperator());

					}
					else {
						lifeForms.set(i, new Defector());
					}
				}
			}
		}
	}

	/**
	 * @return calculates the mean cooperation probability of all the organisms 
	 * in the population�the average of 
	 * the cooperation probabilities of all the organisms in the population.
	 */
	public double calcuateCooperationMean() {
		double cooperationProbability =0; 
		double sumProabilites = 0;
		for (int i =0 ; i <lifeForms.size(); i++){
			sumProabilites +=lifeForms.get(i).getCooperationProbability();

		}
		cooperationProbability = sumProabilites/ lifeForms.size();
		return cooperationProbability;		
	}
	
	/**
	 * @return calculates the mean cooperation probability of all the organisms 
	 * in the population�the average of 
	 * the cooperation probabilities of all the organisms in the population.
	 */
	public double getMeanCooperatorCooperation() {
		double cooperationProbability =0; 
		double sumProabilites = 0;
		for (int i =0 ; i <lifeForms.size(); i++){
			if(lifeForms.get(i).GetType().equals("Cooperator")) {
			sumProabilites +=lifeForms.get(i).getCooperationProbability();
			}

		}
		cooperationProbability = sumProabilites/ lifeForms.size();
		return cooperationProbability;		
	}

	/**
	 * @return calculates the mean cooperation probability of all the organisms 
	 * in the population�the average of 
	 * the cooperation probabilities of all the organisms in the population.
	 */
	public double getMeanPartialCooperatorCooperation() {
		double cooperationProbability =0; 
		double sumProabilites = 0;
		for (int i =0 ; i <lifeForms.size(); i++){
			if(lifeForms.get(i).GetType().equals("PartialCooperator")) {
			sumProabilites +=lifeForms.get(i).getCooperationProbability();
			}

		}
		cooperationProbability = sumProabilites/ lifeForms.size();
		return cooperationProbability;		
	}
	/**
	 * @return calculates the mean cooperation probability of all the organisms 
	 * in the population�the average of 
	 * the cooperation probabilities of all the organisms in the population.
	 */
	public double getMeanDefectorCooperation() {
		double cooperationProbability =0; 
		double sumProabilites = 0;
		for (int i =0 ; i <lifeForms.size(); i++){
			if(lifeForms.get(i).GetType().equals("Defector")) {

			sumProabilites +=lifeForms.get(i).getCooperationProbability();
			}
		}
		cooperationProbability = sumProabilites/ lifeForms.size();
		return cooperationProbability;		
	}

	/**
	 * @return the counts of all the organisms in the population.
	 */
	public Map<String, Integer> getPopulationCounts(){
		int cooperatorNumber =0;
		int defectorNumber =0; 
		int  partialCooperatorNumber  =0;
		HashMap <String, Integer>resultMap  = new HashMap<>();
		for(int i =0; i< lifeForms.size(); i++) {
			if(lifeForms.get(i).GetType().equals("Cooperator")){
				cooperatorNumber += 1;
			}
			else if( lifeForms.get(i).GetType().equals("Defector")){
				defectorNumber +=1 ;
			}
			else if(lifeForms.get(i).GetType().equals("PartialCooperator")){
				partialCooperatorNumber +=1;

			}


		}
		resultMap.put("Cooperator", cooperatorNumber);
		resultMap.put("Defector", defectorNumber);
		resultMap.put("PartialCooperator", partialCooperatorNumber);

		return resultMap;
	}

}

