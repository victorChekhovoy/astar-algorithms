package astar;

import java.util.Comparator;

public class Node_comparator implements Comparator<Node>{
	
	public Node target;
	
	public Node_comparator(Node target) {
		this.target = target;
	}

	@Override
	public int compare(Node n1, Node n2) { 	
		 //-1 if n1 is closer, 0 if equal distance, 1 if n2 is closer. 
		int distance_1 = Heuristic.manhattanHeuristic(n1, target);
		int distance_2 = Heuristic.manhattanHeuristic(n2, target);
		return distance_1 - distance_2;
	}

}
