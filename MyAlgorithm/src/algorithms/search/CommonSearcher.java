package algorithms.search;

import java.util.List;

/**
 * The Class CommonSearcher - Abstract class used to hold mutual data for all searchers.
 *@author Snir Balgaly
 * @param <T> the generic type
 */
public abstract class CommonSearcher<T> implements Searcher<T> {
	
	/** The evaluated nodes number. */
	protected int evaluatedNodes;
	
	/**
	 * Gets the evaluated nodes.
	 *
	 * @return the evaluated nodes
	 */
	// Getters Setters
	public int getEvaluatedNodes() {
		return evaluatedNodes;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searcher#search(algorithms.search.Searchable)
	 */
	@Override
	public abstract Solution<T> search(Searchable<T> searchable);

	/* (non-Javadoc)
	 * @see algorithms.search.Searcher#getEvaluatedNodesNun()
	 */
	@Override
	public int getEvaluatedNodesNun() {
		return evaluatedNodes;
	}

	/**
	 * Back trace.
	 *
	 * @param goalState the goal state
	 * @return the solution
	 */
	protected Solution<T> backTrace(State<T> goalState){
		Solution<T> sol = new Solution<T>();
		State<T> currState = goalState;
		List<State<T>> states = sol.getSolution();
		while (currState != null){
			states.add(0, currState);
			currState = currState.getCameFrom();
		}
		sol.setSolutionCost(goalState.getCost());
		return sol;
	}

}
