package algorithms.mazeGenerators;

import java.io.Serializable;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Maze3d.
 */
public class Maze3d implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The maze. */
	// DM
	private int[][][] maze;

	/** The z. */
	private int z;

	/** The y. */
	private int y;

	/** The x. */
	private int x;

	/** The start position. */
	private Position startPos;

	/** The goal position. */
	private Position goalPos;

	/** The Constant WALL. */
	// Constants
	public final static int WALL = 1;

	/** The Constant FREE. */
	public final static int FREE = 0;

	/**
	 * Instantiates a new 3DMaze.
	 *
	 * @param z
	 *            the z
	 * @param y
	 *            the y
	 * @param x
	 *            the x
	 */
	public Maze3d(int z, int y, int x) {
		super();
		this.z = z;
		this.y = y;
		this.x = x;
		maze = new int[z][y][x];
	}

	/**
	 * Receives a data array and builds a new 3DMaze.
	 *
	 * @param bytes
	 *            - a byte array which contains the data of the 3DMaze.
	 */
	public Maze3d(byte[] bytes) {
		int i = 0;
		this.z = (int) bytes[i++];
		this.y = (int) bytes[i++];
		this.x = (int) bytes[i++];

		this.startPos = new Position((int) bytes[i++], (int) bytes[i++], (int) bytes[i++]);
		this.goalPos = new Position((int) bytes[i++], (int) bytes[i++], (int) bytes[i++]);

		this.maze = new int[this.z][this.y][this.x];

		for (int t = 0; t < this.z; t++) {
			for (int j = 0; j < this.y; j++) {
				for (int h = 0; h < this.x; h++) {
					this.maze[t][j][h] = (int) bytes[i++];
				}
			}
		}
	}

	/**
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	// Setters Getters
	public int[][][] getMaze() {
		return maze;
	}

	/**
	 * Gets the z.
	 *
	 * @return the z
	 */
	public int getZ() {
		return z;
	}

	/**
	 * Sets the z.
	 *
	 * @param z
	 *            the new z
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y
	 *            the new y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x
	 *            the new x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the start pos.
	 *
	 * @return the start pos
	 */
	public Position getStartPos() {
		return startPos;
	}

	/**
	 * Sets the start pos.
	 *
	 * @param startPos
	 *            the new start pos
	 */
	public void setStartPos(Position startPos) {
		this.startPos = startPos;
	}

	/**
	 * Gets the goal pos.
	 *
	 * @return the goal pos
	 */
	public Position getGoalPos() {
		return goalPos;
	}

	/**
	 * Sets the goal pos.
	 *
	 * @param goalPos
	 *            the new goal pos
	 */
	public void setGoalPos(Position goalPos) {
		this.goalPos = goalPos;
	}

	/**
	 * Prints the maze.
	 */
	// Method to print the maze
	public void printMaze() {
		for (int x = 0; x < maze.length; x++) {
			for (int y = 0; y < maze[0].length; y++) {
				for (int z = 0; z < maze[0][0].length; z++) {
					System.out.print(maze[x][y][z] + " ");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		}
	}

	/**
	 * Sets the occ.
	 *
	 * @param z
	 *            the z
	 * @param y
	 *            the y
	 * @param x
	 *            the x
	 */
	// Gets a coordinate and set it as occupied
	public void setOcc(int z, int y, int x) {
		maze[z][y][x] = WALL;
	}

	/**
	 * Sets the free.
	 *
	 * @param z
	 *            the z
	 * @param y
	 *            the y
	 * @param x
	 *            the x
	 */
	// Gets a coordinate and set it as free
	public void setFree(int z, int y, int x) {
		maze[z][y][x] = FREE;
	}

	/**
	 * Inits the maze.
	 *
	 * @param n
	 *            the n
	 */
	// Initialize maze - free or occupied
	private void initMaze(int n) {

		for (int i = 0; i < z; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < x; k++) {
					this.maze[i][j][k] = n;
				}
			}
		}
	}

	/**
	 * Inits the empty maze.
	 */
	// Initialize free maze
	public void initEmptyMaze() {
		this.initMaze(0);
	}

	/**
	 * Inits the full maze.
	 */
	// Initialize occupied maze
	public void initFullMaze() {
		this.initMaze(1);
	}

	// Gets a cell, and maze sized array with information about visited and
	// unvisited cells
	/**
	 * Gets the unvisited neighbors.
	 *
	 * @param visited
	 *            the visited
	 * @param currCell
	 *            the curr cell
	 * @return the unvisited neighbors
	 */
	// and returns a list of unvisited cells of this array
	public ArrayList<Position> getUnvisitedNeighbors(boolean[][][] visited, Position currCell) {

		// Creates the list we will return
		ArrayList<Position> neighbors = new ArrayList<Position>();

		// For an easier use of currCell coordinates
		int z = currCell.getZ();
		int y = currCell.getY();
		int x = currCell.getX();

		// This algorithm will add a visitor to the unvisited neighbor list as
		// long as
		// this neighbor hasn't been visited already and within the maze
		if (z + 2 < this.z) {
			if (visited[z + 2][y][x] == false) {
				neighbors.add(new Position(z + 2, y, x));
			}
		}
		if (y + 2 < this.y) {
			if (visited[z][y + 2][x] == false) {
				neighbors.add(new Position(z, y + 2, x));
			}
		}
		if (x + 2 < this.x) {
			if (visited[z][y][x + 2] == false) {
				neighbors.add(new Position(z, y, x + 2));
			}
		}
		if (z > 1) {
			if (visited[z - 2][y][x] == false) {
				neighbors.add(new Position(z - 2, y, x));
			}
		}
		if (y > 1) {
			if (visited[z][y - 2][x] == false) {
				neighbors.add(new Position(z, y - 2, x));
			}
		}
		if (x > 1) {
			if (visited[z][y][x - 2] == false) {
				neighbors.add(new Position(z, y, x - 2));
			}
		}

		// Returns the list
		return neighbors;
	}

	// This function will get two cells and break the wall between them
	/**
	 * Break wall.
	 *
	 * @param currCell
	 *            the curr cell
	 * @param newCell
	 *            the new cell
	 */
	// (will make the cell between them available)
	public void breakWall(Position currCell, Position newCell) {
		int wallZ = currCell.getZ();
		int wallY = currCell.getY();
		int wallX = currCell.getX();
		if (currCell.getZ() != newCell.getZ()) {
			if (currCell.getZ() > newCell.getZ()) {
				wallZ -= 1;
			}
			if (currCell.getZ() < newCell.getZ()) {
				wallZ += 1;
			}
		}
		if (currCell.getY() != newCell.getY()) {
			if (currCell.getY() > newCell.getY()) {
				wallY -= 1;
			}
			if (currCell.getY() < newCell.getY()) {
				wallY += 1;
			}
		}
		if (currCell.getX() != newCell.getX()) {
			if (currCell.getX() > newCell.getX()) {
				wallX -= 1;
			}
			if (currCell.getX() < newCell.getX()) {
				wallX += 1;
			}
		}
		this.maze[wallZ][wallY][wallX] = Maze3d.FREE;
		this.maze[currCell.getZ()][currCell.getY()][currCell.getX()] = Maze3d.FREE;
		this.maze[newCell.getZ()][newCell.getY()][newCell.getX()] = Maze3d.FREE;
	}

	/**
	 * Creates the track.
	 *
	 * @param start
	 *            the start
	 * @param goal
	 *            the goal
	 */
	// This function will receive two position and create an open path between
	// them on the maze
	public void createTrack(Position start, Position goal) {
		// Variables
		int startZ = start.getZ();
		int startY = start.getY();
		int startX = start.getX();
		int goalZ = goal.getZ();
		int goalY = goal.getY();
		int goalX = goal.getX();
		// create track on the Z axis
		if (startZ > goalZ) {
			for (; startZ > goalZ; startZ--) {
				this.maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
		if (startZ < goalZ) {
			for (; startZ < goalZ; startZ++) {
				this.maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
		// create track on the Y axis
		if (startY > goalY) {
			for (; startY > goalY; startY--) {
				this.maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
		if (startY < goalY) {
			for (; startY < goalY; startY++) {
				this.maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
		// create track on the x axis
		if (startX > goalX) {
			for (; startX > goalX; startX--) {
				this.maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
		if (startX < goalX) {
			for (; startX < goalX; startX++) {
				this.maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
	}

	/**
	 * Gets the cross section by X.
	 *
	 * @param i
	 *            the i
	 * @return the cross section by X
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	// Gets 2DMaze created by a cut of a maze on the X axis
	public int[][] getCrossSectionByX(int i) throws IndexOutOfBoundsException {
		if (i >= 0 && i <= this.getX()) {
			int[][] Maze2D = new int[this.getY()][this.getZ()];
			for (int j = 0; j < this.getY(); j++) {
				for (int k = 0; k < this.getZ(); k++) {
					Maze2D[j][k] = this.maze[j][k][i];
				}
			}
			return Maze2D;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Gets the cross section by Y.
	 *
	 * @param i
	 *            the i
	 * @return the cross section by Y
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	// Gets 2DMaze created by a cut of a maze on the Y axis
	public int[][] getCrossSectionByY(int i) throws IndexOutOfBoundsException {
		if (i >= 0 && i <= this.getY()) {
			int[][] Maze2D = new int[this.getX()][this.getZ()];
			for (int j = 0; j < this.getX(); j++) {
				for (int k = 0; k < this.getZ(); k++) {
					Maze2D[j][k] = this.maze[j][i][k];
				}
			}
			return Maze2D;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Gets the cross section by Z.
	 *
	 * @param i
	 *            the i
	 * @return the cross section by Z
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	// Gets 2DMaze created by a cut of a maze on the Z axis
	public int[][] getCrossSectionByZ(int i) throws IndexOutOfBoundsException {
		if (i >= 0 && i <= this.getZ()) {
			int[][] Maze2D = new int[this.getY()][this.getX()];

			for (int j = 0; j < this.getY(); j++) {
				for (int k = 0; k < this.getX(); k++) {
					Maze2D[j][k] = this.maze[i][j][k];
				}
			}
			return Maze2D;
		} else
			throw new IndexOutOfBoundsException();
	}

	/**
	 * Gets the possible moves.
	 *
	 * @param pos
	 *            the position
	 * @return the possible moves
	 */
	public ArrayList<Position> getPossibleMoves(Position pos) {

		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		if (pos.x + 1 < this.getX()) {
			if (maze[pos.z][pos.y][pos.x + 1] == FREE)
				possibleMoves.add(new Position(pos.z, pos.y, pos.x + 1));
		}
		if (pos.x > 0) {
			if (maze[pos.z][pos.y][pos.x - 1] == FREE)
				possibleMoves.add(new Position(pos.z, pos.y, pos.x - 1));
		}
		if (pos.y + 1 < this.getY()) {
			if (maze[pos.z][pos.y + 1][pos.x] == FREE)
				possibleMoves.add(new Position(pos.z, pos.y + 1, pos.x));
		}
		if (pos.y > 0) {
			if (maze[pos.z][pos.y - 1][pos.x] == FREE)
				possibleMoves.add(new Position(pos.z, pos.y - 1, pos.x));
		}
		if (pos.z + 1 < this.getZ()) {
			if (maze[pos.z + 1][pos.y][pos.x] == FREE)
				possibleMoves.add(new Position(pos.z + 1, pos.y, pos.x));
		}
		if (pos.z > 0) {
			if (maze[pos.z - 1][pos.y][pos.x] == FREE)
				possibleMoves.add(new Position(pos.z - 1, pos.y, pos.x));
		}
		return (ArrayList<Position>) possibleMoves;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object maze) {
		Maze3d m = (Maze3d) maze;
		if ((this.getZ() != m.getZ()) || (this.getY() != m.getY()) || (this.getX() != m.getX())) {
			return false;
		}
		if (!this.getStartPos().equals(m.getStartPos()) || !this.getGoalPos().equals(m.getGoalPos())) {
			return false;
		}
		for (int i = 0; i < this.z; i++) {
			for (int j = 0; j < this.y; j++) {
				for (int h = 0; h < this.x; h++) {
					if (this.maze[i][j][h] != m.maze[i][j][h]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Return the maze as a byte array.
	 *
	 * @return the byte array
	 */
	public byte[] toByteArray() {

		// Turning position to byte arrays using function
		byte[] entranceByteArray = this.getStartPos().toByteArray();
		byte[] goalByteArray = this.getGoalPos().toByteArray();

		// creating the byte array that will holds the maze
		byte[] byteArray = new byte[this.getZ() * this.getY() * this.getX() + 3 + entranceByteArray.length
				+ goalByteArray.length];

		// Entering the meta data to the array (start and goal positions, and
		// amount of floors, cells and columns)
		int i = 0;
		byteArray[i++] = (byte) this.getZ();
		byteArray[i++] = (byte) this.getY();
		byteArray[i++] = (byte) this.getX();
		for (byte b : entranceByteArray) {
			byteArray[i++] = b;
		}
		for (byte b : goalByteArray) {
			byteArray[i++] = b;
		}
		// Entering the maze data - all the cells
		for (int j = 0; j < this.getZ(); j++) {
			for (int k = 0; k < this.getY(); k++) {
				for (int t = 0; t < this.getX(); t++) {
					byteArray[i++] = (byte) this.maze[j][k][t];
				}
			}
		}
		return byteArray;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.z; i++) {
			for (int j = 0; j < this.y; j++) {
				for (int k = 0; k < this.x; k++) {
					if (i == startPos.z && j == startPos.y && k == startPos.x) {
						sb.append("S ");
					} else if (i == goalPos.z && j == goalPos.y && k == goalPos.x) {
						sb.append("G ");
					} else {
						sb.append(this.maze[i][j][k] + " ");
					}
				}
				sb.append("\n");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
