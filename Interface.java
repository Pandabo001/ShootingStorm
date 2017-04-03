import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Font;

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Interface extends Actor
{
    private MyWorld myworld;
    public Font font;
    
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void addedToWorld(World World){
        myworld = (MyWorld) World;
        HPCount hpc = new HPCount();
        myworld.addObject(hpc, 50, 14);
        ScoreCount sc = new ScoreCount();
        myworld.addObject(sc, 150, 14);
        RocketCount rc = new RocketCount();
        myworld.addObject(rc, 272, 14);
    }
    
    public Interface(){
        font = new Font("Haettenschweiler", false, false, 26);  
    }
}
