package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Stack;

// TODO: Auto-generated Javadoc
/**
 * The Class GrowingTreeMaze3dGenerator.
 */
public class GrowingTreeMaze3dGenerator extends CommonMaze3dGenerator {

	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.CommonMaze3dGenerator#generate(int, int, int)
	 */
	@Override
	public Maze3d generate(int z, int y, int x) {
		
		// Algorithm Variables
		Stack<Position> list = new Stack<Position>();
		boolean[][][] visited = new boolean[z][y][x]; // Default value is false already, and this is what we need
		mazeObj = new Maze3d(z,y,x);
		
		// Initialize the maze with only walls and blocked cells
		mazeObj.initFullMaze();
		
		// Choose a starting cell. and add it to the list
		Position currCell = chooseRandomOccPos(mazeObj);
		// Saves The Starting position
		mazeObj.setStartPos(currCell);
		list.push(currCell);
		// Puts the cell it on an array which looks exactly like the maze, but contains true or false
		visited[currCell.getZ()][currCell.getY()][currCell.getX()] = true;
				
		// Head generation loop. will run until we reach back the fist cell and there's no way to go
		do {
			// Generate an list of all unvisited neighbors of a given
			ArrayList<Position> neighbors = mazeObj.getUnvisitedNeighbors(visited, currCell);
			// Get here as long as the list is not empty and there are no unvisited neighbors
			if (neighbors.size() > 0)
			{
				// Get one random neighbor from the list
				Position nextCell = neighbors.get(rand.nextInt(neighbors.size()));
				// Mark the wall between neighbors as free
				mazeObj.breakWall(currCell,nextCell);
				// Insert the current cell to the list and replaces it to the new cell
				list.push(nextCell);
				currCell = nextCell;
				// Mark the cell on the list that shown if we visit this cell or not, and update the counter
				visited[currCell.getZ()][currCell.getY()][currCell.getX()] = true;
			}
			// Get here if there are no neighbors left but the are still unvisited cells in the maze
			else if(neighbors.size() == 0){
				list.pop();
				if (!(list.isEmpty())){
					currCell = list.lastElement();
					// The next line should be uncomment and the former line should be comment if you want
					// to choose a random cell from the list after you're stuck
					//currCell = list.get(rand.nextInt(list.size()));
				}
			}
		} while (!(list.isEmpty()));
		// Chooses random free position to be the goal cell
		Position goalPos = chooseRandomFreePos(mazeObj);
		mazeObj.setGoalPos(goalPos);
		// Returns the generated maze
		return mazeObj;
	}

}
