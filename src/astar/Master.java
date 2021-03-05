package astar;

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;

public class Master {
    
	static final int INITIAL_CAPACITY = 1;
	
    public static void main(String[] args) {
    	
    	ReadFile file = new ReadFile();
    	Node target = file.getGraph().getSpace()[file.getTarget()[0]][file.getTarget()[1]];
		//Node target = new Node(1, 1); //assign to target from input
		Node_comparator nc = new Node_comparator();
	    PriorityQueue<Node> discovered = new PriorityQueue<Node>(INITIAL_CAPACITY, nc);
	    //convert data file to graph <- Data file is read on line 12 right now.
	    Node current = file.getGraph().getSpace()[file.getStart()[0]][file.getStart()[1]];
	    current.setDist(0);
	    discovered.add(current);
	    ArrayList<Node> edges;
	    HashMap<Node, Integer> explored = new HashMap<Node, Integer>();
	  	while (discovered.size() > 0) {
	  		current = discovered.poll();
	  		explored.put(current, 1);
	  		if (current == target) 
	  		{
	  			break;
	  		}
	  		edges = current.getNeighbors();
	  		//for each of the nodes next to current
	  		for (int i = 0; i < edges.size(); i++) {
	  			Node nextNode = edges.get(i);
	  			
	  			double newDist = current.getDist() + nextNode.getDifficulty();
	  			double newTotCost = newDist + Heuristic.manhattanHeuristic(current, target);
	  			if((nextNode.getTotCost() > newTotCost) && !explored.containsKey(nextNode)) {
	  				nextNode.setParent(current);
	  				nextNode.setDist(newDist);
	  				discovered.remove(nextNode);
	  				//set the node's distance to its h(n) + g(n) (exact distance from start + heuristic distance)
	  				nextNode.setDist(newDist);
		  			nextNode.setTotCost(newTotCost);
		  			discovered.offer(nextNode);
	  			}
	  		}
	  	}	
	    //interpret final path from the final node's ancestors
	  	Stack<Node> path = new Stack<Node>();
	  	path.add(current);
	  	while (current.getParent() != null) {
	  		current = current.getParent();
	  		path.add(current);
	  	}
	  	System.out.println("Your path from (" + file.getStart()[0] + ", " + file.getStart()[1] + ") to (" + file.getTarget()[0] + ", " + file.getTarget()[1] + "): \n");
	  	for (int i = path.size()-1; i >= 0; i--) {
	  		System.out.println(path.size()-i + ". " + path.get(i));
	  	}
	}
}
