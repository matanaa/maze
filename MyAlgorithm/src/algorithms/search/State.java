package algorithms.search;

/**
 * The Class State.
 *
 * @param <T> the generic type
 */
public class State<T> implements Comparable<State<T>> {
	
	/** The state. */
	private T state;
	
	/** The cost. */
	private double cost;
	
	/** The came from state. */
	private State<T> cameFrom;
	
	/** The key. */
	private String key;
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	// Getters Setters
	public T getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(T state) {
		this.state = state;
	}
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Gets the came from.
	 *
	 * @return the came from state
	 */
	public State<T> getCameFrom() {
		return cameFrom;
	}
	
	/**
	 * Sets the came from.
	 *
	 * @param cameFrom the new came from state
	 */
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}
	
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	
	/**
	 * Instantiates a new state.
	 *
	 * @param State the state
	 */
	// Constructor
	public State(T State){
		this.state = State;
		this.cost = 0;
		this.cameFrom = null;
	}
	
	/**
	 * Instantiates a new state.
	 *
	 * @param key the key
	 */
	public State(String key){
		this.key = key;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	// Equals function
	@Override
	public boolean equals(Object obj){
		@SuppressWarnings("unchecked")
		State<T> s = ((State<T>) obj);
		return s.state.equals(this.state);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public	String toString() {
		return state.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(State<T> s) {
		return (int)(this.getCost() - s.getCost());
	}
	


}
