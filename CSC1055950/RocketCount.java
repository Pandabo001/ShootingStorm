import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;

/**
 * Write a description of class RocketCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RocketCount extends Interface
{
    int count;
    GreenfootImage counter = new GreenfootImage(120, 30);
    private MyWorld myworld;
    
    /**
     * Act - do whatever the RocketCount wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        count = myworld.player.rockets;
        counter.clear();
        counter.drawString("ROCKETS " + count, 0, 30);
        setImage(counter);
    }    
    
    public void addedToWorld(World World){
        myworld = (MyWorld) World;
        count = myworld.player.rockets;
        counter.clear();
        counter.setFont(font);
        counter.setColor(Color.BLUE);
        counter.drawString("ROCKETS " + count, 0, 30);
        setImage(counter);
    }
}
