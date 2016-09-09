package algorithms.mazeGenerators;

// TODO: Auto-generated Javadoc
/**
 * The Class Position.
 */
public class Position {
	
	/** The x. */
	public int x;
	
	/** The y. */
	public int y;
	
	/** The z. */
	public int z;
	
	/**
	 * Instantiates a new position.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public Position(int x, int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * copy position .
	 *
	 * @param copyPos the copy pos
	 */
	public Position(Position copyPos) {
		this.x = copyPos.x;
		this.y = copyPos.y;
		this.z =copyPos.z;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(z=" + z + ",y=" + y + ",x="+ x +" )";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Position pos = (Position)obj;
		return (this.x == pos.x && this.y == pos.y&& this.z == pos.z);
	}
	
	/**
	 * Change Position by direction.
	 *
	 * @param d the ddirection to change
	 */
	public void changeByDirection(Direction d){
		switch (d) {//Left, Right, Forward, Backward, Up ,Down
		case Left:
			this.x=this.x-1;
			break;
		case Right:
			this.x=this.x+1;
			break;
		case Forward:
			this.y=this.y+1;
			break;
		case Backward:
			this.y=this.y-1;
			break;
		case Up:
			this.z=this.z+1;
			break;
		case Down:
			this.z=this.z-1;
			break;
		default:
			//throw error
			break;
		}
	}

	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		byte[] ret=new byte[3];
		
		ret[0]=(byte)this.x;
		ret[1]=(byte)this.y;
		ret[2]=(byte)this.z;

		return ret;
	}
	

}
