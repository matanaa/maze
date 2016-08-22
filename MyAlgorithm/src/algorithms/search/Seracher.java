package algorithms.search;

public interface Seracher<T> {
	// the search method
	public int getNumberOfNodesEvaluated();
	public Solution<T> search(Searchable<T> s);
	
}
