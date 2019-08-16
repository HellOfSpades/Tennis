package application;


import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Updater extends AnimationTimer{

	
	public void handle(long now) {
		
		//update part
		//player updates
		if (Game.getGame().up2) {
			Game.getGame().player2.y-=20;
            if(Game.getGame().player2.y<0)Game.getGame().player2.y=0;
        }
		if (Game.getGame().down2) {
			Game.getGame().player2.y+=20;
            if(Game.getGame().player2.y+Player.HEIGHT>Game.getGame().controller.canvas.getHeight())
            	Game.getGame().player2.y=(int) (Game.getGame().controller.canvas.getHeight()-Player.HEIGHT);
        }
		if (Game.getGame().up1) {
			Game.getGame().player1.y-=20;
            if(Game.getGame().player1.y<0)Game.getGame().player1.y=0;
        }
		if (Game.getGame().down1) {
			Game.getGame().player1.y+=20;
            if(Game.getGame().player1.y+Player.HEIGHT>Game.getGame().controller.canvas.getHeight())
            	Game.getGame().player1.y=(int) (Game.getGame().controller.canvas.getHeight()-Player.HEIGHT);
        }
		//ball updates
		if(Game.getGame().started) {
			Game.getGame().ball.update();
		}
		
		//graphics part
		
		GraphicsContext g = Game.getGame().controller.canvas.getGraphicsContext2D();
			
		g.setFill(Color.BLACK);
		g.fillRect(0, 0, Game.getGame().controller.canvas.getWidth(), Game.getGame().controller.canvas.getHeight());
		
		g.setFill(Color.RED);
		g.fillRect(Game.getGame().player1.x, Game.getGame().player1.y, Player.WIDTH, Player.HEIGHT);
		g.fillRect(Game.getGame().player2.x, Game.getGame().player2.y, Player.WIDTH, Player.HEIGHT);
		
		
		g.setFill(Color.WHITE);
		g.fillOval(Game.getGame().ball.x, Game.getGame().ball.y, Ball.WIDTH, Ball.WIDTH);
		
		g.setStroke(Color.RED);
		if(!Game.getGame().started) {
			g.strokeText("press a button to start the round", Game.getGame().controller.canvas.getWidth()/2, Game.getGame().controller.canvas.getHeight()/2);
		}
		g.strokeText(Game.getGame().score1+"", Game.getGame().controller.canvas.getWidth()/8,20);
		g.strokeText(Game.getGame().score2+"", Game.getGame().controller.canvas.getWidth()/8*6,20);
	}
}
