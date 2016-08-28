package algorithms.search;

// TODO: Auto-generated Javadoc
/**
 * The Interface Seracher.
 *
 * @param <T> the generic type
 */
public interface Seracher<T> {
	
	/**
	 * Gets the number of nodes evaluated.
	 *
	 * @return the number of nodes evaluated
	 */
	// the search method
	public int getNumberOfNodesEvaluated();
	
	/**
	 * Search.
	 *
	 * @param s the s
	 * @return the solution
	 */
	public Solution<T> search(Searchable<T> s);
	
}
