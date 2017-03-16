import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends Menu
{

    GreenfootSound music = new GreenfootSound("08 - Theme Of Soldier (Instrumental)-(MyMp3Singer.net).MP3");
    boolean Playing = true;
    public boolean end = false;
    
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
    
    public void act(){
        if(Playing)
        {
            music.playLoop();
            Playing = false;
        }

        if(end == true){
            stopped();
        }else {
            music.playLoop();
        }
    }
    
    public void stopped(){
        music.stop();
    }
}
