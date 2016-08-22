package boot;



import algorithms.mazeGenerators.*;
import algorithms.search.BFS;
import algorithms.search.Solution;
import algorithms.search.mazeAdapter;


public class run {

	public run() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrowingTreeGenerator mg =new GrowingTreeGenerator();
		Maze3d maze = mg.generate(10, 10, 10);
		System.out.println(maze.getStartPosition().toString() +' '+maze.getGoalPosition().toString());
		BFS<Position> sh =new BFS<Position>();
		Solution<Position> ans= sh.search(new mazeAdapter(maze));
		System.out.println( ans.toString());
		
	}

}
