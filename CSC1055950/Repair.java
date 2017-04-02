import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Repair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Repair extends PowerUp
{
    /**
     * Act - do whatever the Repair wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void addedToWorld(World World){
        getWorld().addObject(anim1, getX(), getY());
    }
    
    public Repair(){
        image[0] = new GreenfootImage("repair.png");
    }
}
