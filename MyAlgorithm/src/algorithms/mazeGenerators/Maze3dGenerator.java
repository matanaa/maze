package algorithms.mazeGenerators;

// TODO: Auto-generated Javadoc
/**
 * The Interface Maze3dGenerator.
 */
public interface Maze3dGenerator {
	
	/**
	 * Generate.
	 *
	 * @param z the z
	 * @param y the y
	 * @param x the x
	 * @return the maze 3 d
	 */
	public Maze3d generate(int z, int y, int x);
	
	/**
	 * Measure algorithm time.
	 *
	 * @param z the z
	 * @param y the y
	 * @param x the x
	 * @return the string
	 */
	public String measureAlgorithmTime(int z, int y, int x);
	
	/**
	 * Sets the done.
	 *
	 * @param isDone the new done
	 */
	void setDone(boolean isDone);
	
	
}
