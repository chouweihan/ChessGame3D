public class King extends Piece {
	private final String whiteP = "/pic/whiteKing.jpg";
	private final String blackP = "/pic/blackKing.jpg";

	public King(boolean color, Move move) {
		super(color, move);

		if (color) {
			super.setImage(whiteP);
		} else {
			super.setImage(blackP);
		}
	}

	@Override
	public boolean isValidMove(int srcX, int srcY, int destX, int destY) {
		if (move.diag(srcX, srcY, destX, destY) && move.diagDistance(srcY, destY) == 1
				|| move.vertical(srcX, srcY, destX, destY) && move.vertDistance(srcY, destY) == 1
				|| move.horizontal(srcX, srcY, destX, destY) && move.horizDistance(srcX, destX) == 1)
			return true;
		return false;
	}
}
