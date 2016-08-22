package algorithms.search;

import java.util.List;
import java.util.ArrayList;


public class Solution<T> {
	private List<State<T>> states = new ArrayList<State<T>>();
	private double solutionCost;
	
	public List<State<T>> getStates(){
		return states;
	}
	public void setState(List<State<T>> states) {
		this.states = states;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (State<T> s : states) {
			sb.append(s.toString()).append(", ");
		}
		
	return sb.toString();
	}
}
