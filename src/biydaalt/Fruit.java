package biydaalt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Fruit extends JComponent{
	int myFruitX = 10;
	int myFruitY = 50;
    
	public void paint(Graphics g)
    {
        Graphics2D fruit = (Graphics2D) g;
        fruit.setBackground(Color.GREEN);
        fruit.drawRect(myFruitX, myFruitY, 20, 20);
        fruit.fillRect(myFruitX, myFruitY, 20, 20);
    }
	
	

    
}
