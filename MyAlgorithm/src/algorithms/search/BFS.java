package algorithms.search;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class BFS.
 *
 * @param <T> the generic type
 */
public class BFS<T> extends CommonSearcher<T> {

	/** The open list. */
	private PriorityQueue<State<T>> openList = new PriorityQueue<State<T>>();
	
	/** The closed list. */
	private Set<State<T>> closedList = new HashSet<State<T>>();
	
	/**
	 * Instantiates a new bfs.
	 */
	public BFS() {
		super();
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Seracher#search(algorithms.search.Searchable)
	 */
	@Override
	public Solution<T> search(Searchable<T> s) {
		State<T> startState = s.getStartState();
		openList.add(startState);
		
		while (!openList.isEmpty()) {
			State<T> currState = openList.poll();
			closedList.add(currState);
			
			State<T> goalState = s.getGoalState();
			if (currState.equals(goalState)) {
				return backTrace(currState);
			}
			
			List<State<T>> neighbors = s.getAllPossibleStates(currState);
			
			for (State<T> neighbor : neighbors) {
				if (!openList.contains(neighbor) && !closedList.contains(neighbor)) {
					neighbor.setCameFrom(currState);
					neighbor.setCost(currState.getCost() + s.getMoveCost(currState, neighbor));
					openList.add(neighbor);
				}
				else {
					double newPathCost =/* currState.getCost() +*/ s.getMoveCost(currState, neighbor);
					if (neighbor.getCost() > newPathCost) {
						neighbor.setCost(newPathCost);
						neighbor.setCameFrom(currState);
						
						if (!openList.contains(neighbor)) {
							openList.add(neighbor);
						} 
						else { // must notify the priority queue about the change of cost
							openList.remove(neighbor);
							openList.add(neighbor);
						}
					}
				}			
			}
		}
		return null;
	}

}
