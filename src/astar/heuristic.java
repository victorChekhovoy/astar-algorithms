package astar;

public class Heuristic {
	static int manhattanHeuristic(Node start, Node target) {
		//start and target should be int arrays of length 2, where array[0] is the x-cord,
		//and array[1] is the y-cord.
		int dx = Math.abs(start.getX() - target.getY());
		int dy = Math.abs(start.getX() - target.getY());
		return dx + dy;
		//Usually the Manhattan Distance has D * (dx + dy) where D is a scale.
		//Not quite sure what that means exactly right now, I'm assuming just 1?
	}
}
