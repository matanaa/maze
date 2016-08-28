package algorithms.search;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonSearcher.
 *
 * @param <T> the generic type
 */
public abstract class CommonSearcher<T> implements Seracher<T>{
	
	/** The evaluated nodes. */
	protected int evaluatedNodes;
	
	/* (non-Javadoc)
	 * @see algorithms.search.Seracher#getNumberOfNodesEvaluated()
	 */
	@Override
	public int getNumberOfNodesEvaluated() {
		return evaluatedNodes;
	}
	
	/**
	 * Back trace. calculate the Solution
	 *
	 * @param goalState the goal state
	 * @return the solution
	 */
	protected Solution<T> backTrace(State<T> goalState) {
			Solution<T> sol = new Solution<T>();
			
			State<T> currState = goalState;
			List<State<T>> states = sol.getStates();
			while (currState!=null){
				states.add(0, currState);
				currState = currState.getCameFrom();
			}
			return sol;
			
	}
}

