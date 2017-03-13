import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    GreenfootImage imageMO = new GreenfootImage("buttonmouseover.png");
    GreenfootImage image = new GreenfootImage("button.png");
    boolean mouseover = false;
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void checkMouseover(){
        if(Greenfoot.mouseMoved(this) && !mouseover){
            setImage(imageMO);
            mouseover = true;
        }
        else if(Greenfoot.mouseMoved(null) && mouseover && !Greenfoot.mouseMoved(this)){
            setImage(image);
            mouseover = false;
        }
    }
    
    public void draw(String caption){
        Menu menu = (Menu) getWorld();
        image.setColor(Color.orange);
        image.setFont(menu.font);
        image.drawString(caption, 14, 37);
        imageMO.setColor(Color.orange);
        imageMO.setFont(menu.font);
        imageMO.drawString(caption, 14, 37);
        setImage(image);
    }
}
