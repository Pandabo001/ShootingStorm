import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResumeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResumeButton extends Button
{
    
    MyWorld myworld;
    PauseMenu menu;
    int timedown = 40;
    
    /**
     * Act - do whatever the ResumeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timedown--;
        checkMouseover();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(myworld);
        }
    }    
    
    public void addedToWorld(World World){
        draw("RESUME");
        menu = (PauseMenu) World;
        myworld = menu.myworld;
    }
}
