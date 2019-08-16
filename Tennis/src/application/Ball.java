package application;

import java.util.Random;

public class Ball {
	
	int x;
	int y;
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	double angle;
	double speed = 8;
	
	Ball(int x, int y){
		System.out.println(angle);
		this.x = x;
		this.y = y; 
		chooseRandomDir();
	}
	
	public void update() {
		move();
		//player1 ifs
		if((x>Game.getGame().player1.x && x<Game.getGame().player1.x+Player.WIDTH) && 
				((y>Game.getGame().player1.y && y<Game.getGame().player1.y+Player.HEIGHT) || 
						(y+Ball.HEIGHT>Game.getGame().player1.y && y+Ball.HEIGHT<Game.getGame().player1.y+Player.HEIGHT))) {
					
					
			System.out.println("checking");
					
			if((x+Player.WIDTH>Game.getGame().player1.x && x+Player.WIDTH<Game.getGame().player1.x+Player.WIDTH) && 
					((y>Game.getGame().player1.y && y<Game.getGame().player1.y+Player.HEIGHT) || 
							(y+Ball.HEIGHT>Game.getGame().player1.y && y+Ball.HEIGHT<Game.getGame().player1.y+Player.HEIGHT))) {
						
				angle = -angle;
				System.out.println("1");
				move();
						
			}else {
						
				angle = 180-angle;
				System.out.println("2");
				move();
						
			}
					
		}
				
				
		//player1 ifs
		if((x+Player.WIDTH>Game.getGame().player2.x && x+Player.WIDTH<Game.getGame().player2.x+Player.WIDTH) && 
				((y>Game.getGame().player2.y && y<Game.getGame().player2.y+Player.HEIGHT) || 
						(y+Ball.HEIGHT>Game.getGame().player2.y && y+Ball.HEIGHT<Game.getGame().player2.y+Player.HEIGHT))) {
						
						
			System.out.println("checking");
							
			if((x>Game.getGame().player2.x && x<Game.getGame().player2.x+Player.WIDTH) && 
					((y>Game.getGame().player2.y && y<Game.getGame().player2.y+Player.HEIGHT) || 
							(y+Ball.HEIGHT>Game.getGame().player2.y && y+Ball.HEIGHT<Game.getGame().player2.y+Player.HEIGHT))) {
								
				angle = -angle;
				System.out.println("1");
				move();
							
			}else {
							
				angle = 180-angle;
				System.out.println("2");
				move();
								
			}
							
		}
				
				
		if(x<0) {
			Game.getGame().newRound(2);
		}else if(x+WIDTH>Game.getGame().controller.canvas.getWidth()) {
			Game.getGame().newRound(1);
		}
	}
	
	public void move() {
		
		double radianangle = angle*Math.PI/180;
		
		y = (int) (y+Math.sin(radianangle)*speed);
		x = (int) (x+Math.cos(radianangle)*speed);
		
		if(y<0 || y+HEIGHT>Game.getGame().controller.canvas.getHeight()) {
			angle = -angle;
		}
		
		
		
	}
	
	
	public void chooseRandomDir() {
		angle = (new Random()).nextInt(180)*(((new Random()).nextInt(2)==1)?1:-1);
	}
}
