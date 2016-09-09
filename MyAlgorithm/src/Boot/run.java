package Boot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGeneratorBase;
import algorrithm.demo.Demo;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class run {

	public static void main(String[] args) throws IOException {
		//Demo.run();	// TODO Auto-generated method stub
		GrowingTreeGenerator mg =new GrowingTreeGenerator();
		Maze3d maze= mg.generate(10, 10, 20); //... generate it
		// save it to a file
		OutputStream out=new MyCompressorOutputStream(
		new FileOutputStream("1.maz"));
		out.write(maze.toByteArray());
		out.flush();
		out.close();
		InputStream in=new MyDecompressorInputStream(
		new FileInputStream("1.maz"));
		byte b[]=new byte[maze.toByteArray().length];
		in.read(b);
		in.close();
		Maze3d loaded=new Maze3d(b);
		System.out.println(loaded.equals(maze));


	}

}
