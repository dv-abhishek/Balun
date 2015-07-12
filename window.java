package Balun;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class window extends JFrame implements ActionListener{
private JLabel entername;
	
	private JButton click1;
	private JButton click2;
	
	public window(){
		
		Font font = new Font("Arial",Font.BOLD ,30);
		setContentPane(new JLabel(new ImageIcon("E:\\IT\\Java_Projects\\javagame\\download.jpg")));
		
		setSize(1000,700);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("BALUN!");
		setFont(font);
		setResizable(false);
		setVisible(true);

		entername = new JLabel("BALUN!");
		entername.setFont(new Font("Arial", Font.BOLD, 70));
		click1 = new JButton("START");
		click2 = new JButton("EXIT");
		
		entername.setBounds(350,130,1200,80);
		//entername.setBackground(Color.blue);
		
		click1.setBounds(350,250,250,50);
		click1.addActionListener(this);
		add(click1);
		click2.setBounds(350,330,250,50);
		click2.addActionListener(this);
		add(click2);
		add(entername);
		
	click1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
            new Main();        
            setVisible(false);
        }
	});
	
	click2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
            System.exit(0);        
            setVisible(false);
        }
    });
}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}
