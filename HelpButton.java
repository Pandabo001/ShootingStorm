import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpButton extends Button
{
    /**
     * Act - do whatever the HelpButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkMouseover();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new HelpMenu());
        }
    }    
    
    public void addedToWorld(World World){
        draw("HELP");
    }
}
