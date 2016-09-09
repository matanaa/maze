package algorithm.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.mazeGenerators.GrowingTreeMaze3dGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class Demo {

	public static void run() throws IOException {
		GrowingTreeMaze3dGenerator mg = new GrowingTreeMaze3dGenerator();
		Maze3d maze = mg.generate(3, 5, 5);
		System.out.println(maze);
		System.out.println("Start: " + maze.getStartPos().toString() + "\n" + "Goal: " + maze.getGoalPos().toString() + "\n");
		
		BFS<Position> sh = new BFS<Position>();
		Solution<Position> ans = sh.search(new MazeAdapter(maze));
		System.out.println("BFS:" + "\n" + ans + "Evaulated Nodes: "+sh.getEvaluatedNodes()+"\n");

		DFS<Position> Dsh = new DFS<Position>();
		Solution<Position> Dans = Dsh.search(new MazeAdapter(maze));
		System.out.println("DFS:" + "\n" + Dans + "Evaluated Nodes: " + Dsh.getEvaluatedNodes()+"\n");

		OutputStream out = new MyCompressorOutputStream(new FileOutputStream("1.maz"));
		out.write(maze.toByteArray());
		out.flush();
		out.close();
		InputStream in = new MyDecompressorInputStream(new FileInputStream("1.maz"));
		byte b[] = new byte[maze.toByteArray().length];
		in.read(b);
		in.close();
		Maze3d loaded = new Maze3d(b);
		System.out.println(loaded.equals(maze));

	}

}
