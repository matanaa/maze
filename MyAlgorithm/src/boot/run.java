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
		SimpleMaze3dGenerator mg =new SimpleMaze3dGenerator();
		Maze3d maze = mg.generate(10, 10, 10);
		System.out.println(maze);
		BFS<Position> sh =new BFS<Position>();
		Solution<Position> ans= sh.search(new mazeAdapter(maze));
		System.out.println( ans.toString());
		
	}

}
