package algorithms.mazeGenerators;

public class Position {
	public int x;
	public int y;
	public int z;
	
	public Position(int x, int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Position(Position copyPos) {
		this.x = copyPos.x;
		this.y = copyPos.y;
		this.z =copyPos.z;
	}

	@Override
	public String toString() {
		return "(z=" + z + ",y=" + y + ",x="+ x +" )";
	}

	@Override
	public boolean equals(Object obj) {
		Position pos = (Position)obj;
		return (this.x == pos.x && this.y == pos.y&& this.z == pos.z);
	}
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
	

}
