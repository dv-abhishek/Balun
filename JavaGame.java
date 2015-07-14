package Balun;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class JavaGame extends JFrame implements Runnable, MouseMotionListener {

    int x, y, xDirection, yDirection;
    Image bkgrnd;
    Font font = new Font("Arial", Font.BOLD, 30);
    public int count = 0;
    Rectangle r1;
    char score;
    
    @Override
    public void run() {
        try {
            while (true) {
                move();
                count++;
                Thread.sleep(100);//controls the infinite while loop as 100 milliseconds 	
            } 
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }

    public void move() {
        if (x <= 15) {
            x = 15;
        }
        if (x >= 985) {
            x = 985;
        }
        if (y <= 15) {
            y = 15;
        }
        if (y >= 685) {
            y = 685;
        }
    }
   
    @Override
    public void mouseDragged(MouseEvent e) {
    	x = e.getX()-10;
	y = e.getY()-10;
    }


    //This is the default constructor and conditions for JFrame(1)
    public JavaGame() {
        //load images
        ImageIcon i = new ImageIcon("E:\\IT\\Java_Projects\\javagame\\clouds.png");
        bkgrnd = i.getImage();
        
        x = 250;
        y = 150;
    }
    

    public void paintComponent(Graphics g) {
    
        g.drawImage(bkgrnd, 0, 0,1000,700, this);//Set image as background,with size specified
        g.setColor(Color.GRAY);
        g.setFont(font);
        g.drawString("Score : " +Integer.toString(count),0, 50);
        r1 = new Rectangle(x, y, 25, 25);
        g.setColor(Color.blue);
        g.fillRoundRect(r1.x, r1.y, r1.width, r1.height,r1.width, r1.height);  
        g.setColor(Color.red);
    }
    
    
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX()-12;
        y = e.getY()-12;
    }

    public void gameOver() throws FileNotFoundException, IOException {
    	
        BufferedWriter writer = null;
        StringBuilder high_score = new StringBuilder("");
        
        Reader reader = new FileReader("E:\\IT\\Java_Projects\\javagame\\src\\javagame\\HighScore.txt");
        int data = reader.read();
        while(data != -1){
            high_score.append((char) data);
            data = reader.read();
        }
        
        if(Integer.toString(count).compareTo(high_score.toString())>0){
        	try{
	            writer = new BufferedWriter(new FileWriter("E:\\IT\\Java_Projects\\javagame\\src\\javagame\\HighScore.txt"));
	            writer.flush();
	            writer.write(Integer.toString(count));
            	high_score=new StringBuilder(Integer.toString(count));
        	}catch(IOException e){
        	}finally{
            	try{
                	if(writer != null) writer.close();
            	}catch(IOException e){                
            	}
        	}      
        }
         
        JOptionPane.showMessageDialog(this, "<html>Game Over <br> Your Score is: "+count
                + "<br>High Score is: "+high_score+"<br></html>", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
}
