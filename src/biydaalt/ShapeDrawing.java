package biydaalt;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class ShapeDrawing extends JComponent {
	ArrayList<Integer> myXArr = new ArrayList<Integer>();
	ArrayList<Integer> myYArr = new ArrayList<Integer>();
	int myFruitX = 25;
	int myFruitY = 50;
	int myScore = 1;
	int moveDis = 25;
	String Direction="up";
	String BefDirection="down";

	public void paint(Graphics g)
    {
        Graphics2D g1 = (Graphics2D) g;        
        Graphics2D g2 = (Graphics2D) g;        
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
        Graphics2D g3 = (Graphics2D) g;        
        g3.setColor(Color.red);
 	    g3.drawOval(myFruitX, myFruitY, 20, 20);
  	    g3.fillOval(myFruitX, myFruitY, 20, 20);
    }
    
    public void Touch() {
    	
    	double randomX = 1;
    	double randomY = 1;
    	while((randomY%25 !=0 || randomX%25!=0) || myXArr.contains(randomX) || myYArr.contains(randomY)) 
    	{
    		
			randomX = Math.round(Math.random()*320/25)*25;
	    	randomY = Math.round(Math.random()*320/25)*25;
    	}
        	this.myFruitX = (int) randomX;
        	this.myFruitY = (int) randomY;       	
    }
     
    
    public void IsTouched() {
    		if(myXArr.getFirst() == this.myFruitX && myYArr.getFirst() == this.myFruitY) {
    			Touch();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
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
    		}
    }
	
    public void MoveShapeUp() {
    		if(myYArr.getLast() >= 25) {
    			if(!BefDirection.equals("down")) {
    				myYArr.addFirst(myYArr.get(0)-moveDis);
        			myYArr.removeLast();
        			myXArr.addFirst(myXArr.get(0));
        			myXArr.removeLast();	
    			}else {
    				MoveShapeDown();
    			}
    		}else {
    			myYArr.addFirst(325);
    			myYArr.removeLast();
    			myXArr.addFirst(myXArr.get(0));
    			myXArr.removeLast();
    		}
    		this.repaint();
    }
    

	public void MoveShapeDown() {
    		if(myYArr.getLast() <= 325) {
    			if(!BefDirection.equals("up")) {
    				myYArr.addFirst(myYArr.get(0)+moveDis);
        			myYArr.removeLast();
        			myXArr.addFirst(myXArr.get(0));
        			myXArr.removeLast();
    			}else {
    				MoveShapeUp();
    			}
    		}else {
    			myYArr.addFirst(25);
    			myYArr.removeLast();
    			myXArr.addFirst(myXArr.get(0));
    			myXArr.removeLast();
    		}
    		this.repaint();
    }
    
    public void MoveShapeLeft() {
    		if(myXArr.getLast() >= 25) {
    			if(!BefDirection.equals("right")) {
    				myXArr.addFirst(myXArr.get(0)-moveDis);
        			myXArr.removeLast();
        			myYArr.addFirst(myYArr.get(0));
        			myYArr.removeLast();	
    			}else {
    				MoveShapeRight();
    			}
    		}else {
    			myXArr.addFirst(325);
    			myXArr.removeLast();
    			myYArr.addFirst(myYArr.get(0));
    			myYArr.removeLast();
    		}
    		this.repaint();
    }
    
    public void MoveShapeRight() {
    		if(myXArr.getLast() <= 325) {
    			if(!BefDirection.equals("left")) {
    				myXArr.addFirst(myXArr.get(0)+moveDis);
        			myXArr.removeLast();
        			myYArr.addFirst(myYArr.get(0));
        			myYArr.removeLast();	
    			}else {
    				MoveShapeLeft();
    			}
    		}else {
    			myXArr.addFirst(25);
    			myXArr.removeLast();
    			myYArr.addFirst(myYArr.get(0));
    			myYArr.removeLast();
    		} 	
    		this.repaint();
    	} 
}