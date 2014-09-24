package com.tsp;

public final class Node {
	private double lat;// latitude coordinate
	private double lon;// longitude coordinate
	private String name;// node name

	public Node() {

	}

	public Node(String name, double lat, double lon) {
		this.name = name;
		this.lat = lat;
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public String getName() {
		return name;
	}

	public final void print() {
		String str = "(" + this.lat + "," + this.lon + ")";
		System.out.format("%19s%19s", new Object[] { this.name, str });
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public final void setNode() {
		String str = Reader.readString("Name:");
		double d1 = Reader.readDouble("Latitude:", -90.0D, 90.0D);
		double d2 = Reader.readDouble("Longitude:", -180.0D, 180.0D);
		this.setName(str);
		this.setLat(d1);
		this.setLon(d2);
	}

	public void userEdit() {
		String str = Reader.readString("Name:");
		double d1 = Reader.readDouble("Latitude:", -90.0D, 90.0D);
		double d2 = Reader.readDouble("Longitude:", -180.0D, 180.0D);
		this.setName(str);
		this.setLat(d1);
		this.setLon(d2);
	}

	// distance for an arc between 2 nodes
	public static double distance(Node paramc1, Node paramc2) {
		double d1 = paramc1.lat;
		double d2 = paramc2.lat;
		double d3 = paramc1.lon;
		double d4 = paramc2.lon;
		double d5 = Math.toRadians(d2 - d1);
		double d6 = Math.toRadians(d4 - d3);
		d1 = Math.toRadians(d1);
		d2 = Math.toRadians(d2);
		double d7 = Math.pow(Math.sin(d5 / 2.0D), 2.0D) + Math.cos(d1)
				* Math.cos(d2) * Math.pow(Math.sin(d6 / 2.0D), 2.0D);
		double d8 = 2.0D * Math.atan2(Math.sqrt(d7), Math.sqrt(1.0D - d7));
		return d8 * 6371.0D;
	}
}