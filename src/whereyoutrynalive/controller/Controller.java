package whereyoutrynalive.controller;

import java.io.File;
import java.util.ArrayList;

import whereyoutrynalive.model.CityArea;
import whereyoutrynalive.model.Model;
import whereyoutrynalive.model.Question;
import whereyoutrynalive.view.View;

/**
 * 
 * This class is the controller of the MVC framework. This is where the arraylist is sorted based
 * on a certain criteria.
 * @author Jonathan Cagadas
 * @author Jinmo Chong
 *
 */
public class Controller {
	
	Model model;
//	View view = new View(model, this);
	public int priorityCount = 0;
	public int questionCount = 0;
	public int booleanCount = 0;
	public ArrayList<CityArea> cities;
	
	public Question[] questionArray;
	public boolean[] answerArray;
	
	public BinaryTree BT;

	/**
	 * Constructor for controller. Has a model as a parameter.
	 * @param model
	 */
	public Controller(Model model) {
		File selectedFile = model.start();
		ArrayList<String> rawData = model.readFile(selectedFile);
		this.cities = model.makeCities(rawData);
		this.model = model;
		questionArray = new Question[5];
		answerArray = new boolean[5];
		
		BT = new BinaryTree(cities);
	
	}
	
	/**
	 * This is the sorting algorithm. It takes an arraylist of cities, and then sorts them
	 * based on a specific parameter.
	 * @param cities an array of cities
	 * @param questionType a specific question time
	 * @param topbot top or bottom half of the sort
	 * @return
	 */
	public ArrayList<CityArea> topHalf(ArrayList<CityArea> cities, String questionType, boolean topbot){
		ArrayList<Comparison> unsorted = new ArrayList<Comparison>();
		ArrayList<Comparison> sorted = new ArrayList<Comparison>();
		ArrayList<CityArea> sortedCities = new ArrayList<CityArea>();
		if (questionType == "Climate"){
			for (CityArea city : cities){
				Comparison comparison = new Comparison(city.getCityName(), city.getTemperature());
				unsorted.add(comparison);
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
		return sortedCities;
	}

	/**
	 * The main method. Creates instances of the controller, model and view.
	 * @param args
	 */
	public static void main(String[] args) {
		

		Model model = new Model();	 

		Controller controller = new Controller(model);
		View view = new View(model, controller);
		view.display1();
				
	}

}
//package whereyoutrynalive.controller;
//
//import java.io.File;
//import java.util.ArrayList;
//
//import whereyoutrynalive.model.CityArea;
//import whereyoutrynalive.model.Model;
//import whereyoutrynalive.model.Question;
//import whereyoutrynalive.view.View;
//
//public class Controller {
//	
//	Model model;
////	View view = new View(model, this);
//	public int priorityCount = 0;
//	public int questionCount = 0;
//	public int booleanCount = 0;
////	ArrayList<CityArea> cities;
//	
//	public Question[] questionArray;
//	public boolean[] answerArray;
//	
//	public BinaryTree BT;
//
//	public Controller(Model model) {
//		File selectedFile = model.start();
//		ArrayList<String> rawData = model.readFile(selectedFile);
//		ArrayList<CityArea> cities = model.makeCities(rawData);
//		for (CityArea city : cities){
//			System.out.println(city.getCityName());
//		}
//		
//		this.model = model;
//		questionArray = new Question[5];
//		answerArray = new boolean[5];
//		
////		cities
//		
//		
////		BT = new BinaryTree(cities);
//		
//		
//		
//		
//	}
//
//	public static void main(String[] args) {
//		
//		Model model = new Model();
//		
//		Controller controller = new Controller(model);
//
//		View view = new View(model, controller);
//
//		view.display1();
//		
//		
//		
//	}
//
//}
