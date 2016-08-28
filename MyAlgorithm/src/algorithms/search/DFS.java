
package algorithms.search;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class DFS.
 *
 * @param <T> the generic type
 */
public class DFS<T> extends CommonSearcher<T> {

	/** The beenthere. */
	List<State<T>> beenthere=new ArrayList<State<T>>();
	
	/* (non-Javadoc)
	 * @see algorithms.search.Seracher#search(algorithms.search.Searchable)
	 */
	@Override
	public Solution<T> search(Searchable<T> s) {
		State<T> now = s.getStartState();
		beenthere.add(now);
		doDfs(now, s);
		return  backTrace(s.getGoalState());
	}
	
	
	
	/**
	 * recursive method to find the way
	 *
	 * @param now the now
	 * @param s the s
	 * @return true, if successful
	 */
	protected boolean doDfs(State<T> now,Searchable<T> s){
		
		if (now.equals(s.getGoalState())){
			State<T> start = s.getGoalState();
			start.setCameFrom(now.getCameFrom());
			return true;
		}
		
		List<State<T>> neighbors = s.getAllPossibleStates(now);
		
		for (State<T> neighbor : neighbors) {
			if (!beenthere.contains(neighbor) /*&& !neighbor.equals(s.getStartState())*/ ) {
				neighbor.setCameFrom(now);
				beenthere.add(neighbor);
				if (doDfs(neighbor, s))
				{
					return true;
				}
			}
		
		
		}
		return false;

	}

}
