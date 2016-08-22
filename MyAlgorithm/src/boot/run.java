package boot;



import algorithms.mazeGenerators.*;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.Solution;
import algorithms.search.mazeAdapter;


public class run {

	public run() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrowingTreeGenerator mg =new GrowingTreeGenerator();
		Maze3d maze = mg.generate(4, 4, 4);
		System.out.println(maze.getStartPosition().toString() +' '+maze.getGoalPosition().toString());
		BFS<Position> sh =new BFS<Position>();
		Solution<Position> ans= sh.search(new mazeAdapter(maze));
		System.out.println("bfs:"+ ans);
		
		DFS<Position> Dsh =new DFS<Position>();
		Solution<Position> Dans= Dsh.search(new mazeAdapter(maze));
		System.out.println("dfs:"+ Dans);
	}

}
