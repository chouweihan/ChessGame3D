import javafx.scene.layout.GridPane;

public abstract class Board extends GridPane {
	public abstract GridPane getPane();
	public abstract void createBoard();
	public abstract void setBoard();
	public void setPieces(Move m) {}
	public abstract void setTiles(Event handle);
	public abstract void click(int[] pos);
	public abstract void changeColor(int[] pos);
	public abstract int getBNum();
	public abstract Squares[][] getSquareArray();
}
