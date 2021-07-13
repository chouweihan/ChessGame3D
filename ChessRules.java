public class ChessRules {

	private int cRow;
	private int cCol;
	private int destRow = -1;
	private int destCol = -1;
	private final String redColor = "-fx-background-color: #ff0000";
	private boolean active = false; 
	private boolean playerTurn = true;

	private Piece piece = null;
	private Squares[][] srcSquare;
	private Squares[][] destSquare;
	
	
	/** Moves pieces if valid */
	public void move(int r, int c) {
		if (checkDestination(r, c)) {
			if (srcSquare[cRow][cCol].getPiece().isValidMove(cRow, cCol, destRow, destCol)) {
				srcSquare[cRow][cCol].removePiece();
				destSquare[destRow][destCol].removePiece();
				destSquare[destRow][destCol].addPiece(piece);
				playerTurn ^= true;
			} else
				destSquare[destRow][destCol].setSquareColor(redColor);
		} else {
			System.out.println("invalid move");
			//sets background to red, so user know its invalid move
			setDestSquareRed(destRow, destCol);

		}
		setFalse();
	}
	
	/** Checks if square has null piece */
	private boolean checkDestination(int r, int c) {
		if (destSquare[r][c].getPiece() == null
			|| destSquare[r][c].getColorPiece() != playerTurn) 
			return true;
		
		System.err.println("can't attack your own piece");
		return false;
	}
	
	/** sets the source click */
	public void setSourceClick(int r, int c) {
		if (srcSquare[r][c].getPiece() != null 
				&& (srcSquare[r][c].getColorPiece() == playerTurn)) {
			active = true;
			cRow = r;
			cCol = c;
			piece = srcSquare[r][c].getPiece();
		} else {
			setSrcSquareRed(r, c);
			System.err.println("null piece or not your turn");
		}
	}
		
	public void setDestClick(int r, int c) {
		destRow = r;
		destCol = c;
	}
	
	private void setSrcSquareRed(int r, int c) {
		srcSquare[r][c].setSquareColor(redColor);
	} 
	
	private void setDestSquareRed(int r, int c) {
		destSquare[r][c].setSquareColor(redColor);
	} 
	
	public void setFalse() { active = false; } //if active = false; player has not picked a valid piece
	public void setPlayerTurn(boolean b) { playerTurn = b;}
	public Piece getPiece() { return piece;}
	public boolean getActive() {return active;}
	public void setSrcSquare(Squares[][] squareArray) { srcSquare = squareArray; }
	public void setDestSquare(Squares[][] squareArray) { destSquare = squareArray; }
}
