package whereyoutrynalive.controller;


import whereyoutrynalive.model.Model;
import whereyoutrynalive.view.View;

public class Controller {
	
	Model model;
	View view = new View(model, this);
	public int priorityCount = 0;

	public Controller(Model model) {
		this.model = model;
		
		
		
	}

	public static void main(String[] args) {
		
		Model model = new Model();
		Controller controller = new Controller(model);

		View view = new View(model, controller);

		controller.view.display1();

		
		
		
	}

}
