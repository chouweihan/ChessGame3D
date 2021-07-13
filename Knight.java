public class Knight extends Piece {
	
	private final String whiteP = "/pic/whiteKnight.jpg"; 
	private final String blackP = "/pic/blackKnight.jpg";
	
	public Knight(boolean color, Move move) {
		super(color, move);
		
		if (color) {
			super.setImage(whiteP);
		} else {
			super.setImage(blackP);
		}
	}

	@Override
	public boolean isValidMove(int srcX, int srcY, int destX, int destY) {
		if(move.isLong(srcX, srcY, destX, destY))
			return true;
		return false;
	}
}
