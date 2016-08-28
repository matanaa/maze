package algorithms.search;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Searchable.
 *
 * @param <T> the generic type
 */
public interface Searchable<T> {

	/**
	 * Gets the start state.
	 *
	 * @return the start state
	 */
	public State<T> getStartState();
	
	/**
	 * Gets the goal state.
	 *
	 * @return the goal state
	 */
	public State<T> getGoalState();
	
	/**
	 * Gets the all possible states.
	 *
	 * @param s the s
	 * @return the all possible states
	 */
	public ArrayList<State<T>> getAllPossibleStates (State<T> s);
	
	/**
	 * Gets the move cost.
	 *
	 * @param currState the checking state
	 * @param neighbor the neighbor
	 * @return the move cost
	 */
	public double getMoveCost(State<T>currState, State<T> neighbor);
}			