package whereyoutrynalive.controller;

import java.util.*;

import whereyoutrynalive.model.CityArea;

public class BinaryTree {
	
	private Node root;
	public ArrayList<CityArea> data;
	
	public BinaryTree(ArrayList<CityArea> data) {
		root = new Node();
		this.data = data;
//		root.left = left.root;
//		root.right = right.root;
	}

    class Node {
    	public ArrayList<CityArea> data;
    	public Node left;
    	public Node right;
        }
	
    
}
