package algorithms.search;

public class State<T> implements Comparable<State<T>> {
	
	private State <T> cameFrom =null;
	private double cost;
	private T value;
	private String key;
	
	public State (String key){
		this.key = key;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

	public State<T> getCameFrom() {
		return cameFrom;
	}

	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public boolean equals(Object obj) {
		@SuppressWarnings("unchecked")
		State<T> s = (State<T>)obj;
		return s.value.equals(this.value);
	}
	public boolean equals(State<T> obj) {
		//@SuppressWarnings("unchecked")
		return obj.value.equals(this.value);
	}


	@Override
	public int compareTo(State<T> s) {
		return (int)(this.getCost() - s.getCost());
	}
	
	
}
