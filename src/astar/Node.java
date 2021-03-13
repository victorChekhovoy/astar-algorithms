/* Node is a location on our graph, it stores all the location about like its difficulty and location.
 * We also have a spot for the parent and where the parent is in relation to keep track of our path
 * when the A* algorithm is actually running.
 */

package astar;

import java.util.ArrayList;

public class Node {
	private int x, y;
	private double dist = Double.POSITIVE_INFINITY;  //distance from start g(n)
	private double totCost = Double.POSITIVE_INFINITY; //total distance f(n) = g(n) + h(n)
	private ArrayList<Node> neighbors;
	private Node parent;
	private char parentDirection; //w = up, a = left, s = down, d = right
	private int difficulty; //cost of traversing this node (set to 1 for all passible nodes in this basic case)
	
	public Node(int xPos, int yPos, int difficulty) {
		this.x = xPos;
		this.y = yPos;
		this.difficulty = difficulty;
		neighbors = new ArrayList<Node>();
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
		if (this.parent.getY() > this.getY()) {
			this.parentDirection = 's';
		} else if (this.parent.getY() < this.getY()) {
			this.parentDirection = 'w';
		} else if (this.parent.getX() > this.getX()) {
			this.parentDirection = 'd';
		} else if (this.parent.getX() < this.getX()) {
			this.parentDirection = 'a';
		}
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
	
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}

	public char getParentDirection() {
		return parentDirection;
	}

	public void setParentDirection(char parentDirection) {
		this.parentDirection = parentDirection;
	}
	
	
	
}
