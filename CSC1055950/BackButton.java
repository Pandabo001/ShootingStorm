import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Button
{
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkMouseover();
        if(Greenfoot.mouseClicked(this)){
            if(getWorld().getClass() == PauseMenu.class){
                PauseMenu world = (PauseMenu)getWorld();
                int score = world.score;
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                try{
                    FileWriter fw = new FileWriter("scores.txt", true);
                    fw.write(format.format(new Date()) + " " + score + "\n");
                    fw.close();
                }
                catch(IOException ioe){
                    System.err.println("IOException: " + ioe.getMessage());
                }
            }
            Greenfoot.setWorld(new MainMenu());
        }
    }    
    
    public void addedToWorld(World World){
        draw("MAIN MENU");
    }
}
