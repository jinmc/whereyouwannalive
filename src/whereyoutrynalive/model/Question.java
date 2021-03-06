package whereyoutrynalive.model;

/**
 * This question class holds a specific question that we will ask the user. This gets information from
 * the user on what they prefer in a city.
 * 
 * @author Jonathan Cagadas
 * @author Jinmo Chong
 *
 */
public class Question {
	
	private int priority; // should be 1~5
	private String content; // The actual question
	private String abbrev;	// the string matches the 
	
	
	public Question(String abbrev) {
		this.abbrev = abbrev;
	}
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getAbbrev() {
		return abbrev;
	}
	
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}


}
