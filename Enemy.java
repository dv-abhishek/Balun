package Balun;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy implements Runnable{
    
    int x, y,xDirection,yDirection;
    Rectangle ball;

    
    public Enemy(int x, int y) {
		
    	
        this.x = x;
        this.y = y;
        //Set ball moving randomly 
        Random r=new Random();
        int rDir=r.nextInt(1);
        if(rDir==0) rDir--;
        setXDirection(rDir);
        
        int yrDir=r.nextInt(1);
        if(yrDir==0) yrDir--;
        setYDirection(yrDir);
        
        ball= new Rectangle(this.x,this.y, 20, 20);
    	
	}



	public void moveEnemy(){
        ball.x +=xDirection;
        ball.y +=yDirection;
        if(ball.x>=980){
        	setXDirection(-5);
        }
        
        if(ball.x<=15){
        	setXDirection(+1);
        }
        
        if(ball.y>=680){
        	setYDirection(-1);
        }
        
        if(ball.y<=15){
        	setYDirection(+5);
        }
    }
    
    
    public void setXDirection(int xdir) {
        xDirection = xdir;
    }

    public void setYDirection(int ydir) {
        yDirection = ydir;
    }
    
   
    public void paintComponent(Graphics g){
 
        g.fillRoundRect(ball.x, ball.y, 20, 20,20,20);
    }
    @Override
    public void run() {
        try{
            while(true){
              moveEnemy();
              Thread.sleep(3);
            }
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());  
        } 
    }
}
