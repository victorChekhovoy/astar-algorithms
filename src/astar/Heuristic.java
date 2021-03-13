/* Our Heuristic is a simple class that uses the Manhattan distance with 2 dimensions
 * to estimate the best path in A*. The dx and dy values are the difference between
 * the nodes' locations.
 */
package astar;

public class Heuristic {
	static int manhattanHeuristic(Node start, Node target) {
		//start and target should be Node objects
		int dx = Math.abs(start.getX() - target.getX());
		int dy = Math.abs(start.getY() - target.getY());
		return dx + dy;
	}
}
