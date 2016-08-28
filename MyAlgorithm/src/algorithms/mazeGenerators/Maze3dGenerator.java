package algorithms.mazeGenerators;

/**
 * The Interface Maze3dGenerator.
 */
public interface Maze3dGenerator {
	
	/**
	 * Generate.
	 *
	 * @param floor the floor
	 * @param rows the rows
	 * @param cols the cols
	 * @return the maze 3 d
	 */
	Maze3d generate(int floor,int rows, int cols);
	
	/**
	 * Measure algorithm time.
	 *
	 * @param floor the floor
	 * @param rows the rows
	 * @param cols the cols
	 * @return the Time to create the maze
	 */
	String measureAlgorithmTime(int floor,int rows, int cols);
			
}
