import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main for chess
 * @author Wei-Han Chou
 * @version 1.0
 */
public class Game extends Application {
		
	public void start(Stage primaryStage) throws Exception {
		
		ChessBoard3d board = new ChessBoard3d();
		board.createBoard();
	
		for(int i = 0; i < (board.getBNum() * 64); i++) {
			Event handle = new Event(board);
			board.setTiles(handle);
		}
		
		board.setBoard();
		board.setPieces();
				
		final int appWidth = 1800;
	    final int appHeight = 600;

	    
	    Scene scene = new Scene(board.getPane(), appWidth, appHeight);

	    primaryStage.setTitle("Chess Game");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
    public static void main(String[] args) {
        launch(args);
    }

}
