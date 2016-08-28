package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Maze3dGeneratorBase implements Maze3dGenerator {

	protected Random rand = new Random();
	protected Maze3d maze3d;
	
	/**
	 * @return the maze
	 */
	public Maze3d getMaze() {
		return maze3d;
	}
	/**
	 * the method will create new 3d maze 	and return creation time
	 *
	 * 
	 */
	@Override
	public String measureAlgorithmTime(int floor,int rows, int cols) {
		long startTime = System.currentTimeMillis();
		maze3d= this.generate(floor,rows, cols);
		long endTime = System.currentTimeMillis();
		return String.valueOf(endTime - startTime);		
	}
	
	protected Position chooseRandomPosition() {
		// Choose an even column
		int x = rand.nextInt(maze3d.getCols()/2)*2;
		
		// Choose an even row
		int y = rand.nextInt(maze3d.getRows()/2)*2;
		//while (y % 2 == 1)
			//y = rand.nextInt(maze3d.getRows());	
		// Choose an even floor
		int z = rand.nextInt(maze3d.getFloors()/2)*2;
		/*while (z % 2 == 1)
			z = rand.nextInt(maze3d.getFloors());	
				*/
				
		return new Position(x, y,z);		
	}
	

	/**
	 * Gets the possible directions.
	 *
	 * @param p the test position
	 * @return the possible directions from P
	 */
	protected Direction[] getPossibleDirections(Position p){
		List <Direction> directions = new ArrayList<Direction>();
//System.out.println(p);
		if (maze3d.isInMaze(new Position(p.x+2,p.y, p.z))&& maze3d.getValue(p.z,p.y, p.x+2)==Maze3d.WALL){
			directions.add(Direction.Right);
		}
		if (maze3d.isInMaze(new Position( p.x-2, p.y,p.z))&& maze3d.getValue(p.z,p.y, p.x-2)==Maze3d.WALL){
			directions.add(Direction.Left);
		}
		if (maze3d.isInMaze(new Position( p.x, p.y+2,p.z))&& maze3d.getValue(p.z,p.y+2, p.x)==Maze3d.WALL){
			directions.add(Direction.Forward);
		}
		if (maze3d.isInMaze(new Position(p.x, p.y-2,p.z ))&& maze3d.getValue(p.z,p.y-2, p.x)==Maze3d.WALL){
			directions.add(Direction.Backward);
		}
		if (maze3d.isInMaze(new Position( p.x, p.y,p.z+2))&& maze3d.getValue(p.z+2,p.y, p.x)==Maze3d.WALL){
			directions.add(Direction.Up);
		}
		if (maze3d.isInMaze(new Position(p.x, p.y,p.z-2 ))&& maze3d.getValue(p.z-2,p.y, p.x)==Maze3d.WALL){
			directions.add(Direction.Down);
		}
		Direction[] dir = new Direction[directions.size()];
		dir = directions.toArray(dir);
		
		return dir;
		
	}

}
