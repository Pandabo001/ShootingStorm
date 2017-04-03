import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;

/**
 * Write a description of class HelpMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpMenu extends Menu
{

    /**
     * Constructor for objects of class HelpMenu.
     * 
     */
    public HelpMenu()
    {
        BG.scale(BG.getWidth() * getHeight() / BG.getHeight(), getHeight());
        GreenfootImage board = new GreenfootImage("help.png");
        getFont();
        board.setColor(Color.ORANGE);
        board.setFont(font.deriveFont(20f));
        board.drawString("CONTROLS", 15, 27);
        board.drawString("Movement : WASD or Arrow Keys\nFire : Spacebar\nFire Rocket : R\nPause : Escape", 15, 57);
        board.drawString("Power Ups", 245, 27);
        board.drawString("Fully replenishes HP", 245, 126);
        board.drawString("Increases maximum HP", 420, 126);
        board.drawString("Gives 2 rockets", 15, 232);
        board.drawString("Increases firing rate", 245, 232);
        board.drawString("Increases plane speed", 420, 232);
        board.drawString("Increases bullet and rocket\ndamage and rocket blast radius", 15, 360);
        board.drawString("Increases bullet speed", 245, 360);
        board.drawString("Increases bullets fired\nat once and rocket damage", 420, 360);
        BG.drawImage(board, 0, 0);
        setBackground(BG);
        addObject(new BackButton(), 125, 456);
    }
}
