package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;

public class SimpleMaze3dGenerator extends Maze3dGeneratorBase {

	public SimpleMaze3dGenerator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Maze3d generate(int floor, int rows, int cols) {
		this.maze3d = new Maze3d(floor,rows, cols);
		this.maze3d.fillInWalls();
		Position startPos = chooseRandomPosition();
		
		maze3d.setFree(startPos);
		maze3d.setStartPosition(startPos);
		Position endPos=SimpleRoute(startPos);
		maze3d.setGoalPosition(endPos);
			
		return this.maze3d;
	}
	
	private  Position SimpleRoute(Position now){
		
		int steps=rand.nextInt(this.maze3d.getTotalCells()/2);
		for (int i=0;i<steps;i++){
			Direction[] dirs = getPossibleDirections(now);
			if (dirs.length ==0)
			{
				break;
			}
			int indexOfDir = rand.nextInt(dirs.length);
			now.changeByDirection(dirs[indexOfDir]);
			this.maze3d.setFree(now);
			//System.out.println(i+")"+now);
			
		}
		return now;
		

	}
	

	
	
	/*private Direction[] getPossibleDirections(Position currPos) {
		List<Direction> directions = new ArrayList<Direction>();
		
		if (currPos.x + 2 < maze3d.getCols() && 
				maze3d.getValue(currPos.z,currPos.x +2, currPos.y) == Maze3d.WALL) {
			directions.add(Direction.Right);
		}
		
		if (currPos.x - 2 >= 0 && 
				maze3d.getValue(currPos.z,currPos.x - 2, currPos.y) == Maze3d.WALL) {
			directions.add(Direction.Left);
		}
		
		if (currPos.y + 2 < maze3d.getRows() && 
				maze3d.getValue(currPos.z,currPos.x, currPos.y + 2) == Maze3d.WALL) {
			directions.add(Direction.Forward);
		}
		
		if (currPos.y - 2 < maze3d.getRows() && currPos.y - 2 >0 &&
				maze3d.getValue(currPos.z,currPos.x, currPos.y - 2) == Maze3d.WALL) {
			directions.add(Direction.Backward);
		}
		if (currPos.z + 2 < maze3d.getFloors() &&
				maze3d.getValue(currPos.z+ 2,currPos.x, currPos.y ) == Maze3d.WALL) {
			directions.add(Direction.Up);
		}
		
		if (currPos.z - 2 < maze3d.getFloors() && currPos.z - 2 >0 &&
				maze3d.getValue(currPos.z- 2,currPos.x, currPos.y ) == Maze3d.WALL) {
			directions.add(Direction.Down);
		}
		Direction[] dir = new Direction[directions.size()];
		dir = directions.toArray(dir);
		
		return dir;
	}*/
	

}
