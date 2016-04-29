package whereyoutrynalive.controller;


import java.io.File;
import java.util.ArrayList;

import whereyoutrynalive.model.CityArea;
import whereyoutrynalive.model.Model;
import whereyoutrynalive.model.Question;
import whereyoutrynalive.view.View;

public class Controller {
	
	//testtesttest
	
	Model model;
//	View view = new View(model, this);
	public int priorityCount = 0;
	public int questionCount = 0;	
	
	public Question[] questionArray;
	
	

	public Controller(Model model) {
		this.model = model;
		questionArray = new Question[5];
		
	}

	public static void main(String[] args) {
		
		Model model = new Model();
		File selectedFile = model.start();
		ArrayList<String> rawData = model.readFile(selectedFile);
		ArrayList<CityArea> cities = model.makeCities(rawData); 
		Controller controller = new Controller(model);

		View view = new View(model, controller);

		view.display1();
		
	}

}
