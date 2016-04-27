package whereyoutrynalive.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is the model class.
 * It will take in the data of cities of US.
 * @author Chong
 *
 */

public class Model {	
	
	public HashMap<String, Question> questionMap;

	public Model() {
		CityModel.makeCities();
		
		
		
	questionMap = new HashMap<String, Question>();
	
	Question q1 = new Question("Climate");
	q1.setContent("Do you prefer hot Climate to Cold Climate?");
	questionMap.put(q1.getAbbrev(), q1);
	
	Question q2 = new Question("Cost of Living");
	q2.setContent("Do you prefer high cost of living areas?");
	questionMap.put(q2.getAbbrev(), q2);
	
	Question q3 = new Question("Population Density");
	q3.setContent("Do you prefer high population to low population density areas?");
	questionMap.put(q3.getAbbrev(), q3);
	
	Question q4 = new Question("Job Opportunity");
	q4.setContent("Do you prefer higher Job Opportunity areas?");
	questionMap.put(q4.getAbbrev(), q4);
	
	Question q5 = new Question("Crime Rates");
	q5.setContent("Do you prefer high crime rate areas?");
	questionMap.put(q5.getAbbrev(), q5);

	
	}
}
