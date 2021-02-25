package astar;

import java.util.ArrayList;

public class Node {
	private int x, y;
	private ArrayList<Node> neighbors;
	
	public Node(int xPos, int yPos) {
		this.x = xPos;
		this.y = yPos;
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
	
}
