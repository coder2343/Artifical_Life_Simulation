package simulatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * @author walsl
 * class runs through creating a population of bacteria and managing the whole life simulation
 */
public class Population {
	// create types of organisms as private fields
	private ArrayList<Organism> lifeForms ;
	private Integer numberCooperator;
	private Integer numberDefector;
	private Integer numberPartialCooperator;

	/**
	 * @param counts
	 * Constructs a population of organisms dictated by the given set of pairs 
	 * that associate (case-sensitive) names of organisms to counts of that type of organism.
	 * Organisms not mentioned in the mapping do not appear in the population. 
	 * Throws an IllegalArgumentException if the mapping mentions organism types that do not exist in the program.
	 */
	public Population(HashMap<String, Integer> counts) {
		//populationMap = counts;
		lifeForms = new ArrayList<>();
		for(Map.Entry<String,Integer> entry : counts.entrySet()) {
			if( entry.getKey().equals("Cooperators")){
				numberCooperator = entry.getValue();
			}
			else if(entry.getKey().equals("Defectors")){
				numberDefector = entry.getValue();
			}
			else if(entry.getKey().equals("partialCooperators")){
				numberPartialCooperator = entry.getValue();
			}
		}
		for(int i =0; i<numberCooperator; i++) {
			lifeForms.add(new Cooperator());
		}
		for(int i =0; i<numberDefector; i++) {
			lifeForms.add(new Defector());
		}
		for(int i =0; i<numberPartialCooperator; i++) {
			lifeForms.add(new PartialCooperator());
		}
	}

	/**
	 * @param lifeFormsSize
	 * @return arrayList of indexes in random order.
	 */
	public static ArrayList<Integer> generateListRandomNumbers(int lifeFormsSize) {
		ArrayList<Integer> randomIndexList = new ArrayList<>();
		for(int i =0; i<lifeFormsSize; i++) {
			randomIndexList.add(i);
		}
		//Shuffle list to be random order
		Collections.shuffle(randomIndexList);
		return randomIndexList;
	}
	
	/**
	 * @param organismIndex
	 * @param populationSize
	 * @return random index for replacement if organsim i reporduces.
	 */
	public static int generateUniqueReplacementIndex(int organismIndex, int populationSize) {
		Random replace = new Random();
		int replaceIndex= replace.nextInt(populationSize);
		while(organismIndex == replaceIndex) {
			replaceIndex = replace.nextInt(populationSize);
		}
		if(organismIndex !=replaceIndex ) {
			return replaceIndex;
		}
		else {
			return -1;
		}
	}
	
	
	
	/**
	 * oops through all the organisms in the population and (
	 * 1) updates them (by calling their update method), 
	 * (2) checks to see if they cooperate as described above and 
	 * (3) checks to see if they reproduce. We check to see if an organism reproduces 
	 * by first checking its energy level. 
	 * If the organism has at least 10 energy units, 
	 *then it reproduces a and that new organism replaces a random organism in the population.
	 */
	public void update() {
		ArrayList<Integer> randomIndexList = generateListRandomNumbers(lifeForms.size());
		// iterate through whole population
		for(int i= 0; i <lifeForms.size();i++) {
			lifeForms.get(i).update();
			int replaceIndex = generateUniqueReplacementIndex(i, lifeForms.size());

			// check cooperation and add / decrease energy points 
			// set correct donation number 
			int donationNumber = 8;
			if(lifeForms.size()<8) {
				donationNumber = lifeForms.size() - 1;
			}
			if(lifeForms.get(i).cooperates()) {
				// minus energy by 1
				lifeForms.get(i).decmentEnergy();
				// iterate through and add new index for lifeform to increment energy
				for(int b =0; b<donationNumber; b++) {
					Integer CooperationIndex = randomIndexList.get(b);
					// check if cooperator is donating to itself and correct the sitatuioon
					if(lifeForms.get(i)== lifeForms.get(CooperationIndex)) {
						CooperationIndex = randomIndexList.get(b +1);
						// adjust b to skip next index and intended go for one more round
						// set b 
						b=b+2;
						b++;
						lifeForms.get(CooperationIndex).incrementEnergy();
						continue;
					}
					lifeForms.get(CooperationIndex).incrementEnergy();
				}
			}
	
			if((lifeForms.get(i).getEnergy())>=10) {
				if(lifeForms.get(i).GetType().equals("Cooperator")) {
					lifeForms.set(replaceIndex, new Cooperator());
				}
				else if(lifeForms.get(i).GetType().equals("Defector")){
					lifeForms.set(replaceIndex, new Defector());
				}
				else if(lifeForms.get(i).GetType().equals("PartialCooperator")){
					lifeForms.set(replaceIndex, new PartialCooperator());
				}
			}
		}
	}


	/**
	 * @return calculates the mean cooperation probability of all the organisms 
	 * in the population葉he average of 
	 * the cooperation probabilities of all the organisms in the population.
	 */
	public double calcuateCooperationMean() {
		double cooperationProbability =0; 
		double sumProabilites = 0;
		for (int i = 0 ;i <lifeForms.size(); i++){
			sumProabilites +=lifeForms.get(i).getCooperationProbability();

		}
		cooperationProbability = sumProabilites / lifeForms.size();
		return cooperationProbability;		
	}

	/**
	 * @return calculates the mean cooperation probability of all the organisms 
	 * in the population葉he average of 
	 * the cooperation probabilities of all the organisms in the population.
	 */
	public double getMeanCooperatorCooperation() {
		double cooperationProbability = 0; 
		double sumProabilites = 0;
		for (int i =0 ; i <lifeForms.size(); i++){
			if(lifeForms.get(i).GetType().equals("Cooperator")) {
				sumProabilites += lifeForms.get(i).getCooperationProbability();
			}
		}
		cooperationProbability = sumProabilites / lifeForms.size();
		return cooperationProbability;		
	}

	/**
	 * @return calculates the mean cooperation probability of all the organisms 
	 * in the population葉he average of 
	 * the cooperation probabilities of all the organisms in the population.
	 */
	public double getMeanPartialCooperatorCooperation() {
		double cooperationProbability =0; 
		double sumProabilites = 0;
		for (int i = 0; i<lifeForms.size(); i++){
			if(lifeForms.get(i).GetType().equals("PartialCooperator")) {
				sumProabilites += lifeForms.get(i).getCooperationProbability();
			}
		}
		cooperationProbability = sumProabilites / lifeForms.size();
		return cooperationProbability;		
	}
	/**
	 * @return calculates the mean cooperation probability of all the organisms 
	 * in the population葉he average of 
	 * the cooperation probabilities of all the organisms in the population.
	 */
	public double getMeanDefectorCooperation() {
		double cooperationProbability =0; 
		double sumProabilites = 0;
		for (int i =0 ; i<lifeForms.size(); i++){
			if(lifeForms.get(i).GetType().equals("Defector")) {
				sumProabilites += lifeForms.get(i).getCooperationProbability();
			}
		}
		cooperationProbability = sumProabilites / lifeForms.size();
		return cooperationProbability;		
	}

	/**
	 * @return the counts of all the organisms in the population in a map for conveince and access
	 */
	public Map<String, Integer> getPopulationCounts(){
		int cooperatorNumber =0;
		int defectorNumber =0; 
		int  partialCooperatorNumber  =0;
		HashMap <String, Integer>resultMap  = new HashMap<>();
		for(int i =0; i< lifeForms.size(); i++) {
			if(lifeForms.get(i).GetType().equals("Cooperator")){
				cooperatorNumber +=1;
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

