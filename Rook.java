public class Rook extends Piece {

	private final String whiteP = "/pic/whiteRook.jpg"; 
	private final String blackP = "/pic/blackRook.jpg";
	
	public Rook(boolean color, Move move) {
		super(color, move);
		
		if (color) {
			super.setImage(whiteP);
		} else {
			super.setImage(blackP);
		}
	}

	@Override
	public boolean isValidMove(int srcX, int srcY, int destX, int destY) {
		if(move.vertical(srcX, srcY, destX, destY) || move.horizontal(srcX, srcY, destX, destY))
			return true;
		return false;	
	}
}
