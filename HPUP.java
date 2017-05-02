import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HPUP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HPUP extends PowerUp
{
    /**
     * Act - do whatever the HPUP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void addedToWorld(World World){
        getWorld().addObject(anim1, getX(), getY());
    }
    
    public HPUP(){
        image[0] = new GreenfootImage("hpup.png");    
    }  
}
