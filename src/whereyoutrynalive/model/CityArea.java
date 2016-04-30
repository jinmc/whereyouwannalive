package whereyoutrynalive.model;

/**
 * A class that holds a city and the 5 qualities of that particular city.
 * @author Jonathan Cagadas
 * @author Jinmo Chong
 *
 */
public class CityArea {
	
	private String cityName;
	private Double temperature;
	private Double populationDensity;
	private Double jobGrowth;
	private Double costOfLiving;
	private Double crimeRate;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getPopulationDensity() {
		return populationDensity;
	}
	public void setPopulationDensity(Double populationDensity) {
		this.populationDensity = populationDensity;
	}
	public Double getJobGrowth() {
		return jobGrowth;
	}
	public void setJobGrowth(Double jobGrowth) {
		this.jobGrowth = jobGrowth;
	}
	public Double getCostOfLiving() {
		return costOfLiving;
	}
	public void setCostOfLiving(Double costOfLiving) {
		this.costOfLiving = costOfLiving;
	}
	public Double getCrimeRate() {
		return crimeRate;
	}
	public void setCrimeRate(Double crimeRate) {
		this.crimeRate = crimeRate;
	}

	

	
	
}
