package algorithms.search;

// TODO: Auto-generated Javadoc
/**
 * The Class State.
 *
 * @param <T> the generic type
 */
public class State<T> implements Comparable<State<T>> {
	
	/** The came from. */
	private State <T> cameFrom =null;
	
	/** The cost. */
	private double cost;
	
	/** The value. */
	private T value;
	
	/** The key. */
	private String key;
	
	/**
	 * Instantiates a new state.
	 *
	 * @param key the key
	 */
	public State (String key){
		this.key = key;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value.toString();
	}

	/**
	 * Gets the came from.
	 *
	 * @return the came from
	 */
	public State<T> getCameFrom() {
		return cameFrom;
	}

	/**
	 * Sets the came from.
	 *
	 * @param cameFrom the new came from
	 */
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
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
	 * Gets the value.
	 *
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(T value) {
		this.value = value;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		@SuppressWarnings("unchecked")
		State<T> s = (State<T>)obj;
		return s.value.equals(this.value);
	}
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	public boolean equals(State<T> obj) {
		//@SuppressWarnings("unchecked")
		return obj.value.equals(this.value);
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(State<T> s) {
		return (int)(this.getCost() - s.getCost());
	}
	
	
}
