import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerBullet extends PlayerWeapons
{
    /**
     * Act - do whatever the PlayerBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        if(isAtEdge()){
            myworld.removeObject(this);
        }
    }    
    
    public void addedToWorld(World World){
        myworld = (MyWorld) World;
        damage = myworld.player.damage;
        velocity = myworld.player.bulletSpeed;
        explosive = false;
        x = getX();
        y = getY();
        rotation = getRotation();
       
    }
}
