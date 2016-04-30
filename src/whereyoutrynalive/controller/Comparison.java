package whereyoutrynalive.controller;

/**
 * This class is used to create an arraylist with the city name and one of the characteristics as
 * instance variables. We then feed the comparison objects into an arraylist, and then sort the arraylist
 * based on the characteristic, from high to low.
 * 
 * @author Jonathan Cagadas
 * @author Jinmo Chong
 *
 */
public class Comparison {

	private String name;
	private Double value;
	
	/**
	 * Constructor for the comparison object
	 * @param name of city
	 * @param value of specific parameter
	 */
	public Comparison(String name, Double value){
		this.setName(name);
		this.setValue(value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}

