
public abstract class Move {	
	private Squares[][] squares;
	
	public abstract boolean vertical(int srcX, int srcY, int destX, int destY);
	public abstract boolean horizontal(int srcX, int srcY, int destX, int destY);
	public abstract boolean diag(int srcX, int srcY, int destX, int destY);
	public abstract boolean isLong(int srcX, int srcY, int destX, int destY);
	public void setCur(int boardSrc) {};
	public void setDest(Board b, int boardDest) {};
	
	public void setSquares(Squares[][] s) {
		squares = s;
	}
	
	public int vertDistance(int srcY, int destY) {
		return Math.abs(destY - srcY);
	}
	
	public int horizDistance(int srcX, int destX) {
		return Math.abs(destX - srcX);
	}
	
	public int diagDistance(int srcY, int destY) {
		return Math.abs(srcY - destY);
	}
	
	public int difference(int src, int dest) {
		return dest - src;
	}
	
	
	public void setCur() {};
	public void setDest() {};
	
}
