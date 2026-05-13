package biydaalt;
 

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class snake implements ActionListener , KeyListener {
    ShapeDrawing mySnake;
	Timer timer = new Timer(150,this);
	String myEvent;
	 JFrame frame = new JFrame("Snake game");
	 JPanel panel = new JPanel();
     JButton myBtn = new JButton("Stop");
     JButton myStartBtn = new JButton("Start");
     Integer[] myLvl = {5,10,15};
     JComboBox<Integer> comboBox = new JComboBox<>(myLvl);
     JLabel myLabel = new JLabel();
     JLabel myLabelComb = new JLabel("Хожих нөхцөл: ");

	
	public snake() {
		mySnake = new ShapeDrawing(this);
		mySnake.AutoPosGenerate();
		mySnake.myXArr.add(mySnake.randomX);
		mySnake.myYArr.add(mySnake.randomY);
		mySnake.AutoPosGenerate();
		mySnake.myFruitX = mySnake.randomX;
		mySnake.myFruitY = mySnake.randomY;
	        frame.setSize(500, 500);
			myLabel.setBounds(10, 5, 100, 30);
			myBtn.setFocusable(false);
			myStartBtn.setFocusable(false);
			myLabel.setFocusable(false);	
			myBtn.setBounds(260, 410, 100, 20);
			myStartBtn.setBounds(380, 410, 100, 20);
			myLabelComb.setBounds(80, 5, 130, 30);
			comboBox.setBounds(200, 5, 100, 30);
			comboBox.setFocusable(false);
			myBtn.addActionListener(this);
			myStartBtn.addActionListener(this);
	        comboBox.addActionListener(this);
			myLabel.setText("Score:"+mySnake.myScore);
			
			frame.add(myLabelComb);
	        frame.add(comboBox);
			frame.add(myLabel);
			frame.add(myBtn);
			frame.add(myStartBtn);
	        frame.add(mySnake);
	        frame.setFocusable(true);
	        frame.addKeyListener(this);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.setAutoRequestFocus(true);
	        frame.setVisible(true);
	}
	@Override
    public void keyPressed(KeyEvent e) {
		myEvent = KeyEvent.getKeyText(e.getKeyCode()).toLowerCase();
		//System.out.println(myEvent);

		if(myEvent.equals("↑")) {
			myEvent = "up";
		}
		else if(myEvent.equals("←")){
			myEvent = "left";
		}
		else if(myEvent.equals("→")){
			myEvent = "right";
		}
		else if(myEvent.equals("↓")){
			myEvent = "down";
		}else {
			myEvent = mySnake.Direction;
		}
		
		if(mySnake.myXArr.size()==1)
		{
			mySnake.Direction = myEvent;
		}else {
			if(mySnake.Direction.equals("up") && myEvent.equals("down")) {
				mySnake.Direction = "up";
			}
			else if(mySnake.Direction.equals("down") && myEvent.equals("up")) {
				mySnake.Direction = "down";
			}
			else if(mySnake.Direction.equals("left") && myEvent.equals("right")) {
				mySnake.Direction = "left";
			}
			else if(mySnake.Direction.equals("right") && myEvent.equals("left")) {
				mySnake.Direction = "right";
			}else if (!mySnake.Direction.equals(myEvent)){
				mySnake.Direction = myEvent;
			}
		}
    }
	
    @Override
    public void keyTyped(KeyEvent e) {}	
    @Override
    public void keyReleased(KeyEvent e) {
    }
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.myBtn) {
	        System.out.println("The game is stopped!!");
	        timer.stop();
	    }else if (e.getSource() == timer) {
	    		if(mySnake.Direction.equals("up")) {
	    			mySnake.MoveShapeUp();
	    		}else if(mySnake.Direction.equals("down")) {
	    			mySnake.MoveShapeDown();
	    		}else if(mySnake.Direction.equals("right")) {
	    			mySnake.MoveShapeRight();
	    		}else if(mySnake.Direction.equals("left")) {
	    			mySnake.MoveShapeLeft();
	    		}
	    		mySnake.IsTouched();
	    }else if(e.getSource() == this.myStartBtn){
	    	timer.start();
	    }else if(e.getSource() == this.comboBox) {
	    	int selected = (int) comboBox.getSelectedItem();
	    	mySnake.GoalScore = selected;
	    	this.frame.setAutoRequestFocus(true);
	    }
	}
	
	public void ScoreCounter() {
		myLabel.setText("Score:"+mySnake.myScore);
	}

	public static void main(String[] args) {
		new snake();
	}
}
