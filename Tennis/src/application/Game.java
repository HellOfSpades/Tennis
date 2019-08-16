package application;

import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Game {
	
	private static Game game;
	Player player1,player2;
	Ball ball;
	public Updater updater;
	public boolean started = false;
	int score1 = 0;
	int score2 = 0;
	Controller controller;
	public boolean up1 = false;
	public boolean up2 = false;
	public boolean down1 = false;
	public boolean down2 = false;
	
	
	public static void newGame(Controller controller) {
		game = new Game(controller);
	}
	
	private Game(Controller controller){
		player1 = new Player(20,(int) ((controller.canvas.getHeight()/2-Player.HEIGHT/2)));
		player2 = new Player(1260-Player.WIDTH,(int) ((controller.canvas.getHeight()/2-Player.HEIGHT/2)));
		ball = new Ball((int)(controller.canvas.getWidth()/2-Ball.WIDTH/2), (int) (controller.canvas.getHeight()/2-Ball.HEIGHT/2));
		updater = new Updater();
		this.controller = controller;
		updater.start();
	}
	
	
	public void compileActionPressed(KeyEvent e) {
		if(!started) {
			started = true;
		}else {
			
			if (e.getCode() == KeyCode.UP) {
	            up2 = true;
	        }
			if (e.getCode() == KeyCode.DOWN) {
				down2 = true;
	        }
			if (e.getCode() == KeyCode.W) {
				up1 = true;
	        }
			if (e.getCode() == KeyCode.S) {
				down1 = true;
	        }
			
		}
	}
	
	public static Game getGame() {
		return game;
	}
	
	public void newRound(int player) {
		started = false;
		
		ball.x = (int)(controller.canvas.getWidth()/2-Ball.WIDTH/2);
		ball.y = (int) (controller.canvas.getHeight()/2-Ball.HEIGHT/2);
		ball.chooseRandomDir();
		
		if(player==1) {
			score1++;
		}else {
			score2++;
		}
		
	}

	public void compileActionRelease(KeyEvent e) {
		if (e.getCode() == KeyCode.UP) {
            up2 = false;
        }
		if (e.getCode() == KeyCode.DOWN) {
			down2 = false;
        }
		if (e.getCode() == KeyCode.W) {
			up1 = false;
        }
		if (e.getCode() == KeyCode.S) {
			down1 = false;
        }
		
	}
	
	
}
