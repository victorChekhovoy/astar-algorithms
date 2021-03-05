package astar;

import java.util.Comparator;

public class Node_comparator implements Comparator<Node>{
	
	public Node_comparator() { //the comparator doesn't require any additional information besides the nodes
	}

	@Override
	public int compare(Node n1, Node n2) { 	
		//returns a negative number (-1) if node 1 is closer
		//returns a positive number (+1) if node 2 is closer
		// returns 0 if the nodes are at equal distance from the destination
		return (int) (n1.getTotCost() - n2.getTotCost());
	}

}
