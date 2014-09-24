package com.tsp;

public class Process {
	// Add Arcs
	public static void addArcs(Graph graph) {
		System.out.println();
		graph.printNodes();
		int i;
		int j;
		do {// variable i has first arc info
			if ((i = Reader.readInt("Enter first city index (0 to quit): ", 0,
					graph.getN())) == 0) {
				System.out.println();
				return;
			}// variable j has second arc info
			if ((j = Reader.readInt("Enter second city index (0 to quit): ", 0,
					graph.getN())) == 0) {
				System.out.println();
				return;
			}
			if (i == j) {
				System.out
						.println("\nERROR: A city cannot be linked to itself!\n");
			} else {
				@SuppressWarnings("unused")
				boolean bool;
				if (!(bool = graph.existsArc(i - 1, j - 1))) {
					System.out.println("\nERROR: Arc already exists!\n");
				} else {
					System.out.println("\nArc " + i + "-" + j + " added!\n");
				}
			}
		} while ((i != 0) && (j != 0));
		System.out.println();
		System.out.println();
	}

	// Create graphs
	public static void createGraph(Graph graph) {
		System.out.println();
		int i;
		boolean bool;
		if ((i = Reader.readInt("Enter number of cities (0 to quit): ", 0,Integer.MAX_VALUE)) == 0) {
			System.out.println();
			bool = false;
		} else {
			graph.init(i); // Intializing arrays
			for (int k = 0; k < i; k++)
				do {
					System.out.println("\nCity " + (k + 1) + ":");
					Node node;
					(node = new Node("Unnamed", 0.0D, 0.0D)).setNode(); // Asccepting
																		// user
																		// inputs
																		// and
																		// setting
																		// up
																		// nodes
					if (!(bool = graph.addNode(node))) { // Validating nodes
						System.out
								.println("ERROR: City name and/or coordinates already exist!");
					}
				} while (!bool);
		}
		System.out.println("\nNow add arcs:");
		addArcs(graph); // For entering arcs
	}

	// Display Menu
	public static void displayMenu() {
		System.out.println("   JAVA TRAVELING SALESMAN PROBLEM V1");
		System.out.println("G - Create graph");
		System.out.println("C - Edit cities");
		System.out.println("A - Edit arcs");
		System.out.println("D - Display graph info");
		System.out.println("R - Reset graph");
		System.out.println("P - Enter salesman's path");
		System.out.println("Q - Quit\n");
		System.out.print("Enter choice: ");
	}

	// Edit Arcs
	public static void editArcs(Graph graph) {
		System.out.println();
		String str;
		do {
			graph.printArcs();
			System.out.println("EDIT ARCS");
			System.out.println("A - Add arc");
			System.out.println("R - Remove arc");
			System.out.println("Q - Quit\n");
			System.out.print("Enter choice: ");
			if ((str = Reader.readString("")).equalsIgnoreCase("A")) {
				addArcs(graph);
			} else if (str.equalsIgnoreCase("R")) {
				removeArcs(graph);
			} else if (!str.equalsIgnoreCase("Q")) {
				System.out.println("\nERROR: Invalid menu choice!\n");
			}
		} while (!str.equalsIgnoreCase("Q"));
		System.out.println();
	}

	// Edit cities
	public static void editCities(Graph graph) {
		System.out.println();
		graph.printNodes();
		int j;
		do {
			if ((j = Reader.readInt("Enter city to edit (0 to quit): ", 0,
					graph.getN())) != 0) {
				graph.getNode(j - 1).userEdit();
				findCity(graph, j - 1);
				System.out.println();
			}
		} while (j != 0);

	}

	public static void findCity(Graph paramb, int paramInt) {
		for (int i = 0; i < paramb.getN(); i++) {
			if (paramb.getArc(i, paramInt)) {
				// distance for an arc between 2 nodes
				double d = Node.distance(paramb.getNode(i),
						paramb.getNode(paramInt));
				paramb.setCost(i, paramInt, d);
			}
		}
	}

	public static void main(String[] arg) {
		Graph graph = new Graph();
		boolean bool = false;
		String userInput;
		do {
			displayMenu();

			if ((userInput = Reader.readString("")).equalsIgnoreCase("G")) {
				createGraph(graph);
				bool = true;
			} else if (userInput.equalsIgnoreCase("C")) {
				if (!bool) {
					System.out.println("\nERROR: No graph has been loaded!\n");
				} else {
					editCities(graph);
				}
			} else if (userInput.equalsIgnoreCase("A")) {
				if (!bool) {
					System.out.println("\nERROR: No graph has been loaded!\n");
				} else {
					editArcs(graph);
				}
			} else if (userInput.equalsIgnoreCase("D")) {
				if (!bool) {
					System.out.println("\nERROR: No graph has been loaded!\n");
				} else {
					graph.print();
				}
			} else if (userInput.equalsIgnoreCase("R")) {
				if (!bool) {
					System.out.println("\nERROR: No graph has been loaded!\n");
				} else {
					graph.reset();
					bool = false;
					System.out.println();
				}
			} else if (userInput.equalsIgnoreCase("P")) {
				if (!bool) {
					System.out.println("\nERROR: No graph has been loaded!\n");
				} else {
					tryPath(graph);
				}
			} else if (!userInput.equalsIgnoreCase("Q")) {
				System.out.println("\nERROR: Invalid menu choice!\n");
			}
		} while (!userInput.equalsIgnoreCase("Q"));
		System.out.println("\n Good Bye!");
	}

	// Remove Arcs
	public static void removeArcs(Graph graph) {
		int i;
		do {
			System.out.println();
			graph.printArcs();
			if ((i = Reader.readInt("Enter arc to remove (0 to quit): ", 0,
					graph.getM())) == 0) {
				System.out.println();
				break;
			}
			System.out.println();
			graph.removeArc(i - 1);
			System.out.println((new StringBuilder("Arc ")).append(i)
					.append(" removed!\n").toString());
		} while (i != 0);
	}

	// Try path
	public static void tryPath(Graph graph) {
		int i;
		int[] arrayOfInt = new int[(i = graph.getN()) + 1];
		System.out.println();
		graph.printNodes();
		System.out.println("Enter the " + (i + 1)
				+ " cities in the route in order: ");
		for (int j = 0; j < i + 1; j++) {
			arrayOfInt[j] = (Reader.readInt("City " + (j + 1) + ": ", 1, i) - 1);
		}
		if (!graph.checkPath(arrayOfInt)) {
			return;
		}
		System.out.format("\nThe total distance traveled is %.2f km.\n\n",
				new Object[] { Double.valueOf(graph.pathCost(arrayOfInt)) });
	}
}