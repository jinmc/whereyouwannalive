package whereyoutrynalive.controller;

import java.util.*;

import whereyoutrynalive.model.CityArea;

public class BinaryTree {
	
	private Node root;
	public ArrayList<CityArea> data;
	public Node left;
	public Node right;
	
	public BinaryTree(ArrayList<CityArea> data) {
		root = new Node();
		this.data = data;
		this.left = null;
		this.right = null;
	}

    class Node {
    	public ArrayList<CityArea> data;
    	public Node left;
    	public Node right;
        }
    
    public void addLeft(ArrayList<CityArea> al) {
    	this.right = new Node();
    	this.right.data = al;
    	
    }
    
    public void addright(ArrayList<CityArea> al) {
    	this.right = new Node();
    	this.right.data = al;
    }
	
    
}
