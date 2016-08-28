package algorithms.search;

import java.util.List;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class Solution.
 *
 * @param <T> the generic type
 */
public class Solution<T> {
	
	/** The states. */
	private List<State<T>> states = new ArrayList<State<T>>();
	
	/** The solution cost. */
	private double solutionCost;
	
	/**
	 * Gets the states.
	 *
	 * @return the states
	 */
	public List<State<T>> getStates(){
		return states;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param states the new state
	 */
	public void setState(List<State<T>> states) {
		this.states = states;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (State<T> s : states) {
			sb.append(s.toString()).append(", ");
		}
		
	return sb.toString();
	}
}
