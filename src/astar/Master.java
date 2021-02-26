package astar;

import java.util.PriorityQueue;

public class Master {
    static final int INITIAL_CAPACITY = 1;
	public static void main(String[] args) {
		Node target = new Node(1, 1); //assign to target from input
		//convert data file to graph
		//run A* on graph
		   // which will involve calls to Heuristic
		Node_comparator nc = new Node_comparator(target);
	    PriorityQueue pq = new PriorityQueue<Node>(INITIAL_CAPACITY, nc);

	}
}
