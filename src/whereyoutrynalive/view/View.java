package whereyoutrynalive.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import whereyoutrynalive.controller.Controller;
import whereyoutrynalive.model.Model;
import whereyoutrynalive.model.Question;

public class View extends JFrame {
	
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
	
	
	JButton qbutton1;
	JButton qbutton2;
	JButton qbutton3;
	JButton qbutton4;
	JButton qbutton5;
	JButton nextButton;
	JLabel questionLabel;
	JLabel priority;
	JTextArea questionArea;
	
	public View(Model model, Controller controller) {
		this.model = model;
		this.controller = controller;
		
		priorityButtonPanel = new JPanel();
		priorityTextPanel = new JPanel();
		questionPanel = new JPanel();
		questionContentLabel = new JLabel();
		questionButtonPanel = new JPanel();
		yesButton = new JButton("Yes");
		noButton = new JButton("No");
		cityPanel = new JPanel();
		
		qbutton1 = new JButton("Climate");
		qbutton2 = new JButton("Cost of Living");
		qbutton3 = new JButton("Population Density");
		qbutton4 = new JButton("Job Opportunity");
		qbutton5 = new JButton("Crime Rates");
		nextButton = new JButton("Next");
		questionLabel = new JLabel("Which factor do you care the most? Click all 5 in the order of what you care most.");
		priority = new JLabel("This is the order you would care the most.");
		questionArea = new JTextArea(10, 50);
		
	}
	
	
	public void display1() {
        layOutComponents1();
        attachListenersToComponents();
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void display2() {
		revalidate();
		repaint();
        layOutComponents2();
        attachListenersToComponents2();
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

	private void attachListenersToComponents2() {
 		yesButton.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent event) {
 				if (controller.questionCount == 5) {
 					
 				}else {
 				controller.answerArray[controller.booleanCount] = true;
 				controller.booleanCount++;
 				String thisQuestion = controller.questionArray[controller.questionCount].getContent();
 				controller.questionCount++;
 				questionContentLabel.setText(thisQuestion);
 				}
 				System.out.println(controller.questionCount);
 			}
 		});
 		
 		noButton.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent event) {
 				if (controller.questionCount == 5) {
 					
 				} else {
 				controller.answerArray[controller.booleanCount] = false;
 				controller.booleanCount++;
 				String thisQuestion = controller.questionArray[controller.questionCount].getContent();
 				controller.questionCount++;
 				questionContentLabel.setText(thisQuestion);
 				}
 				System.out.println(controller.questionCount);
 			}
 		});
 		
 		
	}

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


	private void setPriorityCount(String string) {
		
		Question thisQuestion = (Question) model.questionMap.get(string);
		controller.questionArray[controller.priorityCount - 1] = thisQuestion;
//		System.out.println("priority :  " + (controller.priorityCount - 1));
//		System.out.println(controller.questionArray[controller.priorityCount - 1].getContent());
//		System.out.println(thisQuestion.getPriority());
		
	}


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
	

}
