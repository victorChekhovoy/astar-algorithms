package astar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) {
		File graphText = new File("graph.txt");
		Scanner graphReader;
		Graph graph;
		int start[];
		int target[];
		
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
				if (next == 0) {
					//System.out.print("(" + count % xSize + ", " + count / xSize + ") ");
					graph.addNode(count % xSize, count / xSize);
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
			
			System.out.println(start[0] + ", " + start[1]);
			System.out.println(target[0] + ", " + target[1]);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
