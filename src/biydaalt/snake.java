package biydaalt;
 

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class snake implements ActionListener , KeyListener {
    static ShapeDrawing mySnake = new ShapeDrawing();
	Timer timer;
	String myEvent;
	static JFrame frame = new JFrame("Snake game");
	static ShapeDrawing myDraw = new ShapeDrawing();
	static JPanel panel = new JPanel();
	static snake myKeyListener = new snake(); // Create the instance
    static JButton myBtn = new JButton("Stop");
    static JLabel myLabel = new JLabel("Score:"+mySnake.myScore);
	@Override
    public void keyPressed(KeyEvent e) {
		timer = new Timer(200 , this);
		timer.start();
		myEvent = KeyEvent.getKeyText(e.getKeyCode());
		mySnake.BefDirection = mySnake.BefDirection.equals(mySnake.Direction) ? mySnake.BefDirection :mySnake.Direction;  
		mySnake.Direction = myEvent.toLowerCase();
    }
	
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
	        System.out.println("The game is stopped!!");
	        timer.stop();
	    }else if (e.getSource() == timer) {
	    		mySnake.IsTouched();
	    		myLabel.setText("Score:"+mySnake.myScore);
	    		if(myEvent.equals("Up")) {
	    			mySnake.MoveShapeUp();
	    		}else if(myEvent.equals("Down")) {
	    			mySnake.MoveShapeDown();
	    		}else if(myEvent.equals("Right")) {
	    			mySnake.MoveShapeRight();
	    		}else if(myEvent.equals("Left")) {
	    			mySnake.MoveShapeLeft();
	    		}	    
	    	}
	}

	public static void main(String[] args) {
		mySnake.myXArr.add(100);
		mySnake.myYArr.add(150);
	        frame.setSize(500, 500);
			myLabel.setBounds(10, 20, 100, 30);
			myBtn.setFocusable(false);
			myLabel.setFocusable(false);
			myBtn.setBounds(50, 400, 100, 20);
			myBtn.addActionListener(myKeyListener);
			frame.add(myLabel);
			frame.add(myBtn);
	        frame.add(mySnake);
	        frame.setFocusable(true);
	        frame.addKeyListener(myKeyListener);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	}

}
