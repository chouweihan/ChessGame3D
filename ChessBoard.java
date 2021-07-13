import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * @author Wei-Han Chou
 * @version 1.0
 */
public class ChessBoard extends Board {
	private static int counter = 0;
	private Button tiles[][];
	private Squares square[][];
	private GridPane pane = new GridPane();
	private final boolean white = true;
	private final boolean black = false;
	private Move move;
	private Squares s;
	private final int boardNum = counter++;

	public ChessBoard(int row, int col) {
		tiles = new Button[row][col];
		square = new Squares[row][col];
	}

	/** Create squares, stores in 2d array true = white, false = black */
	public void createBoard() {
		for (int r = 0; r < tiles.length; r++) {
			for (int c = 0; c < tiles[r].length; c++) {
				// inside loop, because I want each square to have its own color boolean value
				s = new Squares(true);
				// checks if square should be black or white
				if ((r + (c + 1)) % 2 == 0) {
					s.setColor(black);
				} else {
					s.setColor(white);
				}
				square[r][c] = s;
				tiles[r][c] = s.getButton();
			}
		}
	}
	
	public void setTiles(Event handle) {		
		tiles[handle.getRow()][handle.getCol()].setOnAction(handle);
	}

	/** Adds squares to grid pane */
	public void setBoard() {
		for (int r = 0; r < tiles.length; r++) {
			for (int c = 0; c < tiles[0].length; c++) {
				// adds the tiles to gridpane
				pane.add(tiles[r][c], r, c);
			}
		}
	}

	/** Sets initial Pieces. */
	public void setPieces(Move m) {
		move = m;
		square[0][0].addPiece(new Rook(black, move));
		square[1][0].addPiece(new Knight(black, move));
		square[2][0].addPiece(new Bishop(black, move));
		square[3][0].addPiece(new King(black, move));
		square[4][0].addPiece(new Queen(black, move));
		square[5][0].addPiece(new Bishop(black, move));
		square[6][0].addPiece(new Knight(black, move));
		square[7][0].addPiece(new Rook(black, move));

		for (int i = 0; i < 8; i++) {
			square[i][1].addPiece(new Pawn(black, move));
			square[i][6].addPiece(new Pawn(white, move));
		}

		square[0][7].addPiece(new Rook(white, move));
		square[1][7].addPiece(new Knight(white, move));
		square[2][7].addPiece(new Bishop(white, move));
		square[3][7].addPiece(new King(white, move));
		square[4][7].addPiece(new Queen(white, move));
		square[5][7].addPiece(new Bishop(white, move));
		square[6][7].addPiece(new Knight(white, move));
		square[7][7].addPiece(new Rook(white, move));
	}

	public void click(int[] pos) {
		tiles[pos[0]][pos[1]].setStyle("-fx-background-color: #42f459");
	}

	public void changeColor(int[] pos) {
		for (int r = 0; r < tiles.length; r++) {
			for (int c = 0; c < tiles[r].length; c++) {
				// checks if square should be black or white
				if ((r + (c + 1)) % 2 == 0) {
					tiles[r][c].setStyle("-fx-background-color: #a2e8f0");
				} else {
					tiles[r][c].setStyle("-fx-background-color: #e6e6fa");
				}
			}
		}
	}

	public Squares[][] getSquareArray() {
		return square;
	}
	
	public GridPane getPane() {
		return pane;
	}

	public int getBNum() {
		return boardNum;
	}

}
