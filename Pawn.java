public class Pawn extends Piece {

	private final String whiteP = "/pic/whitePawn.jpg";
	private final String blackP = "/pic/blackPawn.jpg";

	public Pawn(boolean color, Move move) {
		super(color, move);

		if (color) {
			super.setImage(whiteP);
		} else {
			super.setImage(blackP);
		}
	}

	@Override
	public boolean isValidMove(int srcX, int srcY, int destX, int destY) {
		if (color) { //White Piece movements
				if ((move.vertical(srcX, srcY, destX, destY) 
						&& move.vertDistance(srcY, destY) == 2
						&& srcY == 6
					|| move.vertical(srcX, srcY, destX, destY) 
					    && move.vertDistance(srcY, destY) == 1)
					&& move.difference(srcY, destY) < 0) 
					return true;
		} else { //black piece movements
			if ((move.vertical(srcX, srcY, destX, destY) 
					&& move.vertDistance(srcY, destY) == 2
					&& srcY == 1
				|| move.vertical(srcX, srcY, destX, destY) 
				    && move.vertDistance(srcY, destY) == 1)
				&& move.difference(srcY, destY) > 0)
					return true;
		}
		return false;
	}

}
