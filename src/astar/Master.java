package astar;

import java.util.PriorityQueue;
import java.util.ArrayList;

public class Master {
    
	static final int INITIAL_CAPACITY = 1;
	
    public static void main(String[] args) {
    	
    	ReadFile file = new ReadFile("graph.txt");
    	Node target = file.getGraph().getSpace()[file.getTarget()[0]][file.getTarget()[1]];
		//Node target = new Node(1, 1); //assign to target from input
		Node_comparator nc = new Node_comparator(target);
	    PriorityQueue<Node> discovered = new PriorityQueue<Node>(INITIAL_CAPACITY, nc);
	    //convert data file to graph <- Data file is read on line 12 right now.
	    
	    Node current = file.getGraph().getSpace()[file.getStart()[0]][file.getStart()[1]];
	    discovered.add(current);
	    
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

		  		System.out.print("hi");
	  			double newDist = current.getDist() + nextNode.getDifficulty() + Heuristic.manhattanHeuristic(current, target);
	  			if(nextNode.getDist() > newDist) {
	  				nextNode.setParent(current);
	  				discovered.remove(nextNode);
	  				//set the node's distance to its h(n) + g(n) (exact distance from start + heuristic distance)
		  			nextNode.setDist(current.getDist() + nextNode.getDifficulty() + Heuristic.manhattanHeuristic(current, target));
		  			discovered.offer(nextNode);
	  			}
	  		}
	  	}	
	    //interpret final path from the final node's ancestors
	}
}
