import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends PlayerWeapons
{
    
    int smokeCycle = 0;
    
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        smokeCycle++;
        if(smokeCycle % 2 == 0){
            myworld.addObject(new Smoke(), getX(), getY());
        }
        move();
        if(isAtEdge()){
            myworld.removeObject(this);
        }
    }    
    
    public void addedToWorld(World World){
        myworld = (MyWorld) World;
        damage = myworld.player.damage * 5 * myworld.player.fireLevel;
        velocity = 5;
        explosive = true;
        radius = 40 + myworld.player.damage * 6;
        x = getX();
        y = getY();
        rotation = getRotation();
    }
}
