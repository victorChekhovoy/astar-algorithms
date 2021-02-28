package astar;

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.ArrayList;

public class Master {
    
	static final int INITIAL_CAPACITY = 1;
	
    public static void main(String[] args) {
		Node target = new Node(1, 1); //assign to target from input
		Node_comparator nc = new Node_comparator(target);
	    PriorityQueue<Node> discovered = new PriorityQueue<Node>(INITIAL_CAPACITY, nc);
	    Stack<Node> path = new Stack();
	    //convert data file to graph
	    Node current;
	    ArrayList<Node> edges;
	  	while (discovered.size() > 0) {
	  		current = discovered.poll();
	  		if (current == target) 
	  		{
	  			break;
	  		}
	  		edges = current.getNeighbors();
	  		//for each of the nodes next to current
	  		for (int i=0; i < edges.size(); i++) {
	  			Node nextNode = edges.get(i);
	  			nextNode.setParent(current);
	  			//set the node's distance to its h(n) + g(n) (exact distance from start + heuristic distance)
	  			nextNode.setDist(current.getDist() + 1 + Heuristic.manhattanHeuristic(current, target));
	  			discovered.offer(edges.get(i));
	  		}
	  	}	
	    //interpret final path from the final node's ancestors
	}
}
