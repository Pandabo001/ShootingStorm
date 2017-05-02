import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossTurret extends Enemy
{
    int firingRate = 50;
    int firingCycle = 0;
    
    /**
     * Act - do whatever the BomberTurret wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turnTowards(myworld.player.getX(), myworld.player.getY());
        fire();
    }    
    
    public void addedToWorld(World World){
        myworld = (MyWorld) World;
    }
    
     void fire(){
        firingCycle++;
        if(firingCycle >= firingRate){
            BossBullet bullet = new BossBullet();
            bullet.setRotation(getRotation());
            myworld.addObject(bullet, getX(), getY());
            Greenfoot.playSound("Cannon+1.wav");
            firingCycle = 0;
        }
    }    
}
