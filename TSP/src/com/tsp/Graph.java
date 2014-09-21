package com.tsp;

import java.util.ArrayList;

public class Graph {
	private int n; // number of nodes
	private int m; // number of arcs
	private ArrayList<Node> node; // ArrayList *or* array of nodes
	private boolean[][] A; // adjacency matrix
	private double[][] C; // cost matrix

	// constructors
	public Graph() {

	}

	public Graph(int n) {

	}

	// setters
	public void setN(int n) {
		this.n = n;
	}

	public void setM(int m) {
		this.m = m;
	}

	public void setArc(int i, int j, boolean b) {
	}

	public void setCost(int i, int j, double c) {
	}

	// getters
	public int getN() {
		return n;
	}

	public int getM() {
		return m;
	}

	public boolean getArc(int i, int j) {
		return false;
	}

	public double getCost(int i, int j) {
		return 0;
	}

	public Node getNode(int i) {
		return null;
	}

	public void init(int n) // initialize values and arrays
	{
		this.A = new boolean[n][n];
		this.C = new double[n][n];
		setN(n);
	}

	public void reset() // reset the graph
	{
	}

	public boolean existsArc(int i, int j) // check if arc exists
	{
		return false;
	}

	public boolean existsNode(Node t) // check if node exists
	{
		boolean returnvalue=false;
		if (this.node.size() != 0) {
			for (int i = 0; i < this.node.size(); i++) {
				if(this.node.get(i).getName().equalsIgnoreCase(t.getName())){
					returnvalue= true;
					break;
				}
				if(this.node.get(i).getLat()==t.getLat() && this.node.get(i).getLon()==t.getLon()){
					returnvalue= true;
					break;
				}
			}
			return returnvalue;
		} else
			return returnvalue;
	}

	public boolean addArc(int i, int j) // add an arc , return T/F success
	{
		return false;
	}

	public void removeArc(int k) // remove an arc
	{
	}

	public boolean addNode(Node t) // add a node
	{
		this.node.add(t);
		return true;
	}

	public void print() // print all graph info
	{
	}

	public void printNodes() // print node list
	{
	}

	public void printArcs() // print arc list
	{
	}

	public boolean checkPath(int[] P) // check feasibility of path P
	{
		return false;
	}

	public double pathCost(int[] P) // calculate cost of path P
	{
		return 0;
	}

}
