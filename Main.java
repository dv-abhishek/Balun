package Balun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class Main extends JFrame{
   
    public Thread t = new Thread(jg);
    
    private Image dbImage;			//This creates a double buffer image of the background
    private Graphics dbg;			//This creates a double buffer image of the balloon
    
    static Enemy b1= new Enemy((int)(Math.random()*1000)+10,(int)(Math.random()*700)+10);   //The next 4 lines create 5 enemies
	static Enemy b2= new Enemy((int)(Math.random()*1000)+10,(int)(Math.random()*700)+10);
	static Enemy b3= new Enemy((int)(Math.random()*1000)+10,(int)(Math.random()*700)+10);
    static Enemy b4= new Enemy((int)(Math.random()*1000)+10,(int)(Math.random()*700)+10);
    static Enemy b5= new Enemy((int)(Math.random()*1000)+10,(int)(Math.random()*700)+10);
    
	static Enemy coin= new Enemy(500,350);	//This creates the coin we need to collect														
    
    static JavaGame jg = new JavaGame();    //Creating an object of javaGame type
    
    public Main(){   //Default constructor for gui window
    
        setTitle("BALUN");
        setSize(1000, 700);
        setResizable(false);
        setVisible(true);
        addMouseMotionListener(jg);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
  
    @Override
    public void paint(Graphics g) { //created a new graphics variable g
    	
    	dbImage = createImage(getWidth(), getHeight());//gets the image of the current screen
        
    	dbg = dbImage.getGraphics();//gets the graphics here it is the balloon
        try {
            paintComponent(dbg);//paints the balloon
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    	g.drawImage(dbImage, 0, 0, this);//draws the screen back   
    }
    
    
	public void paintComponent(Graphics g) throws IOException{
    	   
    	   jg.paintComponent(g);
           b1.paintComponent(g);
           b2.paintComponent(g);
           b3.paintComponent(g);
           b4.paintComponent(g);
           b5.paintComponent(g);
        
    	   g.setColor(Color.ORANGE);
           coin.paintComponent(g);
       
    	   if(b1.ball.intersects(jg.r1) || b2.ball.intersects(jg.r1) || b3.ball.intersects(jg.r1) || b4.ball.intersects(jg.r1) || b5.ball.intersects(jg.r1))
            {   
                jg.gameOver();
            }
        
    	    if(coin.ball.intersects(jg.r1)){
        	    coin.ball.move((int)(Math.random()*900)+80, (int)(Math.random()*600)+80);
			    jg.count+=50;
            }
            
        repaint();
    }   	        
    	      
    
    public static void main(String[] args) {
      
        new window();
        //Threads
        Thread t = new Thread(jg);
        t.start();
        
        Thread ball1 = new Thread(b1);
        Thread ball2 = new Thread(b2);
        Thread ball3 = new Thread(b3);
        Thread ball4 = new Thread(b4);
        Thread ball5 = new Thread(b5);
        
        ball1.start();
        ball2.start();
        ball3.start();
        ball4.start();
        ball5.start();
    }
}
