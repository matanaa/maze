package algorithms.search;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class DFS - Searching for a solution
 *@author Snir Balgaly
 * @param <T> the generic type
 */
public class DFS<T> extends CommonSearcher<T> {

	/** The array of visited cells */
	List<State<T>> visited=new ArrayList<State<T>>();
	
	
	/* (non-Javadoc)
	 * @see algorithms.search.CommonSearcher#search(algorithms.search.Searchable)
	 */
	@Override
	public Solution<T> search(Searchable<T> searchable) {
		State<T> currState = searchable.getStartState();
		visited.add(currState);
		doDfs(currState, searchable);
		return backTrace(searchable.getGoalState());
	}
	
	/**
	 * doDfs - the main algorithm.
	 *
	 * @param currState the current state
	 * @param searchable the searchable (the game we want to solve)
	 * @return true, if successful
	 */
	protected boolean doDfs(State<T> currState,Searchable<T> searchable){
		
		if (currState.equals(searchable.getGoalState())){
			State<T> start = searchable.getGoalState();
			start.setCameFrom(currState.getCameFrom());
			start.setCost(currState.getCost());
			return true;
		}
		
		List<State<T>> neighbors = searchable.getAllPossibleMoves(currState);
		
		
		for (State<T> neighbor : neighbors) {
			if (!visited.contains(neighbor) && !neighbor.equals(searchable.getStartState())) {
				neighbor.setCameFrom(currState);
				neighbor.setCost(searchable.getMoveCost(currState, neighbor));
				visited.add(neighbor);
				this.evaluatedNodes++;
				if (doDfs(neighbor, searchable)){
					return true;
				}
			}
		}
		return false;
	}
}