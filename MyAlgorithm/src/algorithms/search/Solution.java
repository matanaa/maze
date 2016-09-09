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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(solutionCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((states == null) ? 0 : states.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solution other = (Solution) obj;
		return this.toString().equals(other.toString());
	}

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
