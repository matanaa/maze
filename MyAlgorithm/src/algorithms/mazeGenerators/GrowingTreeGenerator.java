package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;

public class GrowingTreeGenerator extends Maze3dGeneratorBase {
	public GrowingTreeGenerator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Maze3d generate(int floor, int rows, int cols) {
		List <Position> cels=new ArrayList<Position>();
		this.maze3d = new Maze3d(floor,rows, cols);
		this.maze3d.fillInWalls();
		cels.add(this.chooseRandomPosition());
		maze3d.setFree(cels.get(0));
		maze3d.setStartPosition(cels.get(0));
		while(!cels.isEmpty()){
			Position now =cels.get(cels.size()-1);
			Direction[] dirs = getPossibleDirections(now);
			if (dirs.length!=0){
				int indexOfDir = rand.nextInt(dirs.length);
				now.changeByDirection(dirs[indexOfDir]);
				this.maze3d.setFree(now);
				now.changeByDirection(dirs[indexOfDir]);
				this.maze3d.setFree(now);
				cels.add(now);

			}
			else{
				cels.remove(now);
				maze3d.setGoalPosition(now);

			}
		}
		return maze3d;
	}
	
	public Maze3d generateRandom(int floor, int rows, int cols) {
		List <Position> cels=new ArrayList<Position>();
		this.maze3d = new Maze3d(floor,rows, cols);
		this.maze3d.fillInWalls();
		cels.add(this.chooseRandomPosition());
		maze3d.setFree(cels.get(0));
		maze3d.setStartPosition(cels.get(0));
		while(!cels.isEmpty()){
			Position now =cels.get(rand.nextInt(cels.size()));
			Direction[] dirs = getPossibleDirections(now);
			if (dirs.length!=0){
				int indexOfDir = rand.nextInt(dirs.length);
				now.changeByDirection(dirs[indexOfDir]);
				this.maze3d.setFree(now);
				now.changeByDirection(dirs[indexOfDir]);
				this.maze3d.setFree(now);
				cels.add(now);
			}
			else{
				cels.remove(now);
				maze3d.setGoalPosition(now);
			}
		}
		return maze3d;
	}
	


}
