package simulatore;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ALifeSim {

	
	/**
	 * @param args <#/iterations> <#/cooperators> <#/defectors> <#/partial cooperators> 
	 */
	public static void main(String args[]) {
		Integer iterations =0, cooperators = 0, defectors=0, partialCooperators =0;
		HashMap<String, Integer> inputTable = new HashMap<>();
		try {
			iterations = Integer.parseInt(args[0]);
			cooperators = Integer.parseInt(args[1]);
			System.out.println(cooperators);
			defectors = Integer.parseInt(args[2]);
			partialCooperators = Integer.parseInt(args[3]);

		}
		catch(NumberFormatException e){
			
		}
		inputTable.put("Cooperators", cooperators);
		inputTable.put("Defectors", defectors);
		inputTable.put("partialCooperators", partialCooperators);
		
		Population testPopulation = new Population(inputTable);

		// implemmenting population
		for(int i= 0; i<100;i++) {
			testPopulation.update();
			
		}
		Map<String,Integer> expirmentOutput = testPopulation.getPopulationCounts();
		System.out.println("After: " + iterations + " iterations" );
		for(Map.Entry<String,Integer> entry : expirmentOutput.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println("mean cooperation proabability =" + " " + testPopulation.calcuateCooperationMean());
		System.out.println("mean defector cooperation proabability =" + " " + testPopulation.getMeanDefectorCooperation());
		System.out.println("mean partial  cooperator cooperation proabability =" + " " + testPopulation.getMeanPartialCooperatorCooperation());
		System.out.println("mean  cooperator cooperation proabability =" + " " + testPopulation.getMeanCooperatorCooperation());

		
	}
}
