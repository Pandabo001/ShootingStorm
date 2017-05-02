import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BomberTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BomberTurret extends Enemy
{
    int firingRate = 40;
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
            EnemyBullet bullet = new EnemyBullet();
            bullet.setRotation(getRotation());
            myworld.addObject(bullet, getX(), getY());
            Greenfoot.playSound("Cannon+1.wav");
            firingCycle = 0;
        }
    }   
}
