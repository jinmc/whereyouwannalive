package whereyoutrynalive.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFileChooser;

/**
 * This is the model class.
 * It will take in the data of cities of US.
 * @author Chong
 *
 */

public class Model {	
	
	public HashMap<String, Question> questionMap;

	public File start(){
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		File selectedFile = null;
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
		}
		return selectedFile;
		
	}
	
	public ArrayList<String> readFile(File file) {
		ArrayList<String> al = new ArrayList<String>();
		try {
			if (file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;
				br.readLine();
				while((line = br.readLine()) != null) {
					al.add(line);
					System.out.println(line);
				}
				br.close();
			}
		} catch (IOException e) {	
			}
		return al;
		}
	
	public ArrayList<CityArea> makeCities(ArrayList<String> list){
		ArrayList<CityArea> cityData = new ArrayList<CityArea>();
		
		String cvsSplitBy = ",";
		for (String string : list){
			CityArea city = new CityArea();
			String[] data = string.split(cvsSplitBy);
			city.setCityName(data[0]);
			city.setPopulationDensity(Double.valueOf(data[1]));
			city.setTemperature(Double.valueOf(data[2]));
			city.setCostOfLiving(Double.valueOf(data[3]));
			city.setCrimeRate(Double.valueOf(data[4]));
			System.out.println(city.getCityName());
			System.out.println(city.getCrimeRate());
			cityData.add(city);
		}
		return cityData;
	}
	
	
	public Model() {
		
		
		
		
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
