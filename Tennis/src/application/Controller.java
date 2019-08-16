package application;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller {
	
	@FXML
	Canvas canvas;
	
	public void initialize() {
		Game.newGame(this);
		
	}
}
