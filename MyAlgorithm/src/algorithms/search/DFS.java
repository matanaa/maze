
package algorithms.search;

import java.util.List;

public class DFS<T> extends CommonSearcher<T> {

	@Override
	public Solution<T> search(Searchable<T> s) {
		State<T> now = s.getStartState();
		now.setCameFrom(s.getGoalState());
		doDfs(now, s);
		return  backTrace(s.getGoalState());
	}
	
	
	
	protected boolean doDfs(State<T> now,Searchable<T> s){
		
		if (now.equals(s.getGoalState())){
			return true;
		}
		
		List<State<T>> neighbors = s.getAllPossibleStates(now);
		
	//	for (State<T> neighbor : neighbors) {
		for(int i=0;i<neighbors.size();i++){
			State<T> neighbor =neighbors.get(i);
			if (neighbor.getCameFrom()==null && !neighbor.equals(s.getStartState()) ) {
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
