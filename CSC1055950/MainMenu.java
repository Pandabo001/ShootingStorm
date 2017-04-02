import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends Menu
{

    
    
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {
        BG.scale(BG.getWidth() * getHeight() / BG.getHeight(), getHeight());
        getFont();
        setBackground(BG);
        addObject(new StartButton(), 125, 100);
        addObject(new ScoreBoardsButton(), 125, 200);
        addObject(new HelpButton(), 125, 300);
    }
    
    
}
