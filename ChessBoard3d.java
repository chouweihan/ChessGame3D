import javafx.scene.layout.GridPane;

public class ChessBoard3d extends Board {

	private Board board[];
	private GridPane pane = new GridPane();
	private ChessRules rule = new ChessRules();
	private Move move = new MoveList3D();
	private int curBoard = -1;

	public void createBoard() {
		board = new Board[3];
		board[0] = new ChessBoard(8, 8);
		board[1] = new ChessBoard(8, 8);
		board[2] = new ChessBoard(8, 8);
		board[0].createBoard();
		board[1].createBoard();
		board[2].createBoard();
	}

	public void setTiles(Event handle) {
		board[handle.getB()].setTiles(handle);
	}

	public void setBoard() {
		board[0].setBoard();
		board[1].setBoard();
		board[2].setBoard();
		pane.add(board[0].getPane(), 0, 0);
		pane.add(board[1].getPane(), 1, 0);
		pane.add(board[2].getPane(), 2, 0);
	}

	public GridPane getPane() {
		pane.setGridLinesVisible(true);
		return pane;
	}

	public void setPieces() {
		board[0].setPieces(move);
	}

	public void click(int[] pos) {
		setCurBoard(pos[2]);
		board[pos[2]].click(pos);
		if (!rule.getActive()) {
			rule.setSrcSquare(getSquareArray());
			move.setCur(pos[2]);
			rule.setSourceClick(pos[0], pos[1]);
		} else {
			rule.setDestSquare(getSquareArray());
			rule.setDestClick(pos[0], pos[1]);
			move.setSquares(getSquareArray());
			move.setDest(board[pos[2]], pos[2]);
			rule.move(pos[0], pos[1]);
		}
	}

	public void changeColor(int[] pos) {
		board[0].changeColor(pos);
		board[1].changeColor(pos);
		board[2].changeColor(pos);
	}
	
	public int getBNum() {
		return board.length;
	}

	public Squares[][] getSquareArray() {
		return board[curBoard].getSquareArray();
	}
	
	private void setCurBoard(int b) {
		curBoard = b;
	}
}
