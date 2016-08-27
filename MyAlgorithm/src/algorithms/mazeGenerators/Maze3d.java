package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze3d {
	private int[][][] maze;
	private int floors;
	private int rows;
	private int cols; 
	private Position startPosition;
	private Position goalPosition;
	public static final int FREE = 0;
	public static final int WALL = 1;
	/**
	 * @return the maze
	 */
	
	public Maze3d(int floor,int rows, int cols) {
		this.floors=floor;
		this.rows=rows;
		this.cols=cols;
		this.maze=new int[floor][rows][cols];
		
	}
	

	public void setFree(int z,int x, int y) {
		maze[z][y][x] = FREE;
	}
	
	public int[][][] getMaze() {
		return maze;
	}
	/**
	 * @return the floors
	 */
	public int getFloors() {
		return floors;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @return the cols
	 */
	public int getCols() {
		return cols;
	}


	/**
	 * @return the startPosition
	 */
	public Position getStartPosition() {
		return startPosition;
	}
	/**
	 * @param startPosition the startPosition to set
	 */
	public void setStartPosition(Position startPosition) {
		this.startPosition = new Position(startPosition.x, startPosition.y, startPosition.z) ;
	}
	/**
	 * @return the goalPosition
	 */
	public Position getGoalPosition() {
		return goalPosition;
	}
	/**
	 * @param goalPosition the goalPosition to set
	 */
	public void setGoalPosition(Position goalPosition) {
		this.goalPosition =  new Position(goalPosition.x, goalPosition.y, goalPosition.z);
	}


	public int getValue(int z, int y, int x) {
		// TODO Auto-generated method stub
		return maze[z][y][x];
	}

	/**
	 * This method Initialize all maze cells to be WALLS
	 */
	public void fillInWalls()
	{
		this.fillIn(WALL);
	}
	
	protected void fillIn(int dir){
		for (int z=0;z<this.floors;z++)
		{
			for (int y=0;y<this.rows;y++)
			{
				for (int x=0;x<this.cols;x++)
				{
	
						this.maze[z][y][x] = dir;
					
				}
			}
		}
		
	}
	public int getTotalCells(){
		return this.floors*this.rows*this.cols;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int z=0;z<this.floors;z++)
		{
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				if (z==startPosition.z && y==startPosition.y && x==startPosition.x){
					sb.append( "E ");
				}
				else if (z==goalPosition.z && y==goalPosition.y && x==goalPosition.x){
					sb.append( "X ");
				}
				else{
				sb.append(maze[z][y][x] + " ");
				}
			}
			sb.append("\n");
		}
		sb.append("\n");
		}
		return sb.toString();
	}


	public void setFree(Position p) {
		maze[p.z][p.y][p.x] = FREE;
		
	}
	
	public boolean isInMaze(Position pos)
	{
		if (pos==null)
			return false;
	//	System.out.println(pos + " floors z " + this.floors  +" rows y " + this.rows +" cols x " + this.cols);
		return (pos.z>=0 && pos.z<this.floors 
				&& pos.x>=0 && pos.x<this.cols 
				&& pos.y>=0 && pos.y<this.rows);
	}
	public int[][] getCrossSectionByX(int x){
		  if (!(x>=0 && x<this.cols)){
			  throw new IndexOutOfBoundsException();
			  
		  }
		
		int[][] maze2d =new int[this.floors][this.cols];
		for (int z=0;z<this.floors;z++)
		{
			for (int i = 0; i < this.cols; i++) {
				maze2d[z][i]=maze[z][i][x];
				
			}
		}
		return maze2d;
	}
	public int[][] getCrossSectionByY(int y){
	  if (!(y>=0 && y<this.rows)){
		  throw new IndexOutOfBoundsException();
		  
	  }
		int[][] maze2d =new int[this.floors][this.rows];
		for (int z=0;z<this.floors;z++)
		{
			for (int i = 0; i < this.rows; i++) {
				maze2d[z][i]=maze[z][y][i];
				
			}
		}
		return maze2d;
	}
	public int[][] getCrossSectionByZ(int z){
		  if (!(z>=0 && z<this.floors)){
			  throw new IndexOutOfBoundsException();
			  
		  }

		 
		int[][] maze2d =new int[this.cols][this.rows];
		for (int y=0;y<this.cols;y++)
		{
			for (int i = 0; i < this.rows; i++) {
				maze2d[y][i]=maze[z][y][i];
				
			}
		}
		return maze2d;
	}



	public Direction[] getPossibleMoves(Position p) {
		List <Direction> directions = new ArrayList<Direction>();
	//System.out.println(p);
			if (isInMaze(new Position(p.x+1,p.y,p.z ))&& getValue(p.z,p.y, p.x+1)==Maze3d.FREE){
				directions.add(Direction.Right);
			}
			if (isInMaze(new Position( p.x-1, p.y,p.z))&& getValue(p.z,p.y, p.x-1)==Maze3d.FREE){
				directions.add(Direction.Left);
			}
			if (isInMaze(new Position(p.x , p.y+1,p.z))&& getValue(p.z,p.y+1, p.x)==Maze3d.FREE){
				directions.add(Direction.Forward);
			}
			if (isInMaze(new Position( p.x, p.y-1, p.z))&& getValue(p.z,p.y-1, p.x)==Maze3d.FREE){
				directions.add(Direction.Backward);
			}
			if (isInMaze(new Position(p.x, p.y,p.z+1 ))&& getValue(p.z+1,p.y, p.x)==Maze3d.FREE){
				directions.add(Direction.Up);
			}
			if (isInMaze(new Position(p.z-1, p.y,p.x))&& getValue(p.z-1,p.y, p.x)==Maze3d.FREE){
				directions.add(Direction.Down);
			}

			Direction[] dir = new Direction[directions.size()];
			dir = directions.toArray(dir);
			
			return dir;
		
	}
/*	
	public String[] getPossibleMoves(Position p) {
			List <String> directions = new ArrayList<String>();
	//System.out.println(p);
			if (isInMaze(new Position(p.x+1,p.y, p.z))&& getValue(p.z,p.y, p.x+1)==Maze3d.FREE){
				directions.add("Right");
			}
			if (isInMaze(new Position( p.x-1, p.y,p.z))&& getValue(p.z,p.y, p.x-1)==Maze3d.FREE){
				directions.add("Left");
			}
			if (isInMaze(new Position( p.x, p.y+1,p.z))&& getValue(p.z,p.y+1, p.x)==Maze3d.FREE){
				directions.add("Forward");
			}
			if (isInMaze(new Position(p.x, p.y-1,p.z ))&& getValue(p.z,p.y-1, p.x)==Maze3d.FREE){
				directions.add("Backward");
			}
			if (isInMaze(new Position( p.x, p.y,p.z+1))&& getValue(p.z+1,p.y, p.x)==Maze3d.FREE){
				directions.add("Up");
			}
			if (isInMaze(new Position(p.x, p.y,p.z-1 ))&& getValue(p.z-1,p.y, p.x)==Maze3d.FREE){
				directions.add("Down");
			}
			String[] dir = new String[directions.size()];
			dir = directions.toArray(dir);
			
			return dir;
		
	}
*/
}
