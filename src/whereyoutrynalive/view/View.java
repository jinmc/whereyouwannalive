package whereyoutrynalive.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import whereyoutrynalive.controller.Controller;
import whereyoutrynalive.model.CityArea;
import whereyoutrynalive.model.Model;
import whereyoutrynalive.model.Question;

/**
 * This is the view class of MVC. This class extends JFrame. All of the swing elements are found
 * in this class.
 * @author Jonathan Cagadas
 * @author Jinmo Chong
 *
 */
public class View extends JFrame {
	
	private static final LayoutManager FlowLayout = null;
	Model model = new Model();
	Controller controller;
	
	JPanel priorityButtonPanel;
	JPanel priorityTextPanel;
	JPanel questionPanel;
	JLabel questionContentLabel;
	JPanel questionButtonPanel;
	JButton yesButton;
	JButton noButton;
	JPanel cityPanel;
	JPanel finalPanel;
	
	JButton qbutton1;
	JButton qbutton2;
	JButton qbutton3;
	JButton qbutton4;
	JButton qbutton5;
	JButton nextButton;
	JLabel questionLabel;
	JLabel priority;
	JLabel finalLabel;
	JTextArea questionArea;
	JTextArea finalTextArea;
	JTextField finalTextField;
	
	ArrayList<CityArea> finalList;
	
	/**
	 * Constructor for the view class.
	 * Builds the GUI.
	 * @param model
	 * @param controller
	 */
	public View(Model model, Controller controller) {
		this.model = model;
		this.controller = controller;
		
		this.finalList = new ArrayList<CityArea>();
		
		priorityButtonPanel = new JPanel();
		priorityTextPanel = new JPanel();
		questionPanel = new JPanel();
		questionContentLabel = new JLabel();
		questionButtonPanel = new JPanel();
		yesButton = new JButton("Yes");
		noButton = new JButton("No");
		cityPanel = new JPanel();
		finalPanel = new JPanel();
		finalLabel = new JLabel("This is the number one city that you would want to live in.");
				
		qbutton1 = new JButton("Climate");
		qbutton2 = new JButton("Cost of Living");
		qbutton3 = new JButton("Population Density");
		qbutton4 = new JButton("Job Opportunity");
		qbutton5 = new JButton("Crime Rates");
		nextButton = new JButton("Next");
		questionLabel = new JLabel("Which factor do you care the most? Click all 5 in the order of what you care most.");
		priority = new JLabel("This is the order you would care the most.");
		questionArea = new JTextArea(10, 50);
		finalTextArea = new JTextArea(100, 500);
		
		finalTextField = new JTextField();

	}
	
	
	/**
	 * First panel with the priority of characteristics.
	 */
	public void display1() {
        layOutComponents1();
        attachListenersToComponents();
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Holds the questions.
	 */
	private void display2() {
		revalidate();
		repaint();
        layOutComponents2();
        attachListenersToComponents2();
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	
	
	/**
	 * Displays the result.
	 */
	private void display3() {
		revalidate();
		repaint();	
        layOutComponents3();
//        attachListenersToComponents3();
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Layout components for the first display.
	 */
	private void layOutComponents1() {
    	this.setLayout(new GridLayout(2, 1));
    	this.add(priorityButtonPanel);
//    	panel1.setBorder(new TitledBorder("Checks"));
    	priorityButtonPanel.add(questionLabel);
//    	priorityButtonPanel.setBorder(new TitledBorder("buttons"));
    	priorityButtonPanel.add(qbutton1);
    	priorityButtonPanel.add(qbutton2);
    	priorityButtonPanel.add(qbutton3);
    	priorityButtonPanel.add(qbutton4);
    	priorityButtonPanel.add(qbutton5);
    	
    	this.add(priorityTextPanel);
    	priorityTextPanel.add(priority);
    	priorityTextPanel.add(nextButton);
    	nextButton.setEnabled(false);
    	priorityTextPanel.add(questionArea);
    }

	/**
	 * Layout components for the second display.
	 */
	private void layOutComponents2() {
    	this.setLayout(new GridLayout(3, 1));
    	this.add(questionPanel);
    	String thisQuestion = controller.questionArray[controller.questionCount].getContent();
    	controller.questionCount++;
    	questionContentLabel = new JLabel(thisQuestion);
    	questionPanel.add(questionContentLabel);
    	this.add(questionButtonPanel);
    	questionButtonPanel.add(yesButton);
    	questionButtonPanel.add(noButton);
	}
	
	/**
	 * Layout components for the third display.
	 */
	private void layOutComponents3() {
//		this.setLayout(new LayoutManager());
		this.add(finalPanel);
//		finalLabel = new JLabel(finalString);
		finalPanel.add(finalLabel);
//		String finalAnswer = something;
//		finalTextArea.setText(finalAnswer);
		
		String finalAnswer = finalList.get(0).getCityName();
		System.out.println(finalAnswer);
		finalTextField.setText(finalAnswer);
		finalPanel.add(finalTextField);
		
	}
	

	/**
	 * Action listeners for yes/no buttons.
	 */
	/**
	 * 
	 */
	private void attachListenersToComponents2() {
 		yesButton.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent event) {
 				if (controller.questionCount == 5) {
 	 				controller.answerArray[controller.booleanCount] = true;
 	 				controller.booleanCount++;
 	 				finalList = controller.topHalf(finalList, controller.questionArray[controller.questionCount - 1].getAbbrev(), true);
 	        		getContentPane().removeAll();
 	        		display3();
 				} else {
 				controller.answerArray[controller.booleanCount] = true;
 				controller.booleanCount++;
 				String thisQuestion = controller.questionArray[controller.questionCount].getContent();
 				controller.questionCount++;
 				questionContentLabel.setText(thisQuestion);
 				if (controller.questionCount - 2 == 0) {
 					finalList = controller.cities;
 				}
 				System.out.println(controller.questionCount - 1);
 				finalList = controller.topHalf(finalList, controller.questionArray[controller.questionCount - 1].getAbbrev(), true);
// 				controller.BT.addLeft(controller.BT.data, controller.sortData(controller.booleanCount));
// 				controller.BT.addright(controller.BT.data, controller.sortData(controller.booleanCount));
 				}
// 				System.out.println(controller.questionCount);
// 				for (CityArea c : controller.BT.data) {
// 					System.out.println(c.getCityName());
// 				}
 			}
 		});
 		
 		noButton.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent event) {
 				if (controller.questionCount == 5) {
 	 				controller.answerArray[controller.booleanCount] = false;
 	 				controller.booleanCount++;
 	 				finalList = controller.topHalf(finalList, controller.questionArray[controller.questionCount - 1].getAbbrev(), false);
 	        		getContentPane().removeAll();
 	        		display3();
 				} else {
 				controller.answerArray[controller.booleanCount] = false;
 				controller.booleanCount++;
 				String thisQuestion = controller.questionArray[controller.questionCount].getContent();
 				controller.questionCount++;
 				questionContentLabel.setText(thisQuestion);
 				if (controller.questionCount - 2 == 0) {
 					finalList = controller.cities;
 				}
 				System.out.println(controller.questionCount - 1);
 				finalList = controller.topHalf(finalList, controller.questionArray[controller.questionCount - 1].getAbbrev(), false);
// 				controller.BT.addLeft(controller.BT.data, controller.sortData(controller.booleanCount));
// 				controller.BT.addright(controller.BT.data, controller.sortData(controller.booleanCount));
 				}
// 				System.out.println(controller.questionCount);
 			}
 		});
 		
	}

	
	/**
	 * Action listeners for the 5 different characteristics and next button.
	 */
	private void attachListenersToComponents() {
        qbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	controller.priorityCount++;
                qbutton1.setEnabled(false);
                String oldText = questionArea.getText();
                questionArea.setText(oldText + controller.priorityCount + " Climate \n");
        		if (controller.priorityCount == 5) {
        			nextButton.setEnabled(true);
        		}
        		setPriorityCount("Climate");
            }
        });
        
        qbutton2.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
        		controller.priorityCount++;
        		qbutton2.setEnabled(false);
        		String oldText = questionArea.getText();
        		questionArea.setText(oldText + controller.priorityCount + " Cost of Living \n");
        		if (controller.priorityCount == 5) {
        			nextButton.setEnabled(true);
        		}
        		setPriorityCount("Cost of Living");
        	}
        });
        
        qbutton3.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
        		controller.priorityCount++;
        		qbutton3.setEnabled(false);
        		String oldText = questionArea.getText();
        		questionArea.setText(oldText + controller.priorityCount + " Population Density \n");
        		if (controller.priorityCount == 5) {
        			nextButton.setEnabled(true);
        		}
        		setPriorityCount("Population Density");
        	}
        });
        
        qbutton4.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
        		controller.priorityCount++;
        		qbutton4.setEnabled(false);
        		String oldText = questionArea.getText();
        		questionArea.setText(oldText + controller.priorityCount + " Job Opportunity \n");
        		if (controller.priorityCount == 5) {
        			nextButton.setEnabled(true);
        		}
        		setPriorityCount("Job Opportunity");
        	}
        });
        
        qbutton5.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
        		controller.priorityCount++;
        		qbutton5.setEnabled(false);
        		String oldText = questionArea.getText();
        		questionArea.setText(oldText + controller.priorityCount + " Crime Rates \n");
        		if (controller.priorityCount == 5) {
        			nextButton.setEnabled(true);
        		}
        		setPriorityCount("Crime Rates");
        	}
        });
        
        nextButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
        		
        		getContentPane().removeAll();
        		display2();
        	}
        });
	}


	/**
	 * Sets the priority for the questions.
	 * @param string
	 */
	private void setPriorityCount(String string) {
		
		Question thisQuestion = (Question) model.questionMap.get(string);
		controller.questionArray[controller.priorityCount - 1] = thisQuestion;
//		System.out.println("priority :  " + (controller.priorityCount - 1));
//		System.out.println(controller.questionArray[controller.priorityCount - 1].getContent());
//		System.out.println(thisQuestion.getPriority());
		
	}



}
