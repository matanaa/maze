package algorithms.search;

import java.util.ArrayList;

import algorithms.mazeGenerators.Direction;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class mazeAdapter implements Searchable<Position> {

	protected  Maze3d maze =null;
	
	public mazeAdapter(Maze3d maze) {
		this.maze=maze;

	}

	@Override
	public State<Position> getStartState() {
		
		return this.adaptPosition(maze.getStartPosition());
	}

	@Override
	public State<Position> getGoalState() {	
		return this.adaptPosition(maze.getGoalPosition());

	}

	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {

		Direction[] dirs = maze.getPossibleMoves(s.getValue());
		ArrayList <State<Position>> posList =new  ArrayList<State<Position>>();
		 for (Direction d : dirs){
			Position pos = new Position(s.getValue());
			pos.changeByDirection(d);
			 State<Position> newState= adaptPosition(pos);
			 newState.setCameFrom(s);
			 newState.setCost(s.getCost()+newState.getCost());
			 posList.add(newState);
		 }
		 
		 return posList;
	}

	@Override
	public double getMoveCost(State<Position> currState, State<Position> neighbor) {
		// TODO Auto-generated method stub
		return currState.getCost()+ neighbor.getCost();
	}
	
	protected State<Position> adaptPosition(Position p) {
		State<Position> s =new State<Position>(p.toString());
		s.setValue(p);
		s.setCameFrom(null);
		s.setCost(1);
		return s;
		
	}

}
