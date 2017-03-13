import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullet extends Actor
{
    double velocity = 3;
    public static int damage = 3;
    private MyWorld myworld;
    int rotation;
    double x, y;
    
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
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
        x = getX();
        y = getY();
        damage = myworld.difficulty / 2 + 2;
        rotation = getRotation();
    }
    
    public void move(){
        x += velocity * Math.cos(rotation * Math.PI / 180);
        y += velocity * Math.sin(rotation * Math.PI / 180);
        setLocation((int)x, (int)y);
    }
}
