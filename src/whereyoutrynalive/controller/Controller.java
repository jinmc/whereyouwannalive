package whereyoutrynalive.controller;

import java.io.File;
import java.util.ArrayList;

import whereyoutrynalive.model.CityArea;
import whereyoutrynalive.model.Model;
import whereyoutrynalive.model.Question;
import whereyoutrynalive.view.View;

public class Controller {
	
	Model model;
//	View view = new View(model, this);
	public int priorityCount = 0;
	public int questionCount = 0;
	public int booleanCount = 0;
	ArrayList<CityArea> cities;
	

	
	public Question[] questionArray;
	public boolean[] answerArray;
	
	public BinaryTree BT;

	public Controller(Model model) {
		File selectedFile = model.start();
		ArrayList<String> rawData = model.readFile(selectedFile);
		this.cities = model.makeCities(rawData);
		for (CityArea city : cities){
			System.out.println(city.getCityName());
		}
		
		this.model = model;
		questionArray = new Question[5];
		answerArray = new boolean[5];
		
		BT = new BinaryTree(cities);
	
	}
	
	public ArrayList<CityArea> topHalf(ArrayList<CityArea> cities, String questionType, boolean topbot){
		ArrayList<Comparison> unsorted = new ArrayList<Comparison>();
		ArrayList<Comparison> sorted = new ArrayList<Comparison>();
		ArrayList<CityArea> sortedCities = new ArrayList<CityArea>();
		if (questionType == "Climate"){
			for (CityArea city : cities){
				Comparison comparison = new Comparison(city.getCityName(), city.getTemperature());
				unsorted.add(comparison);
				System.out.println(comparison.getName());
			}
		}
		if (questionType == "Cost of Living"){
			for (CityArea city : cities){
				Comparison comparison = new Comparison(city.getCityName(), city.getCostOfLiving());
				unsorted.add(comparison);
			}
		}
		if (questionType == "Population Density"){
			for (CityArea city : cities){
				Comparison comparison = new Comparison(city.getCityName(), city.getCostOfLiving());
				unsorted.add(comparison);
			}
		}
		if (questionType == "Job Opportunity"){
			for (CityArea city : cities){
				Comparison comparison = new Comparison(city.getCityName(), city.getCostOfLiving());
				unsorted.add(comparison);
			}
		}
		if (questionType == "Crime Rates"){
			for (CityArea city : cities){
				Comparison comparison = new Comparison(city.getCityName(), city.getCostOfLiving());
				unsorted.add(comparison);
			}
		}
		String topCity = "";
		Double topValue;
		int duplicate;
		for (int i = 0; i < cities.size(); i++){
			topValue = -10.0;
			duplicate = 0;
			for (Comparison city : unsorted){
				if (city.getValue() >= topValue){
					duplicate = 0;
					for (Comparison city2 : sorted){
						if (city2.getName() == city.getName()){
							duplicate = 1;
						}
					}
					if (duplicate == 0){
						topCity = city.getName();
						topValue = city.getValue();
					}
				}
			}
			Comparison sortedComparison = new Comparison(topCity, topValue);
			System.out.println(sortedComparison.getValue());
			sorted.add(sortedComparison);
		}
		CityArea currentCity = null;
		if (topbot){
			for (int i = 0; i < cities.size() / 2; i++){
				String cityName = sorted.get(i).getName();
				for (CityArea city : cities){
					if (cityName == city.getCityName()){
						currentCity = city;
					}
				}
				sortedCities.add(currentCity);
			}
		} else {
			for (int i = cities.size() - 1; i > (cities.size() / 2) - 1; i--){
				String cityName = sorted.get(i).getName();
				for (CityArea city : cities){
					if (cityName == city.getCityName()){
						currentCity = city;
					}
				}
				sortedCities.add(currentCity);
			}
		}
		for (CityArea city : sortedCities){
			System.out.println(city.getCityName());
		}
		return sortedCities;
	}

	public static void main(String[] args) {
		
		Model model = new Model();	 
		Controller controller = new Controller(model);
		View view = new View(model, controller);
		view.display1();
		controller.topHalf(controller.cities, "Climate", false);
				
	}

}
