/**
 * This class checks if destination and source matches up with a certain move
 * type It also checks if there's a collision between pieces and movement
 * 
 * @author Wei-Han Chou
 * @version 1.0
 */
public class MoveList extends Move{

	private Squares[][] square;
	
	public void setSquares(Squares[][] s) {
		square = s;
	}
	
	// Move vertically
	public boolean vertical(int srcX, int srcY, int destX, int destY) {
		if (srcX == destX && destY != srcY) // if its a vertical move
			if (checkCollisionVertical(srcX, srcY, destY)) // checks collision
				return true;
		return false;
	}

	// moves horizontally 
	public boolean horizontal(int srcX, int srcY, int destX, int destY) {
		if (srcY == destY && destX != srcX)
			if (checkCollisionHorizontal(srcY, srcX, destX))
				return true;
		return false;
	}

	// move diagonally
	public boolean diag(int srcX, int srcY, int destX, int destY) {
		if (Math.abs(srcX - destX) == Math.abs(srcY - destY))
			if (checkCollisionDiagonal(srcX, srcY, destX, destY))
				return true;
		return false;
	}
	
	public boolean isLong(int srcX, int srcY, int destX, int destY) {
		if ((horizDistance(srcX, destX) == 1 && vertDistance(srcY, destY) == 2)
			|| (horizDistance(srcX, destX) == 2 && vertDistance(srcY, destY) == 1))
			return true;
		return false;		
	}


	private boolean checkCollisionDiagonal(int srcX, int srcY, int destX, int destY) {
		if ((srcX - destX) < 0 && (srcY - destY) < 0) { // towards South East
			for (int i = srcX + 1, j = srcY + 1; i < destX; i++, j++)
				if (square[i][j].getPiece() != null)
					return false;
		} else if ((srcX - destX) > 0 && (srcY - destY) > 0) { // towards north west
			for (int i = srcX - 1, j = srcY - 1; i > destX; i--, j--)
				if (square[i][j].getPiece() != null)
					return false;
		} else if ((srcX - destX) > 0 && (srcY - destY) < 0) { // towards south east
			for (int i = srcX - 1, j = srcY + 1; i > destX; i--, j++)
				if (square[i][j].getPiece() != null)
					return false;
		} else // towards north east
			for (int i = srcX + 1, j = srcY - 1; i < destX; i++, j--)
				if (square[i][j].getPiece() != null)
					return false;

		return true; // if no collisions at all
	}

	private boolean checkCollisionHorizontal(int srcY, int srcX, int destX) {
		if (srcX > destX) { // if piece is moving left
			for (int i = (srcX - 1); i > destX; i--)
				if (square[i][srcY].getPiece() != null)
					return false;
		} else // if piece is moving right
			for (int i = (srcX + 1); i < destX; i++)
				if (square[i][srcY].getPiece() != null)
					return false;

		return true; // no collision
	}

	private boolean checkCollisionVertical(int srcX, int srcY, int destY) {
		if (srcY > destY) { // if piece is moving upwards
			for (int i = (srcY - 1); i > destY; i--)
				if (square[srcX][i].getPiece() != null)
					return false;
		} else // if piece is moving downwards
			for (int i = (srcY + 1); i < destY; i++)
				if (square[srcX][i].getPiece() != null)
					return false;
		return true; // if no collision
	}
}