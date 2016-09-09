package algorithms.mazeGenerators;

// TODO: Auto-generated Javadoc
/**
 * The Class Position.
 */
public class Position {
	
	/** The z. */
	//DM
	public int z;
	
	/** The y. */
	public int y;
	
	/** The x. */
	public int x;
	
	/**
	 * Gets the z.
	 *
	 * @return the z
	 */
	// Getters Setters
	public int getZ() {
		return z;
	}
	
	/**
	 * Sets the z.
	 *
	 * @param z the new z
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Instantiates a new position.
	 *
	 * @param z the z
	 * @param y the y
	 * @param x the x
	 */
	// C'tor
	public Position(int z, int y, int x) {
		this.z = z;
		this.y = y;
		this.x = x;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{" + z + ", "+ y + ", "+ x + "}";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Position pos = (Position)obj;
		return (this.x == pos.x && this.y == pos.y && this.z == pos.z);
	}
	
	/**
	 * Turn position into a byte array
	 *
	 * @return the byte array of the position
	 */
	public byte[] toByteArray() {
		byte[] byteArray = new byte[3] ;
		int  i =0 ;
		byteArray[i++] = (byte)this.getZ();
		byteArray[i++] = (byte)this.getY();
		byteArray[i++] = (byte)this.getX();
		return byteArray;
	}
}
