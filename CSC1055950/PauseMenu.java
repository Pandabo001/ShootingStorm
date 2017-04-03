import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;

/**
 * Write a description of class PauseMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PauseMenu extends Menu
{
    MyWorld myworld;
    int score = 0;
    
    /**
     * Constructor for objects of class PauseMenu.
     * 
     */
    public PauseMenu(MyWorld world, int scoreg)
    {
        score = scoreg;
        myworld = world;
        GreenfootImage board = new GreenfootImage("gameover.png");
        BG.scale(BG.getWidth() * getHeight() / BG.getHeight(), getHeight());
        getFont();
        board.setFont(font.deriveFont(40f));
        board.setColor(Color.ORANGE);
        board.drawString("PAUSED", 20, 50);
        board.drawString("SCORE: " + score, 20, 100);
        BG.drawImage(board, 50, 50);
        setBackground(BG);
        addObject(new ResumeButton(), 150, 220);
        addObject(new BackButton(), 150, 295);
    }
}
