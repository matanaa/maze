
package algorithms.search;

import java.util.List;

public class DFS<T> extends CommonSearcher<T> {

	@Override
	public Solution<T> search(Searchable<T> s) {
		doDfs(s.getStartState(), s);
		return  backTrace(s.getGoalState());
	}
	
	
	
	protected boolean doDfs(State<T> now,Searchable<T> s){
		
		if (s.equals(s.getGoalState())){
			return true;
		}
		
		List<State<T>> neighbors = s.getAllPossibleStates(now);
		
		for (State<T> neighbor : neighbors) {
			if (neighbor.getCameFrom()==null) {
				neighbor.setCameFrom(now);
				if (doDfs(neighbor, s))
				{
					return true;
				}
			}
		
		
		}
		return false;

	}

}
