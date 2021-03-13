/* Master is our class with the main function in it. It's what actually stores the
 * A* algorithm. We start by calling ReadFile to create our graph and then run the
 * A* algorithm. We finish by tracing back our path and the directions needed to
 * get to that path to make it easier for the user.
 */
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
	  	int totalCost = (int) current.getDifficulty();
	  	path.add(current);
	  	while (current.getParent() != null) {
	  		current = current.getParent();
	  		path.add(current);
	  		totalCost+= current.getDifficulty();
	  	}
	  	System.out.println("Your path from (" + file.getStart()[0] + ", " + file.getStart()[1] + ") to (" + file.getTarget()[0] + ", " + file.getTarget()[1] + "):\n");
	  	for (int i = path.size()-1; i >= 0; i--) {
	  		System.out.print(path.size()-i + ". ");
	  		if (path.get(i).getParentDirection() == 's') {
	  			System.out.print("Go up to ");
	  		} else if (path.get(i).getParentDirection() == 'w') {
	  			System.out.print("Go down to ");
	  		} else if (path.get(i).getParentDirection() == 'a') {
	  			System.out.print("Go right to ");
	  		} else if (path.get(i).getParentDirection() == 'd') {
	  			System.out.print("Go left to ");
	  		} else {
	  			System.out.print("Start at ");
	  		}
	  		System.out.println(path.get(i));
	  		
	  	}
	  	System.out.println("\nThe cost of the quickest path is: " + totalCost);
	}
}
