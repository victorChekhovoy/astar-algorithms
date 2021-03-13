package astar;

public class Heuristic {
	static int manhattanHeuristic(Node start, Node target) {
		//start and target should be Node objects
		int dx = Math.abs(start.getX() - target.getX());
		int dy = Math.abs(start.getY() - target.getY());
		int dz = (int) Math.abs(start.getDifficulty() - target.getDifficulty());
		return dx + dy + dz;
		//Usually the Manhattan Distance has D * (dx + dy) where D is a scale.
		//Not quite sure what that means exactly right now, I'm assuming just 1?
	}
}
