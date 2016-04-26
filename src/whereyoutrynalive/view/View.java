package whereyoutrynalive.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import whereyoutrynalive.controller.Controller;
import whereyoutrynalive.model.Model;

public class View extends JFrame {
	
	Model model = new Model();
	Controller controller;
	
	JPanel priorityButtonPanel = new JPanel();
	JPanel priorityTextPanel = new JPanel() ;
	JPanel questionPanel = new JPanel();
	JLabel questionContentLabel = new JLabel();
	JPanel questionButtonPanel = new JPanel();
	JButton yesButton = new JButton("Yes");
	JButton noButton = new JButton("No");
	JPanel cityPanel = new JPanel();
	
	JButton qbutton1 = new JButton("Climate");
	JButton qbutton2 = new JButton("Cost of Living");
	JButton qbutton3 = new JButton("Population Density");
	JButton qbutton4 = new JButton("Job Opportunity");
	JButton qbutton5 = new JButton("Crime Rates");
	JButton nextButton = new JButton("Next");
	JLabel questionLabel = new JLabel("Which factor do you care the most? Click all 5 in the order of what you care most.");
	JLabel priority = new JLabel("This is the order you would care the most.");
	JTextArea questionArea = new JTextArea(10, 50);
	
	
	
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
 		
	}

	private void layOutComponents2() {
    	this.setLayout(new GridLayout(3, 1));
    	this.add(questionPanel);
    	    	
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
        		setPriorityCount();
//                stopButton.setEnabled(true);
//                model.start();
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
	
	
	public View(Model model, Controller controller) {
		
		this.model = model;
		this.controller = controller;
		
		
	}
	
	 
	
}
