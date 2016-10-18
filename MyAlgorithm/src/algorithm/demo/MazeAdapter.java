package algorithm.demo;

import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;

/**
 * The Class MazeAdapter - Turns the maze3d problem into a searchable problem which a searcher can solve.
 */
public class MazeAdapter implements Searchable<Position> {
	
	/** The maze. */
	protected Maze3d maze;
	
	/** The start state. */
	State<Position> startState;
	
	/** The goal state. */
	State<Position> goalState;
	
	/**
	 * Instantiates a new maze adapter.
	 *
	 * @param mazeObj the maze object
	 */
	public MazeAdapter(Maze3d mazeObj){
		this.maze = mazeObj;
		this.startState = this.adaptToState(maze.getStartPos());
		this.goalState = this.adaptToState(maze.getGoalPos());
		startState.setCost(0);
		
	}
	
	public MazeAdapter(Maze3d mazeObj, Position startpos){
		this.maze = mazeObj;
		this.startState = this.adaptToState(startpos);
		this.goalState = this.adaptToState(maze.getGoalPos());
		startState.setCost(0);
		
	}
	
	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getStartState()
	 */
	@Override
	public State<Position> getStartState() {
		return this.startState;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getGoalState()
	 */
	@Override
	public State<Position> getGoalState() {
		return this.goalState;

	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getAllPossibleMoves(algorithms.search.State)
	 */
	@Override
	public ArrayList<State<Position>> getAllPossibleMoves(State<Position> currState) {
		Position pos = currState.getState();
		ArrayList<Position> list = this.maze.getPossibleMoves(pos);
		ArrayList<State<Position>> StateList = new ArrayList<State<Position>>();
		for (Position p : list){
			State<Position> state = adaptToState(p);
			state.setCameFrom(currState);
			StateList.add(state);
		}
		return StateList;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getMoveCost(algorithms.search.State, algorithms.search.State)
	 */
	@Override
	public double getMoveCost(State<Position> currState, State<Position> neighbor) {
		return currState.getCost() + 1;
	}
	
	/**
	 * Adapt to state.
	 *
	 * @param pos the position
	 * @return the state
	 */
	protected State<Position> adaptToState(Position pos){
		State<Position> s = new State<Position>(pos.toString());
		s.setState(pos);
		s.setCost(1);
		s.setCameFrom(null);
		return s;
	}

}
