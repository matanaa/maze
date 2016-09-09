package algorithms.mazeGenerators;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonMaze3dGenerator.
 */
public abstract class CommonMaze3dGenerator implements Maze3dGenerator {
	
	/** The maze obj. */
	// DM
	Maze3d mazeObj;
	
	/** The rand. */
	Random rand = new Random();
	
	/**
	 * Choose random free pos.
	 *
	 * @param maze the maze
	 * @return the position
	 */
	// Choose random free position
	public Position chooseRandomFreePos(Maze3d maze){
		return chooseRandomPos(maze, 0);
	}
	
	/**
	 * Choose random occ pos.
	 *
	 * @param maze the maze
	 * @return the position
	 */
	// Choose random occupied position
	public Position chooseRandomOccPos(Maze3d maze){
		return chooseRandomPos(maze, 1);
	}
	
	/**
	 * Choose random pos.
	 *
	 * @param maze the maze
	 * @param n the n
	 * @return the position
	 */
	// Private function used by chooseRandomFreePos and chooseRandomOccPos
	private Position chooseRandomPos(Maze3d maze, int n){
		int[][][] mymaze = maze.getMaze();
		int levels;
		int rows;
		int cols;
		do {
			levels = rand.nextInt(maze.getZ());
			rows = rand.nextInt(maze.getY());
			cols = rand.nextInt(maze.getX());
		}
		while (mymaze[levels][rows][cols] != n);
		Position pos = new Position(levels,rows,cols);
		return pos;
	}
	
	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.Maze3dGenerator#generate(int, int, int)
	 */
	// Abstract method where each generator will have its algorithm at
	@Override
	public abstract Maze3d generate(int z, int y, int x);
	
	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.Maze3dGenerator#measureAlgorithmTime(int, int, int)
	 */
	// Mutual to all generators. test creation time
	@Override
	public String measureAlgorithmTime(int z, int y, int x) {
		long startTime = System.currentTimeMillis();
		this.generate(z, y, x);
		long endTime = System.currentTimeMillis();
		
		return String.valueOf(endTime-startTime);
	}

}
