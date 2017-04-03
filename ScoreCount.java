import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;
import java.text.DecimalFormat;

/**
 * Write a description of class ScoreCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCount extends Interface
{
    int count;
    GreenfootImage counter = new GreenfootImage(120, 30);
    private MyWorld myworld;
    DecimalFormat format = new DecimalFormat("00.0");
    
    /**
     * Act - do whatever the ScoreCount wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        count = myworld.score;
        counter.clear();
        if(count < 10000){
            counter.drawString("SCORE " + count, 0, 30);
        }
        else if(count < 99950){
            counter.drawString("SCORE " + format.format((double)count / 1000) + "k", 0, 30);
        }
        else if(count < 999500){
            format.applyPattern("000");
            counter.drawString("SCORE " + format.format((double)count / 1000) + "k", 0, 30);            
        }
        else if(count < 9995000){
            format.applyPattern("0.00");
            counter.drawString("SCORE " + format.format((double)count / 1000000) + "m", 0, 30);
        }
        else if(count < 99950000){
            format.applyPattern("00.0");
            counter.drawString("SCORE " + format.format((double)count / 1000000) + "m", 0, 30);            
        }
        else{
            format.applyPattern("000");
            counter.drawString("SCORE " + format.format((double)count / 1000000) + "m", 0, 30);            
        }
        setImage(counter);   
    }    
    
    public void addedToWorld(World World){
        myworld = (MyWorld) World;
        count = myworld.score;
        counter.clear();
        counter.setColor(Color.ORANGE);
        counter.setFont(font);
        counter.drawString("SCORE " + count, 0, 30);
        setImage(counter);
    }
}
