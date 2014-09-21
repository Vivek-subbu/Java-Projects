package com.tsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.plaf.SliderUI;

public class Main {
	public static BufferedReader inp = new BufferedReader(
			new InputStreamReader(System.in));
	public static Graph G = new Graph();

	public static void main(String args[]) throws IOException {
		displayMenu();
		menuValidator();
	}

	public static void menuValidator() throws IOException {
		String sLine = inp.readLine();
		if (isSingleChar(sLine)) {
			switch (sLine.toUpperCase()) {
			case "G":
				createGraph(G);
				break;
			case "C":
				editCities(G);
				break;
			case "A":
				editArcs(G);
				break;
			case "D":
				displayGraph(G);
				break;
			case "R":
				resetGraph(G);
				break;
			case "P":
				tryPath(G);
				break;
			case "Q":
				System.exit(0);
				break;
			default:
				System.out.println("ERROR: Invalid menu choice!");
				break;
			}

		} else {
			System.out.println("ERROR: Invalid menu choice!");
		}
	}

	public static void displayMenu()
	// Display the menu.
	{
		System.out.println("### MENU OPTIONS ###");
		System.out.println("G - Create graph");
		System.out.println("C - Edit cities");
		System.out.println("A - Edit arcs");
		System.out.println("D - Display graph info");
		System.out.println("R - Reset graph");
		System.out.println("P - Enter salesman's path");
		System.out.println("Q - Quit");
		System.out.println("Please enter an option: ");
	}

	public static boolean isVoid(String str) {
		if (str != null && !str.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	public static boolean isSingleChar(String str) {
		if (str != null && str.length()==1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean createGraph(Graph G) throws IOException
	// Get the graph details from the user.
	{
		System.out.println("Enter the number of cities:");
		String sCities = inp.readLine();
		int iNoOfCities=Integer.parseInt(sCities);
		if (!isVoid(sCities)) {
			G.init(iNoOfCities);
		}
		System.out.println("Cities to be entered are:"+iNoOfCities);
		for(int i=0;i<iNoOfCities;i++)
		{
			System.out.println("Enter details for City "+i+" as City Name, Longitude, Latitude");
			String sCityInfo = inp.readLine();
			Node N= new Node();
			if (!isVoid(sCityInfo)) {
				String sCityName = sCityInfo.split(",")[0];
				if (!isVoid(sCityName)) {
					N.setName(sCityName);
				}

				String sCityLongitude = sCityInfo.split(",")[1];
				if (!isVoid(sCityLongitude)) {
					N.setLon(Double.parseDouble(sCityLongitude));
				}
				String sCityLatitude = sCityInfo.split(",")[2];
				if (!isVoid(sCityLatitude)) {
					N.setLat(Double.parseDouble(sCityLatitude));
				}

			}
			G.addNode(N);
		}
		

		return false;
	}

	public static void editCities(Graph G)
	// Allow the user to edit city information inside the graph.
	{
	}

	public static void editArcs(Graph G)
	// Allow the user to edit city information inside the graph.
	{
	}

	public static void addArcs(Graph G)
	// Allow the user to add arcs to the graph.
	{
	}

	public static void removeArc(Graph G)
	// Allow the user to remove arcs from the graph.
	{
	}

	public static void displayGraph(Graph G)
	// Allow the user to remove arcs from the graph.
	{
	}

	public static void resetGraph(Graph G)
	// Allow the user to remove arcs from the graph.
	{
	}

	public static void tryPath(Graph G)
	// Get a path from the user, check its feasibility, and then print its cost.
	{
	}

	public static int getInteger(String prompt, int LB, int UB)
	// Get an integer in the range [LB, UB] from the user. Prompt the user
	// repeatedly until a valid value is
	// entered.
	{
		return 0;
	}

	public static double getDouble(String prompt, double LB, double UB)
	// Get a real number in the range [LB, UB] from the user. Prompt the user
	// repeatedly until a valid value
	// is entered.
	{
		return 0;
	}

}
