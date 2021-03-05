package astar;

import java.util.ArrayList;

public class Node {
	private int x, y;
	private double dist = Double.POSITIVE_INFINITY;  //distance from start g(n)
	private double totCost = Double.POSITIVE_INFINITY; //total distance f(n) = g(n) + h(n)
	private ArrayList<Node> neighbors;
	private Node parent;
	private double difficulty; //cost of traversing this node (set to 1 for all passible nodes in this basic case)
	
	public Node(int xPos, int yPos) {
		this.x = xPos;
		this.y = yPos;
		neighbors = new ArrayList<Node>();
		difficulty = 1;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ArrayList<Node> getNeighbors() {
		return neighbors;
	}
	
	public void addNeightbor(Node newnode) {
		this.neighbors.add(newnode);
	}
	
	public void removeNeighbor(Node node) {
		this.neighbors.remove(node);
	}
	
	public void removeNeighbor(int index) {
		this.neighbors.remove(index);
	}
	
	public void setNeighbors(ArrayList<Node> neighbors) {
		this.neighbors = neighbors;
	}

	public double getDist() {
		return dist;
	}

	public void setDist(double dist) {
		this.dist = dist;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public double getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public double getTotCost() {
		return totCost;
	}

	public void setTotCost(double totCost) {
		this.totCost = totCost;
	}
	
}
