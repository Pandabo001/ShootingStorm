import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Menu
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int score){
        BG.scale(BG.getWidth() * getHeight() / BG.getHeight(), getHeight());
        getFont();
        GreenfootImage board = new GreenfootImage("gameover.png");
        BG.scale(BG.getWidth() * getHeight() / BG.getHeight(), getHeight());
        getFont();
        board.setFont(font.deriveFont(40f));
        board.setColor(Color.ORANGE);
        board.drawString("GAME OVER", 20, 50);
        board.drawString("SCORE: " + score, 20, 100);
        BG.drawImage(board, 50, 50);
        setBackground(BG);
        addObject(new RestartButton(), 150, 220);
        addObject(new BackButton(), 150, 295);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try{
            FileWriter fw = new FileWriter("scores.txt", true);
            fw.write(format.format(new Date()) + " " + score + "\n");
            fw.close();
        }catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
    
    
}
