package algorrithm.demo;

import java.util.ArrayList;

import algorithms.mazeGenerators.Direction;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;

// TODO: Auto-generated Javadoc
/**
 * The Class mazeAdapter.
 */
public class mazeAdapter implements Searchable<Position> {

	/** The maze. */
	protected  Maze3d maze =null;
	
	/** The start state. */
	State<Position> startState=null;
	
	/** The goal state. */
	State<Position> goalState=null;
	
	/**
	 * Instantiates a new maze adapter.
	 *
	 * @param maze the maze
	 */
	public mazeAdapter(Maze3d maze) {
		this.maze=maze;
		this.startState=this.adaptPosition(maze.getStartPosition());
		this.goalState=this.adaptPosition(maze.getGoalPosition());

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
	 * @see algorithms.search.Searchable#getAllPossibleStates(algorithms.search.State)
	 */
	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {

		Direction[] dirs = maze.getPossibleMoves(s.getValue());
		ArrayList <State<Position>> posList =new  ArrayList<State<Position>>();
		 for (Direction d : dirs){
			Position pos = new Position(s.getValue());
			pos.changeByDirection(d);
			 State<Position> newState= adaptPosition(pos);
			 //newState.setCameFrom(s);
			 //newState.setCost(s.getCost()+newState.getCost());
			 posList.add(newState);
		 }
		 
		 return posList;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getMoveCost(algorithms.search.State, algorithms.search.State)
	 */
	@Override
	public double getMoveCost(State<Position> currState, State<Position> neighbor) {
		// TODO Auto-generated method stub
		return currState.getCost()+ neighbor.getCost();
	}
	
	/**
	 * Adapt position.
	 *
	 * @param p the Position
	 * @return the state
	 */
	protected State<Position> adaptPosition(Position p) {
		State<Position> s =new State<Position>(p.toString());
		s.setValue(p);
		s.setCameFrom(null);
		s.setCost(1);
		return s;
		
	}

}
