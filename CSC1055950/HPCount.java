import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class HPCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HPCount extends Interface
{
    int count;
    GreenfootImage counter = new GreenfootImage(80, 30);
    private MyWorld myworld;
    
    /**
     * Act - do whatever the HPCount wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        count = myworld.player.hp;
        counter.clear();
        counter.drawString("HP " + count, 0, 30);
        setImage(counter);
    }    
    
    public void addedToWorld(World World){
        myworld = (MyWorld) World;
        count = myworld.player.hp;
        counter.clear();
        counter.setFont(font);
        counter.setColor(Color.red);
        counter.drawString("HP " + count, 0, 30);
        setImage(counter);
    }
}
