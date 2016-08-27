package algorrithm.demo;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.Solution;

public class Demo {

	public static void run() {
		GrowingTreeGenerator mg =new GrowingTreeGenerator();
		Maze3d maze = mg.generate(6, 5, 5);
		System.out.println(maze);
		
		System.out.println("start point :" +maze.getStartPosition().toString() + " stop point :"+maze.getGoalPosition().toString());
		BFS<Position> sh =new BFS<Position>();
		Solution<Position> ans= sh.search(new mazeAdapter(maze));
		System.out.println("bfs:"+ ans);
		
		DFS<Position> Dsh =new DFS<Position>();
		Solution<Position> Dans= Dsh.search(new mazeAdapter(maze));
		System.out.println("dfs:"+ Dans);

	}

}
