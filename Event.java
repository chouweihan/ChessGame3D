import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Event implements EventHandler<ActionEvent> {

	private static int counter = 0;
	private final int p = counter++;
	private int[] pos = new int[3];
	private Board board;
	
	public Event(Board b) {
		board = b;
		pos[0] = (p % 64) / 8;  //row
		pos[1] = p % 8;         //col
		pos[2] = p / 64;        //bNum
	}

	@Override
	public void handle(ActionEvent event) {
		board.changeColor(pos);
		//returns clicked coordinates to board
		board.click(pos);
	}
	
	public int getRow() {
		return pos[0];
	}
	
	public int getCol() {
		return pos[1];
	}
	
	public int getB() {
		return pos[2];
	}
}
