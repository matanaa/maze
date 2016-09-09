package algorithms.mazeGenerators;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleMaze3dGenerator.
 */
public class SimpleMaze3dGenerator extends CommonMaze3dGenerator {
	
	/** The Constant WALL_RATIO. */
	// This will decide what will be the free \ occupied cells ratio
	private static final float WALL_RATIO = 0.5F;
	
	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.CommonMaze3dGenerator#generate(int, int, int)
	 */
	@Override
	// Generating the maze
	public Maze3d generate(int z, int y, int x) {
		// Creates the maze we will return
		Maze3d mazeObj = new Maze3d(z, y, x);
		// go through random cells and make them occupied
		for(int i = 0 ; i < (int)(WALL_RATIO*x*y*z) ; i++){
			int levels = rand.nextInt(z);
			int rows = rand.nextInt(y);
			int cols = rand.nextInt(x);
			mazeObj.setOcc(levels,rows,cols);
		}
		// Generating random start and goal positions
		Position startPos = chooseRandomFreePos(mazeObj);
		mazeObj.setStartPos(startPos);
		Position goalPos = chooseRandomFreePos(mazeObj);
		mazeObj.setGoalPos(goalPos);
		
		//Make sure there's a path between entrance and exit
		mazeObj.createTrack(startPos, goalPos);
		
		return mazeObj;
	}
	
	
	


}
