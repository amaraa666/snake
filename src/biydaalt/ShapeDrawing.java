package biydaalt;

import java.awt.*;
import java.awt.Toolkit;

import java.util.ArrayList;
import javax.swing.*;

public class ShapeDrawing extends JComponent {
    snake SnakeWindow;
	int randomX;
	int randomY;
	ArrayList<Integer> myXArr = new ArrayList<Integer>();
	ArrayList<Integer> myYArr = new ArrayList<Integer>();
	int myFruitX;
	int myFruitY;
	int GoalScore=5;
	int myScore = 1;
	int moveDis = 25;
	String Direction="up";
	String BefDirection="down";
    
    public ShapeDrawing(snake parent) {
    	SnakeWindow = parent;
    }

	public void paint(Graphics g){
        Graphics2D g4 = (Graphics2D) g;        
        Graphics2D g1 = (Graphics2D) g;        
        Graphics2D g2 = (Graphics2D) g;     
        Graphics2D g3 = (Graphics2D) g;   
        
        g4.setColor(Color.black);
        g4.fillRect(0,40,500,360);

        g3.setColor(Color.red);
 	    g3.drawOval(myFruitX, myFruitY, 20, 20);
  	    g3.fillOval(myFruitX, myFruitY, 20, 20);
        for(int i = 0; i < myScore ;i++) {
        	
        	if(i == 0) 
        	{
        		g1.setColor(Color.yellow);
            	g1.drawRect(myXArr.get(i), myYArr.get(i), 20, 20);
                g1.fillRect(myXArr.get(i), myYArr.get(i), 20, 20);	
        	}else {
            	g2.setColor(Color.pink);
            	g2.drawRect(myXArr.get(i), myYArr.get(i), 20, 20);
                g2.fillRect(myXArr.get(i), myYArr.get(i), 20, 20);
        	}	
        } 
    }
   
	public void AutoPosGenerate() {
		randomX = 1;
		randomY = 1;
    	while((randomY%50 !=0 || randomX%25!=0)  || ( myXArr.contains(randomX) || myYArr.contains(randomY)) || (randomX == 0 || randomY == 0) ) 
    	{
    		
			randomX = (int) Math.round(Math.random()*450/25)*25;
	    	randomY = (int) Math.round(Math.random()*350/50)*50;
    	}
	}
	//jimsend hureh uyd jims random baidlaar garah
    public void ChangeFruitPos() {
    	
    	    AutoPosGenerate();
        	this.myFruitX = (int) randomX;
        	this.myFruitY = (int) randomY;       	
    }
     
    //jims ideh uyd suul nemegdeh
    public void IsTouched() {
    		if(myXArr.getFirst() == this.myFruitX && myYArr.getFirst() == this.myFruitY) {
    	        Toolkit.getDefaultToolkit().beep();
    			ChangeFruitPos();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    			if(Direction.equals("left")) {
    				myXArr.add(myXArr.getLast()+25);
        			myYArr.add(myYArr.getLast());	
    			}
    			else if(Direction.equals("right"))
    			{
    				myXArr.add(myXArr.getLast()-25);
        			myYArr.add(myYArr.getLast());
    			}
    			else if(Direction.equals("up")) 
    			{
    				myXArr.add(myXArr.getLast());
        			myYArr.add(myYArr.getLast()+25);
    			}
    			else if(Direction.equals("down")) 
    			{
    				myXArr.add(myXArr.getLast());
        			myYArr.add(myYArr.getLast()-25);
    			}
    			
    		
    			myScore+=1;    	
    			SnakeWindow.ScoreCounter();
    			if(GoalScore == myScore) {
    				System.out.println("WON");
    				SnakeWindow.timer.stop();
    				JOptionPane.showMessageDialog(null, "Won the game! Score: " + myScore);
    				ResetGame();
    			}
    		}
    }
    
    //game over
    public boolean IsGameOver(int x, int y) {
    		for(int i = 0 ; i < myXArr.size(); i++) {
    			if(myXArr.get(i) == x && myYArr.get(i) == y) {
    				System.out.println("Game over");
    				SnakeWindow.timer.stop();
    				JOptionPane.showMessageDialog(null, "Game Over! Score: " + myScore);
    				ResetGame();
    				return true;
    			}
    		}
    		return false;
    }
    
    //reset game
    public void ResetGame() {
	    AutoPosGenerate();
    	this.myXArr.removeAll(myXArr);
    	myXArr.add(randomX);
    	this.myYArr.removeAll(myYArr);
    	myYArr.add(randomY);
	    AutoPosGenerate();
    	this.myFruitX = randomX;
    	this.myFruitY = randomY;
    	this.myScore = 1;
		SnakeWindow.ScoreCounter();
    }
    
    //movement sections
	int x,y;
    public void MoveShapeUp() {
    		if(myYArr.getFirst() >= 75) {
    				x = myXArr.get(0);
    				y = myYArr.get(0)-moveDis;
    				
    				if(!IsGameOver(x,y)) {
    					myYArr.addFirst(y);
            			myYArr.removeLast();
            			myXArr.addFirst(x);
            			myXArr.removeLast();
    				}

    		}else {
    			myYArr.addFirst(375);
    			myYArr.removeLast();
    			myXArr.addFirst(myXArr.get(0));
    			myXArr.removeLast();
    		}
    		this.repaint();
    }

	public void MoveShapeDown() {
    		if(myYArr.getFirst() <= 350) {
    				x = myXArr.get(0);
    				y = myYArr.get(0)+moveDis;
    				if(!IsGameOver(x,y)) {
        				myYArr.addFirst(y);
            			myYArr.removeLast();
            			myXArr.addFirst(x);
            			myXArr.removeLast();
    				}
    		}else {
    			myYArr.addFirst(50);
    			myYArr.removeLast();
    			myXArr.addFirst(myXArr.get(0));
    			myXArr.removeLast();
    		}
    		this.repaint();
    }
    
    public void MoveShapeLeft() {
    		if(myXArr.getFirst() >= 25) {
    				x = myXArr.get(0)-moveDis;
    				y = myYArr.get(0);
    				if(!IsGameOver(x,y)) {
    					myXArr.addFirst(x);
            			myXArr.removeLast();
            			myYArr.addFirst(y);
            			myYArr.removeLast();	
    				}		
    		}else {
    			myXArr.addFirst(475);
    			myXArr.removeLast();
    			myYArr.addFirst(myYArr.get(0));
    			myYArr.removeLast();
    		}
    		this.repaint();
    }
    
    public void MoveShapeRight() {
    		if(myXArr.getFirst() <= 450) {
    				x = myXArr.get(0)+moveDis;
    				y = myYArr.get(0);
    				if(!IsGameOver(x,y)) {
    					myXArr.addFirst(x);
            			myXArr.removeLast();
            			myYArr.addFirst(y);
            			myYArr.removeLast();	
    				}
    		}else {
    			myXArr.addFirst(0);
    			myXArr.removeLast();
    			myYArr.addFirst(myYArr.get(0));
    			myYArr.removeLast();
    		} 	
    		this.repaint();
    } 
}