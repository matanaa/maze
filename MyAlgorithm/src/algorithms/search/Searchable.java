package algorithms.search;

import java.util.ArrayList;

/**
 * The Interface Searchable - Holds all the functions that a searchable problem has to have..
 *@author - Snir Balgaly
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
		 * Gets the all possible moves.
		 *
		 * @param currState the current state
		 * @return the all possible moves
		 */
		public ArrayList<State<T>> getAllPossibleMoves(State<T> currState);
		
		/**
		 * Gets the move cost.
		 *
		 * @param currState the current state
		 * @param neighbor the neighbor
		 * @return the move cost
		 */
		double getMoveCost(State<T> currState, State<T> neighbor);
}
