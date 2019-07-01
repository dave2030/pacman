package packman;

import java.awt.*;

import javax.swing.*;

import java.util.*;
import java.awt.event.*;


public class Game extends JPanel implements  Runnable, KeyListener  {
    Thread runner;
    int speed=50;
    Boolean next; // level done or not
    Level L;
  

    public Game() {
      super();
      setSize(602,451);
      addKeyListener(this);
      L =(Level) new titleBG();
      runner = new Thread(this);
      runner.start();
      next=true;
    }

    public void paintComponent(Graphics g) {
      L.paintLevel((Graphics2D)g,this);
    }

    public void run(){
      Thread thisThread=Thread.currentThread();
      while(runner == thisThread){
        while(runner == thisThread&&next){
          L.buildLevel(this);
          repaint();
          try { Thread.sleep(speed); }
          catch (InterruptedException e) {} // do nothing
        }
        if(L.getLevel()==1) 
        	L =(Level) new pacmangame(); 
        else 
        	L=(Level)new titleBG();  
        next=true;
        requestFocus();
      }
    }

    public void setNext() {
      next=false; 
    }
    
  public void keyPressed (KeyEvent event){ L.keyPressed(event); }
  
  public void keyReleased(KeyEvent event){}
  
  public void keyTyped(KeyEvent event){}
    
}
