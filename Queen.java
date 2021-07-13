public class Queen extends Piece {
	
	private final String whiteP = "/pic/whiteQueen.jpg"; 
	private final String blackP = "/pic/blackQueen.jpg";
	
	public Queen(boolean color, Move move) {
		super(color, move);
		
		if (color) {
			super.setImage(whiteP);
		} else {
			super.setImage(blackP);
		}
	}

	@Override
	public boolean isValidMove(int srcX, int srcY, int destX, int destY) {
		if(move.diag(srcX, srcY, destX, destY) 
				|| move.vertical(srcX, srcY, destX, destY)
				|| move.horizontal(srcX, srcY, destX, destY))
			return true;
		return false;
	}
}
