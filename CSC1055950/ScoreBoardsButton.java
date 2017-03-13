import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoardsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoardsButton extends Button
{
    /**
     * Act - do whatever the ScoreBoardsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkMouseover();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new ScoreBoard());
        }
    }    
    
    public void addedToWorld(World World){
        draw("SCORES BOARD");
    }
}
