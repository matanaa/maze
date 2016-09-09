package algorithms.search;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class BFS - algorithm for searching a solution using Best First Search..<p>
 * The advantages of BFS:<p>
 * Finding the lowest cost possible for solving a problem.<p>
 * The advantages of DFS:<p>
 * Find a quick solution. Once you got to the goal state, it's over.<p>
 * I used this method because this is they way we learned this from the pseudo code.<p>
 * 
 * Mouse Maze question:<p>
 * BFS:<p>
 * According to Wikipedia, evaluated node, is a node that enters the CLOSED list and will no be evaluated again.<p>
 * Therefore, the ammount of evaluated nodes in the BFS algorithm is 10.<p>
 * DFS:<p>
 * The number of evaluated nodes is 6<p>
 *@author Snir Balgaly
 * @param <T> the generic type
 */
public class BFS<T> extends CommonSearcher<T> {
	
	/** The open list. */
	// DM
	private Queue<State<T>> openList = new PriorityQueue<State<T>>();
	
	/** The closed list. */
	private Set<State<T>> closedList = new HashSet<State<T>>();
	
	/* (non-Javadoc)
	 * @see algorithms.search.CommonSearcher#search(algorithms.search.Searchable)
	 */
	@Override
	public Solution<T> search(Searchable<T> s){
		State<T> startState = s.getStartState();
		openList.add(startState);
		
		while (!openList.isEmpty()){
			State<T> currState = openList.poll();
			closedList.add(currState);
			this.evaluatedNodes++;
			
			State<T> goalState = s.getGoalState();
			if (currState.equals(goalState)){
				return backTrace(currState);
			}
			
			List<State<T>> neighbours = s.getAllPossibleMoves(currState);
			
			for (State<T> neighbor : neighbours) {
				if (!openList.contains(neighbor) && !closedList.contains(neighbor)){
					neighbor.setCameFrom(currState);
					neighbor.setCost(s.getMoveCost(currState, neighbor));
					openList.add(neighbor);
				}
				else {
					double newPathCost = currState.getCost() + s.getMoveCost(currState, neighbor);
					if (neighbor.getCost() > newPathCost){
						neighbor.setCost(newPathCost);
						neighbor.setCameFrom(currState);
						
						if (!openList.contains(neighbor)){
							openList.add(neighbor);
						}
						else{
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
