public abstract class Piece {
	
	protected final boolean color;
	private String pic;
	protected Move move;
	
	// Give pieces a color
	public Piece(boolean color, Move m) {
		this.color = color;
		move = m;
	}
	
	//Creates new image object, p = image destination
	public void setImage(String p) {
		pic = p;
	}

	public String getPic() {
		return pic;
	}

	public boolean getColor() {
		return color;
	}
	
	public void setMove(MoveList m) {
		move = m;
	}
	
	/** Validates if Piece can move from source position to destination */
	public abstract boolean isValidMove(int srcX, int srcY, int destX, int destY);
}
