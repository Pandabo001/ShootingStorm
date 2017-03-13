import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerWeapons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerWeapons extends Actor
{
    
    double velocity = 5;
    int damage = 5;
    boolean explosive = false;
    int radius = 0;
    MyWorld myworld;
    double x, y;
    int rotation;
    
    /**
     * Act - do whatever the PlayerWeapons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        if(isAtEdge()){
            myworld.removeObject(this);
        }
    }    
    
    /*
     * Make the player weapon move in x and y coordinate.
     */
    public void move(){
        x += velocity * Math.cos(rotation * Math.PI / 180);
        y += velocity * Math.sin(rotation * Math.PI / 180);
        setLocation((int)x, (int)y);
    }
    
    /*
     * 
     * add to the world when player fire.
     */
    public void addedToWorld(World World){
        myworld = (MyWorld) World;
        x = getX();
        y = getY();
        rotation = getRotation();
    }
}
