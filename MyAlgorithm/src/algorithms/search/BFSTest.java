package algorithms.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.demo.MazeAdapter;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class BFSTest {

	int[][][] maze = {
			{ 	{ 1, 1, 1, 1, 1 },
				{ 1, 0, 1, 0, 1 }, 
				{ 1, 0, 1, 0, 1 }, 
				{ 1, 0, 0, 0, 1 }, 
				{ 1, 1, 1, 1, 1 } } 
			};
	Position startPos = new Position(0, 1, 1);
	Position goalPos = new Position(0, 1, 3);
	Searchable<Position> mazeSearchable = new MazeAdapter(new Maze3d(maze, startPos, goalPos));
	Searcher<Position> bfs = new BFS<Position>();
	Solution<Position> sol = bfs.search(mazeSearchable);

	/**
	 * shouldReturnCountOfPathFromStartToFinishPosition the way from the start
	 * position to the end is 5 we check if it is 5 by the assertEquals
	 */
	@Test
	public void shouldReturnCountOfPathFromStartToFinishPosition() {
		assertEquals(6, sol.getSolution().size());
	}

	/**
	 * shouldReturnTheGoalStateOfTheMaze check if the goal state is the same
	 * with the assertEquals
	 */
	@Test
	public void shouldReturnTheGoalStateOfTheMaze() {
		assertEquals(goalPos, sol.getSolution().get(sol.getSolution().size() - 1).getCost());
	}

	/**
	 * shouldReturnTheStartStateOfTheMaze check if the start state is the same
	 * with the assertEquals
	 */
	@Test
	public void shouldReturnTheStartStateOfTheMaze() {
		assertEquals(startPos, sol.getSolution().get(0).getCost());
	}

	/**
	 * checkIfTheEvaluatedNumberOfNodesOfTheSolutionIsValid
	 */
	@Test
	public void checkIfTheEvaluatedNumberOfNodesOfTheSolutionIsValid() {
		assertEquals(true, bfs.getEvaluatedNodesNun() >= sol.getSolution().size());
	}


}
