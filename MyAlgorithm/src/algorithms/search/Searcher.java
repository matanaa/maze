package algorithms.search;

// TODO: Auto-generated Javadoc
/**
 * The Interface Searcher - Holds all the functions that a searcher of a problem has to have.
 * @author Snir Balgaly
 * @param <T> the generic type
 */
public interface Searcher<T> {
	
	/**
	 * Search.
	 *
	 * @param searchable the searchable (the problem)
	 * @return the solution
	 */
	public Solution<T> search (Searchable<T> searchable);
	
	/**
	 * Gets the evaluated nodes nun.
	 *
	 * @return the evaluated nodes nun
	 */
	public int getEvaluatedNodesNun();
	
}
