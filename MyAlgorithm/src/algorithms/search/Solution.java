package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class Solution.
 *
 * @param <T>
 *            the generic type
 */
public class Solution<T> implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1;
	/** The solution. */
	private List<State<T>> solution;

	/** The solution cost. */
	private double solutionCost;

	/**
	 * Instantiates a new solution.
	 */
	public Solution() {
		this.setSolution(new ArrayList<State<T>>());
	}

	/**
	 * Instantiates a new solution.
	 *
	 * @param path
	 *            the path
	 * @param pathCost
	 *            the path cost
	 */
	public Solution(ArrayList<State<T>> path, double pathCost) {
		this.solution = path;
		this.solutionCost = pathCost;
	}

	/**
	 * Gets the solution.
	 *
	 * @return the solution
	 */
	// Getters Setters
	public ArrayList<State<T>> getSolution() {
		return (ArrayList<State<T>>) solution;
	}

	/**
	 * Sets the solution.
	 *
	 * @param states
	 *            the new solution
	 */
	public void setSolution(ArrayList<State<T>> states) {
		this.solution = states;
	}

	/**
	 * Gets the solution cost.
	 *
	 * @return the solution cost
	 */
	public double getSolutionCost() {
		return solutionCost;
	}

	/**
	 * Sets the solution cost.
	 *
	 * @param solutionCost
	 *            the new solution cost
	 */
	public void setSolutionCost(double solutionCost) {
		this.solutionCost = solutionCost;
	}

	/**
	 * Prints the solution.
	 */
	public void print() {
		for (State<T> s : this.solution) {
			System.out.println(s.getState() + " ");
		}
		System.out.println("");
	}

	/**
	 * Adds a state to the solution.
	 *
	 * @param i
	 *            the place
	 * @param s
	 *            the state
	 */
	public void add(int i, State<T> s) {
		this.solution.add(i, s);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "";
		for (State<T> s : solution) {
			str = str + s.getState() + "\n";
		}
		str += "The Cost: " + this.solutionCost + "\n";
		return str;
	}
}
