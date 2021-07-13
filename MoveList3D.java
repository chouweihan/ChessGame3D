
public class MoveList3D extends Move {
	
	private int boardSrc = -1;
	private int boardDest = -1;
	private Move move = new MoveList();
	

	public boolean vertical(int srcX, int srcY, int destX, int destY) {
		int check = check3D();
		if(check == 0) {
			if(move.vertical(srcX, srcY, destX, destY))
				return true;
		}
		else if (move.vertical(srcX, srcY, destX, destY) && vertDistance(srcY, destY) == check)
				return true;
		
		return false;
	}


	public boolean horizontal(int srcX, int srcY, int destX, int destY) {
		int check = check3D();
		if(check == 0) {
			if(move.horizontal(srcX, srcY, destX, destY))
				return true;
		}
		else if(move.horizontal(srcX, srcY, destX, destY) && horizDistance(srcX, destX) == check)
			return true;
		
		return false;
	}


	public boolean diag(int srcX, int srcY, int destX, int destY) {
		int check = check3D();
		if(check == 0) {
			if(move.diag(srcX, srcY, destX, destY))
				return true;
		} 
		else if(move.diag(srcX, srcY, destX, destY) && diagDistance(srcY, destY) == check)
			return true;
		
		return false;
	}


	public boolean isLong(int srcX, int srcY, int destX, int destY) {
	//	int check = check3D();
	//	if(check == 0)
			if(move.isLong(srcX, srcY, destX, destY))
				return true;
		return false;
	}
	
	private int check3D() {
		return Math.abs(boardDest - boardSrc);
	}
	
	public void setCur(int bS) { boardSrc = bS; }
	public void setSquares(Squares[][] s) {
		move.setSquares(s);
	}
	
	public void setDest(Board b, int bD) { 
		boardDest = bD;
		}

}
