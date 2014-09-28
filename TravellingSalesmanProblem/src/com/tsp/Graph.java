package com.tsp;

import java.util.ArrayList;
import java.util.Iterator;

public final class Graph {
	private boolean[][] A;// adjacency matrix
	private double[][] C;// cost matrix
	private int m;// number of arcs
	private int n; // number of nodes
	private ArrayList<Node> node;// ArrayList *or* array of nodes

	public Graph() {
		reset();
	}

	public Graph(int n) {
		int i = n;
		this.n = i;
		i = 0;
		this.m = i;
		this.node = new ArrayList<Node>();
		this.node.ensureCapacity(n);
		this.A = new boolean[this.n][this.n];
		this.C = new double[this.n][this.n];

	}

	public final boolean addArc(int paramInt1, int paramInt2) {
		if (getArc(paramInt1, paramInt2)) {
			return false;
		}
		setArc(paramInt1, paramInt2, true);
		double d = Node.distance((Node) this.node.get(paramInt1),
				(Node) this.node.get(paramInt2));
		setCost(paramInt1, paramInt2, d);
		paramInt2 = this.m + 1;
		this.m = paramInt2;
		return true;
	}

	// Validating nodes
	public final boolean addNode(Node inputNode) {
		int iflag = 0;
		Node iteratedNode = null;
		Iterator<Node> localIterator = this.node.iterator();
		while (localIterator.hasNext()) {
			iteratedNode = localIterator.next();
			if (inputNode.getName().equalsIgnoreCase(
					iteratedNode.getName())) {
				iflag = 1;
				break;
			}
			if ((inputNode.getLon() == iteratedNode.getLon() && inputNode
					.getLat() == iteratedNode.getLat())) {
				iflag = 1;
				break;
			}
		}

		if (iflag == 0) {
			this.node.add(inputNode);
			return true;
		} else {
			return false;
		}
	}

	public final boolean checkPath(int[] arrayOfCities) {

		if (arrayOfCities[0] != arrayOfCities[this.n]) {
			System.out
					.println("\nERROR: Start and end cities must be the same!\n");
			return false;
		}
		int i = 0;
		do {
			int j = i + 1;
			do {
				if (arrayOfCities[i] == arrayOfCities[j]) {
					System.out
							.println("\nERROR: Cities cannot be visited more than once!");
					System.out.println("ERROR: Not all cities are visited!\n");
					return false;
				}
				j++;

			} while (j < this.n);
			i++;

		} while (i < this.n);
		i = 0;
		do {
			if (!getArc(arrayOfCities[i], arrayOfCities[(i + 1)])) {
				System.out.println("\nERROR: Arc " + (arrayOfCities[i] + 1)
						+ "-" + (arrayOfCities[(i + 1)] + 1)
						+ " does not exist!\n");
				return false;
			}
			i++;

		} while (i < this.n);
		return true;
	}

	public final boolean existsArc(int paramInt1, int paramInt2) {
		if (getArc(paramInt1, paramInt2)) {
			return false;
		}
		setArc(paramInt1, paramInt2, true);
		double d = Node.distance((Node) this.node.get(paramInt1),
				(Node) this.node.get(paramInt2));
		setCost(paramInt1, paramInt2, d);
		paramInt2 = this.m + 1;
		this.m = paramInt2;
		return true;
	}

	public final boolean existsNode(Node paramc) {
		Node localc = paramc;
		int iflag = 0;
		Object localObject = null;
		Iterator<Node> localIterator = this.node.iterator();
		while (localIterator.hasNext()) {
			localObject = (Node) localIterator.next();
			if (localc.getName().equalsIgnoreCase(
					((Node) localObject).getName())) {
				iflag = 1;
				break;
			}
			if ((localc.getLon() == ((Node) localObject).getLon() && localc
					.getLat() == ((Node) localObject).getLat())) {
				iflag = 1;
				break;
			}
		}

		if (iflag == 0) {
			return true;
		} else {
			return false;
		}
	}

	public final boolean getArc(int paramInt1, int paramInt2) {
		int i = paramInt2;
		paramInt2 = paramInt1;
		return this.A[paramInt2][i];
	}

	private double getCost(int paramInt1, int paramInt2) {
		return this.C[paramInt1][paramInt2];
	}

	public final int getM() {
		return this.m;
	}

	public final int getN() {
		return this.n;
	}

	public final Node getNode(int paramInt) {
		return (Node) this.node.get(paramInt);
	}

	// initialize values and arrays
	public void init(int paramInt) {
		int i = paramInt;
		this.n = i;
		i = 0;
		this.m = i;
		this.node = new ArrayList<Node>();
		this.node.ensureCapacity(paramInt);
		this.A = new boolean[this.n][this.n];
		this.C = new double[this.n][this.n];
	}

	public final double pathCost(int[] paramArrayOfInt) {
		double d = 0.0D;
		int i = 0;
		do {
			d += getCost(paramArrayOfInt[i], paramArrayOfInt[(i + 1)]);
			i++;

		} while (i < this.n);
		return d;
	}

	// display graph
	public final void print() {
		System.out.println("Number of nodes: " + this.n);
		System.out.println("Number of arcs: " + this.m);
		System.out.println();
		printNodes();
		printArcs();
	}

	public final void printArcs() {
		System.out.println("ARC LIST");
		System.out.format("%3s%10s%15s\n", new Object[] { "No.", "Cities",
				"Distance" });
		for (int i = 0; i < 28; i++) {
			System.out.print("-");
		}
		System.out.println();
		int i = 0;
		for (int j = 0; j < this.n; j++) {
			for (int k = j; k < this.n; k++) {
				if (getArc(j, k)) {
					i++;
					System.out.format("%3d",
							new Object[] { Integer.valueOf(i) });
					String str = Integer.toString(j + 1) + "-"
							+ Integer.toString(k + 1);
					System.out.format("%10s%15.2f\n", new Object[] { str,
							Double.valueOf(getCost(j, k)) });
				}
			}
		}
		System.out.println();
	}

	public final void printNodes() {
		System.out.println("NODE LIST");
		System.out.format("%3s%19s%19s\n", new Object[] { "No.", "Name",
				"Coordinates" });
		for (int i = 0; i < 41; i++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < this.n; i++) {
			System.out.format("%3d", new Object[] { Integer.valueOf(i + 1) });
			((Node) this.node.get(i)).print();
			System.out.println();
		}
		System.out.println();
	}

	public final void removeArc(int paramInt) {
		int i = -1;
		for (int j = 0; j < this.n; j++) {
			for (int k = j + 1; k < this.n; k++) {
				int p = getArc(j, k) ? 1 : 0;
				i = i + p;
				if (i == paramInt) {
					setArc(j, k, false);
					setCost(j, k, 0.0D);
					i = this.m - 1;

					this.m = i;
					return;
				}
			}
		}
	}

	// reset graph
	public void reset() {
		if (this.n > 0) {
			this.node.clear();
		}
		this.n = (this.m = 0);
		this.A = null;
		this.C = null;

	}

	private void setArc(int paramInt1, int paramInt2, boolean paramBoolean) {
		this.A[paramInt1][paramInt2] = paramBoolean;
		this.A[paramInt2][paramInt1] = paramBoolean;
	}

	public final void setCost(int paramInt1, int paramInt2, double paramDouble) {
		this.C[paramInt1][paramInt2] = paramDouble;
		this.C[paramInt2][paramInt1] = paramDouble;
	}

	public void setM(int m) {
		this.m = m;
	}

	public void setN(int n) {
		this.n = n;
	}
}