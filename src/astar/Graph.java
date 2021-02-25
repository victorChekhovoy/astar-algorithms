package astar;

import java.util.LinkedList;

public class Graph {
    public Node[][] space;

    public Graph(int xSize, int ySize) {
        space = new Node[xSize][ySize];
    }

    public void addNode(int xPos, int yPos){
    	//Add a new node in the given position
    	space[xPos][yPos] = new Node(xPos, yPos);
    	
    	
    	//Check if there is a node left of this one, if so add connections to both nodes
    	if(xPos > 0) {
    		if (space[xPos-1][yPos] != null) {
    			space[xPos-1][yPos].addNeightbor(space[xPos][yPos]);
    			space[xPos][yPos].addNeightbor(space[xPos-1][yPos]);
    		}
    	}
    	//Check if there is a node above this one, if so add connections to both nodes
    	if(yPos > 0) {
    		if(space[xPos][yPos-1] != null) {
    			space[xPos][yPos-1].addNeightbor(space[xPos][yPos]);
    			space[xPos][yPos].addNeightbor(space[xPos][yPos-1]);
    		}
    	}
    }

    public Node[][] getSpace()
    {
    	return space;
    } 
    

}