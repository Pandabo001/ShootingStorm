import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BulletSpeed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletSpeed extends PowerUp
{
    /**
     * Act - do whatever the BulletSpeed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void addedToWorld(World World){
        getWorld().addObject(anim1, getX(), getY());
    }
    
    public BulletSpeed(){
        image[0] = new GreenfootImage("bulletspeed.png");    
    }
}
