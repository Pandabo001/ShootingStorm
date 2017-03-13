import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Smoke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smoke extends Actor
{
    GreenfootImage image = new GreenfootImage("smoke.png");
    int lifetime = 50;
    int state = 0;
    
    /**
     * Act - do whatever the Smoke wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        state++;
        setLocation(getX() - 2, getY());
        fade();
        if(state >= lifetime){
            getWorld().removeObject(this);
        }
    }    
    
    public Smoke(){
        setRotation(Greenfoot.getRandomNumber(360));
        image.setTransparency(150);
        GreenfootImage tmp = new GreenfootImage(image);
        tmp.scale(5, 5);
        setImage(tmp);
    }
    
    public void fade(){
        GreenfootImage tmp = new GreenfootImage(image);
        tmp.scale(40 - 35 * (lifetime - state) / lifetime, 40 - 35 * (lifetime - state) / lifetime);
        tmp.setTransparency(150 * (lifetime - state) / lifetime);
        setImage(tmp);
    }
}
