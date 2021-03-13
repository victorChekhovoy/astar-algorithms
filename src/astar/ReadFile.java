/* ReadFile is responsible reading a graph with a start and target and then running A* on it.
 * See graph.txt for an example on how this text file with that information is formatted.
 * It creates all nodes (and ignores walls) and creates the necessary edges between them.
 * It also parses the start and target information so we can later in Master actually assign that to a node.
 */


package astar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	
	private Graph graph;
	private int start[];
	private int target[];
	
	public ReadFile() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the name of the text file with the graph? \nPlease read README.md if you're confused about formattting.");
		
		File graphText = new File(input.nextLine());
		Scanner graphReader;
		
		try {
			graphReader = new Scanner(graphText);
			String startString = graphReader.nextLine(); //Format: (x, y)
			String targetString = graphReader.nextLine();
			int xSize = graphReader.nextInt();
			int ySize = graphReader.nextInt();
			
			graph = new Graph(xSize, ySize);
			int count = 0;
			while (graphReader.hasNext()) {
				int next = graphReader.nextInt();
				if (next != 0) {
					//System.out.print("(" + count % xSize + ", " + count / xSize + ") ");
					graph.addNode(count % xSize, count / xSize, next);
				}
				count++;
			}
			
			start = new int[2];
			target = new int[2];
			
			int divide = startString.indexOf(',');
			int end = startString.indexOf(')');
			start[0] = Integer.parseInt((String) startString.subSequence(1, divide));
			start[1] = Integer.parseInt((String) startString.substring(divide+1, end));
			
			divide = targetString.indexOf(',');
			end = targetString.indexOf(')');
			target[0] = Integer.parseInt((String) targetString.subSequence(1, divide));
			target[1] = Integer.parseInt((String) targetString.substring(divide+1, end));
			
			input.close();
			graphReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public int[] getStart() {
		return start;
	}

	public void setStart(int[] start) {
		this.start = start;
	}

	public int[] getTarget() {
		return target;
	}

	public void setTarget(int[] target) {
		this.target = target;
	}
	
}

/*
 * "graph.txt" example:
 * (0,0)
 * (3,0)
 * 
 * 4 4
 * 
 * 0 0 1 0
 * 0 0 1 0
 * 0 1 1 0
 * 0 0 0 0
 */

/*
 * Idea is that 0s are open spots and 1s are walls so we don't add a node there.
 * We can keep track of the coordinates. Coordinates for start and target have
 * be changed into actual coordinates. I have it in the form of a 2D array.
 */
