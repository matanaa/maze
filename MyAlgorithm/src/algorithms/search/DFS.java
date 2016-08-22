
package algorithms.search;

import java.util.ArrayList;
import java.util.List;

public class DFS<T> extends CommonSearcher<T> {

	List<State<T>> beenthere=new ArrayList<State<T>>();
	@Override
	public Solution<T> search(Searchable<T> s) {
		State<T> now = s.getStartState();
beenthere.add(now);
		doDfs(now, s);
		return  backTrace(s.getGoalState());
	}
	
	
	
	protected boolean doDfs(State<T> now,Searchable<T> s){
		
		if (now.equals(s.getGoalState())){
			State<T> start = s.getGoalState();
			start.setCameFrom(now.getCameFrom());
			return true;
		}
		
		List<State<T>> neighbors = s.getAllPossibleStates(now);
		
		for (State<T> neighbor : neighbors) {
			if (!beenthere.contains(neighbor) && !neighbor.equals(s.getStartState()) ) {
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
